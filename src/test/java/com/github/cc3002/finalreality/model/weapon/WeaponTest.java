package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponTest {
    private static final String AXE_NAME  = "Test Axe";
    private static final String BOW_NAME  = "Test Bow";
    private static final String SWORD_NAME  = "Test Sword";
    private static final String STAFF_NAME  = "Test Staff";
    private static final String KNIFE_NAME  = "Test Knife";
    private static final int DAMAGE  = 15;
    private static final int MAGIC_DAMAGE  = 15;
    private static final int WEIGHT  = 30;

    private Axe testAxe;
    private Bow testBow;
    private Sword testSword;
    private Staff testStaff;
    private Knife testKnife;


    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        testStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructionTest() {

    }
}
