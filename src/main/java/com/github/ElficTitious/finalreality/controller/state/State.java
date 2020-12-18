package com.github.ElficTitious.finalreality.controller.state;

import com.github.ElficTitious.finalreality.controller.GameController;

public class State {

    private GameController controller;

    public void setController(GameController controller) {
        this.controller = controller;
    }

    protected void changeState(State state) {
        controller.setState(state);
    }

    void error() { throw new AssertionError("Wrong State"); }

    public void checkTurn() {
        error();
    }

    public void checkQueue() {
        error();
    }

    public void enemyTurn() {
        error();
    }

    public void playerTurn() {
        error();
    }

    public void victory() {
        error();
    }

    public void defeat() {
        error();
    }

    public boolean isStarting() {
        return false;
    }

    public boolean isTakingCharacter() {
        return false;
    }

    public boolean isEnemyTurn() {
        return false;
    }

    public boolean isPlayerTurn() {
        return false;
    }

    public boolean isDefeated() {
        return false;
    }

    public boolean isVictorious() {
        return false;
    }

    public boolean isCheckingQueue() {
        return false;
    }
}
