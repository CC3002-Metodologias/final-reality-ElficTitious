package com.github.cc3002.finalreality.controller.factories;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.Inventory;
import com.github.ElficTitious.finalreality.controller.Party;
import com.github.ElficTitious.finalreality.controller.factories.CharacterFactory;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.EnemyDeathHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.EnemyTurnHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.PlayerCharacterDeathHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.PlayerTurnHandler;
import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code CharacterFactory} class.
 *
 * @author Ismael Correa Arellano.
 * @see com.github.ElficTitious.finalreality.controller.factories.CharacterFactory
 */
public class CharacterFactoryTest {

    private BlockingQueue<ICharacter> turnsQueue;
    private PlayerCharacterDeathHandler playerCharacterDeathHandler;
    private EnemyDeathHandler enemyDeathHandler;
    private PlayerTurnHandler playerTurnHandler;
    private EnemyTurnHandler enemyTurnHandler;

    private GameController controller;

    private CharacterFactory characterFactory;

    private static final String DARK_WIZARD_NAME = "Test Dark Wizard";
    private static final String ENGINEER_NAME = "Test Engineer";
    private static final String KNIGHT_NAME = "Test Knight";
    private static final String THIEF_NAME = "Test Thief";
    private static final String WHITE_WIZARD_NAME = "Test White Wizard";
    private static final String ENEMY_NAME = "Test Enemy";

    protected static final int HEALTH_POINTS = 120;
    protected static final int DEFENSE = 50;
    protected static final int MANA = 100;
    private static final int WEIGHT = 10;
    private static final int ATTACK_POWER = 30;

    private DarkWizard testDarkWizard;
    private Engineer testEngineer;
    private Knight testKnight;
    private Thief testThief;
    private WhiteWizard testWhiteWizard;
    private Enemy testEnemy;


    /**
     * Setup method.
     * Creates a character factory and characters for comparing.
     */
    @BeforeEach
    void setUp() {
        controller = new GameController();
        turnsQueue = new LinkedBlockingQueue<>();
        playerCharacterDeathHandler = new PlayerCharacterDeathHandler(controller);
        enemyDeathHandler = new EnemyDeathHandler(controller);
        playerTurnHandler = new PlayerTurnHandler(controller);
        enemyTurnHandler = new EnemyTurnHandler(controller);
        characterFactory = new CharacterFactory(turnsQueue, playerCharacterDeathHandler,
                enemyDeathHandler, playerTurnHandler, enemyTurnHandler);

        testDarkWizard = new DarkWizard(turnsQueue, DARK_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        testEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
        testKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        testThief = new Thief(turnsQueue, THIEF_NAME, HEALTH_POINTS, DEFENSE);
        testWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        testEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE, WEIGHT,
                ATTACK_POWER);
    }

    /**
     * Checks that the character creation methods of the CharacterFactory class work as
     * intended.
     */
    @Test
    void characterCreationTest() {
        assertEquals(testDarkWizard, characterFactory.createDarkWizard(DARK_WIZARD_NAME,
                HEALTH_POINTS, DEFENSE, MANA));
        assertEquals(testEngineer, characterFactory.createEngineer(ENGINEER_NAME,
                HEALTH_POINTS, DEFENSE));
        assertEquals(testKnight, characterFactory.createKnight(KNIGHT_NAME,
                HEALTH_POINTS, DEFENSE));
        assertEquals(testThief, characterFactory.createThief(THIEF_NAME,
                HEALTH_POINTS, DEFENSE));
        assertEquals(testWhiteWizard, characterFactory.createWhiteWizard(WHITE_WIZARD_NAME,
                HEALTH_POINTS, DEFENSE, MANA));
        assertEquals(testEnemy, characterFactory.createEnemy(ENEMY_NAME, HEALTH_POINTS,
                DEFENSE, WEIGHT, ATTACK_POWER));
    }

    /**
     * Checks that the getter methods of the CharacterFactory class work as
     * intended.
     */
    @Test
    void gettersTest() {
        assertEquals(ENEMY_NAME, characterFactory.getName(testEnemy));
        assertEquals(HEALTH_POINTS, characterFactory.getHealthPoints(testEnemy));
        assertEquals(DEFENSE, characterFactory.getDefense(testEnemy));
        assertEquals(WEIGHT, characterFactory.getWeight(testEnemy));
        assertEquals(ATTACK_POWER, characterFactory.getAttackPower(testEnemy));
        assertEquals(MANA, characterFactory.getMana(testDarkWizard));
    }
}
