package com.github.ElficTitious.finalreality.model.controller.characterfactory.concretecharacterfactory;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.DarkWizard;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import com.github.ElficTitious.finalreality.model.controller.characterfactory.AbstractCharacterFactory;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteWizardFactory extends AbstractCharacterFactory {

    private int mana;

    public WhiteWizardFactory(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                             int healthPoints, int defense, int mana) {
        super(turnsQueue, name, healthPoints, defense);
        this.mana = mana;
    }

    @Override
    public ICharacter make() {
        return new WhiteWizard(turnsQueue, name, healthPoints, defense, mana);
    }
}
