package com.github.ElficTitious.finalreality.model.character.player;

import com.github.ElficTitious.finalreality.model.character.AbstractCharacter1;
import com.github.ElficTitious.finalreality.model.character.ICharacter1;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class PlayerCharacter1 extends AbstractCharacter1 {

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   */
  public PlayerCharacter1(@NotNull String name,
                          @NotNull BlockingQueue<ICharacter1> turnsQueue,
                          final CharacterClass characterClass) {
    super(turnsQueue, name, characterClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter1)) {
      return false;
    }
    final PlayerCharacter1 that = (PlayerCharacter1) o;
    return getCharacterClass() == that.getCharacterClass()
        && getName().equals(that.getName());
  }
}
