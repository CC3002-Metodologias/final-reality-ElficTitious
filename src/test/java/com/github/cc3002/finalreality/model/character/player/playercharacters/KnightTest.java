package com.github.cc3002.finalreality.model.character.player.playercharacters;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Engineer;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.Knight;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest extends AbstractPlayerCharacterTest {

    private static final String KNIGHT_NAME = "Test Knight";

    private Knight testKnight;

    @BeforeEach
    void setUp() {
        testKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
    }

    @Test
    void constructorTest() {
        var expectedTestKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestKnight, testKnight);
    }

    @Test
    void equipWeaponTest() {
        checkUnsuccessfulEquipWeapon(testKnight, testStaff);
        checkSuccessfulEquipWeapon(testKnight, testKnife);
        checkSuccessfulEquipWeapon(testKnight, testAxe);
        checkUnsuccessfulEquipWeapon(testKnight, testBow);
        checkSuccessfulEquipWeapon(testKnight, testSword);
    }
}
