package com.github.cc3002.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowTest extends AbstractWeaponTest {

    private static final String BOW_NAME = "Test Bow";

    private Bow testBow;

    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest() {
        var expectedTestBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestBow, testBow);
    }
}
