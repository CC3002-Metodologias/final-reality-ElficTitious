package com.github.ElficTitious.finalreality.model.controller;

import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IMageCharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.*;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.CheckedOutputStream;

/**
 * A class that works as an intermediary between the user and objects from the model.
 *
 * @author Ismael Correa Arellano.
 */
public class GameController {

    private Inventory inventory;
    private Party playerParty;
    private Party enemyParty;
    protected final BlockingQueue<ICharacter> turnsQueue;

    /**
     * Creates a controller with an inventory, player and enemy parties and a queue to control
     * the flow of the game.
     */
    public GameController() {
        this.inventory = new Inventory();
        this.playerParty = new Party();
        this.enemyParty = new Party();
        this.turnsQueue = new LinkedBlockingQueue<>();
    }

    //Character getters:

    public String getName(ICharacter character) {
        return character.getName();
    }

    public int getHealthPoints(ICharacter character) {
        return character.getHealthPoints();
    }

    public int getDefense(ICharacter character) {
        return character.getDefense();
    }

    public int getMana(IMageCharacter mage) {
        return mage.getMana();
    }

    public int getWeight(Enemy enemy) {
        return enemy.getWeight();
    }

    public int getAttackPower(Enemy enemy) {
        return enemy.getAttackPower();
    }

    //Weapon getters:

    public String getName(IWeapon weapon) {
        return weapon.getName();
    }

    public int getDamage(IWeapon weapon) {
        return weapon.getDamage();
    }

    public int getWeight(IWeapon weapon) {
        return weapon.getWeight();
    }

    public int getMagicDamage(Staff staff) {
        return staff.getMagicDamage();
    }

    //Equip weapon method:

    public void equipWeapon(IWeapon weapon, IPlayerCharacter playerCharacter) {
        IWeapon previouslyEquippedWeapon = playerCharacter.getEquippedWeapon();
        weapon.equipToPlayerCharacter(playerCharacter);
        if (playerCharacter.getEquippedWeapon() == weapon) {
            inventory.removeWeapon(weapon);
            if (previouslyEquippedWeapon != null) {
                inventory.addWeapon(previouslyEquippedWeapon);
            }
        }
    }

    //Attacking method:

    public void attack(ICharacter attacker, ICharacter attacked) {
        attacker.attack(attacked);
    }

    //Turn implementation:

    public ICharacter getFirstCharacter() {
        var temp = turnsQueue.peek();
        return temp;
    }

    public void removeCharacter(ICharacter character) {
        turnsQueue.remove(character);
    }

    public void startTimer(ICharacter character) {
        character.waitTurn();
    }

    public boolean checkLoss(IPlayerCharacter playerCharacter) {
        playerParty.removeCharacter(playerCharacter);
        return playerParty.getPartySize() == 0;
    }

    public boolean checkVictory(Enemy enemy) {
        enemyParty.removeCharacter(enemy);
        return enemyParty.getPartySize() == 0;
    }


}
