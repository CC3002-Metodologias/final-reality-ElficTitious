package com.github.cc3002.finalreality.model.character;

import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    protected BlockingQueue<ICharacter> turnsQueue;
    protected ScheduledExecutorService scheduledExecutor;

    private static final String ENEMY_NAME = "Test Enemy";
    private static final String SECOND_ENEMY_NAME = "Second Test Enemy";
    private static final int WEIGHT = 10;
    private static final int SECOND_WEIGHT = 120;
    private static final int HEALTH_POINTS = 100;
    private static final int DEFENSE = 50;
    private static final int ATTACK_POWER = 30;

    private static final String AXE_NAME  = "Test Axe";
    private static final int DAMAGE  = 15;
    private static final int AXE_WEIGHT  = 30;

    private Enemy testEnemy;
    private Enemy testEnemyDifferentName;
    private Enemy testEnemyDifferentWeight;

    protected Axe testAxe;

    @BeforeEach
    void setUp() {
        turnsQueue = new LinkedBlockingQueue<>();

        testEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        testEnemyDifferentName = new Enemy(turnsQueue, SECOND_ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        testEnemyDifferentWeight = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                SECOND_WEIGHT, ATTACK_POWER);
        testAxe = new Axe(AXE_NAME, DAMAGE, AXE_WEIGHT);
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        assertTrue(turnsQueue.isEmpty());
        testEnemy.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            assertEquals(0, turnsQueue.size());
            Thread.sleep(200);
            assertEquals(1, turnsQueue.size());
            assertEquals(testEnemy, turnsQueue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void constructionTest() {
        var expectedTestEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        assertEquals(expectedTestEnemy, testEnemy);
    }

    @Test
    void getHealthPointsTest() {
        var expectedTestEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        assertEquals(expectedTestEnemy.getHealthPoints(), testEnemy.getHealthPoints());
    }

    @Test
    void getDefenseTest() {
        var expectedTestEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        assertEquals(expectedTestEnemy.getDefense(), testEnemy.getDefense());
    }

    @Test
    void getAttackPowerTest() {
        var expectedTestEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        assertEquals(expectedTestEnemy.getAttackPower(), testEnemy.getAttackPower());
    }

    @Test
    void equalsTest() {
        var expectedTestEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        assertEquals(expectedTestEnemy, expectedTestEnemy);
        assertEquals(expectedTestEnemy, testEnemy);
        assertNotEquals(expectedTestEnemy, testEnemyDifferentName);
        assertNotEquals(expectedTestEnemy, testEnemyDifferentWeight);
        assertNotEquals(expectedTestEnemy, testAxe);
    }

    @Test
    void hashCodeTest() {
        var expectedTestEnemy = new Enemy(turnsQueue, ENEMY_NAME, HEALTH_POINTS, DEFENSE,
                WEIGHT, ATTACK_POWER);
        assertEquals(expectedTestEnemy.hashCode(), testEnemy.hashCode());
        assertNotEquals(expectedTestEnemy.hashCode(), testEnemyDifferentName.hashCode());
    }
}
