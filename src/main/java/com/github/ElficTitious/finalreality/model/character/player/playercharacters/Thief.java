package com.github.ElficTitious.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Staff;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds the information and behaviour of all Thieves in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class Thief extends AbstractPlayerCharacter {

    /**
     * Creates a Thief with a name, a given amount of health points, a given amount
     * of defense and the queue with the characters ready to play.
     */
    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                 int healthPoints, int defense) {
        super(turnsQueue, name, healthPoints, defense);
    }

    @Override
    public void equipSword(Sword sword) {
        if (this.isAlive()) { //if this thief is alive
            super.setEquippedWeapon(sword); //We set the equipped weapon to the given sword.
        }
    }

    @Override
    public void equipStaff(Staff staff) {
        if (this.isAlive()) { //if this thief is alive
            super.setEquippedWeapon(staff); //We set the equipped weapon to the given staff.
        }
    }

    @Override
    public void equipBow(Bow bow) {
        if (this.isAlive()) { //if this thief is alive
            super.setEquippedWeapon(bow); //We set the equipped weapon to the given bow.
        }
    }
}
