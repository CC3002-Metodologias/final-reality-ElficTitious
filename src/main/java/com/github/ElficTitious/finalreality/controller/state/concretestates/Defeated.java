package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

/**
 * Class that represents the state were the player lost the game.
 */
public class Defeated extends State {

    @Override
    public boolean isDefeated() {
        return true;
    }
}
