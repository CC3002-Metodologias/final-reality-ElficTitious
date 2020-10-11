package com.github.ElficTitious.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class WhiteWizard extends AbstractPlayerCharacter {

    private int mana;
    private final String type = "Dark Wizard";

    public WhiteWizard(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                       int healthPoints, int defense, int mana) {
        super(turnsQueue, name, healthPoints, defense);
        this.mana = mana;
    }

    @Override
    public String getType() {
        return type;
    }


    public int getMana() {
        return mana;
    }


    @Override
    public void equipStaff(Staff staff) {
        super.equipStaff(staff);
    }
}
