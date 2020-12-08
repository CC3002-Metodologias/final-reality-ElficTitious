package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.DarkWizard;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code Engineer} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see Engineer
 */
public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Test Engineer";

    private Engineer testEngineer;
    private Engineer deadTestEngineer;

    /**
     * Setup method.
     * Creates a new Engineer instance.
     */
    @BeforeEach
    void setUp() {
        testEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
        deadTestEngineer = new Engineer(turnsQueue, ENGINEER_NAME, DEPLETED_HEALTH_POINTS,
                DEFENSE);
    }

    /**
     * Checks that the {@code Engineer} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestEngineer, testEngineer);
    }

    /**
     * Checks that the weapons that are equippable by this class get equipped and those who aren't
     * don't get equipped.
     * Uses the {@code checkSuccesfulEquipWeapon} method defined in the
     * {@code AbstractPlayerCharacterTest} class.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testEngineer.getEquippedWeapon());
        assertThrows(AssertionError.class, () -> testEngineer.equipStaff(testStaff));
        assertThrows(AssertionError.class, () -> testEngineer.equipKnife(testKnife));
        checkSuccessfulEquipWeapon(testEngineer, testAxe);
        checkSuccessfulEquipWeapon(testEngineer, testBow);
        assertThrows(AssertionError.class, () -> testEngineer.equipSword(testSword));
        assertThrows(AssertionError.class, () -> deadTestEngineer.equipAxe(testAxe));
        assertThrows(AssertionError.class, () -> deadTestEngineer.equipBow(testBow));
    }
}
