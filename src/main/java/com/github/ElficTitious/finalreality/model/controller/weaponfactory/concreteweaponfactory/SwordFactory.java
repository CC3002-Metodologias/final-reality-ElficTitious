package com.github.ElficTitious.finalreality.model.controller.weaponfactory.concreteweaponfactory;

import com.github.ElficTitious.finalreality.model.controller.weaponfactory.AbstractWeaponFactory;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;

public class SwordFactory extends AbstractWeaponFactory {

    public SwordFactory(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public IWeapon make() {
        return new Sword(name, damage, weight);
    }
}
