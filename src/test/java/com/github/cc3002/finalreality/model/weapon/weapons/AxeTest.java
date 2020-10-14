package com.github.cc3002.finalreality.model.weapon.weapons;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.DarkWizard;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * A class that holds a set of tests for the {@code Axe} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see Axe
 */
public class AxeTest extends AbstractWeaponTest {

    private static final String AXE_NAME = "Test Axe";

    private Axe testAxe;

    /**
     * Setup method.
     * Creates a new Axe instance.
     */
    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    }

    /**
     * Checks that the {@code Axe} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestAxe, testAxe);
    }
}
