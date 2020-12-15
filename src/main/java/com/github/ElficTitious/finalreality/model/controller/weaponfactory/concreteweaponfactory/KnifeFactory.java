package com.github.ElficTitious.finalreality.model.controller.weaponfactory.concreteweaponfactory;

import com.github.ElficTitious.finalreality.model.controller.weaponfactory.AbstractWeaponFactory;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;

public class KnifeFactory extends AbstractWeaponFactory {

    public KnifeFactory(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public IWeapon make() {
        return new Knife(name, damage, weight);
    }
}
