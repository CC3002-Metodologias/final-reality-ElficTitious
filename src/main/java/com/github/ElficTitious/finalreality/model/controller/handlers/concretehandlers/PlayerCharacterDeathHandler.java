package com.github.ElficTitious.finalreality.model.controller.handlers.concretehandlers;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.controller.GameController;
import com.github.ElficTitious.finalreality.model.controller.handlers.IEventHandler;

import java.beans.PropertyChangeEvent;

public class PlayerCharacterDeathHandler implements IEventHandler {

    private final GameController controller;

    public PlayerCharacterDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.checkLoss((IPlayerCharacter) evt.getNewValue());
    }
}
