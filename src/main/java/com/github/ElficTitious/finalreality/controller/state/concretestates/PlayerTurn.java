package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

/**
 * Class that represents the state were the turn belongs to the player. From this state
 * the accessible states are Victorious and CheckingQueue. Necessary methods are overriden.
 */
public class PlayerTurn extends State {

    @Override
    public void victory() {
        changeState(new Victorious());
    }

    @Override
    public void checkQueue() {
        changeState(new CheckingQueue());
    }

    @Override
    public boolean isPlayerTurn() {
        return true;
    }
}
