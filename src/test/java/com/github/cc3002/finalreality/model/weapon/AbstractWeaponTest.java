package com.github.cc3002.finalreality.model.weapon;

import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AbstractWeaponTest {

    void checkEquals(IWeapon expectedWeapon, IWeapon equalWeapon,
                     IWeapon differentWeightWeapon, IWeapon differentNameWeapon,
                     IWeapon differentClassWeapon) {
        assertEquals(expectedWeapon, expectedWeapon);
        assertEquals(expectedWeapon, equalWeapon);
        assertNotEquals(expectedWeapon, differentWeightWeapon);
        assertNotEquals(expectedWeapon, differentNameWeapon);
        assertNotEquals(expectedWeapon, differentClassWeapon);
    }

    void checkHashCode(IWeapon expectedWeapon, IWeapon sameHashWeapon,
                       IWeapon differentHashWeapon) {
        assertEquals(expectedWeapon.hashCode(), sameHashWeapon.hashCode());
        assertNotEquals(expectedWeapon.hashCode(), differentHashWeapon.hashCode());
    }

    void checkGetDamage(IWeapon expectedWeapon, IWeapon sameDamageWeapon,
                        IWeapon differentDamageWeapon) {
        assertEquals(expectedWeapon.getDamage(), sameDamageWeapon.getDamage());
        assertNotEquals(expectedWeapon.getDamage(), differentDamageWeapon.getDamage());
    }
}
