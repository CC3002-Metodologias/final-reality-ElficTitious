package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.Objects;

/**
 * A class that holds the information and behaviour of all axes in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class Axe extends AbstractWeapon {

    /**
     * Creates an Axe with a name, a base damage and weight (uses the superclass constructor).
     */
    public Axe(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToPlayerCharacter(IPlayerCharacter playerCharacter) {
        playerCharacter.equipAxe(this);
    }
}
