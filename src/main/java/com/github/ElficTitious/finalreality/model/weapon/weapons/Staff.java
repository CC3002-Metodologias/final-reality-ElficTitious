package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;

import java.util.Objects;

/**
 * A class that holds the information and behaviour of all staves in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class Staff extends AbstractWeapon {

    private final int magicDamage;

    /**
     * Creates a Staff with a name, a base damage, a base magic damage and weight
     * (uses the superclass constructor).
     */
    public Staff(final String name, final int damage, final int magicDamage, final int weight) {
        super(name, damage, weight);
        this.magicDamage = magicDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    @Override
    public void equipToPlayerCharacter(IPlayerCharacter playerCharacter) {
        playerCharacter.equipStaff(this);
    }
}
