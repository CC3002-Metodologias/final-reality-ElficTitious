package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

public class Starting extends State {

    @Override
    public void checkTurn() {
        changeState(new CheckingTurn());
    }

    @Override
    public boolean isStarting() {
        return true;
    }
}
