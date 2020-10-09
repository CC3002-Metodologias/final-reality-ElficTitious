package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;

public class Sword extends AbstractWeapon {

    /**
     * Creates a Sword with a name, a base damage and weight.
     */
    public Sword(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToCharacter(ICharacter character) {
        character.equipSword(this);
    }
}
