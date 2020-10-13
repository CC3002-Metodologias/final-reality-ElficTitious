package com.github.cc3002.finalreality.model.character.equipweapon;

import com.github.cc3002.finalreality.model.character.PlayerCharacterTest;
import org.junit.jupiter.api.Test;

public class WhiteWizardEquipWeaponTest extends PlayerCharacterTest {

    @Test
    void equipWeaponTest() {
        checkSuccessfulEquipWeapon(testWhiteWizard, testStaff);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testKnife);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testAxe);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testBow);
        checkUnsuccessfulEquipWeapon(testWhiteWizard, testSword);
    }
}
