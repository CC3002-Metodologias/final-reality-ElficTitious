package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code Knight} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see Knight
 */
public class KnightTest extends AbstractPlayerCharacterTest {

    private static final String KNIGHT_NAME = "Test Knight";

    private Knight testKnight;

    /**
     * Setup method.
     * Creates a new Knight instance.
     */
    @BeforeEach
    void setUp() {
        testKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
    }

    /**
     * Checks that the {@code Knight} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestKnight, testKnight);
    }

    /**
     * Checks that the weapons that are equippable by this class get equipped and those who aren't
     * don't get equipped.
     * Uses the {@code checkSuccesfulEquipWeapon} method defined in the
     * {@code AbstractPlayerCharacterTest} class.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testKnight.getEquippedWeapon());
        checkUnsuccessfulEquipWeapon(testKnight, testStaff);
        checkSuccessfulEquipWeapon(testKnight, testKnife);
        checkSuccessfulEquipWeapon(testKnight, testAxe);
        checkUnsuccessfulEquipWeapon(testKnight, testBow);
        checkSuccessfulEquipWeapon(testKnight, testSword);
    }
}
