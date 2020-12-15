package com.github.ElficTitious.finalreality.model.controller.weaponfactory;

public abstract class AbstractWeaponFactory implements IWeaponFactory{

    protected final String name;
    protected final int damage;
    protected final int weight;

    public AbstractWeaponFactory(final String name, final int damage, final int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }
}
