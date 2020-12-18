package com.github.ElficTitious.finalreality.controller;

import com.github.ElficTitious.finalreality.controller.state.State;
import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.controller.factories.CharacterFactory;
import com.github.ElficTitious.finalreality.controller.factories.WeaponFactory;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.EnemyDeathHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.EnemyTurnHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.PlayerCharacterDeathHandler;
import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.PlayerTurnHandler;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that works as an intermediary between the user and objects from the model.
 *
 * @author Ismael Correa Arellano.
 */
public class GameController {

    private State state;
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
     * Creates a controller with an inventory, player and enemy parties, a queue to control
     * the flow of the game, a weapon and character factory, and all the necessary handlers.
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
        this.setState(//aState);
    }

    //State methods:

    public void setState(State state) {
        this.state = state;
        state.setController(this);
    }

    //Equip weapon method:

    /**
     * Method that equips the weapon given as parameter to the character given as
     * parameter. If the weapon was equippable by the character, the methods removes
     * the weapon from the inventory, and if the previously equipped weapon
     * wasn't null, it stores it in the inventory.
     */
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

    /**
     * Method that controls the attacking. The attacking character given as parameter
     * attacks the attacked character, also given as parameter.
     */
    public void attack(ICharacter attacker, ICharacter attacked) {
        attacker.attack(attacked);

        this.removeCharacter(attacker);
        this.setTimer(attacker);

    }

    //Turn implementation:

    /**
     * Method that holds the behaviour and game flow when in the turn of the player.
     */
    public void playerTurn(IPlayerCharacter playerCharacter) {
        // At this point of the development, the method is empty.
        ;
    }

    /**
     * Method that holds the behaviour and game flow when in the turn of the player.
     */
    public void enemyTurn(Enemy enemy) {
        // At this point of the development, the method is empty.
        ;
    }

    /**
     * Method that takes the first character in the turns queue and returns it (the character
     * isn't removed from the queue). In order to know if the next turn belongs to the player
     * or enemy, the method calls the turn method of the character taken.
     */
    public ICharacter getNextCharacter() {
        var temp = turnsQueue.peek();
        temp.turn();
        return temp;
    }

    /**
     * Method that removes the character given as parameter from the turns queue after
     * its turn ended.
     */
    public void removeCharacter(ICharacter character) {
        turnsQueue.remove(character);
    }

    /**
     * Method that sets a timer for the character given as parameter after it was removed
     * from the turns queue.
     */
    public void setTimer(ICharacter character) {
        character.waitTurn();
    }

    /**
     * Method that checks if the player lost after one of the characters in his party
     * died. The method removes the character from the party and turns queue and, if the
     * size of the player's party is zero, changes the state to Defeated.
     */
    public void checkLoss(IPlayerCharacter playerCharacter) {
        playerParty.removeCharacter(playerCharacter);
        turnsQueue.remove(playerCharacter);
        if (playerParty.getPartySize() == 0) {
            state.defeat();
        }
    }

    /**
     * Method that checks if the player won after one of the characters in the enemy party
     * died. The method removes the enemy from the party and turns queue and, if the size
     * of the enemy party is zero, changes the state to Victorious.
     */
    public void checkVictory(Enemy enemy) {
        enemyParty.removeCharacter(enemy);
        turnsQueue.remove(enemy);
        if (enemyParty.getPartySize() == 0) {
            state.victory();
        }
    }

    /**
     * Returns this controller's character factory.
     */
    public CharacterFactory getCharacterFactory() {
        return this.characterFactory;
    }

    /**
     * Returns this controller's weapon factory.
     */
    public WeaponFactory getWeaponFactory() {
        return this.weaponFactory;
    }

    /**
     * Returns this controller's inventory.
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Returns this controller's player party.
     */
    public Party getPlayerParty() {
        return this.playerParty;
    }

    /**
     * Returns this controller's enemy party.
     */
    public Party getEnemyParty() {
        return this.enemyParty;
    }

    /**
     * Returns this controller's turns queue.
     */
    public BlockingQueue<ICharacter> getTurnsQueue() {
        return this.turnsQueue;
    }

}
