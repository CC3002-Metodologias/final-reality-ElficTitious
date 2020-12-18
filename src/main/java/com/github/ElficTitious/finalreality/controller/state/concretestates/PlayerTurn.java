package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

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
