package com.github.ElficTitious.finalreality.model.controller.characterfactory.concretecharacterfactory;

import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.controller.characterfactory.AbstractCharacterFactory;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class EnemyFactory extends AbstractCharacterFactory{

    private final int weight;
    private final int attackPower;

    public EnemyFactory(@NotNull final BlockingQueue<ICharacter> turnsQueue,
                        @NotNull final String name, final int healthPoints, final int defense,
                        final int weight, final int attackPower) {
        super(turnsQueue, name, healthPoints, defense);
        this.weight = weight;
        this.attackPower = attackPower;

    }

    @Override
    public ICharacter make() {
        return new Enemy(turnsQueue, name, healthPoints, defense, weight, attackPower);
    }
}
