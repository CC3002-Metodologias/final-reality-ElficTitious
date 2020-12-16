package com.github.ElficTitious.finalreality.model.controller.handlers.concretehandlers;

import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.controller.GameController;
import com.github.ElficTitious.finalreality.model.controller.handlers.IEventHandler;

import java.beans.PropertyChangeEvent;

public class EnemyDeathHandler implements IEventHandler {

    private final GameController controller;

    public EnemyDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.checkVictory((Enemy) evt.getNewValue());
    }
}
