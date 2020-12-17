package com.github.ElficTitious.finalreality.controller.handlers.concretehandlers;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.handlers.IEventHandler;
import com.github.ElficTitious.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

/**
 * Class that handles enemy turn events.
 *
 * @author Ismael Correa Arellano.
 */
public class EnemyTurnHandler implements IEventHandler {

    private final GameController controller;

    /**
     * Creates an enemy turn handler with a controller associated with it.
     */
    public EnemyTurnHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /* If an enemy turn event is triggered, the method calls the enemyTurn method
        * from the controller. */
        controller.enemyTurn((Enemy) evt.getNewValue());
    }
}
