package armour;

import java.util.Objects;

/**
 * This class represents a HeadGear and its attributes, which are, the impacts over the attributes
 * of abilities of a Player.
 */
public class Headgear extends ArmourAbstractClass implements ArmourInterface {
  private final int constitutionImpact;
  private boolean inUse;

  /**
   * This is the constructor for HeadGear, all the values are initialized ranging from -7 to 7
   * randomly.
   */
  public Headgear() {
    this.constitutionImpact = generateAbilityImpactValue();
    this.inUse = false;
  }


  /**
   * This is the constructor for HeadGear, all the values are initialized ranging from -7 to 7
   * randomly over which "magnitudeMarker" will work and will rectify the sign of the value as per
   * needed.
   *
   * @param signController Give +val or -val to fix the Ability Value to be of that sign only.
   */
  public Headgear(int signController) {
    int constitutionImpact1;
    constitutionImpact1 = generateAbilityImpactValue();
    if (signController >= 0) {
      constitutionImpact1 = Math.abs(constitutionImpact1);
    } else {
      constitutionImpact1 = -1 * Math.abs(constitutionImpact1);
    }

    this.constitutionImpact = constitutionImpact1;
    this.inUse = false;
  }

  @Override
  public int getConstitutionImpact() {
    return this.constitutionImpact;
  }

  @Override
  public String toString() {
    return "Headgear{" + "constitutionImpact=" + constitutionImpact + ", inUse=" + inUse + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Headgear)) {
      return false;
    }
    Headgear headgear = (Headgear) o;
    return constitutionImpact == headgear.constitutionImpact && inUse == headgear.inUse;
  }

  @Override
  public int hashCode() {
    return Objects.hash(constitutionImpact, inUse);
  }


  /**
   * Sets whether the headgear is in use or not.
   *
   * @param inUse The boolean value user will provide to be set.
   */
  public void setInUse(boolean inUse) {
    this.inUse = inUse;
  }

}
