package com.github.ElficTitious.finalreality.model.controller.characterfactory.concretecharacterfactory;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.ElficTitious.finalreality.model.controller.characterfactory.AbstractCharacterFactory;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class KnightFactory extends AbstractCharacterFactory {

    public KnightFactory(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                           int healthPoints, int defense) {
        super(turnsQueue, name, healthPoints, defense);
    }

    @Override
    public ICharacter make() {
        return new Knight(turnsQueue, name, healthPoints, defense);
    }
}
