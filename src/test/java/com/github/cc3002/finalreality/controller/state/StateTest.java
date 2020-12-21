package com.github.cc3002.finalreality.controller.state;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.Party;
import com.github.ElficTitious.finalreality.controller.state.State;
import com.github.ElficTitious.finalreality.controller.state.concretestates.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code state} package.
 *
 * @author Ismael Correa Arellano.
 * @see com.github.ElficTitious.finalreality.controller.state
 */
public class StateTest {

    private GameController testController;
    private State testState;

    /**
     * Setup method.
     * Creates a new test state and game controller.
     */
    @BeforeEach
    void basicSetUp () {
        testController = new GameController();
        testState = new State();
    }

    /**
     * Checks that the getController {@code State} class works as intended.
     */
    @Test
    void getControllerTest() {
        var unexpectedTestController = new GameController();
        testState.setController(testController);
        assertEquals(testController, testState.getController());
        assertNotEquals(unexpectedTestController, testState.getController());
    }

    /**
     * Checks that the Starting class works as intended.
     */
    @Test
    void startingTest() {
        testController.setState(new Starting());
        assertFalse(testController.isCheckingQueue());
        assertFalse(testController.isCheckingTurn());
        assertFalse(testController.isDefeated());
        assertFalse(testController.isEnemyTurn());
        assertFalse(testController.isPlayerTurn());
        assertFalse(testController.isVictorious());
        assertFalse(testController.isWaitingQueue());
        assertTrue(testController.isStarting());
        var expectedState = testController.getState();
        expectedState.checkQueue();
        assertTrue(testController.isStarting());
        expectedState.waitQueue();
        assertTrue(testController.isStarting());
        expectedState.queueReady();
        assertTrue(testController.isStarting());
        expectedState.enemyTurn();
        assertTrue(testController.isStarting());
        expectedState.playerTurn();
        assertTrue(testController.isStarting());
        expectedState.victory();
        assertTrue(testController.isStarting());
        expectedState.defeat();
        assertTrue(testController.isStarting());
        expectedState.checkTurn();
        assertTrue(testController.isCheckingTurn());
    }

    /**
     * Checks that the CheckingTurn class works as intended.
     */
    @Test
    void checkingTurnTest() {
        testController.setState(new CheckingTurn());
        assertTrue(testController.isCheckingTurn());
        assertFalse(testController.isCheckingQueue());
        assertFalse(testController.isDefeated());
        assertFalse(testController.isEnemyTurn());
        assertFalse(testController.isPlayerTurn());
        assertFalse(testController.isVictorious());
        assertFalse(testController.isWaitingQueue());
        assertFalse(testController.isStarting());
        var expectedState = testController.getState();
        expectedState.checkQueue();
        assertTrue(testController.isCheckingTurn());
        expectedState.waitQueue();
        assertTrue(testController.isCheckingTurn());
        expectedState.queueReady();
        assertTrue(testController.isCheckingTurn());
        expectedState.checkTurn();
        assertTrue(testController.isCheckingTurn());
        expectedState.victory();
        assertTrue(testController.isCheckingTurn());
        expectedState.defeat();
        assertTrue(testController.isCheckingTurn());
        expectedState.enemyTurn();
        assertTrue(testController.isEnemyTurn());
        testController.setState(new CheckingTurn());
        expectedState.playerTurn();
        assertTrue(testController.isPlayerTurn());
    }

    /**
     * Checks that the enemyTurn class works as intended.
     */
    @Test
    void enemyTurnTest() {
        testController.setState(new EnemyTurn());
        assertFalse(testController.isCheckingQueue());
        assertFalse(testController.isCheckingTurn());
        assertFalse(testController.isDefeated());
        assertTrue(testController.isEnemyTurn());
        assertFalse(testController.isPlayerTurn());
        assertFalse(testController.isVictorious());
        assertFalse(testController.isWaitingQueue());
        assertFalse(testController.isStarting());
        var expectedState = testController.getState();
        expectedState.waitQueue();
        assertTrue(testController.isEnemyTurn());
        expectedState.queueReady();
        assertTrue(testController.isEnemyTurn());
        expectedState.checkTurn();
        assertTrue(testController.isEnemyTurn());
        expectedState.enemyTurn();
        assertTrue(testController.isEnemyTurn());
        expectedState.playerTurn();
        assertTrue(testController.isEnemyTurn());
        expectedState.victory();
        assertTrue(testController.isEnemyTurn());
        expectedState.defeat();
        assertTrue(testController.isDefeated());
        testController.setState(new EnemyTurn());
        expectedState.checkQueue();
        assertTrue(testController.isCheckingQueue());
    }

    /**
     * Checks that the Defeated class works as intended.
     */
    @Test
    void defeatedTest() {
        testController.setState(new Defeated());
        assertFalse(testController.isCheckingQueue());
        assertFalse(testController.isCheckingTurn());
        assertTrue(testController.isDefeated());
        assertFalse(testController.isEnemyTurn());
        assertFalse(testController.isPlayerTurn());
        assertFalse(testController.isVictorious());
        assertFalse(testController.isWaitingQueue());
        assertFalse(testController.isStarting());
        var expectedState = testController.getState();
        expectedState.checkQueue();
        assertTrue(testController.isDefeated());
        expectedState.checkTurn();
        assertTrue(testController.isDefeated());
        expectedState.waitQueue();
        assertTrue(testController.isDefeated());
        expectedState.queueReady();
        assertTrue(testController.isDefeated());
        expectedState.enemyTurn();
        assertTrue(testController.isDefeated());
        expectedState.playerTurn();
        assertTrue(testController.isDefeated());
        expectedState.victory();
        assertTrue(testController.isDefeated());
        expectedState.defeat();
        assertTrue(testController.isDefeated());
    }

    /**
     * Checks that the PlayerTurn class works as intended.
     */
    @Test
    void playerTurnTest() {
        testController.setState(new PlayerTurn());
        assertFalse(testController.isCheckingQueue());
        assertFalse(testController.isCheckingTurn());
        assertFalse(testController.isDefeated());
        assertFalse(testController.isEnemyTurn());
        assertTrue(testController.isPlayerTurn());
        assertFalse(testController.isVictorious());
        assertFalse(testController.isWaitingQueue());
        assertFalse(testController.isStarting());
        var expectedState = testController.getState();
        expectedState.checkTurn();
        assertTrue(testController.isPlayerTurn());
        expectedState.waitQueue();
        assertTrue(testController.isPlayerTurn());
        expectedState.queueReady();
        assertTrue(testController.isPlayerTurn());
        expectedState.enemyTurn();
        assertTrue(testController.isPlayerTurn());
        expectedState.playerTurn();
        assertTrue(testController.isPlayerTurn());
        expectedState.defeat();
        assertTrue(testController.isPlayerTurn());
        expectedState.victory();
        assertTrue(testController.isVictorious());
        testController.setState(new PlayerTurn());
        expectedState.checkQueue();
        assertTrue(testController.isCheckingQueue());
    }

    /**
     * Checks that the Victorious class works as intended.
     */
    @Test
    void victoriousTest() {
        testController.setState(new Victorious());
        assertFalse(testController.isCheckingQueue());
        assertFalse(testController.isCheckingTurn());
        assertFalse(testController.isDefeated());
        assertFalse(testController.isEnemyTurn());
        assertFalse(testController.isPlayerTurn());
        assertTrue(testController.isVictorious());
        assertFalse(testController.isWaitingQueue());
        assertFalse(testController.isStarting());
        var expectedState = testController.getState();
        expectedState.checkQueue();
        assertTrue(testController.isVictorious());
        expectedState.checkTurn();
        assertTrue(testController.isVictorious());
        expectedState.waitQueue();
        assertTrue(testController.isVictorious());
        expectedState.queueReady();
        assertTrue(testController.isVictorious());
        expectedState.enemyTurn();
        assertTrue(testController.isVictorious());
        expectedState.playerTurn();
        assertTrue(testController.isVictorious());
        expectedState.victory();
        assertTrue(testController.isVictorious());
        expectedState.defeat();
        assertTrue(testController.isVictorious());
    }

    /**
     * Checks that the CheckingQueue class works as intended.
     */
    @Test
    void checkingQueueTest() {
        testController.setState(new CheckingQueue());
        assertFalse(testController.isCheckingTurn());
        assertTrue(testController.isCheckingQueue());
        assertFalse(testController.isDefeated());
        assertFalse(testController.isEnemyTurn());
        assertFalse(testController.isPlayerTurn());
        assertFalse(testController.isVictorious());
        assertFalse(testController.isWaitingQueue());
        assertFalse(testController.isStarting());
        var expectedState = testController.getState();
        expectedState.checkQueue();
        assertTrue(testController.isCheckingQueue());
        expectedState.queueReady();
        assertTrue(testController.isCheckingQueue());
        expectedState.enemyTurn();
        assertTrue(testController.isCheckingQueue());
        expectedState.playerTurn();
        assertTrue(testController.isCheckingQueue());
        expectedState.victory();
        assertTrue(testController.isCheckingQueue());
        expectedState.defeat();
        assertTrue(testController.isCheckingQueue());
        expectedState.waitQueue();
        assertTrue(testController.isWaitingQueue());
        testController.setState(new CheckingTurn());
        expectedState.checkTurn();
        assertTrue(testController.isCheckingTurn());
    }

    /**
     * Checks that the WaitingQueue class works as intended.
     */
    @Test
    void waitingQueueTest() {
        testController.setState(new WaitingQueue());
        assertFalse(testController.isCheckingQueue());
        assertFalse(testController.isCheckingTurn());
        assertFalse(testController.isDefeated());
        assertFalse(testController.isEnemyTurn());
        assertFalse(testController.isPlayerTurn());
        assertFalse(testController.isVictorious());
        assertTrue(testController.isWaitingQueue());
        assertFalse(testController.isStarting());
        var expectedState = testController.getState();
        expectedState.checkQueue();
        assertTrue(testController.isWaitingQueue());
        expectedState.waitQueue();
        assertTrue(testController.isWaitingQueue());
        expectedState.enemyTurn();
        assertTrue(testController.isWaitingQueue());
        expectedState.playerTurn();
        assertTrue(testController.isWaitingQueue());
        expectedState.victory();
        assertTrue(testController.isWaitingQueue());
        expectedState.defeat();
        assertTrue(testController.isWaitingQueue());
        expectedState.checkTurn();
        assertTrue(testController.isCheckingTurn());
    }
}
