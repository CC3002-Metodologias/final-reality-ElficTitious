package com.github.cc3002.finalreality.model.character;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.DarkWizard;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DarkWizardEquipWeaponTest extends PlayerCharacterTest{

    @Test
    void equipWeaponTest() {
        checkSuccessfulEquipWeapon(testDarkWizard, testStaff);
        checkSuccessfulEquipWeapon(testDarkWizard, testKnife);
        checkUnsuccessfulEquipWeapon(testDarkWizard, testAxe);
        checkUnsuccessfulEquipWeapon(testDarkWizard, testBow);
        checkUnsuccessfulEquipWeapon(testDarkWizard, testSword);
    }
}
