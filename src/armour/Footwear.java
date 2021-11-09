package armour;

import java.util.Objects;

/**
 * This class represents the Footwear item in the scenario.
 * It has it impact over any 1 kind of abilities, which is selected at random with random values
 * in a preset range.
 */
public class Footwear extends ArmourAbstractClass implements ArmourInterface {
  private final int dexterityImpact;

  /**
   * This the constructor of Footwear object, it initialises the value of a footwear object.
   */
  public Footwear() {
    this.dexterityImpact = generateAbilityImpactValue();
  }

  /**
   * This the constructor of Footwear object, it initialises the value of a footwear object.
   * It also allows keeping values either positive or negative.
   */
  public Footwear(int signController) {
    int dexterityImpact1;
    dexterityImpact1 = generateAbilityImpactValue();
    if (signController >= 0) {
      dexterityImpact1 = Math.abs(dexterityImpact1);
    } else {
      dexterityImpact1 = -1 * Math.abs(dexterityImpact1);
    }

    this.dexterityImpact = dexterityImpact1;
  }

  @Override
  public int getDexterityImpact() {
    return this.dexterityImpact;
  }

  @Override
  public String toString() {
    return "Footwear{" + "dexterityImpact=" + dexterityImpact + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Footwear)) {
      return false;
    }
    Footwear footwear = (Footwear) o;
    return dexterityImpact == footwear.dexterityImpact;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dexterityImpact);
  }
}



