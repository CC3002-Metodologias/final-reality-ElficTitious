package com.github.ElficTitious.finalreality.model.controller;

import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.controller.factories.CharacterFactory;
import com.github.ElficTitious.finalreality.model.controller.factories.WeaponFactory;
import com.github.ElficTitious.finalreality.model.controller.handlers.concretehandlers.EnemyDeathHandler;
import com.github.ElficTitious.finalreality.model.controller.handlers.concretehandlers.EnemyTurnHandler;
import com.github.ElficTitious.finalreality.model.controller.handlers.concretehandlers.PlayerCharacterDeathHandler;
import com.github.ElficTitious.finalreality.model.controller.handlers.concretehandlers.PlayerTurnHandler;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that works as an intermediary between the user and objects from the model.
 *
 * @author Ismael Correa Arellano.
 */
public class GameController {

    private Inventory inventory;
    private Party playerParty;
    private Party enemyParty;
    private CharacterFactory characterFactory;
    private WeaponFactory weaponFactory;
    protected final BlockingQueue<ICharacter> turnsQueue;
    private PlayerCharacterDeathHandler playerCharacterDeathHandler;
    private EnemyDeathHandler enemyDeathHandler;
    private PlayerTurnHandler playerTurnHandler;
    private EnemyTurnHandler enemyTurnHandler;


    /**
     * Creates a controller with an inventory, player and enemy parties and a queue to control
     * the flow of the game.
     */
    public GameController() {
        this.inventory = new Inventory();
        this.playerParty = new Party();
        this.enemyParty = new Party();
        this.turnsQueue = new LinkedBlockingQueue<>();
        this.playerCharacterDeathHandler = new PlayerCharacterDeathHandler(this);
        this.enemyDeathHandler = new EnemyDeathHandler(this);
        this.playerTurnHandler = new PlayerTurnHandler(this);
        this.enemyTurnHandler = new EnemyTurnHandler(this);
        this.characterFactory = new CharacterFactory(turnsQueue, playerCharacterDeathHandler,
                enemyDeathHandler, playerTurnHandler, enemyTurnHandler);
        this.weaponFactory = new WeaponFactory();
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

    public void playerTurn() {
        ;
    }

    public void enemyTurn() {
        ;
    }

    public ICharacter getFirstCharacter() {
        var temp = turnsQueue.peek();
        temp.turn();
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
