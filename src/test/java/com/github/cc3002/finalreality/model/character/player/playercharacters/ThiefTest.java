package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Thief;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThiefTest extends AbstractPlayerCharacterTest {

    private static final String THIEF_NAME = "Test Thief";

    private Thief testThief;

    @BeforeEach
    void setUp() {
        testThief = new Thief(turnsQueue, THIEF_NAME, HEALTH_POINTS, DEFENSE);
    }

    @Test
    void constructorTest() {
        var expectedTestThief = new Thief(turnsQueue, THIEF_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestThief, testThief);
    }

    @Test
    void equipWeaponTest() {
        checkSuccessfulEquipWeapon(testThief, testStaff);
        checkUnsuccessfulEquipWeapon(testThief, testKnife);
        checkUnsuccessfulEquipWeapon(testThief, testAxe);
        checkSuccessfulEquipWeapon(testThief, testBow);
        checkSuccessfulEquipWeapon(testThief, testSword);
    }
}
