package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;

import java.util.Objects;

/**
 * A class that holds the information and behaviour of all knives in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class Knife extends AbstractWeapon {

    /**
     * Creates a Knife with a name, a base damage and weight (uses the superclass constructor).
     */
    public Knife(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToPlayerCharacter(IPlayerCharacter playerCharacter) {
        playerCharacter.equipKnife(this);
    }
}
