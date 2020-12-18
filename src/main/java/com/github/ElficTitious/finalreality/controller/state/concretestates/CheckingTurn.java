package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;

public class CheckingTurn extends State {

    @Override
    public void enemyTurn() {
        changeState(new EnemyTurn());
    }

    @Override
    public void playerTurn() {
        changeState(new PlayerTurn());
    }

    @Override
    public boolean isCheckingTurn() {
        return true;
    }
}
