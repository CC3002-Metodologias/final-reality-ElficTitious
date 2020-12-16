package com.github.ElficTitious.finalreality.model.controller.handlers.concretehandlers;

import com.github.ElficTitious.finalreality.model.controller.GameController;
import com.github.ElficTitious.finalreality.model.controller.handlers.IEventHandler;

import java.beans.PropertyChangeEvent;

public class PlayerTurnHandler implements IEventHandler {

    private final GameController controller;

    public PlayerTurnHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.playerTurn();
    }
}
