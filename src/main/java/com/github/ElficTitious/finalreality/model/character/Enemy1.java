package com.github.ElficTitious.finalreality.model.character;

import com.github.ElficTitious.finalreality.model.character.player.CharacterClass;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Your name>
 */
public class Enemy1 extends AbstractCharacter1 {

  private final int weight;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy1(@NotNull final String name, final int weight,
                @NotNull final BlockingQueue<ICharacter1> turnsQueue) {
    super(turnsQueue, name, CharacterClass.ENEMY);
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy1)) {
      return false;
    }
    final Enemy1 enemy1 = (Enemy1) o;
    return getWeight() == enemy1.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }
}
