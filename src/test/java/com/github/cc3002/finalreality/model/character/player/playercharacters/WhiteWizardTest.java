package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Thief;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import com.github.cc3002.finalreality.model.character.player.AbstractMagePlayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteWizardTest extends AbstractMagePlayerCharacterTest {

    private static final String WHITE_WIZARD_NAME = "Test White Wizard";

    private WhiteWizard testWhiteWizard;

    @BeforeEach
    void setUp() {
        testWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
    }

    @Test
    void constructorTest() {
        var expectedTestWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        assertEquals(expectedTestWhiteWizard, testWhiteWizard);
    }

    @Test
    void equipWeaponTest() {
        checkSuccessfulEquipWeapon(testWhiteWizard, testStaff);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testKnife);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testAxe);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testBow);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testSword);
    }
}
