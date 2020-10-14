package com.github.cc3002.finalreality.model.character.player;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.character.player.playercharacters.*;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;
import com.github.ElficTitious.finalreality.model.weapon.weapons.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that holds a set of tests for the {@code AbstractPlayerCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa Arellano.
 * @see com.github.ElficTitious.finalreality.model.character.player.AbstractPlayerCharacter
 */
public class AbstractPlayerCharacterTest {

    protected BlockingQueue<ICharacter> turnsQueue;
    protected ScheduledExecutorService scheduledExecutor;

    private static final String AXE_NAME  = "Test Axe";
    private static final String BOW_NAME  = "Test Bow";
    private static final String SWORD_NAME  = "Test Sword";
    private static final String STAFF_NAME  = "Test Staff";
    private static final String KNIFE_NAME  = "Test Knife";
    private static final int DAMAGE  = 15;
    private static final int MAGIC_DAMAGE  = 15;
    private static final int WEIGHT  = 10;

    private static final String KNIGHT_NAME = "Test Knight";
    private static final String SECOND_KNIGHT_NAME = "Second Test Knight";
    protected static final int HEALTH_POINTS = 120;
    protected static final int DEFENSE = 50;

    protected Axe testAxe;
    protected Bow testBow;
    protected Sword testSword;
    protected Staff testStaff;
    protected Knife testKnife;

    private Knight testKnight;
    private Thief testThiefWithKnightName;
    private Knight testKnightDifferentName;

    /**
     * Setup method.
     * Creates new weapons, player characters and a linked blocking queue.
     */
    @BeforeEach
    void basicSetUp() {
        turnsQueue = new LinkedBlockingQueue<>();

        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        testStaff = new Staff(STAFF_NAME, DAMAGE, MAGIC_DAMAGE, WEIGHT);
        testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);

        testKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        testThiefWithKnightName = new Thief(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        testKnightDifferentName = new Knight(turnsQueue, SECOND_KNIGHT_NAME,
                HEALTH_POINTS, DEFENSE);
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        assertTrue(turnsQueue.isEmpty());
        testKnight.equipSword(testSword);
        testKnight.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            assertEquals(0, turnsQueue.size());
            Thread.sleep(200);
            assertEquals(1, turnsQueue.size());
            assertEquals(testKnight, turnsQueue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks that the equals method from the {@code AbstractPlayerCharacter} class works
     * as intended.
     */
    @Test
    void equalsTest() {
        var expectedTestKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestKnight, expectedTestKnight);
        assertEquals(expectedTestKnight, testKnight);
        assertNotEquals(expectedTestKnight, testKnightDifferentName);
        assertNotEquals(expectedTestKnight, testThiefWithKnightName);
        assertNotEquals(expectedTestKnight, testAxe);
    }

    /**
     * Checks that the hashCode method from the {@code AbstractPlayerCharacter} class works
     * as intended, that is, according to the definition of the equals method.
     */
    @Test
    void hashCodeTest() {
        var expectedTestKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestKnight.hashCode(), testKnight.hashCode());
        assertNotEquals(expectedTestKnight.hashCode(),
                testKnightDifferentName.hashCode());
    }

    /**
     * Checks that the {@code getHealthPoints} method works as intended.
     */
    @Test
    void getHealthPointsTest() {
        var expectedTestKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestKnight.getHealthPoints(), testKnight.getHealthPoints());
    }

    /**
     * Checks that the {@code getDefense} method works as intended.
     */
    @Test
    void getDefenseTest() {
        var expectedTestKnight = new Knight(turnsQueue, KNIGHT_NAME, HEALTH_POINTS, DEFENSE);
        assertEquals(expectedTestKnight.getDefense(), testKnight.getDefense());
    }

    /**
     * Checks that an equippable weapon (given the class of the character which we want equip
     * it to) gets in fact equipped. To do so, in the process we check also that the double
     * dispatch scheme implemented works properly.
     *
     * @param playerCharacter
     * Player character which we want to equip the {@param equippableWeapon}.
     * @param equippableWeapon
     * Weapon of a class that is equippable by the class of {@param playerCharacter}.
     */
    public void checkSuccessfulEquipWeapon(final IPlayerCharacter playerCharacter,
                                    final IWeapon equippableWeapon) {
        equippableWeapon.equipToPlayerCharacter(playerCharacter);
        assertEquals(equippableWeapon, playerCharacter.getEquippedWeapon());
    }

    /**
     * Checks that an unequippable weapon (given the class of the character which we want to try
     * equip it to) doesn't get in fact equipped. To do so, in the process we check also that
     * the double dispatch scheme implemented works properly.
     *
     * @param playerCharacter
     * Player character which we want to try equip the {@param unequippableWeapon}.
     * @param unequippableWeapon
     * Weapon of a class that is unequippable by the class of {@param playerCharacter}.
     */
    public void checkUnsuccessfulEquipWeapon(final IPlayerCharacter playerCharacter,
                                    final IWeapon unequippableWeapon) {
        unequippableWeapon.equipToPlayerCharacter(playerCharacter);
        assertNotEquals(unequippableWeapon, playerCharacter.getEquippedWeapon());
    }
}
