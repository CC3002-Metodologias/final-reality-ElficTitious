package com.github.ElficTitious.finalreality.controller.handlers.concretehandlers;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.handlers.IEventHandler;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

/**
 * Class that handles player character turn events.
 *
 * @author Ismael Correa Arellano.
 */
public class PlayerTurnHandler implements IEventHandler {

    private final GameController controller;

    /**
     * Creates a player character turn handler with a controller associated with it.
     */
    public PlayerTurnHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /* If a player character turn event is triggered, the method calls the playerTurn
         * method from the controller. */
        controller.playerTurn((IPlayerCharacter) evt.getNewValue());
    }
}
