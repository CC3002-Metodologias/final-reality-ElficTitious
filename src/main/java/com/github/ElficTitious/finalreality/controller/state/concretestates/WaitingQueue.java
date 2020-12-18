package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.state.State;

public class WaitingQueue extends State {

    @Override
    public void checkTurn() {
        changeState(new CheckingTurn());
    }

    @Override
    public void queueReady() {
        GameController controller = getController();
        controller.getNextCharacter();
    }

    @Override
    public boolean isWaitingQueue() {
        return true;
    }
}
