package com.github.ElficTitious.finalreality.model.character;


import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ismael Correa Arellano.
 */
public interface ICharacter {

    /**
     * Attacks a character given as parameter.
     * It sends a message to the character which determines if it can be attacked and if
     * so, by how much.
     *
     * @param character
     *      character which is being attacked.
     */
    void attack(ICharacter character);

    /**
     * Method that determines if it can be attacked by the character given as parameter and
     * if so, by how much its health points diminish.
     *
     * @param character
     *      character which is attacking.
     */
    void beingAttacked(ICharacter character);

    /**
     * Sets a scheduled executor to make this character (thread) wait for {@code weight / 10}
     * seconds before adding the character to the queue.
     */
    void waitTurn();

    /**
     * Returns this character's attack power.
     */
    int getAttackPower();
}
