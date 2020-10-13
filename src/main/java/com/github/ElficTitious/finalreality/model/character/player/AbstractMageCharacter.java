package com.github.ElficTitious.finalreality.model.character.player;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractMageCharacter extends AbstractPlayerCharacter implements IMageCharacter {

    private int mana;

    public AbstractMageCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                 int healthPoints, int defense, int mana) {
        super(turnsQueue, name, healthPoints, defense);
        this.mana = mana;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void equipStaff(Staff staff) {
        super.setEquippedWeapon(staff);
    }
}
