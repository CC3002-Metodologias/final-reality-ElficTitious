package com.github.cc3002.finalreality.model.character;

import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;
import com.github.ElficTitious.finalreality.model.weapon.IWeapon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AbstractPlayerCharacterTest {

    protected BlockingQueue<ICharacter> turnsQueue;
    protected ScheduledExecutorService scheduledExecutor;

    protected void checkEquals(final IPlayerCharacter expectedPlayerCharacter,
                                     final IPlayerCharacter equalPlayerCharacter,
                                     final IPlayerCharacter differentClassPlayerCharacter,
                                     final IPlayerCharacter differentNamePlayerCharacter) {
        assertEquals(expectedPlayerCharacter, expectedPlayerCharacter);
        assertEquals(expectedPlayerCharacter, equalPlayerCharacter);
        assertNotEquals(expectedPlayerCharacter, differentClassPlayerCharacter);
        assertNotEquals(expectedPlayerCharacter, differentNamePlayerCharacter);
    }

    void checkHashCode(final IPlayerCharacter expectedPlayerCharacter,
                       final IPlayerCharacter sameHashPlayerCharacter,
                       final IPlayerCharacter differentHashPlayerCharacter) {
        assertEquals(expectedPlayerCharacter.hashCode(), sameHashPlayerCharacter.hashCode());
        assertNotEquals(expectedPlayerCharacter.hashCode(),
                differentHashPlayerCharacter.hashCode());
    }
}
