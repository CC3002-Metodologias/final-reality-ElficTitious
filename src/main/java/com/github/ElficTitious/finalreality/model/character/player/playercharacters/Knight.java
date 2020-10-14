package com.github.ElficTitious.finalreality.model.character.player.playercharacters;


import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds the information and behaviour of all Knights in the game.
 *
 * @author Ismael Correa Arellano.
 */
public class Knight extends AbstractPlayerCharacter {

    /**
     * Creates a Knight with a name, a given amount of health points, a given amount
     * of defense and the queue with the characters ready to play.
     */
    public Knight(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                  int healthPoints, int defense) {
        super(turnsQueue, name, healthPoints, defense);
    }

    @Override
    public void equipAxe(Axe axe) {
        super.setEquippedWeapon(axe); //We set the equipped weapon to the given axe.
    }

    @Override
    public void equipSword(Sword sword) {
        super.setEquippedWeapon(sword); //We set the equipped weapon to the given sword.
    }

    @Override
    public void equipKnife(Knife knife) {
        super.setEquippedWeapon(knife); //We set the equipped weapon to the given knife.
    }
}
