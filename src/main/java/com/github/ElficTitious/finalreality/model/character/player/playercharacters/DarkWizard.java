package com.github.ElficTitious.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Staff;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class DarkWizard extends AbstractPlayerCharacter {

    private int mana;
    private final String type = "Dark Wizard";

    public DarkWizard(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                      int healthPoints, int defense, int mana) {
        super(turnsQueue, name, healthPoints, defense);
        this.mana = mana;
    }


    public int getMana() {
        return mana;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void equipKnife(Knife knife) {
        super.equipKnife(knife);
    }

    @Override
    public void equipStaff(Staff staff) {
        super.equipStaff(staff);
    }
}
