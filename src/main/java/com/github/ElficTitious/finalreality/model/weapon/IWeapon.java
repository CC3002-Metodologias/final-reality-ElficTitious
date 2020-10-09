package com.github.ElficTitious.finalreality.model.weapon;


/**
 * This represents a weapon from the game.
 */
public interface IWeapon {

    /**
     * Returns this weapon's name.
     */
    String getName();

    /**
     * Returns this weapon's damage.
     */
    int getDamage();

    /**
     * Returns this weapon's weight.
     */
    int getWeight();
}
