package com.github.ElficTitious.finalreality.controller;

import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.ArrayList;

/**
 * A class that holds the information of the inventory of the player and manages it.
 *
 * @author Ismael Correa Arellano.
 */
public class Inventory {

    private ArrayList<IWeapon> inventory;

    /**
     * Creates an inventory implemented as an array list of IWeapons.
     */
    public Inventory() {
        this.inventory = new ArrayList<IWeapon>();
    }

    /**
     * Returns this inventory's inventory field.
     */
    public ArrayList<IWeapon> getInventory() {
        return this.inventory;
    }

    /**
     * Method that adds the weapon given as a parameter to the inventory.
     */
    public void addWeapon(IWeapon weapon) {
        //We simply add the weapon to the end of the array list that represents the inventory.
        inventory.add(weapon);
    }

    /**
     * Method that removes the weapon given as a parameter from the inventory.
     */
    public void removeWeapon(IWeapon weapon) {
        inventory.remove(weapon);
    }
}
