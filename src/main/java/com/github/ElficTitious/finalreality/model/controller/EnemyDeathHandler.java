package com.github.ElficTitious.finalreality.model.controller;

import com.github.ElficTitious.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

public class EnemyDeathHandler implements IEventHandler{

    private final GameController controller;

    public EnemyDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.checkVictory((Enemy) evt.getNewValue());
    }
}
