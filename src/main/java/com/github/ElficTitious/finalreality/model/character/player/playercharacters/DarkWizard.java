package com.github.ElficTitious.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractMagePlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class DarkWizard extends AbstractMagePlayerCharacter {

    public DarkWizard(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                      int healthPoints, int defense, int mana) {
        super(turnsQueue, name, healthPoints, defense, mana);
    }

    @Override
    public void equipKnife(Knife knife) {
        super.setEquippedWeapon(knife);
    }
}
