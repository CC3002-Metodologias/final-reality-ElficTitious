package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Test Engineer";

    private Engineer testEngineer;

    @BeforeEach
    void setUp() {
        testEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
    }

    @Test
    void constructorTest() {
        var expectedTestEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestEngineer, testEngineer);
    }

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
