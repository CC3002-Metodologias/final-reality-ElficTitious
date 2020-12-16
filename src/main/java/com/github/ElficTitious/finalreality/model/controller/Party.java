package com.github.ElficTitious.finalreality.model.controller;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.ArrayList;

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

    public int getPartySize() {
        return party.size();
    }
}
