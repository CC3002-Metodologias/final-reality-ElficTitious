package com.github.cc3002.finalreality.controller;

import com.github.ElficTitious.finalreality.controller.Inventory;
import com.github.ElficTitious.finalreality.model.character.Enemy;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.Axe;
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

    /**
     * Setup method.
     * Creates a new test inventory and axe.
     */
    @BeforeEach
    void setUp() {
        testInventory = new Inventory();
        testAxe = new Axe("Test Axe", 10, 10);
    }

    /**
     * Checks that the {@code Inventory} constructor works properly, and to do so, we compare
     * the testInventory's inventory field with an equal array list, and by doing so, we are
     * testing the getInventory method as well.
     */
    @Test
    void constructorTest() {
        var expectedTestInventory = new ArrayList<>();
        assertEquals(expectedTestInventory, testInventory.getInventory());
    }

    /**
     * Checks that the addWeapon and removeWeapon methods work as intended.
     */
    @Test
    void addAndRemoveWeaponTest() {
        var expectedTestInventory = new ArrayList<>();
        expectedTestInventory.add(testAxe);
        testInventory.addWeapon(testAxe);
        assertEquals(expectedTestInventory, testInventory.getInventory());
        expectedTestInventory.remove(testAxe);
        testInventory.removeWeapon(testAxe);
        assertEquals(expectedTestInventory, testInventory.getInventory());
    }
}
