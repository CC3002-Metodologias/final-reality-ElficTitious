package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

/**
 * Class that represents the state were the turn belongs to the enemy. From this state
 * the accessible states are Defeated and CheckingQueue. Necessary methods are overriden.
 */
public class EnemyTurn extends State {

    @Override
    public void defeat() {
        changeState(new Defeated());
    }

    @Override
    public void checkQueue() {
        changeState(new CheckingQueue());
    }

    @Override
    public boolean isEnemyTurn() {
        return true;
    }
}
