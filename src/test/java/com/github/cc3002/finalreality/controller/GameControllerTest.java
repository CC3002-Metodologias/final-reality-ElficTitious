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
import com.github.ElficTitious.finalreality.controller.state.concretestates.EnemyTurn;
import com.github.ElficTitious.finalreality.controller.state.concretestates.PlayerTurn;
import com.github.ElficTitious.finalreality.controller.state.concretestates.Starting;
import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
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
        controller.equipWeapon(testAxe, testKnight);
        expectedInventory.removeWeapon(testAxe);
        assertEquals(testAxe, testKnight.getEquippedWeapon());
        assertEquals(expectedInventory, inventory);
        controller.equipWeapon(testSword, testKnight);
        expectedInventory.removeWeapon(testSword);
        expectedInventory.addWeapon(testAxe);
        assertEquals(testSword, testKnight.getEquippedWeapon());
        assertEquals(expectedInventory, inventory);
    }

    @RepeatedTest(20)
    void turnFlowAndCombatTest() {
        var turnsQueue = controller.getTurnsQueue();
        var playerParty = controller.getPlayerParty();
        var enemyParty = controller.getEnemyParty();
        var characterFactory = controller.getCharacterFactory();
        var weaponFactory = controller.getWeaponFactory();

        // Let's create characters
        var testKnightOne = characterFactory.createKnight("Test Knight One",
                100, 10);
        var testEnemyOne = characterFactory.createEnemy("Test Enemy One",
                100, 10, 10, 10);
        var testKnightTwo = characterFactory.createKnight("Test Knight Two",
                100, 10);
        var testEnemyTwo = characterFactory.createEnemy("Test Enemy One",
                100, 10, 20, 20);
        var testThief = characterFactory.createThief("Test Thief",
                100, 10);
        var testEnemyThree = characterFactory.createEnemy("Test Enemy Three",
                100, 10, 30, 30);

        // Let's check the characters where added to their respective parties and turns queue.
        assertEquals(playerParty.getPartySize(), 3);
        assertEquals(enemyParty.getPartySize(), 3);
        assertEquals(turnsQueue.size(), 6);

        // Let's create weapons and equip them.
        var testSwordOne = weaponFactory.createSword("Test Sword One", 10,
                10);
        controller.equipWeapon(testSwordOne, testKnightOne);
        assertEquals(testKnightOne.getEquippedWeapon(), testSwordOne);
        var testSwordTwo = weaponFactory.createSword("Test Sword Two", 20,
                20);
        controller.equipWeapon(testSwordTwo, testThief);
        assertEquals(testThief.getEquippedWeapon(), testSwordTwo);
        var testAxe = weaponFactory.createAxe("Test Axe", 30, 30);
        controller.equipWeapon(testAxe, testKnightTwo);
        assertEquals(testKnightTwo.getEquippedWeapon(), testAxe);
        controller.getNextCharacter();
        assertTrue(controller.isPlayerTurn());

        while (!controller.isDefeated() && !controller.isVictorious()) {
            if (controller.isPlayerTurn()) {
                var attacker = (IPlayerCharacter) turnsQueue.peek();
                controller.attack(attacker, enemyParty.getRandomCharacter());
                var weapon = attacker.getEquippedWeapon();
                var millis = 1000 * (weapon.getWeight()/10);
                try {
                    Thread.sleep(millis + 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (controller.isDefeated()) {
            assertEquals(0, playerParty.getPartySize());
        }
        else {
            assertEquals(0, enemyParty.getPartySize());
        }
    }

    /**
     * Checks that the checkVictory and checkLoss methods work as intended.
     */
    @Test
    void checkVictoryAndLossTest() {
        var characterFactory = controller.getCharacterFactory();
        var testKnight = characterFactory.createKnight("Test Knight",
                20, 0);
        var testEngineer = characterFactory.createEngineer("Test Engineer",
                20, 0);
        var firstTestEnemy = characterFactory.createEnemy("First Test Enemy",
                20, 0, 10, 30);
        var secondTestEnemy = characterFactory.createEnemy("Second Test Enemy",
                20, 0, 10, 30);

        controller.setState(new EnemyTurn());
        controller.checkLoss(testKnight);
        assertFalse(controller.isDefeated());
        controller.setState(new PlayerTurn());
        controller.checkVictory(firstTestEnemy);
        assertFalse(controller.isVictorious());
        controller.setState(new EnemyTurn());
        controller.checkLoss(testEngineer);
        assertTrue(controller.isDefeated());
        controller.setState(new PlayerTurn());
        controller.checkVictory(secondTestEnemy);
        assertTrue(controller.isVictorious());
    }


    /**
     * Checks that the removeCharacter and setTimer methods from the GameController
     * class work as intended.
     */
    @Test
    void removeCharacterAndSetTimerTest() {
        var turnsQueue = controller.getTurnsQueue();
        var characterFactory = controller.getCharacterFactory();
        var weaponFactory = controller.getWeaponFactory();
        var testSword = weaponFactory.createSword("Test Sword", 30, 10);
        var testKnight = characterFactory.createKnight("Test Knight",
                20, 0);

        var testEnemy = characterFactory.createEnemy("Test Enemy", 20,
                0, 10, 30);

        controller.equipWeapon(testSword, testKnight);
        assertEquals(testKnight, turnsQueue.peek());
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

    /**
     * Checks that the endTurn method from the GameController class works as intended.
     */
    @Test
    void endTurnTest() {
        var state = controller.getState();
        var playerParty = controller.getPlayerParty();
        var turnsQueue = controller.getTurnsQueue();
        var characterFactory = controller.getCharacterFactory();
        var weaponFactory = controller.getWeaponFactory();
        var testSwordOne = weaponFactory.createSword("Test Sword One", 30,
                10);
        var testSwordTwo = weaponFactory.createSword("Test Sword Two", 30,
                10);
        var testKnight = characterFactory.createKnight("Test Knight",
                20, 0);
        assertEquals(1, turnsQueue.size());
        controller.equipWeapon(testSwordOne, testKnight);
        controller.getNextCharacter();
        controller.endTurn(testKnight);
        assertEquals(0, turnsQueue.size());
        try {
            /* Because the turns queue is emptied after ending the turn of the test knight,
               the controller's state becomes WaitingQueue. */

            assertTrue(controller.isWaitingQueue());
            Thread.sleep(900);
            assertEquals(0, turnsQueue.size());
            assertFalse(turnsQueue.contains(testKnight));
            Thread.sleep(200);
            assertEquals(1, turnsQueue.size());
            assertEquals(testKnight, turnsQueue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(controller.isPlayerTurn());
        var testThief = characterFactory.createEngineer("Test Thief",
                20, 0);
        controller.equipWeapon(testSwordTwo, testThief);
        /* We now test the case where after ending the turn there's still a character in
           the turns queue. */
        controller.setState(new Starting());
        controller.getNextCharacter();
        controller.endTurn(testKnight);
        try {
            Thread.sleep(900);
            assertEquals(1, turnsQueue.size());
            assertFalse(turnsQueue.contains(testKnight));
            Thread.sleep(200);
            assertEquals(2, turnsQueue.size());
            assertEquals(testThief, turnsQueue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /* The state automatically transitions to PlayerTurn, going through CheckingQueue and
           CheckingTurn.
         */
        assertTrue(controller.isPlayerTurn());
    }
}
