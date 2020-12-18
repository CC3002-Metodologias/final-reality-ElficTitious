package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

public class EnemyTurn extends State {

    @Override
    public void defeat() {
        changeState(new Defeated());
    }

    @Override
    public void checkTurn() {
        changeState(new CheckingQueue());
    }

    @Override
    public boolean isEnemyTurn() {
        return true;
    }
}
