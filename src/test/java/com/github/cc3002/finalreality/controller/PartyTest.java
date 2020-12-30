package com.github.cc3002.finalreality.controller;

import com.github.ElficTitious.finalreality.controller.Party;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that holds a set of tests for the {@code Party} class.
 *
 * @author Ismael Correa Arellano.
 * @see Party
 */
public class PartyTest {

    protected BlockingQueue<ICharacter> turnsQueue;

    private Party testParty;
    private Knight testKnight;
    private Thief testThief;
    private Engineer testEngineer;

    /**
     * Setup method.
     * Creates a new test party and knight.
     */
    @BeforeEach
    void setUp() {
        turnsQueue = new LinkedBlockingQueue<>();
        testParty = new Party();
        testKnight = new Knight(turnsQueue, "Test Knight", 10, 10);
        testThief = new Thief(turnsQueue, "Test Thief", 10, 10);
        testEngineer = new Engineer(turnsQueue, "Test Engineer", 10, 10);
    }

    /**
     * Checks that the {@code Party} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestParty = new Party();
        assertEquals(expectedTestParty, testParty);
    }

    /**
     * Checks that the equals method from the {@code Party} class works
     * as intended.
     */
    @Test
    void equalsTest() {
        var expectedTestParty = new Party();
        assertEquals(expectedTestParty, expectedTestParty);
        assertEquals(expectedTestParty, testParty);
        assertNotEquals(expectedTestParty, testKnight);
        expectedTestParty.addCharacter(testKnight);
        assertNotEquals(expectedTestParty, testParty);
        testParty.addCharacter(testKnight);
        assertEquals(expectedTestParty, testParty);
        testParty.removeCharacter(testKnight);
        testParty.addCharacter(testThief);
        assertNotEquals(expectedTestParty, testParty);
    }

    /**
     * Checks that the hashCode method from the {@code Party} class works
     * as intended, that is, according to the definition of the equals method.
     */
    @Test
    void hashCodeTest() {
        var expectedTestParty = new Party();
        assertEquals(expectedTestParty.hashCode(), expectedTestParty.hashCode());
        testParty.addCharacter(testKnight);
        assertNotEquals(expectedTestParty.hashCode(), testParty.hashCode());
    }

    /**
     * Checks that the addCharacter and removeCharacter methods work as intended.
     */
    @Test
    void addAndRemoveCharacterTest() {
        var expectedTestParty = new Party();
        expectedTestParty.addCharacter(testKnight);
        testParty.addCharacter(testKnight);
        assertEquals(expectedTestParty, testParty);
        expectedTestParty.removeCharacter(testKnight);
        testParty.removeCharacter(testKnight);
        assertEquals(expectedTestParty, testParty);
    }

    /**
     * Checks that the getPartySize method work as intended.
     */
    @Test
    void getPartySizeTest() {
        assertEquals(testParty.getPartySize(), 0);
        testParty.addCharacter(testKnight);
        assertEquals(testParty.getPartySize(), 1);
        testParty.addCharacter(testKnight);
        assertEquals(testParty.getPartySize(), 2);
        testParty.removeCharacter(testKnight);
        assertEquals(testParty.getPartySize(), 1);
    }

    @Test
    void getCharacterTest() {
        testParty.addCharacter(testKnight);
        testParty.addCharacter(testThief);
        testParty.addCharacter(testEngineer);
        assertEquals(testParty.getCharacter(0), testKnight);
        assertEquals(testParty.getCharacter(1), testThief);
        assertEquals(testParty.getCharacter(2), testEngineer);
    }
}
