package com.github.ElficTitious.finalreality.controller.state.concretestates;

import com.github.ElficTitious.finalreality.controller.state.State;
import com.github.ElficTitious.finalreality.model.character.ICharacter;
import com.github.ElficTitious.finalreality.model.character.player.IPlayerCharacter;

/**
 * Class that represents the state were the turn belongs to the player. From this state
 * the accessible states are Victorious and CheckingQueue. Necessary methods are overriden.
 */
public class PlayerTurn extends State {

    IPlayerCharacter playerCharacter = null;

    @Override
    public void setPlayerCharacter(IPlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    @Override
    public ICharacter getPlayerCharacter() {
        return playerCharacter;
    }

    @Override
    public void victory() {
        changeState(new Victorious());
    }

    @Override
    public void checkQueue() {
        changeState(new CheckingQueue());
    }

    @Override
    public boolean isPlayerTurn() {
        return true;
    }
}
