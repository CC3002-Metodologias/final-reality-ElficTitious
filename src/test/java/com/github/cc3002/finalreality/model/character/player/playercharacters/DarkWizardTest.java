package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.DarkWizard;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import com.github.cc3002.finalreality.model.character.player.AbstractMagePlayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DarkWizardTest extends AbstractMagePlayerCharacterTest {

    private static final String DARK_WIZARD_NAME = "Test Dark Wizard";

    private DarkWizard testDarkWizard;

    @BeforeEach
    void setUp() {
        testDarkWizard = new DarkWizard(turnsQueue, DARK_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
    }

    @Test
    void constructorTest() {
        var expectedTestDarkWizard = new DarkWizard(turnsQueue, DARK_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        assertEquals(expectedTestDarkWizard, testDarkWizard);
    }

    @Test
    void equipWeaponTest() {
        checkSuccessfulEquipWeapon(testDarkWizard, testStaff);
        checkSuccessfulEquipWeapon(testDarkWizard, testKnife);
        checkUnsuccessfulEquipWeapon(testDarkWizard, testAxe);
        checkUnsuccessfulEquipWeapon(testDarkWizard, testBow);
        checkUnsuccessfulEquipWeapon(testDarkWizard, testSword);
    }
}
