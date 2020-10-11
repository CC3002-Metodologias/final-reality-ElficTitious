package com.github.ElficTitious.finalreality.model.weapon;


import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;

/**
 * This represents a weapon from the game.
 */
public interface IWeapon {

    /**
     * Equips a given weapon determined by it's class to the player character given as parameter.
     * (double dispatch scheme).
     * @param playerCharacter
     *      player character which you want to equip the weapon.
     */
    void equipToPlayerCharacter(IPlayerCharacter playerCharacter);

    /**
     * Returns this weapon's weight.
     */
    int getWeight();

    /**
     * Returns this weapon's damage.
     */
    int getDamage();

    /**
     * Returns this weapon's type.
     */
    String getType();

    /**
     * Returns this weapon's name.
     */
    String getName();
}
