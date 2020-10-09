package com.github.ElficTitious.finalreality.model.weapon;


import com.github.ElficTitious.finalreality.model.character.ICharacter1;

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

    /**
     * Equips a given weapon determined by the class to the character given as parameter.
     * @param character
     *      character which you want to equip the weapon.
     */
    void equipToCharacter(ICharacter1 character);
}
