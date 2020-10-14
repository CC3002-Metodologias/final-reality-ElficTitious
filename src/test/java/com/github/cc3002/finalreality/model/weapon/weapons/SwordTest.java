package com.github.cc3002.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A class that holds a set of tests for the {@code Sword} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see Sword
 */
public class SwordTest extends AbstractWeaponTest {

    private static final String SWORD_NAME = "Test Sword";

    private Sword testSword;

    /**
     * Setup method.
     * Creates a new Sword instance.
     */
    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    }

    /**
     * Checks that the {@code Sword} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestSword, testSword);
    }
}
