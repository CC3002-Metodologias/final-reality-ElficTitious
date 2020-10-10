package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;

public class Staff extends AbstractWeapon {

    private final int magicDamage;

    /**
     * Creates a Staff with a name, a base damage, a base magic damage and weight.
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
