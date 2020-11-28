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

/**
 * An Abstract class that holds the common behaviour and information of all characters
 * controlled by the player in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 */
public abstract class AbstractPlayerCharacter implements IPlayerCharacter {

    protected final BlockingQueue<ICharacter> turnsQueue;
    private ScheduledExecutorService scheduledExecutor;
    private final String name;
    private int healthPoints;
    private int defense;
    private IWeapon equippedWeapon = null;


    /**
     * Creates a new player character with a name, a given amount of health points, a given amount
     * of defense and the queue with the characters ready to play.
     */
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

    @Override
    public boolean isAlive() {
        return this.getHealthPoints() > 0;
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

    /**
     * Sets the {@code equippedWeapon} of this player character to the weapon given
     * as parameter.
     *
     * @param weapon
     * weapon which we want to set as {@code equippedWeapon} of this character.
     */
    protected void setEquippedWeapon(IWeapon weapon) {
        this.equippedWeapon = weapon;
    }

    /*
    By default we define that equipping any weapon isn't possible (independent of the
    class that's trying to equip it).
     */

    @Override
    public void equipAxe(Axe axe) {

    }

    @Override
    public void equipSword(Sword sword) {
    }

    @Override
    public void equipBow(Bow bow) {

    }

    @Override
    public void equipKnife(Knife knife) {

    }

    @Override
    public void equipStaff(Staff staff) {

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

    /**
     * Method that compares two player characters, returning if they are equal or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { //If the Object is exactly the player character, then they are equal.
            return true;
        }

        if (!(obj instanceof IPlayerCharacter)) {
            return false;
        }
        /* A player character is defined equal to another one if they belong to the same class
        and have the same name.
        */
        final var playerCharacter = (IPlayerCharacter) obj;
        return getName().equals(playerCharacter.getName()) &&
                getClass() == playerCharacter.getClass();
    }

    /**
     * Returns this player character's hashCode (according to the definition of the equals method).
     */
    @Override
    public int hashCode() {
        return Objects.hash(getClass(), getName());
    }
}
