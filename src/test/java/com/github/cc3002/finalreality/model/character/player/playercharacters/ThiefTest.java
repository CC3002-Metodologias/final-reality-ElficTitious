package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Thief;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code Engineer} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see Thief
 */
public class ThiefTest extends AbstractPlayerCharacterTest {

    private static final String THIEF_NAME = "Test Thief";

    private Thief testThief;
    private Thief deadTestThief;

    /**
     * Setup method.
     * Creates a new Thief instance.
     */
    @BeforeEach
    void setUp() {
        testThief = new Thief(turnsQueue, THIEF_NAME, HEALTH_POINTS, DEFENSE);
        deadTestThief = new Thief(turnsQueue, THIEF_NAME, DEPLETED_HEALTH_POINTS, DEFENSE);
    }

    /**
     * Checks that the {@code Thief} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestThief = new Thief(turnsQueue, THIEF_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestThief, testThief);
    }

    /**
     * Checks that the weapons that are equippable by this class get equipped and those who aren't
     * don't get equipped.
     * Uses the {@code checkSuccesfulEquipWeapon} and {@code checkUnsuccesfulEquipWeapon} methods
     * defined in the {@code AbstractPlayerCharacterTest} class.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testThief.getEquippedWeapon());
        checkSuccessfulEquipWeapon(testThief, testStaff);
        assertThrows(AssertionError.class, () -> testThief.equipKnife(testKnife));
        assertThrows(AssertionError.class, () -> testThief.equipAxe(testAxe));
        checkSuccessfulEquipWeapon(testThief, testBow);
        checkSuccessfulEquipWeapon(testThief, testSword);
        assertThrows(AssertionError.class, () -> deadTestThief.equipStaff(testStaff));
        assertThrows(AssertionError.class, () -> deadTestThief.equipBow(testBow));
        assertThrows(AssertionError.class, () -> deadTestThief.equipSword(testSword));
    }
}
