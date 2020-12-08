package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.DarkWizard;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import com.github.cc3002.finalreality.model.character.player.AbstractMagePlayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code DarkWizard} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see DarkWizard
 */
public class DarkWizardTest extends AbstractMagePlayerCharacterTest {

    private static final String DARK_WIZARD_NAME = "Test Dark Wizard";

    private DarkWizard testDarkWizard;
    private DarkWizard deadTestDarkWizard;

    /**
     * Setup method.
     * Creates a new Dark Wizard instance.
     */
    @BeforeEach
    void setUp() {
        testDarkWizard = new DarkWizard(turnsQueue, DARK_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        deadTestDarkWizard = new DarkWizard(turnsQueue, DARK_WIZARD_NAME, DEPLETED_HEALTH_POINTS,
                DEFENSE, MANA);
    }

    /**
     * Checks that the {@code DarkWizard} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestDarkWizard = new DarkWizard(turnsQueue, DARK_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        assertEquals(expectedTestDarkWizard, testDarkWizard);
    }

    /**
     * Checks that the weapons that are equippable by this class get equipped and those who aren't
     * don't get equipped.
     * Uses the {@code checkSuccesfulEquipWeapon} and {@code checkUnsuccesfulEquipWeapon} methods
     * defined in the {@code AbstractPlayerCharacterTest} class.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testDarkWizard.getEquippedWeapon());
        checkSuccessfulEquipWeapon(testDarkWizard, testStaff);
        checkSuccessfulEquipWeapon(testDarkWizard, testKnife);
        assertThrows(AssertionError.class, () -> testDarkWizard.equipAxe(testAxe));
        assertThrows(AssertionError.class, () -> testDarkWizard.equipBow(testBow));
        assertThrows(AssertionError.class, () -> testDarkWizard.equipSword(testSword));
        assertThrows(AssertionError.class, () -> deadTestDarkWizard.equipStaff(testStaff));
        assertThrows(AssertionError.class, () -> deadTestDarkWizard.equipKnife(testKnife));
    }
}
