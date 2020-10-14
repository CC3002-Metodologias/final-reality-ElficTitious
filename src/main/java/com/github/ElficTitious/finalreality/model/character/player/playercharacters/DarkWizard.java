package com.github.ElficTitious.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractMagePlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds the information and behaviour of all Dark Wizards in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class DarkWizard extends AbstractMagePlayerCharacter {

    /**
     * Creates a Dark Wizard with a name, a given amount of health points, a given
     * amount of defense, a given amount of mana and the queue with the characters ready to play
     * (uses the superclass constructor).
     */
    public DarkWizard(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                      int healthPoints, int defense, int mana) {
        super(turnsQueue, name, healthPoints, defense, mana);
    }

    @Override
    public void equipKnife(Knife knife) {
        super.setEquippedWeapon(knife); //We set the equipped weapon to the given knife.
    }
}
