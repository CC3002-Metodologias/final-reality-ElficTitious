package com.github.cc3002.finalreality.model.character.equipweapon;

import com.github.cc3002.finalreality.model.character.PlayerCharacterTest;
import org.junit.jupiter.api.Test;

public class KnightEquipWeaponTest extends PlayerCharacterTest {

    @Test
    void equipWeaponTest() {
        checkUnsuccessfulEquipWeapon(testKnight, testStaff);
        checkSuccessfulEquipWeapon(testKnight, testKnife);
        checkSuccessfulEquipWeapon(testKnight, testAxe);
        checkUnsuccessfulEquipWeapon(testKnight, testBow);
        checkSuccessfulEquipWeapon(testKnight, testSword);
    }
}
