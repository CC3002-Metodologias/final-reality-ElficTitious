package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.ICharacter1;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;

public class Axe extends AbstractWeapon {

    /**
     * Creates an Axe with a name, a base damage and weight.
     */
    public Axe(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToCharacter(ICharacter1 character) {
        character.equipAxe(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Axe)) {
            return false;
        }
        final Axe axe = (Axe) o;
        return getDamage() == axe.getDamage() &&
                getWeight() == axe.getWeight() &&
                getName().equals(axe.getName());
    }


}
