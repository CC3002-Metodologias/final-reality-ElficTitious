package com.github.cc3002.finalreality.model.weapon;

import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * A class that holds a set of tests for the {@code AbstractWeapon} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see com.github.ElficTitious.finalreality.model.weapon.AbstractWeapon
 */
public class AbstractWeaponTest {


    private static final String AXE_NAME  = "Test Axe";
    private static final String SECOND_AXE_NAME  = "Second Test Axe";
    protected static final int DAMAGE  = 15;
    protected static final int WEIGHT  = 30;
    private static final int SECOND_WEIGHT  = 25;

    private Axe testAxe;
    private Axe testAxeDifferentName;
    private Axe testAxeDifferentWeight;
    private Axe testAxeDifferentDamage;
    private Sword testSwordWithAxeName;

    /**
     * Setup method.
     * Creates new test weapons.
     */
    @BeforeEach
    void basicSetUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        testAxeDifferentName = new Axe(SECOND_AXE_NAME, DAMAGE, WEIGHT);
        testAxeDifferentWeight = new Axe(AXE_NAME, DAMAGE, SECOND_WEIGHT);
        testSwordWithAxeName = new Sword(AXE_NAME, DAMAGE, WEIGHT);
    }

    /**
     * Checks that the equals method from the {@code AbstractWeapon} class works
     * as intended.
     */
    @Test
    void equalsTest() {
        var expectedTestAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestAxe, expectedTestAxe);
        assertEquals(expectedTestAxe, testAxe);
        assertNotEquals(expectedTestAxe, testAxeDifferentName);
        assertEquals(expectedTestAxe, testSwordWithAxeName);
    }

    /**
     * Checks that the hashCode method from the {@code AbstractWeapon} class works
     * as intended, that is, according to the definition of the equals method.
     */
    @Test
    void hashCodeTest() {
        var expectedTestAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestAxe.hashCode(), testAxe.hashCode());
        assertNotEquals(expectedTestAxe.hashCode(), testAxeDifferentName.hashCode());
    }

    /**
     * Checks that the {@code getDamage} method works as intended.
     */
    @Test
    void getDamageTest() {
        var expectedTestAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        assertEquals(expectedTestAxe.getDamage(), testAxe.getDamage());
    }
}
