package com.github.ElficTitious.finalreality.model.character.player.playercharacters;


import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends AbstractPlayerCharacter {


    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                  int healthPoints, int defense) {
        super(turnsQueue, name, healthPoints, defense);
    }

    @Override
    public void equipAxe(Axe axe) {
        super.setEquippedWeapon(axe);
    }

    @Override
    public void equipSword(Sword sword) {
        super.setEquippedWeapon(sword);
    }

    @Override
    public void equipKnife(Knife knife) {
        super.setEquippedWeapon(knife);
    }
}
