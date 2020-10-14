package com.github.ElficTitious.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractMagePlayerCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds the information and behaviour of all White Wizards in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class WhiteWizard extends AbstractMagePlayerCharacter {

    /**
     * Creates a White Wizard with a name, a given amount of health points, a given
     * amount of defense, a given amount of mana and the queue with the characters ready to play
     * (uses the superclass constructor).
     */
    public WhiteWizard(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                       int healthPoints, int defense, int mana) {
        super(turnsQueue, name, healthPoints, defense, mana);
    }
}
