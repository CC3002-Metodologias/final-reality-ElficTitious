package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;

import java.util.Objects;

/**
 * A class that holds the information and behaviour of all swords in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class Sword extends AbstractWeapon {

    /**
     * Creates a Sword with a name, a base damage and weight (uses the superclass constructor).
     */
    public Sword(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToPlayerCharacter(IPlayerCharacter playerCharacter) {
        playerCharacter.equipSword(this);
    }
}
