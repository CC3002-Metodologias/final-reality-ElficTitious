package com.github.cc3002.finalreality.model.character.player;

import com.github.ElficTitious.finalreality.model.character.player.playercharacters.WhiteWizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractMagePlayerCharacterTest extends AbstractPlayerCharacterTest {

    private static final String WHITE_WIZARD_NAME = "Test White Wizard";
    protected static final int MANA = 100;

    private WhiteWizard testWhiteWizard;

    @BeforeEach
    void basicMageSetUp() {
        testWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
    }

    @Test
    void getManaTest() {
        var expectedTestWhiteWizard = new WhiteWizard(turnsQueue, WHITE_WIZARD_NAME, HEALTH_POINTS,
                DEFENSE, MANA);
        assertEquals(expectedTestWhiteWizard.getMana(), testWhiteWizard.getMana());
    }
}
