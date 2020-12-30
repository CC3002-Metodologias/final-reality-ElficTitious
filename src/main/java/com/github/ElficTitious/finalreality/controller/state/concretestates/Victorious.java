package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

/**
 * Class that represents the state were the player won the game.
 */
public class Victorious extends State {

    @Override
    public boolean isVictorious() {
        return true;
    }
}
