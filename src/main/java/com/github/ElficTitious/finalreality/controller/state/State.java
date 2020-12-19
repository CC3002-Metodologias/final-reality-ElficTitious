package com.github.ElficTitious.finalreality.controller.state;

import com.github.ElficTitious.finalreality.controller.GameController;

/**
 * A class that represents all possible states the game can be in; It holds common behaviour
 * and methods that are overriden by the concrete states.
 *
 * @author Ismael Correa Arellano.
 */
public class State {

    private GameController controller;

    /**
     * Method that sets this state's controller to the controller given as parameter.
     */
    public void setController(GameController controller) {
        this.controller = controller;
    }

    /**
     * Method that returns this state's controller.
     */
    protected GameController getController() {
        return this.controller;
    }

    /**
     * Method that change's this state's controller state to the one given as parameter.
     */
    protected void changeState(State state) {
        controller.setState(state);
    }

    /**
     * Method that defines the error thrown when trying to transition to an inaccessible
     * state from the current one.
     */
    void error() { throw new AssertionError("Wrong State"); }

    /**
     * Method that change's the controller's state to CheckingTurn. (here it throws an
     * error, but the behaviour is overriden in concrete states).
     */
    public void checkTurn() {
        error();
    }

    /**
     * Method that change's the controller's state to CheckingQueue. (here it throws an
     * error, but the behaviour is overriden in concrete states).
     */
    public void checkQueue() {
        error();
    }

    /**
     * Method that change's the controller's state to WaitingQueue. (here it throws an
     * error, but the behaviour is overriden in concrete states).
     */
    public void waitQueue() {
        error();
    }

    /**
     * Method that returns to the first phase of the turns flow when the turns queue of
     * the game controller isn't empty; it's only accessible from the WaitingQueue state.
     * (here it throws an error, but the behaviour is overriden in the WaitingQueue state).
     */
    public void queueReady() {
        error();
    }

    /**
     * Method that change's the controller's state to EnemyTurn. (here it throws an
     * error, but the behaviour is overriden in concrete states).
     */
    public void enemyTurn() {
        error();
    }

    /**
     * Method that change's the controller's state to PlayerTurn. (here it throws an
     * error, but the behaviour is overriden in concrete states).
     */
    public void playerTurn() {
        error();
    }

    /**
     * Method that change's the controller's state to Victorious. (here it throws an
     * error, but the behaviour is overriden in concrete states).
     */
    public void victory() {
        error();
    }

    /**
     * Method that change's the controller's state to Defeated. (here it throws an
     * error, but the behaviour is overriden in concrete states).
     */
    public void defeat() {
        error();
    }

    /**
     * Method that returns if the controller's state is Starting or not. (here it's
     * defined as false by default, but the behaviour is overriden in concrete states).
     */
    public boolean isStarting() {
        return false;
    }

    /**
     * Method that returns if the controller's state is CheckingTurn or not. (here it's
     * defined as false by default, but the behaviour is overriden in concrete states).
     */
    public boolean isCheckingTurn() {
        return false;
    }

    /**
     * Method that returns if the controller's state is EnemyTurn or not. (here it's
     * defined as false by default, but the behaviour is overriden in concrete states).
     */
    public boolean isEnemyTurn() {
        return false;
    }

    /**
     * Method that returns if the controller's state is PlayerTurn or not. (here it's
     * defined as false by default, but the behaviour is overriden in concrete states).
     */
    public boolean isPlayerTurn() {
        return false;
    }

    /**
     * Method that returns if the controller's state is Defeated or not. (here it's
     * defined as false by default, but the behaviour is overriden in concrete states).
     */
    public boolean isDefeated() {
        return false;
    }

    /**
     * Method that returns if the controller's state is Victorious or not. (here it's
     * defined as false by default, but the behaviour is overriden in concrete states).
     */
    public boolean isVictorious() {
        return false;
    }

    /**
     * Method that returns if the controller's state is CheckingQueue or not. (here it's
     * defined as false by default, but the behaviour is overriden in concrete states).
     */
    public boolean isCheckingQueue() {
        return false;
    }

    /**
     * Method that returns if the controller's state is WaitingQueue or not. (here it's
     * defined as false by default, but the behaviour is overriden in concrete states).
     */
    public boolean isWaitingQueue() {
        return false;
    }
}
