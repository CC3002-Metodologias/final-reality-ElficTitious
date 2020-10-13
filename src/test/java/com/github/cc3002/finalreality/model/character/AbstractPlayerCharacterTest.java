package com.github.cc3002.finalreality.model.character;

import com.github.ElficTitious.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

public class AbstractPlayerCharacterTest {

    protected BlockingQueue<ICharacter> turnsQueue;
    protected ScheduledExecutorService scheduledExecutor;

    void checkConstruction();

}
