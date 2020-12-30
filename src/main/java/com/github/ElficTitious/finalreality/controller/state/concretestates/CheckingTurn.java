package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

/**
 * Class that represents the state where the game controller is waiting the message that
 * tells it if the turn belongs to the player or the enemy. From this state the accessible
 * states are EnemyTurn and PlayerTurn. Necessary methods are overriden.
 */
public class CheckingTurn extends State {

    @Override
    public void enemyTurn() {
        changeState(new EnemyTurn());
    }

    @Override
    public void playerTurn() {
        changeState(new PlayerTurn());
    }

    @Override
    public boolean isCheckingTurn() {
        return true;
    }
}
