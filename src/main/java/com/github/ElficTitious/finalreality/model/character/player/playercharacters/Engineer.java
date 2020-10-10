package com.github.ElficTitious.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Engineer extends AbstractPlayerCharacter {

    public Engineer(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                    int healthPoints, int defense) {
        super(turnsQueue, name, healthPoints, defense);
    }

    @Override
    public void equipAxe(Axe axe) {
        super.setEquippedWeapon(axe);
    }

    @Override
    public void equipBow(Bow bow) {
        super.setEquippedWeapon(bow);
    }


}
