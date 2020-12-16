package com.github.ElficTitious.finalreality.model.character.player;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * An Abstract class that holds the common behaviour and information of all magic characters
 * controlled by the player in the game (either a White or Dark Wizard).
 *
 * @author Ismael Correa Arellano.
 */
public abstract class AbstractMagePlayerCharacter extends AbstractPlayerCharacter implements IMageCharacter {

    private int mana;

    /**
     * Creates a new mage player character with a name, a given amount of health points, a given
     * amount of defense, a given amount of mana and the queue with the characters ready to play
     * (uses the superclass constructor).
     */
    public AbstractMagePlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                       int healthPoints, int defense, int mana) {
        super(turnsQueue, name, healthPoints, defense);
        this.mana = mana;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void equipStaff(Staff staff) {
        super.setEquippedWeapon(staff); //We set the equipped weapon to the given staff.
    }
}
