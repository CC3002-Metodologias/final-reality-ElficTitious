package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

public class Axe extends AbstractWeapon {

    /**
     * Creates an Axe with a name, a base damage and weight.
     */
    public Axe(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToCharacter(ICharacter character) {
        character.equipAxe(this);
    }
}
