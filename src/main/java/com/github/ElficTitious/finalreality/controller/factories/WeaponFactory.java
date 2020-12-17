package com.github.ElficTitious.finalreality.controller.factories;

import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;

/**
 * A class that holds all the weapon creation methods and getters
 * for their fields.
 *
 * @author Ismael Correa Arellano.
 */
public class WeaponFactory {

    /**
     * Creates a new axe with all its fields initialized.
     */
    public IWeapon createAxe(final String name, final int damage, final int weight) {
        return new Axe(name, damage, weight);
    }

    /**
     * Creates a new bow with all its fields initialized.
     */
    public IWeapon createBow(final String name, final int damage, final int weight) {
        return new Bow(name, damage, weight);
    }

    /**
     * Creates a new knife with all its fields initialized.
     */
    public IWeapon createKnife(final String name, final int damage, final int weight) {
        return new Knife(name, damage, weight);
    }

    /**
     * Creates a new staff with all its fields initialized.
     */
    public IWeapon createStaff(final String name, final int damage, final int magicDamage,
                               final int weight) {
        return new Staff(name, damage, magicDamage, weight);
    }

    /**
     * Creates a new sword with all its fields initialized.
     */
    public IWeapon createSword(final String name, final int damage, final int weight) {
        return new Sword(name, damage, weight);
    }

    //Weapon getters:

    /**
     * Returns the name of the weapon given as parameter.
     */
    public String getName(IWeapon weapon) {
        return weapon.getName();
    }

    /**
     * Returns the damage of the weapon given as parameter.
     */
    public int getDamage(IWeapon weapon) {
        return weapon.getDamage();
    }

    /**
     * Returns the weight of the weapon given as parameter.
     */
    public int getWeight(IWeapon weapon) {
        return weapon.getWeight();
    }

    /**
     * Returns the magic damage of the staff given as parameter.
     */
    public int getMagicDamage(Staff staff) {
        return staff.getMagicDamage();
    }
}
