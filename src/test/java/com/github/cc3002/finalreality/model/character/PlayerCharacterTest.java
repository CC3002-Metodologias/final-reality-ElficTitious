package com.github.cc3002.finalreality.model.character;

import com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.*;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerCharacterTest extends AbstractPlayerCharacterTest{

    private static final String AXE_NAME  = "Test Axe";
    private static final String BOW_NAME  = "Test Bow";
    private static final String SWORD_NAME  = "Test Sword";
    private static final String STAFF_NAME  = "Test Staff";
    private static final String KNIFE_NAME  = "Test Knife";
    private static final int DAMAGE  = 15;
    private static final int MAGIC_DAMAGE  = 15;
    private static final int WEIGHT  = 30;

    private static final String DARK_WIZARD_NAME = "Test Dark Wizard";
    private static final String WHITE_WIZARD_NAME = "Test White Wizard";
    private static final String ENGINEER_NAME = "Test Engineer";
    private static final String KNIGHT_NAME = "Test Knight";
    private static final String SECOND_KNIGHT_NAME = "Second Test Knight";
    private static final String THIEF_NAME = "Test Thief";
    private static final int HEALTH_POINTS = 120;
    private static final int DEFENSE = 50;
    private static final int MANA = 100;

    protected Axe testAxe;
    protected Bow testBow;
    protected Sword testSword;
    protected Staff testStaff;
    protected Knife testKnife;

    protected DarkWizard testDarkWizard;
    protected WhiteWizard testWhiteWizard;
    protected Engineer testEngineer;
    protected Thief testThief;
    protected Knight testKnight;
    protected Knight secondTestKnight;

    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        testStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);

        testDarkWizard = new DarkWizard(turnsQueue, DARK_WIZARD_NAME,
                HEALTH_POINTS, DEFENSE, MANA);
        testWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME,
                HEALTH_POINTS, DEFENSE, MANA);
        testEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
        testThief = new Thief(turnsQueue, THIEF_NAME, HEALTH_POINTS, DEFENSE);
        testKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        secondTestKnight = new Knight(turnsQueue, SECOND_KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
    }

    @Test
    void constructionTest() {
        var expectedDarkWizard = new DarkWizard(turnsQueue, DARK_WIZARD_NAME,
                HEALTH_POINTS, DEFENSE, MANA);
        var expectedWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME,
                HEALTH_POINTS, DEFENSE, MANA);
        var expectedEngineer = new Engineer(turnsQueue, ENGINEER_NAME, HEALTH_POINTS, DEFENSE);
        var expectedThief = new Thief(turnsQueue, THIEF_NAME, HEALTH_POINTS, DEFENSE);
        var expectedKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedDarkWizard, testDarkWizard);
        assertEquals(expectedWhiteWizard, testWhiteWizard);
        assertEquals(expectedEngineer, testEngineer);
        assertEquals(expectedThief, testThief);
        assertEquals(expectedKnight, testKnight);
    }

    @Test
    void equalsTest() {
        var expectedKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        checkEquals(expectedKnight, testKnight, testEngineer, secondTestKnight);
    }

    @Test
    void hashCodeTest() {
        var expectedKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        checkHashCode(expectedKnight, testKnight, secondTestKnight);
    }
}
