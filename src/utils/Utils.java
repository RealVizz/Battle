package utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The utility class fot the project.
 */
public class Utils {

  /**
   * Gives out the random number in the range given by the user.
   *
   * @param min The minimum value of the range.
   * @param max The maximum value of the range.
   * @return The random number in the given range (both inclusive).
   */
  public static int generateRandomIntInRAnge(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

}
