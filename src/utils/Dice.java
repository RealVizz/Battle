package utils;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a real world Dice.
 */
public class Dice {
  private int value;
  private final int numOfSides;

  /**
   * This is constructor for DICE, it initialises the total number of sides of the DICE along with
   * its first roll value.
   *
   * @param numOfSides The number of a faces a DICE to have.
   */
  public Dice(int numOfSides) {
    this.numOfSides = numOfSides;
    this.reRoll();
  }

  /**
   * After rolling the dice, we have some value on its top side, that is face, it returns the face
   * value.
   *
   * @return The current face value of the dice object.
   */
  public int getFaceValue() {
    return this.value;
  }


  /**
   * Internally re-rolls the dice and sets the new face value.
   *
   * @return Self reference for chain method functionality.
   */
  public Dice reRoll() {
    this.value = new Random().nextInt(numOfSides + 1);
    return this;
  }

  @Override
  public String toString() {
    return "Dice{" + "value=" + value + ", numOfSides=" + numOfSides + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Dice)) {
      return false;
    }
    Dice dice = (Dice) o;
    return value == dice.value && numOfSides == dice.numOfSides;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, numOfSides);
  }
}
