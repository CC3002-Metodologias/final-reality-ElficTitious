package com.github.ElficTitious.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.github.ElficTitious.finalreality.model.character.player.CharacterClass;
import org.jetbrains.annotations.NotNull;

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
    public Enemy(@NotNull final String name, final int healthPoints,
                  final int defense, final int weight, final int attackPower,
                  @NotNull final BlockingQueue<ICharacter> turnsQueue) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.weight = weight;
        this.attackPower = attackPower;
        this.turnsQueue = turnsQueue;
    }

    /**
     * Returns the weight of this enemy.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns the attack power of this enemy.
     */
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String getName() {
        return name;
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
}
