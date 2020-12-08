package com.github.cc3002.finalreality.model.character;

import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the methods defined in the {@code ICharacter} interface
 * not tested in other classes (mainly combat methods).
 *
 * @author Ismael Correa Arellano.
 * @see com.github.ElficTitious.finalreality.model.character.ICharacter
 */
public class ICharacterTest {

    protected BlockingQueue<ICharacter> turnsQueue;
    protected ScheduledExecutorService scheduledExecutor;

    private static final String ENEMY_NAME = "Test Enemy";
    private static final int WEIGHT = 10;
    private static final int HEALTH_POINTS = 100;
    private static final int DEFENSE = 15;
    private static final int ATTACK_POWER = 30;

    private static final String KNIGHT_NAME = "Test Knight";

    private static final String AXE_NAME = "Test Axe";
    private static final int DAMAGE = 40;
    private static final int AXE_WEIGHT = 30;

    private Enemy testEnemy;
    private Knight testKnight;

    protected Axe testAxe;

    /**
     * Setup method.
     * Creates a new enemy, player character, a linked blocking queue and a test weapon.
     */
    @BeforeEach
    void setUp() {
        turnsQueue = new LinkedBlockingQueue<>();

        testEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        testKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        testAxe = new Axe(AXE_NAME, DAMAGE, AXE_WEIGHT);
    }

    @Test
    void combatTest() {
        // First we check the Knight attacking the enemy character.
        testKnight.attack(testEnemy);
        assertEquals(testEnemy.getHealthPoints(), HEALTH_POINTS);
        testKnight.equipAxe(testAxe);
        testKnight.attack(testEnemy);
        assertEquals(75, testEnemy.getHealthPoints());
        testEnemy.setHealthPoints(1);
        testKnight.attack(testEnemy);
        assertEquals(0, testEnemy.getHealthPoints());
        assertThrows(AssertionError.class, () -> testKnight.attack(testEnemy));
        testKnight.setHealthPoints(0);
        testEnemy.setHealthPoints(HEALTH_POINTS);
        assertThrows(AssertionError.class, () -> testKnight.attack(testEnemy));

        // Now we check the enemy character attacking the Knight.
        testKnight.setHealthPoints(HEALTH_POINTS);
        testEnemy.attack(testKnight);
        assertEquals(85, testKnight.getHealthPoints());
        testKnight.setHealthPoints(1);
        testEnemy.attack(testKnight);
        assertEquals(0, testKnight.getHealthPoints());
        assertThrows(AssertionError.class, () -> testEnemy.attack(testKnight));
        testEnemy.setHealthPoints(0);
        testKnight.setHealthPoints(HEALTH_POINTS);
        assertThrows(AssertionError.class, () -> testEnemy.attack(testKnight));
    }
}
