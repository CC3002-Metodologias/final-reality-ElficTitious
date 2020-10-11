package com.github.cc3002.finalreality.model.weapon;

import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WeaponTest extends AbstractWeaponTest{

    private static final String FIRST_AXE_NAME = "First Test Axe";
    private static final String SECOND_AXE_NAME = "Second Test Axe";
    private static final String STAFF_NAME = "Test Staff";
    private static final int DAMAGE = 15;
    private static final int WEIGHT = 10;
    private static final int MAGIC_DAMAGE = 20;

    private Axe firstTestAxe;
    private Axe secondTestAxe;
    private Staff testStaff;

    @BeforeEach
    void setUp() {
        firstTestAxe = new Axe(FIRST_AXE_NAME, DAMAGE, WEIGHT);
        secondTestAxe = new Axe(SECOND_AXE_NAME, DAMAGE, WEIGHT);
        testStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest() {
        var expectedAxe = new Axe(FIRST_AXE_NAME, DAMAGE, WEIGHT);
        var expectedStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        checkConstruction(expectedAxe, expectedAxe, secondTestAxe, testStaff);
        assertEquals(expectedStaff.getMagicDamage(), testStaff.getMagicDamage());
    }
}
