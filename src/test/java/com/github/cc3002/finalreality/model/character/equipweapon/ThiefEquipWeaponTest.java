package com.github.cc3002.finalreality.model.character.equipweapon;

import com.github.cc3002.finalreality.model.character.PlayerCharacterTest;
import org.junit.jupiter.api.Test;

public class ThiefEquipWeaponTest extends PlayerCharacterTest {

    @Test
    void equipWeaponTest() {
        checkSuccessfulEquipWeapon(testThief, testStaff);
        checkUnsuccessfulEquipWeapon(testThief, testKnife);
        checkUnsuccessfulEquipWeapon(testThief, testAxe);
        checkSuccessfulEquipWeapon(testThief, testBow);
        checkSuccessfulEquipWeapon(testThief, testSword);
    }
}
