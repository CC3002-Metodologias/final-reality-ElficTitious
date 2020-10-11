package com.github.ElficTitious.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon;

import java.util.Objects;

public class Bow extends AbstractWeapon {

    private final String type = "Bow";

    /**
     * Creates a Bow with a name, a base damage and weight.
     */
    public Bow(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void equipToPlayerCharacter(IPlayerCharacter playerCharacter) {
        playerCharacter.equipBow(this);
    }
}
