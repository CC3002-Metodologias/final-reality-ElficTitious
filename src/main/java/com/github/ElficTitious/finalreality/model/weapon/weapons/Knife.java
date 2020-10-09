package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;

public class Knife extends AbstractWeapon {

    /**
     * Creates a Knife with a name, a base damage and weight.
     */
    public Knife(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToCharacter(ICharacter character) {
        character.equipBow(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Knife)) {
            return false;
        }
        final Knife knife = (Knife) o;
        return getDamage() == knife.getDamage() &&
                getWeight() == knife.getWeight() &&
                getName().equals(knife.getName());
    }
}
