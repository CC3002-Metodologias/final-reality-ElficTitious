package com.github.ElficTitious.finalreality.model.controller;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

public class PlayerCharacterDeathHandler implements IEventHandler{

    private final GameController controller;

    public PlayerCharacterDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.checkLoss((IPlayerCharacter) evt.getNewValue());
    }
}
