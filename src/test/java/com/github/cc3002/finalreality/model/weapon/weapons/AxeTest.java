package com.github.cc3002.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AxeTest extends AbstractWeaponTest {

    private static final String AXE_NAME = "Test Axe";

    private Axe testAxe;

    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    }

    @Test
    void constructorTest() {
        var expectedTestAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestAxe, testAxe);
    }
}
