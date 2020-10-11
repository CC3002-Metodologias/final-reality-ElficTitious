package com.github.ElficTitious.finalreality.model.weapon;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;

import java.util.Objects;

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

    /**
     * Returns this weapon's damage.
     */
    public int getDamage() {
        return damage;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IWeapon)) {
            return false;
        }
        final var weapon = (IWeapon) obj;
        return getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName()) &&
                getType().equals(weapon.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getName(), getWeight());
    }
}
