package com.github.ElficTitious.finalreality.model.controller;

import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IMageCharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.*;
import com.github.ElficTitious.finalreality.model.controller.EnemyDeathHandler;
import com.github.ElficTitious.finalreality.model.controller.PlayerCharacterDeathHandler;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class CharacterFactory {

    private final BlockingQueue<ICharacter> turnsQueue;
    private final PlayerCharacterDeathHandler playerCharacterDeathHandler;
    private final EnemyDeathHandler enemyDeathHandler;

    public CharacterFactory(@NotNull BlockingQueue<ICharacter> turnsQueue,
                            PlayerCharacterDeathHandler playerCharacterDeathHandler,
                            EnemyDeathHandler enemyDeathHandler) {
        this.turnsQueue = turnsQueue;
        this.playerCharacterDeathHandler = playerCharacterDeathHandler;
        this.enemyDeathHandler = enemyDeathHandler;
    }

    public ICharacter createDarkWizard(@NotNull String name, int healthPoints, int defense,
                                       int mana) {
        var temp = new DarkWizard(turnsQueue, name, healthPoints, defense, mana);
        temp.addListener(playerCharacterDeathHandler);
        return temp;
    }

    public ICharacter createEngineer(@NotNull String name, int healthPoints, int defense) {
        var temp = new Engineer(turnsQueue, name, healthPoints, defense);
        temp.addListener(playerCharacterDeathHandler);
        return temp;
    }

    public ICharacter createKnight(@NotNull String name, int healthPoints, int defense) {
        var temp = new Knight(turnsQueue, name, healthPoints, defense);
        temp.addListener(playerCharacterDeathHandler);
        return temp;
    }

    public ICharacter createThief(@NotNull String name, int healthPoints, int defense) {
        var temp = new Thief(turnsQueue, name, healthPoints, defense);
        temp.addListener(playerCharacterDeathHandler);
        return temp;
    }

    public ICharacter createWhiteWizard(@NotNull String name, int healthPoints, int defense,
                                       int mana) {
        var temp = new WhiteWizard(turnsQueue, name, healthPoints, defense, mana);
        temp.addListener(playerCharacterDeathHandler);
        return temp;
    }

    public ICharacter createEnemy(@NotNull String name, int healthPoints, int defense,
                                        int mana, int weight, int attackPower) {
        var temp = new Enemy(turnsQueue, name, healthPoints, defense, weight, attackPower);
        temp.addListener(enemyDeathHandler);
        return temp;
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
}
