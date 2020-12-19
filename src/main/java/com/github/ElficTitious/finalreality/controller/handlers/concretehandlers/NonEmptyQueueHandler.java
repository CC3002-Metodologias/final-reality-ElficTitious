package com.github.ElficTitious.finalreality.controller.handlers.concretehandlers;

import com.github.ElficTitious.finalreality.controller.GameController;
import com.github.ElficTitious.finalreality.controller.handlers.IEventHandler;
import com.github.ElficTitious.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

/**
 * Class that handles the non empty queue events.
 *
 * @author Ismael Correa Arellano.
 */
public class NonEmptyQueueHandler implements IEventHandler {

    private final GameController controller;

    /**
     * Creates a non empty queue handler with a controller associated with it.
     */
    public NonEmptyQueueHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /* If a non empty queue event is triggered, the method calls the queueReady method
         * from the controller. */
        controller.queueReady();
    }
}
