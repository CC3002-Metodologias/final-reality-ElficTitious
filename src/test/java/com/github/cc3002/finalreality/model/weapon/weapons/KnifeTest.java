package com.github.cc3002.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Knife;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnifeTest extends AbstractWeaponTest {

    private static final String KNIFE_NAME = "Test Knife";

    private Knife testKnife;

    @BeforeEach
    void setUp() {
        testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest() {
        var expectedTestKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestKnife, testKnife);
    }
}
