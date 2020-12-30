package com.github.ElficTitious.finalreality.controller.state;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;

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
     * Method that sets the player character (Of the state PlayerTurn) to the given player
     * character (here it does nothing, but overriden in the PlayerTurn state).
     */
    public void setPlayerCharacter(IPlayerCharacter playerCharacter) {
        ;
    }

    /**
     * Method that returns this state's controller.
     */
    public GameController getController() {
        return this.controller;
    }

    /**
     * Method that returns the player character (Of the state PlayerTurn)
     * (here it returns null, but overriden in the PlayerTurn state).
     */
    public ICharacter getPlayerCharacter() {
        return null;
    }

    /**
     * Method that change's this state's controller state to the one given as parameter.
     */
    protected void changeState(State state) {
        controller.setState(state);
    }

    /**
     * Method that change's the controller's state to CheckingTurn. (here it doesn't
     * do anything, but the behaviour is overriden in concrete states).
     */
    public void checkTurn() {
        ;
    }

    /**
     * Method that change's the controller's state to CheckingQueue. (here it doesn't
     * do anything, but the behaviour is overriden in concrete states).
     */
    public void checkQueue() {
        ;
    }

    /**
     * Method that change's the controller's state to WaitingQueue. (here it doesn't
     * do anything, but the behaviour is overriden in concrete states).
     */
    public void waitQueue() {
        ;
    }

    /**
     * Method that returns to the first phase of the turns flow when the turns queue of
     * the game controller isn't empty; it's only accessible from the WaitingQueue state.
     * (here it doesn't do anything, but the behaviour is overriden in the WaitingQueue
     * state).
     */
    public void queueReady() {
        ;
    }

    /**
     * Method that change's the controller's state to EnemyTurn. (here it doesn't
     * do anything, but the behaviour is overriden in concrete states).
     */
    public void enemyTurn() {
        ;
    }

    /**
     * Method that change's the controller's state to PlayerTurn. (here it doesn't
     * do anything, but the behaviour is overriden in concrete states).
     */
    public void playerTurn() {
        ;
    }


    /**
     * Method that change's the controller's state to Victorious. (here it doesn't
     * do anything, but the behaviour is overriden in concrete states).
     */
    public void victory() {
        ;
    }

    /**
     * Method that change's the controller's state to Defeated. (here it doesn't
     * do anything, but the behaviour is overriden in concrete states).
     */
    public void defeat() {
        ;
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
