package com.github.ElficTitious.finalreality.controller.handlers.concretehandlers;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.handlers.IEventHandler;

import java.beans.PropertyChangeEvent;

/**
 * Class that handles player character death events.
 *
 * @author Ismael Correa Arellano.
 */
public class PlayerCharacterDeathHandler implements IEventHandler {

    private final GameController controller;

    /**
     * Creates a player character death handler with a controller associated with it.
     */
    public PlayerCharacterDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /*If a player character death event is triggered, the controller checks for the
         * players loss with the player character that died as its parameter*/
        System.out.println("Character Died");
        controller.checkLoss((IPlayerCharacter) evt.getNewValue());
    }
}
