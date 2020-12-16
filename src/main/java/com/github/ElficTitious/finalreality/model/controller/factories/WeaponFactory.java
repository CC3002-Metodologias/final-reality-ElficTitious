package com.github.ElficTitious.finalreality.model.controller.factories;

import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;

public class WeaponFactory {

    public IWeapon createAxe(final String name, final int damage, final int weight) {
        return new Axe(name, damage, weight);
    }

    public IWeapon createBow(final String name, final int damage, final int weight) {
        return new Bow(name, damage, weight);
    }

    public IWeapon createKnife(final String name, final int damage, final int weight) {
        return new Knife(name, damage, weight);
    }

    public IWeapon createStaff(final String name, final int damage, final int magicDamage,
                               final int weight) {
        return new Staff(name, damage, magicDamage, weight);
    }

    public IWeapon createSword(final String name, final int damage, final int weight) {
        return new Sword(name, damage, weight);
    }

    //Weapon getters:

    public String getName(IWeapon weapon) {
        return weapon.getName();
    }

    public int getDamage(IWeapon weapon) {
        return weapon.getDamage();
    }

    public int getWeight(IWeapon weapon) {
        return weapon.getWeight();
    }

    public int getMagicDamage(Staff staff) {
        return staff.getMagicDamage();
    }
}
