package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.state.State;

/**
 * Class that represents the state were the controller is waiting for a character to enter
 * the turns queue in order to return to the first phase of the turns flow. From this state
 * the only accessible state is CheckingTurn. Necessary methods are overriden.
 */
public class WaitingQueue extends State {

    @Override
    public void checkTurn() {
        changeState(new CheckingTurn());
    }

    @Override
    public void queueReady() {
        GameController controller = getController();
        /* In order to return to the first phase of the turns flow we call the
        * getNextCharacter method from the controller. */
        controller.getNextCharacter();
    }

    @Override
    public boolean isWaitingQueue() {
        return true;
    }
}
