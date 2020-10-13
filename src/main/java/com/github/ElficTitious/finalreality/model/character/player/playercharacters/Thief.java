package com.github.ElficTitious.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Staff;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Thief extends AbstractPlayerCharacter {

    public Thief(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                 int healthPoints, int defense) {
        super(turnsQueue, name, healthPoints, defense);
    }

    @Override
    public void equipSword(Sword sword) {
        super.equipSword(sword);
    }

    @Override
    public void equipStaff(Staff staff) {
        super.equipStaff(staff);
    }

    @Override
    public void equipBow(Bow bow) {
        super.equipBow(bow);
    }
}
