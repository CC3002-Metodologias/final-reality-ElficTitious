package com.github.ElficTitious.finalreality.controller.handlers.concretehandlers;

import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.handlers.IEventHandler;

import java.beans.PropertyChangeEvent;
import java.io.PrintStream;

/**
 * Class that handles enemy death events.
 *
 * @author Ismael Correa Arellano.
 */
public class EnemyDeathHandler implements IEventHandler {

    private final GameController controller;

    /**
     * Creates an enemy death handler with a controller associated with it.
     */
    public EnemyDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /*If a enemy death event is triggered, the controller checks for the
        * players victory with the enemy that died as its parameter*/
        controller.checkVictory((Enemy) evt.getNewValue());
    }
}
