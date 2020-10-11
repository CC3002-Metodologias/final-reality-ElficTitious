package com.github.ElficTitious.finalreality.model.character.player;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;


public interface IPlayerCharacter extends ICharacter {

    /**
     * Equips a given axe to a player character.
     */
    void equipAxe(Axe axe);

    /**
     * Equips a given sword to a player character.
     */
    void equipSword(Sword sword);

    /**
     * Equips a given bow to a player character.
     */
    void equipBow(Bow bow);

    /**
     * Equips a given knife to a player character.
     */
    void equipKnife(Knife knife);

    /**
     * Equips a given staff to a player character.
     */
    void equipStaff(Staff staff);

    /**
     * Returns this player character's name.
     */
    String getName();

    /**
     * Returns this player character's type.
     */
    String getType();
}
