package com.github.ElficTitious.finalreality.model.controller.weaponfactory.concreteweaponfactory;

import com.github.ElficTitious.finalreality.model.controller.weaponfactory.AbstractWeaponFactory;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Staff;

public class StaffFactory extends AbstractWeaponFactory {

    private final int magicDamage;

    public StaffFactory(final String name, final int damage, final int magicDamage,
                        final int weight) {
        super(name, damage, weight);
        this.magicDamage = magicDamage;
    }

    @Override
    public IWeapon make() {
        return new Staff(name, damage, magicDamage, weight);
    }
}
