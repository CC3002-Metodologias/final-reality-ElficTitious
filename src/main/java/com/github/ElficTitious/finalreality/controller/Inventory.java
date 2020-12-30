package com.github.ElficTitious.finalreality.controller;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.ArrayList;
import java.util.Objects;

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

    /**
     * Method that compares if two inventories, returning if they're equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { //If the Object is exactly this inventory, then they are equal.
            return true;
        }

        if (!(obj instanceof Inventory)) {
            return false;
        }
        /* An Inventory is defined equal to another one if their inventory arrays are
         * equal. */
        final var inventory = (Inventory) obj;
        return getInventory().equals(inventory.getInventory());
    }

    /**
     * Returns this inventory's hashCode (according to the definition of the
     * equals method).
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getInventory());
    }
}
