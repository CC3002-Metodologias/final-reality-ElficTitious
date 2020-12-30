package com.github.cc3002.finalreality.controller;

import com.github.ElficTitious.finalreality.controller.Inventory;
import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * A class that holds a set of tests for the {@code Inventory} class.
 *
 * @author Ismael Correa Arellano.
 * @see Inventory
 */
public class InventoryTest {

    private Inventory testInventory;
    private Axe testAxe;
    private Sword testSword;

    /**
     * Setup method.
     * Creates a new test inventory and axe.
     */
    @BeforeEach
    void setUp() {
        testInventory = new Inventory();
        testAxe = new Axe("Test Axe", 10, 10);
        testSword = new Sword("Test Sword", 10, 10);
    }

    /**
     * Checks that the {@code Inventory} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestInventory = new Inventory();
        assertEquals(expectedTestInventory, testInventory);
    }

    /**
     * Checks that the equals method from the {@code Inventory} class works
     * as intended.
     */
    @Test
    void equalsTest() {
        var expectedTestInventory = new Inventory();
        assertEquals(expectedTestInventory, expectedTestInventory);
        assertEquals(expectedTestInventory, testInventory);
        assertNotEquals(expectedTestInventory, testAxe);
        expectedTestInventory.addWeapon(testAxe);
        assertNotEquals(expectedTestInventory, testInventory);
        testInventory.addWeapon(testAxe);
        assertEquals(expectedTestInventory, testInventory);
        testInventory.removeWeapon(testAxe);
        testInventory.addWeapon(testSword);
        assertNotEquals(expectedTestInventory, testInventory);
    }

    /**
     * Checks that the hashCode method from the {@code Inventory} class works
     * as intended, that is, according to the definition of the equals method.
     */
    @Test
    void hashCodeTest() {
        var expectedTestInventory = new Inventory();
        assertEquals(expectedTestInventory.hashCode(), testInventory.hashCode());
        testInventory.addWeapon(testAxe);
        assertNotEquals(expectedTestInventory.hashCode(), testInventory.hashCode());
    }

    /**
     * Checks that the addWeapon and removeWeapon methods work as intended.
     */
    @Test
    void addAndRemoveWeaponTest() {
        var expectedTestInventory = new Inventory();
        expectedTestInventory.addWeapon(testAxe);
        testInventory.addWeapon(testAxe);
        assertEquals(expectedTestInventory, testInventory);
        expectedTestInventory.removeWeapon(testAxe);
        testInventory.removeWeapon(testAxe);
        assertEquals(expectedTestInventory, testInventory);
    }
}
