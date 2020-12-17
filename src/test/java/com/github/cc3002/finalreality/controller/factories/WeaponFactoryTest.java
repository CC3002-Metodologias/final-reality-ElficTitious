package com.github.cc3002.finalreality.controller.factories;

import com.github.ElficTitious.finalreality.controller.factories.WeaponFactory;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code WeaponFactory} class.
 *
 * @author Ismael Correa Arellano.
 * @see com.github.ElficTitious.finalreality.controller.factories.WeaponFactory
 */
public class WeaponFactoryTest {

    private WeaponFactory weaponFactory;

    private static final String AXE_NAME  = "Test Axe";
    private static final String BOW_NAME  = "Test Bow";
    private static final String KNIFE_NAME  = "Test Knife";
    private static final String STAFF_NAME  = "Test Staff";
    private static final String SWORD_NAME  = "Test Sword";

    private static final int DAMAGE  = 15;
    private static final int MAGIC_DAMAGE = 20;
    private static final int WEIGHT  = 30;

    private Axe testAxe;
    private Bow testBow;
    private Knife testKnife;
    private Staff testStaff;
    private Sword testSword;

    /**
     * Setup method.
     * Creates a weapon factory and weapons for comparing.
     */
    @BeforeEach
    void setUp() {
        weaponFactory = new WeaponFactory();
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
        testStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    }

    /**
     * Checks that the weapon creation methods of the WeaponFactory class work as
     * intended.
     */
    @Test
    void weaponCreationTest() {
        assertEquals(testAxe, weaponFactory.createAxe(AXE_NAME, DAMAGE, WEIGHT));
        assertEquals(testBow, weaponFactory.createBow(BOW_NAME, DAMAGE, WEIGHT));
        assertEquals(testKnife, weaponFactory.createKnife(KNIFE_NAME, DAMAGE, WEIGHT));
        assertEquals(testStaff, weaponFactory.createStaff(STAFF_NAME, DAMAGE,
                MAGIC_DAMAGE, WEIGHT));
        assertEquals(testSword, weaponFactory.createSword(SWORD_NAME, DAMAGE, WEIGHT));
    }

    /**
     * Checks that the getter methods of the WeaponFactory class work as
     * intended.
     */
    @Test
    void gettersTest() {
        assertEquals(STAFF_NAME, weaponFactory.getName(testStaff));
        assertEquals(DAMAGE, weaponFactory.getDamage(testStaff));
        assertEquals(MAGIC_DAMAGE, weaponFactory.getMagicDamage(testStaff));
        assertEquals(WEIGHT, weaponFactory.getWeight(testStaff));
    }
}
