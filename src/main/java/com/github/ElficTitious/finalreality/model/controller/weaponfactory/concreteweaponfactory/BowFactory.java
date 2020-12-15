package com.github.ElficTitious.finalreality.model.controller.weaponfactory.concreteweaponfactory;

import com.github.ElficTitious.finalreality.model.controller.weaponfactory.AbstractWeaponFactory;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;

public class BowFactory extends AbstractWeaponFactory {

    public BowFactory(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public IWeapon make() {
        return new Bow(name, damage, weight);
    }
}
