package com.github.ElficTitious.finalreality.model.weapon;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;

import java.util.Objects;

/**
 * An Abstract class that holds the common behaviour of all the weapons in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 */
public abstract class AbstractWeapon implements IWeapon{

    private final String name;
    private final int damage;
    private final int weight;

    /**
     * Creates a weapon with a name, a base damage and weight.
     */
    public AbstractWeapon(final String name, final int damage, final int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    /**
     * Method that compares two weapons, returning if they are equal or not.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) { //If the Object is exactly the weapon, then they are equal.
            return true;
        }

        if (!(obj instanceof IWeapon)) {
            return false;
        }
        /* A weapon is defined equal to another one if they belong to the same class, have the
        same name and same weight.
        */
        final var weapon = (IWeapon) obj;
        return getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName()) &&
                getClass() == weapon.getClass();
    }

    /**
     * Returns this weapon´s hashCode (according to the definition of the equals method).
     */
    @Override
    public int hashCode() {
        return Objects.hash(getClass(), getName(), getWeight());
    }
}
