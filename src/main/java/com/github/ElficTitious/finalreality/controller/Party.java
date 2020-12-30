package com.github.ElficTitious.finalreality.controller;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * A class that holds the information and manages parties of characters from the game.
 * Parties can be composed by player characters or enemies.
 *
 * @author Ismael Correa Arellano.
 */
public class Party {

    private ArrayList<ICharacter> party;

    /**
     * Creates a party implemented as an array list of ICharacters.
     */
    public Party() {
        party = new ArrayList<ICharacter>();
    }

    /**
     * Method that adds the character given as a parameter to the party.
     */
    public void addCharacter(ICharacter character) {
        //We simply add the character to the end of the array list that represents the party.
        party.add(character);
    }

    /**
     * Method that removes the character given as a parameter from the party.
     */
    public void removeCharacter(ICharacter character) {
        party.remove(character);
    }

    /**
     * Method that returns the size of this party.
     */
    public int getPartySize() {
        return party.size();
    }

    /**
     * Method that returns the character at position index in the party array.
     */
    public ICharacter getCharacter(int index) {
        return getParty().get(index);
    }

    /**
     * Returns this party's party field.
     */
    public ArrayList<ICharacter> getParty() {
        return this.party;
    }

    /**
     * Method that returns a random character from the party.
     */
    public ICharacter getRandomCharacter() {
        Random random = new Random();
        return getCharacter(random.nextInt(getPartySize()));
    }

    /**
     * Method that compares if two parties, returning if they're equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { //If the Object is exactly this party, then they are equal.
            return true;
        }

        if (!(obj instanceof Party)) {
            return false;
        }
        /* A Party is defined equal to another one if their party arrays are
         * equal. */
        final var party = (Party) obj;
        return getParty().equals(party.getParty());
    }

    /**
     * Returns this party's hashCode (according to the definition of the
     * equals method).
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getParty());
    }
}
