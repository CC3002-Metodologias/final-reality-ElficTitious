package com.github.cc3002.finalreality.controller;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.Inventory;
import com.github.ElficTitious.finalreality.controller.Party;
import com.github.ElficTitious.finalreality.controller.factories.CharacterFactory;
import com.github.ElficTitious.finalreality.controller.factories.WeaponFactory;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.EnemyDeathHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.EnemyTurnHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.PlayerCharacterDeathHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.PlayerTurnHandler;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;


public class GameControllerTest {


    private GameController controller;
    protected ScheduledExecutorService scheduledExecutor;


    /**
     * Setup method.
     * Creates a new controller.
     */
    @BeforeEach
    void setUp() {
        controller = new GameController();
    }

    /**
     * Checks that the equipWeapon method works as intended.
     */
    @Test
    void equipWeaponTest() {
        var expectedInventory = new Inventory();
        var inventory = controller.getInventory();
        var weaponFactory = controller.getWeaponFactory();
        var characterFactory = controller.getCharacterFactory();
        var testAxe = weaponFactory.createAxe("Test Axe", 30, 10);
        var testSword = weaponFactory.createSword("Test Sword", 25, 10);
        var testKnight = characterFactory.createKnight("Test Knight",
                100, 30);

        expectedInventory.addWeapon(testAxe);
        expectedInventory.addWeapon(testSword);
        inventory.addWeapon(testAxe);
        inventory.addWeapon(testSword);
        controller.equipWeapon(testAxe, testKnight);
        expectedInventory.removeWeapon(testAxe);
        assertEquals(testAxe, testKnight.getEquippedWeapon());
        assertEquals(expectedInventory.getInventory(), inventory.getInventory());
        controller.equipWeapon(testSword, testKnight);
        expectedInventory.removeWeapon(testSword);
        expectedInventory.addWeapon(testAxe);
        assertEquals(testSword, testKnight.getEquippedWeapon());
        assertEquals(expectedInventory.getInventory(), inventory.getInventory());
    }

    /**
     * Checks that the attack method and death handlers work as intended.
     */
    @Test
    void combatTest() {
        var expectedPlayerParty = new Party();
        var expectedEnemyParty = new Party();
        var playerParty = controller.getPlayerParty();
        var enemyParty = controller.getEnemyParty();
        var turnsQueue = controller.getTurnsQueue();
        var inventory = controller.getInventory();
        var characterFactory = controller.getCharacterFactory();
        var weaponFactory = controller.getWeaponFactory();
        var testSword = weaponFactory.createSword("Test Sword", 30, 10);
        var testKnight = characterFactory.createKnight("Test Knight",
                20, 0);
        var testEnemy = characterFactory.createEnemy("Test Enemy", 20,
                0, 10, 30);

        /* First we test that the enemy death handler work as intended by making
        * the test knight kill the test enemy. */
        inventory.addWeapon(testSword);
        playerParty.addCharacter(testKnight);
        expectedPlayerParty.addCharacter(testKnight);
        turnsQueue.add(testKnight);
        enemyParty.addCharacter(testEnemy);
        expectedEnemyParty.addCharacter(testEnemy);
        turnsQueue.add(testEnemy);
        controller.equipWeapon(testSword, testKnight);
        controller.attack(testKnight, testEnemy);
        expectedEnemyParty.removeCharacter(testEnemy);
        assertEquals(expectedEnemyParty.getParty(), enemyParty.getParty());
        /* If turnsQueue.remove(testEnemy) returns false, it means that it was
        * successfully removed by the checkVictory method. */
        assertFalse(turnsQueue.remove(testEnemy));

        /* Now we test that the player character death handler work as intended by making
         * the test enemy kill the test knight. */
        testEnemy.setHealthPoints(20);
        enemyParty.addCharacter(testEnemy);
        expectedEnemyParty.addCharacter(testEnemy);
        turnsQueue.add(testEnemy);
        controller.attack(testEnemy, testKnight);
        expectedPlayerParty.removeCharacter(testKnight);
        assertEquals(expectedPlayerParty.getParty(), playerParty.getParty());
        /* If turnsQueue.remove(testKnight) returns false, it means that it was
         * successfully removed by the checkLoss method. */
        assertFalse(turnsQueue.remove(testKnight));
    }

    /**
     * Checks that the checkVictory and checkLoss methods work as intended.
     */
    @Test
    void checkVictoryAndLossTest() {
        var playerParty = controller.getPlayerParty();
        var enemyParty = controller.getEnemyParty();
        var characterFactory = controller.getCharacterFactory();
        var testKnight = characterFactory.createKnight("Test Knight",
                20, 0);
        var testEngineer = characterFactory.createEngineer("Test Engineer",
                20, 0);
        var firstTestEnemy = characterFactory.createEnemy("First Test Enemy",
                20, 0, 10, 30);
        var secondTestEnemy = characterFactory.createEnemy("Second Test Enemy",
                20, 0, 10, 30);

        playerParty.addCharacter(testKnight);
        playerParty.addCharacter(testEngineer);
        enemyParty.addCharacter(firstTestEnemy);
        enemyParty.addCharacter(secondTestEnemy);

        assertFalse(controller.checkLoss(testKnight));
        assertFalse(controller.checkVictory(firstTestEnemy));
        assertTrue(controller.checkLoss(testEngineer));
        assertTrue(controller.checkVictory(secondTestEnemy));
    }

    /**
     * Checks that the turns method from the GameController Class, as well as the turn
     * handlers, work as intended.
     */
    @Test
    void turnsTest() {
        var turnsQueue = controller.getTurnsQueue();
        var characterFactory = controller.getCharacterFactory();
        var weaponFactory = controller.getWeaponFactory();
        var testSword = weaponFactory.createSword("Test Sword", 30, 10);
        var testKnight = characterFactory.createKnight("Test Knight",
                20, 0);

        var testEnemy = characterFactory.createEnemy("Test Enemy", 20,
                0, 10, 30);

        controller.equipWeapon(testSword, testKnight);
        turnsQueue.add(testKnight);
        turnsQueue.add(testEnemy);
        assertEquals(testKnight, controller.getNextCharacter());
        controller.removeCharacter(testKnight);
        assertFalse(turnsQueue.remove(testKnight));
        controller.setTimer(testKnight);
        try {
            Thread.sleep(900);
            assertEquals(1, turnsQueue.size());
            Thread.sleep(200);
            assertEquals(2, turnsQueue.size());
            assertEquals(testEnemy, turnsQueue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(testEnemy, controller.getNextCharacter());
        controller.removeCharacter(testEnemy);
        assertFalse(turnsQueue.remove(testEnemy));
        controller.setTimer(testEnemy);
        try {
            Thread.sleep(900);
            assertEquals(1, turnsQueue.size());
            Thread.sleep(200);
            assertEquals(2, turnsQueue.size());
            assertEquals(testKnight, turnsQueue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
