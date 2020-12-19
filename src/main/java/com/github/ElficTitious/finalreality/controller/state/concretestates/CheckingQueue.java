package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

/**
 * Class that represents the state where the game controller tries to return to the
 * first phase of the turns flow by checking if the turns queue contains characters.
 * From this state the accessible states are CheckingTurn and WaitingQueue. Necessary
 * methods are overriden.
 */
public class CheckingQueue extends State {

    @Override
    public void checkTurn() {
        changeState(new CheckingTurn());
    }

    @Override
    public void waitQueue() {
        changeState(new WaitingQueue());
    }

    @Override
    public boolean isCheckingQueue() {
        return true;
    }
}
