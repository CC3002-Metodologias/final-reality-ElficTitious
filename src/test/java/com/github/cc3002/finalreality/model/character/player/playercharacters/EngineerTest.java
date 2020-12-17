package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.DarkWizard;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code Engineer} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see Engineer
 */
public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Test Engineer";

    private Engineer testEngineer;

    /**
     * Setup method.
     * Creates a new Engineer instance.
     */
    @BeforeEach
    void setUp() {
        testEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
    }

    /**
     * Checks that the {@code Engineer} constructor works properly.
     */
    @Test
    void constructorTest() {
        var expectedTestEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestEngineer, testEngineer);
    }

    /**
     * Checks that the weapons that are equippable by this class get equipped and those who aren't
     * don't get equipped.
     * Uses the {@code checkSuccesfulEquipWeapon} method defined in the
     * {@code AbstractPlayerCharacterTest} class.
     */
    @Test
    void equipWeaponTest() {
        assertNull(testEngineer.getEquippedWeapon());
        checkUnsuccessfulEquipWeapon(testEngineer, testStaff);
        checkUnsuccessfulEquipWeapon(testEngineer, testKnife);
        checkSuccessfulEquipWeapon(testEngineer, testAxe);
        checkSuccessfulEquipWeapon(testEngineer, testBow);
        checkUnsuccessfulEquipWeapon(testEngineer, testSword);
    }
}
