package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.Objects;

public class Axe extends AbstractWeapon {

    private final String type = "Axe";
    /**
     * Creates an Axe with a name, a base damage and weight.
     */
    public Axe(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void equipToPlayerCharacter(IPlayerCharacter playerCharacter) {
        playerCharacter.equipAxe(this);
    }
}
