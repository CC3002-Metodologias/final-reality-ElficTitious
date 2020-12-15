package com.github.ElficTitious.finalreality.model.controller.weaponfactory.concreteweaponfactory;

import com.github.ElficTitious.finalreality.model.controller.weaponfactory.AbstractWeaponFactory;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;

public class AxeFactory extends AbstractWeaponFactory {

    public AxeFactory(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public IWeapon make() {
        return new Axe(name, damage, weight);
    }
}
