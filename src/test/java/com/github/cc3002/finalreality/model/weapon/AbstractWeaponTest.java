package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

public abstract class AbstractWeaponTest {

    void checkEquals(IWeapon expectedWeapon, IWeapon equalWeapon,
                     IWeapon differentWeightWeapon, IWeapon differentNameWeapon,
                     IWeapon differentTypeWeapon) {
        assertEquals(expectedWeapon, expectedWeapon);
        assertEquals(expectedWeapon, equalWeapon);
        assertNotEquals(expectedWeapon, differentWeightWeapon);
        assertNotEquals(expectedWeapon, differentNameWeapon);
        assertNotEquals(expectedWeapon, differentTypeWeapon);
    }
}
