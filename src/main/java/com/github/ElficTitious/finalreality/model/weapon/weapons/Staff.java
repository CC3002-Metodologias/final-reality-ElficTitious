package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.ICharacter1;
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
    public void equipToCharacter(ICharacter1 character) {
        character.equipStaff(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        final Staff staff = (Staff) o;
        return getDamage() == staff.getDamage() &&
                getMagicDamage() == staff.getMagicDamage() &&
                getWeight() == staff.getWeight() &&
                getName().equals(staff.getName());
    }
}
