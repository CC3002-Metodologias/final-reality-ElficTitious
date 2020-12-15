package com.github.ElficTitious.finalreality.model.controller.characterfactory.concretecharacterfactory;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Thief;
import com.github.ElficTitious.finalreality.model.controller.characterfactory.AbstractCharacterFactory;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class ThiefFactory extends AbstractCharacterFactory {

    public ThiefFactory(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                         int healthPoints, int defense) {
        super(turnsQueue, name, healthPoints, defense);
    }

    @Override
    public ICharacter make() {
        return new Thief(turnsQueue, name, healthPoints, defense);
    }
}
