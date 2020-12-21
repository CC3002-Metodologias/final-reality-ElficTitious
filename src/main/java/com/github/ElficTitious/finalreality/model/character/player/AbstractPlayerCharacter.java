package com.github.ElficTitious.finalreality.model.character.player;

import com.github.ElficTitious.finalreality.controller.handlers.IEventHandler;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeSupport;
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

    private final PropertyChangeSupport playerCharacterDeathEvent =
            new PropertyChangeSupport(this);
    private final PropertyChangeSupport playerTurnEvent =
            new PropertyChangeSupport(this);
    private final PropertyChangeSupport nonEmptyQueueEvent =
            new PropertyChangeSupport(this);


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

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getAttackPower() {
        IWeapon equippedWeapon = this.getEquippedWeapon();
        if (equippedWeapon == null) {
            return 0;
        }
        else {
            return equippedWeapon.getDamage();
        }
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

    /**
     * Sets this player character's health points to the given integer.
     */
    public void setHealthPoints(int newHP) {
        this.healthPoints = newHP;
    }

    /*
    By default we define that equipping any weapon isn't possible (independent of the
    class that's trying to equip it).
     */

    @Override
    public void equipAxe(Axe axe) {
        ;
    }

    @Override
    public void equipSword(Sword sword) {
        ;
    }

    @Override
    public void equipBow(Bow bow) {
        ;
    }

    @Override
    public void equipKnife(Knife knife) {
        ;
    }

    @Override
    public void equipStaff(Staff staff) {
        ;
    }

    @Override
    public void attack(ICharacter character) {
        character.beingAttacked(this);
    }

    @Override
    public void beingAttacked(ICharacter character) {
        System.out.println("Player Character being attacked");
        int currentHP = this.getHealthPoints();
        int damage = Math.max(0, character.getAttackPower() - this.getDefense());
        /*In order to not diminish the HP below zero, we define health points after
          being attacked as follows*/
        int afterAttackHP = Math.max(0, currentHP - damage);
        this.setHealthPoints(afterAttackHP);
        if (!this.isAlive()) {
            playerCharacterDeathEvent.firePropertyChange("Dead character",
                    null, this);
        }
    }

    @Override
    public void turn() {
        // This player character is sent as newValue.
        playerTurnEvent.firePropertyChange("Player Turn", null, this);
    }

    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor
                .schedule(this::addToQueue, getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
    }

    /**
     * Adds this player character to the turns queue if its alive. If a player's
     * character is added to the turns queue, it triggers a non empty queue event.
     */
    private void addToQueue() {
        if (this.isAlive()) {
            System.out.println("Player Character entered the turns queue");
            turnsQueue.add(this);
            nonEmptyQueueEvent.firePropertyChange("Non Empty Queue",
                    null, null);
        }
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
        /* A player character is defined equal to another one if they have the same name.
        */
        final var playerCharacter = (IPlayerCharacter) obj;
        return getName().equals(playerCharacter.getName());
    }

    /**
     * Returns this player character's hashCode (according to the definition of the equals method).
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    /**
     * Adds the player character death, turn and non empty queue handlers to the player
     * character death, turn and non empty queue events.
     */
    public void addListeners(IEventHandler deathHandler, IEventHandler turnHandler,
                             IEventHandler nonEmptyQueueHandler) {
        playerCharacterDeathEvent.addPropertyChangeListener(deathHandler);
        playerTurnEvent.addPropertyChangeListener(turnHandler);
        nonEmptyQueueEvent.addPropertyChangeListener(nonEmptyQueueHandler);
    }
}
