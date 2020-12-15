package com.github.ElficTitious.finalreality.model.controller.characterfactory;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractCharacterFactory implements ICharacterFactory{

    protected final BlockingQueue<ICharacter> turnsQueue;
    protected final String name;
    protected int healthPoints;
    protected int defense;


    public AbstractCharacterFactory(@NotNull BlockingQueue<ICharacter> turnsQueue,
                                    @NotNull String name, int healthPoints, int defense) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.turnsQueue = turnsQueue;
    }
}
