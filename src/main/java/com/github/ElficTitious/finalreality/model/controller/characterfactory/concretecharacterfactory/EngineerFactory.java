package com.github.ElficTitious.finalreality.model.controller.characterfactory.concretecharacterfactory;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.DarkWizard;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.controller.characterfactory.AbstractCharacterFactory;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class EngineerFactory extends AbstractCharacterFactory {

    public EngineerFactory(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                             int healthPoints, int defense) {
        super(turnsQueue, name, healthPoints, defense);
    }

    @Override
    public ICharacter make() {
        return new Engineer(turnsQueue, name, healthPoints, defense);
    }
}
