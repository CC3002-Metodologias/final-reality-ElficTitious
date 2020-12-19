package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

/**
 * Class that represents the initial state of the game. From this state the only accessible
 * state is CheckingTurn. Necessary methods are overriden.
 */
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
