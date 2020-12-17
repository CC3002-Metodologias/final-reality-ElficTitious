package com.github.cc3002.finalreality.controller;

import com.github.ElficTitious.finalreality.controller.Party;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
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

    /**
     * Setup method.
     * Creates a new test party and knight.
     */
    @BeforeEach
    void setUp() {
        turnsQueue = new LinkedBlockingQueue<>();
        testParty = new Party();
        testKnight = new Knight(turnsQueue, "Test Knight", 10, 10);
    }

    /**
     * Checks that the {@code Party} constructor works properly, and to do so, we compare
     * the testParty's party field with an equal array list, and by doing so, we are testing
     * the getParty method as well.
     */
    @Test
    void constructorTest() {
        var expectedTestParty = new ArrayList<>();
        assertEquals(expectedTestParty, testParty.getParty());
    }

    /**
     * Checks that the addCharacter and removeCharacter methods work as intended.
     */
    @Test
    void addAndRemoveCharacterTest() {
        var expectedTestParty = new ArrayList<>();
        expectedTestParty.add(testKnight);
        testParty.addCharacter(testKnight);
        assertEquals(expectedTestParty, testParty.getParty());
        expectedTestParty.remove(testKnight);
        testParty.removeCharacter(testKnight);
        assertEquals(expectedTestParty, testParty.getParty());
    }

    /**
     * Checks that the getPartySize method work as intended.
     */
    @Test
    void getPartySizeTest() {
        var expectedTestParty = new ArrayList<>();
        assertEquals(expectedTestParty.size(), testParty.getPartySize());
        expectedTestParty.add(testKnight);
        testParty.addCharacter(testKnight);
        assertEquals(expectedTestParty.size(), testParty.getPartySize());
    }
}
