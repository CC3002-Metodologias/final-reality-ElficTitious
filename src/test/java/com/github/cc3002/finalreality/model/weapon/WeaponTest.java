package com.github.cc3002.finalreality.model.weapon;

import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class  WeaponTest extends AbstractWeaponTest{

    private static final String AXE_NAME  = "Test Axe";
    private static final String SECOND_AXE_NAME  = "Second Test Axe";
    private static final String BOW_NAME  = "Test Bow";
    private static final String SWORD_NAME  = "Test Sword";
    private static final String STAFF_NAME  = "Test Staff";
    private static final String KNIFE_NAME  = "Test Knife";
    private static final int DAMAGE  = 15;
    private static final int SECOND_DAMAGE  = 20;
    private static final int MAGIC_DAMAGE  = 15;
    private static final int SECOND_MAGIC_DAMAGE  = 20;
    private static final int WEIGHT  = 30;
    private static final int SECOND_WEIGHT  = 25;

    private Axe testAxe;
    private Axe testAxeDifferentName;
    private Axe testAxeDifferentWeight;
    private Axe testAxeDifferentDamage;
    private Bow testBow;
    private Sword testSword;
    private Sword testSwordAxeName;
    private Staff testStaff;
    private Staff testStaffDifferentMagicDamage;
    private Knife testKnife;


    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        testAxeDifferentName = new Axe(SECOND_AXE_NAME, DAMAGE, WEIGHT);
        testAxeDifferentWeight = new Axe(AXE_NAME, DAMAGE, SECOND_WEIGHT);
        testAxeDifferentDamage = new Axe(AXE_NAME, SECOND_DAMAGE, WEIGHT);
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        testSwordAxeName = new Sword(AXE_NAME, DAMAGE, WEIGHT);
        testStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        testStaffDifferentMagicDamage = new Staff(STAFF_NAME, DAMAGE, SECOND_MAGIC_DAMAGE, WEIGHT);
        testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructionTest() {
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        var expectedBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        var expectedSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        var expectedStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedAxe, testAxe);
        assertEquals(expectedStaff, testStaff);
        assertEquals(expectedSword, testSword);
        assertEquals(expectedBow, testBow);
        assertEquals(expectedKnife, testKnife);
    }

    @Test
    void equalsTest() {
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        checkEquals(expectedAxe, testAxe, testAxeDifferentWeight,
                testAxeDifferentName, testSwordAxeName);
    }

    @Test
    void hashCodeTest() {
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        checkHashCode(expectedAxe, testAxe, testSwordAxeName);
    }

    @Test
    void getDamageTest() {
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        checkGetDamage(expectedAxe, testAxe, testAxeDifferentDamage);
    }

    @Test
    void getMagicDamageTest() {
        var expectedStaff =  new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        assertEquals(expectedStaff.getMagicDamage(), testStaff.getMagicDamage());
        assertNotEquals(expectedStaff.getMagicDamage(),
                testStaffDifferentMagicDamage.getMagicDamage());
    }
}
