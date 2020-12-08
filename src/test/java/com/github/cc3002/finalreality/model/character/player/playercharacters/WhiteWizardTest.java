package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Thief;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import com.github.cc3002.finalreality.model.character.player.AbstractMagePlayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code WhiteWizard} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see WhiteWizard
 */
public class WhiteWizardTest extends AbstractMagePlayerCharacterTest {

    private static final String WHITE_WIZARD_NAME = "Test White Wizard";

    private WhiteWizard testWhiteWizard;
    private WhiteWizard deadTestWhiteWizard;

    /**
     * Setup method.
     * Creates a new White Wizard instance.
     */
    @BeforeEach
    void setUp() {
        testWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        deadTestWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME,
                DEPLETED_HEALTH_POINTS, DEFENSE, MANA);
    }

    /**
     * Checks that the {@code WhiteWizard} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        assertEquals(expectedTestWhiteWizard, testWhiteWizard);
    }

    /**
     * Checks that the weapons that are equippable by this class get equipped and those who aren't
     * don't get equipped.
     * Uses the {@code checkSuccesfulEquipWeapon} and {@code checkUnsuccesfulEquipWeapon} methods
     * defined in the {@code AbstractPlayerCharacterTest} class.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testWhiteWizard.getEquippedWeapon());
        checkSuccessfulEquipWeapon(testWhiteWizard, testStaff);
        assertThrows(AssertionError.class, () -> testWhiteWizard.equipKnife(testKnife));
        assertThrows(AssertionError.class, () -> testWhiteWizard.equipAxe(testAxe));
        assertThrows(AssertionError.class, () -> testWhiteWizard.equipBow(testBow));
        assertThrows(AssertionError.class, () -> testWhiteWizard.equipSword(testSword));
        assertThrows(AssertionError.class, () -> deadTestWhiteWizard.equipStaff(testStaff));
    }
}
