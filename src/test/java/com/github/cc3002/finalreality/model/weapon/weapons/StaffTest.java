package com.github.cc3002.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Staff;
import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StaffTest extends AbstractWeaponTest {

    private static final String STAFF_NAME = "Test Staff";
    private static int MAGIC_DAMAGE = 20;
    private static int SECOND_MAGIC_DAMAGE = 25;

    private Staff testStaff;
    private Staff testStaffDifferentMagicDamage;

    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        testStaffDifferentMagicDamage = new Staff(STAFF_NAME, DAMAGE,
                SECOND_MAGIC_DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest() {
        var expectedTestStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        assertEquals(expectedTestStaff, testStaff);
    }

    @Test
    void getMagicDamageTest() {
        var expectedTestStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        assertEquals(expectedTestStaff.getMagicDamage(), testStaff.getMagicDamage());
        assertNotEquals(expectedTestStaff.getMagicDamage(),
                testStaffDifferentMagicDamage.getMagicDamage());
    }
}
