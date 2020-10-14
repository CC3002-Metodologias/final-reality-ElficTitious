package com.github.ElficTitious.finalreality.model.character;


/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 */
public interface ICharacter {

    /**
     * Sets a scheduled executor to make this character (thread) wait for {@code weight / 10}
     * seconds before adding the character to the queue.
     */
    void waitTurn();
}
