package com.github.ElficTitious.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds the information and behaviour of all enemies in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class Enemy implements ICharacter{

    protected final BlockingQueue<ICharacter> turnsQueue;
    private ScheduledExecutorService scheduledExecutor;
    private final String name;
    private final int healthPoints;
    private final int defense;
    private final int weight;
    private final int attackPower;

    /**
     * Creates a new enemy with a name, a weight and the queue with the characters ready to
     * play.
     */
    public Enemy(@NotNull final BlockingQueue<ICharacter> turnsQueue,
                 @NotNull final String name, final int healthPoints, final int defense,
                 final int weight, final int attackPower) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.weight = weight;
        this.attackPower = attackPower;
        this.turnsQueue = turnsQueue;
    }

    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        var enemy = (Enemy) this;
        scheduledExecutor
                .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }

    /**
     * Adds this enemy to the turns queue.
     */
    private void addToQueue() {
        turnsQueue.add(this);
        scheduledExecutor.shutdown();
    }

    /**
     * Returns this enemy's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns this enemy's health points.
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Returns this enemy's defense.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Returns this enemy's weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns this enemy's attack power.
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Method that compares two enemies, returning if they are equal or not.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) { //If the Object is exactly the enemy, then they are equal.
            return true;
        }
        if (!(obj instanceof Enemy)) {
            return false;
        }
        /* An enemy is defined equal to another one if they have the
        same name and same weight.
        */
        final var enemy = (Enemy) obj;
        return getWeight() == enemy.getWeight() &&
                getName().equals(enemy.getName());
    }

    /**
     * Returns this enemy's hashCode (according to the definition of the equals method).
     */
    @Override
    public int hashCode() {
        return Objects.hash(Enemy.class, getName(), getWeight());
    }
}
