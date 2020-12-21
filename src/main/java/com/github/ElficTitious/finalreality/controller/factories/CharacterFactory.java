package com.github.ElficTitious.finalreality.controller.factories;

import com.github.ElficTitious.finalreality.controller.Party;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.*;
import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IMageCharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the character creation methods (including enemies) and getters
 * for player characters and enemies.
 *
 * @author Ismael Correa Arellano.
 */
public class CharacterFactory {

    private BlockingQueue<ICharacter> turnsQueue;
    private Party playerParty;
    private Party enemyParty;
    private final PlayerCharacterDeathHandler playerCharacterDeathHandler;
    private final EnemyDeathHandler enemyDeathHandler;
    private final PlayerTurnHandler playerTurnHandler;
    private final EnemyTurnHandler enemyTurnHandler;
    private final NonEmptyQueueHandler nonEmptyQueueHandler;

    /**
     * Creates a new character factory with a blocking queue and necessary handlers.
     */
    public CharacterFactory(@NotNull BlockingQueue<ICharacter> turnsQueue,
                            PlayerCharacterDeathHandler playerCharacterDeathHandler,
                            EnemyDeathHandler enemyDeathHandler,
                            PlayerTurnHandler playerTurnHandler,
                            EnemyTurnHandler enemyTurnHandler,
                            NonEmptyQueueHandler nonEmptyQueueHandler,
                            Party playerParty, Party enemyParty) {
        this.turnsQueue = turnsQueue;
        this.playerCharacterDeathHandler = playerCharacterDeathHandler;
        this.enemyDeathHandler = enemyDeathHandler;
        this.playerTurnHandler = playerTurnHandler;
        this.enemyTurnHandler = enemyTurnHandler;
        this.nonEmptyQueueHandler = nonEmptyQueueHandler;
        this.playerParty = playerParty;
        this.enemyParty = enemyParty;
    }

    /**
     * Creates a new dark wizard with all its fields initialized, adds the necessary
     * listeners and puts it in the turns queue and player's party.
     */
    public IPlayerCharacter createDarkWizard(@NotNull String name, int healthPoints, int defense,
                                             int mana) {
        var temp = new DarkWizard(turnsQueue, name, healthPoints, defense, mana);
        temp.addListeners(playerCharacterDeathHandler, playerTurnHandler,
                nonEmptyQueueHandler);
        playerParty.addCharacter(temp);
        turnsQueue.add(temp);
        return temp;
    }

    /**
     * Creates a new engineer with all its fields initialized, adds the necessary
     * listeners and puts it in the turns queue and player's party.
     */
    public IPlayerCharacter createEngineer(@NotNull String name, int healthPoints, int defense) {
        var temp = new Engineer(turnsQueue, name, healthPoints, defense);
        temp.addListeners(playerCharacterDeathHandler, playerTurnHandler,
                nonEmptyQueueHandler);
        playerParty.addCharacter(temp);
        turnsQueue.add(temp);
        return temp;
    }

    /**
     * Creates a new knight with all its fields initialized, adds the necessary
     * listeners and puts it in the turns queue and player's party.
     */
    public IPlayerCharacter createKnight(@NotNull String name, int healthPoints, int defense) {
        var temp = new Knight(turnsQueue, name, healthPoints, defense);
        temp.addListeners(playerCharacterDeathHandler, playerTurnHandler,
                nonEmptyQueueHandler);
        playerParty.addCharacter(temp);
        turnsQueue.add(temp);
        return temp;
    }

    /**
     * Creates a new thief with all its fields initialized, adds the necessary
     * listeners and puts it in the turns queue and player's party.
     */
    public IPlayerCharacter createThief(@NotNull String name, int healthPoints, int defense) {
        var temp = new Thief(turnsQueue, name, healthPoints, defense);
        temp.addListeners(playerCharacterDeathHandler, playerTurnHandler,
                nonEmptyQueueHandler);
        playerParty.addCharacter(temp);
        turnsQueue.add(temp);
        return temp;
    }

    /**
     * Creates a new white wizard with all its fields initialized, adds the necessary
     * listeners and puts it in the turns queue and player's party.
     */
    public IMageCharacter createWhiteWizard(@NotNull String name, int healthPoints, int defense,
                                       int mana) {
        var temp = new WhiteWizard(turnsQueue, name, healthPoints, defense, mana);
        temp.addListeners(playerCharacterDeathHandler, playerTurnHandler,
                nonEmptyQueueHandler);
        playerParty.addCharacter(temp);
        turnsQueue.add(temp);
        return temp;
    }

    /**
     * Creates a new enemy with all its fields initialized, adds the necessary
     * listeners and puts it in the turns queue and enemy's party.
     */
    public Enemy createEnemy(@NotNull String name, int healthPoints, int defense,
                                  int weight, int attackPower) {
        var temp = new Enemy(turnsQueue, name, healthPoints, defense, weight, attackPower);
        temp.addListeners(enemyDeathHandler, enemyTurnHandler,
                nonEmptyQueueHandler);
        enemyParty.addCharacter(temp);
        turnsQueue.add(temp);
        return temp;
    }

    //Character getters:

    /**
     * Returns the name of the character given as parameter.
     */
    public String getName(ICharacter character) {
        return character.getName();
    }

    /**
     * Returns the health points of the character given as parameter.
     */
    public int getHealthPoints(ICharacter character) {
        return character.getHealthPoints();
    }

    /**
     * Returns the defense of the character given as parameter.
     */
    public int getDefense(ICharacter character) {
        return character.getDefense();
    }

    /**
     * Returns the mana of the mage character given as parameter.
     */
    public int getMana(IMageCharacter mage) {
        return mage.getMana();
    }

    /**
     * Returns the wight of the enemy given as parameter.
     */
    public int getWeight(Enemy enemy) {
        return enemy.getWeight();
    }

    /**
     * Returns the attack power of the enemy given as parameter.
     */
    public int getAttackPower(Enemy enemy) {
        return enemy.getAttackPower();
    }
}
