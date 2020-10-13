package com.github.cc3002.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordTest extends AbstractWeaponTest {

    private static final String SWORD_NAME = "Test Sword";

    private Sword testSword;

    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest() {
        var expectedTestSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestSword, testSword);
    }
}
