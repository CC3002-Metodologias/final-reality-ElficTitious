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

    /**
     * Setup method.
     * Creates a new White Wizard instance.
     */
    @BeforeEach
    void setUp() {
        testWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
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
     * Uses the {@code checkSuccesfulEquipWeapon} method defined in the
     * {@code AbstractPlayerCharacterTest} class.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testWhiteWizard.getEquippedWeapon());
        checkSuccessfulEquipWeapon(testWhiteWizard, testStaff);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testKnife);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testAxe);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testBow);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testSword);
    }
}
