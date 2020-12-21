package com.github.ElficTitious.finalreality.controller;

import com.github.ElficTitious.finalreality.controller.handlers.concretehandlers.*;
import com.github.ElficTitious.finalreality.controller.state.State;
import com.github.ElficTitious.finalreality.controller.state.concretestates.Starting;
import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.controller.factories.CharacterFactory;
import com.github.ElficTitious.finalreality.controller.factories.WeaponFactory;
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
    private NonEmptyQueueHandler nonEmptyQueueHandler;

    /**
     * Creates a controller with an inventory, player and enemy parties, a queue to control
     * the flow of the game, a weapon and character factory, all the necessary handlers, and
     * the state initialized as Starting.
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
        this.nonEmptyQueueHandler = new NonEmptyQueueHandler(this);
        this.characterFactory = new CharacterFactory(turnsQueue, playerCharacterDeathHandler,
                enemyDeathHandler, playerTurnHandler, enemyTurnHandler,
                nonEmptyQueueHandler, playerParty, enemyParty);
        this.weaponFactory = new WeaponFactory(inventory);
        this.setState(new Starting());
    }

    //State methods:

    /**
     * Method that sets this controller's state to the given state, it also sets the
     * given state's controller to this controller.
     */
    public void setState(State state) {
        this.state = state;
        state.setController(this);
    }

    /**
     * Method that returns if this controller is in the Starting state or not.
     */
    public boolean isStarting() {
        return state.isStarting();
    }

    /**
     * Method that returns if this controller is in the CheckingTurn state or not.
     */
    public boolean isCheckingTurn() {
        return state.isCheckingTurn();
    }

    /**
     * Method that returns if this controller is in the EnemyTurn state or not.
     */
    public boolean isEnemyTurn() {
        return state.isEnemyTurn();
    }

    /**
     * Method that returns if this controller is in the PlayerTurn state or not.
     */
    public boolean isPlayerTurn() {
        return state.isPlayerTurn();
    }

    /**
     * Method that returns if this controller is in the Defeated state or not.
     */
    public boolean isDefeated() {
        return state.isDefeated();
    }

    /**
     * Method that returns if this controller is in the Victorious state or not.
     */
    public boolean isVictorious() {
        return state.isVictorious();
    }

    /**
     * Method that returns if this controller is in the CheckingQueue state or not.
     */
    public boolean isCheckingQueue() {
        return state.isCheckingQueue();
    }

    /**
     * Method that returns if this controller is in the WaitingQueue state or not.
     */
    public boolean isWaitingQueue() {
        return state.isWaitingQueue();
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
     * attacks the attacked character, also given as parameter. It invokes the endTurn
     * method in order to continue with the turn flow.
     */
    public void attack(ICharacter attacker, ICharacter attacked) {
        attacker.attack(attacked);
        endTurn(attacker);
    }

    //Turn implementation:

    /**
     * Method that holds the behaviour when it's the turn of the player. It sets the state
     * to PlayerTurn.
     */
    public void playerTurn(IPlayerCharacter playerCharacter) {
        state.playerTurn();
    }

    /**
     * Method that holds the behaviour when it's the turn of the enemy. It sets the state
     * to EnemyTurn and attacks a random character from the player's party.
     */
    public void enemyTurn(Enemy enemy) {
        state.enemyTurn();
        attack(enemy, getPlayerParty().getRandomCharacter());
    }

    /**
     * Method that takes the first character in the turns queue and returns it (the character
     * isn't removed from the queue). In order to know if the next turn belongs to the player
     * or enemy, the method calls the turn method of the character taken. It sets the state
     * to CheckingTurn.
     */
    public ICharacter getNextCharacter() {
        var temp = turnsQueue.peek();
        state.checkTurn();
        temp.turn();
        return temp;
    }

    /**
     * Method in charge of removing from the turns queue and setting a timer for the
     * character that just ended his turn, after which it sets the state to CheckingQueue
     * (if possible). If the turns queue contains characters it invokes the getNextCharacter
     * method to return to the first phase of the turns flow, if not, it sets the state to
     * WaitingQueue where it waits for a character to enter the turns queue.
     */
    public void endTurn(ICharacter character) {
        this.removeCharacter(character);
        this.setTimer(character);
        state.checkQueue();
        if (turnsQueue.size() != 0) {
            this.getNextCharacter();
        }
        else {
            state.waitQueue();
        }
    }

    /**
     * Method that notifies the WaitingQueue state that it can return to the first phase
     * of the turns flow.
     */
    public void queueReady() {
        state.queueReady();
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

    /**
     * Returns this controller's state (intended for testing purposes).
     */
    public State getState() {
        return this.state;
    }
}
