package com.github.cc3002.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Bow;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A class that holds a set of tests for the {@code Bow} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see Bow
 */
public class BowTest extends AbstractWeaponTest {

    private static final String BOW_NAME = "Test Bow";

    private Bow testBow;

    /**
     * Setup method.
     * Creates a new Bow instance.
     */
    @BeforeEach
    void setUp() {
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    }

    /**
     * Checks that the {@code Bow} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestBow, testBow);
    }
}
