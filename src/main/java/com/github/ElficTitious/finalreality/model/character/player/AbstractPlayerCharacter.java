package com.github.ElficTitious.finalreality.model.character.player;

import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPlayerCharacter implements IPlayerCharacter {

    protected final BlockingQueue<ICharacter> turnsQueue;
    private ScheduledExecutorService scheduledExecutor;
    private final String name;
    private int healthPoints;
    private int defense;
    private IWeapon equippedWeapon = null;


    public AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                  int healthPoints, int defense) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.turnsQueue = turnsQueue;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns this player character's health points.
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Returns this player character's defense.
     */
    public int getDefense() {
        return defense;
    }

    @Override
    public IWeapon getEquippedWeapon() {
        return equippedWeapon;
    }

    protected void setEquippedWeapon(IWeapon weapon) {
        this.equippedWeapon = weapon;
    }

    @Override
    public void equipAxe(Axe axe) {
        System.out.println("Not possible to equip this weapon.");
    }

    @Override
    public void equipSword(Sword sword) {
        System.out.println("Not possible to equip this weapon.");
    }

    @Override
    public void equipBow(Bow bow) {
        System.out.println("Not possible to equip this weapon.");
    }

    @Override
    public void equipKnife(Knife knife) {
        System.out.println("Not possible to equip this weapon.");
    }

    @Override
    public void equipStaff(Staff staff) {
        System.out.println("Not possible to equip this weapon.");
    }

    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor
                .schedule(this::addToQueue, getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
    }

    /**
     * Adds this player character to the turns queue.
     */
    private void addToQueue() {
        turnsQueue.add(this);
        scheduledExecutor.shutdown();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IPlayerCharacter)) {
            return false;
        }
        final var playerCharacter = (IPlayerCharacter) obj;
        return getName().equals(playerCharacter.getName()) &&
                getClass() == playerCharacter.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), getName());
    }
}
