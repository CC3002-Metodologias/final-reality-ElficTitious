package com.github.cc3002.finalreality.model.character.equipweapon;

import com.github.cc3002.finalreality.model.character.PlayerCharacterTest;
import org.junit.jupiter.api.Test;

public class EngineerEquipWeaponTest extends PlayerCharacterTest {

    @Test
    void equipWeaponTest() {
        checkUnsuccessfulEquipWeapon(testEngineer, testStaff);
        checkUnsuccessfulEquipWeapon(testEngineer, testKnife);
        checkSuccessfulEquipWeapon(testEngineer, testAxe);
        checkSuccessfulEquipWeapon(testEngineer, testBow);
        checkUnsuccessfulEquipWeapon(testEngineer, testSword);
    }
}
