package armour;

import java.util.Objects;

import utils.Utils;

/**
 * This class represents a Potions and its attributes, which are, the impacts over the attributes
 * of abilities of a Player.
 */
public class Potions extends ArmourAbstractClass implements ArmourInterface {
  private int strengthImpact;
  private int dexterityImpact;
  private int constitutionImpact;
  private int charismaImpact;
  private boolean used;

  /**
   * This is the constructor for Potions, all the values are initialized ranging from -7 to 7
   * randomly.
   */
  public Potions() {
    unBiasedInitialize();
    this.used = false;
  }

  /**
   * This is the constructor for Potions, all the values are initialized ranging from -7 to 7
   * randomly.
   * It also allows keeping values either positive or negative.
   */
  public Potions(int signController) {
    unBiasedInitialize();
    rectifySigns(signController);
    this.used = false;
  }

  private void rectifySigns(int theSignController) {
    if (theSignController >= 0) {
      this.constitutionImpact = Math.abs(this.constitutionImpact);
      this.strengthImpact = Math.abs(this.strengthImpact);
      this.dexterityImpact = Math.abs(this.dexterityImpact);
      this.charismaImpact = Math.abs(this.charismaImpact);
    } else {
      this.constitutionImpact = -1 * Math.abs(this.constitutionImpact);
      this.strengthImpact = -1 * Math.abs(this.strengthImpact);
      this.dexterityImpact = -1 * Math.abs(this.dexterityImpact);
      this.charismaImpact = -1 * Math.abs(this.charismaImpact);
    }
  }

  private void unBiasedInitialize() {
    int randomCase = Utils.generateRandomIntInRAnge(1, 4);
    this.strengthImpact = 0;
    this.dexterityImpact = 0;
    this.constitutionImpact = 0;
    this.charismaImpact = 0;
    switch (randomCase) {
      case 1:
        this.strengthImpact = generateAbilityImpactValue();
        break;
      case 2:
        this.dexterityImpact = generateAbilityImpactValue();
        break;
      case 3:
        this.constitutionImpact = generateAbilityImpactValue();
        break;
      case 4:
        this.charismaImpact = generateAbilityImpactValue();
        break;
      default:
        break;
    }
  }


  /**
   * Checks whether the Potion is used or not.
   *
   * @return boolean value for if the Potion is used or not.
   */
  public boolean isUsed() {
    return used;
  }

  /**
   * Sets whether the headgear is in use or not.
   *
   * @param used The boolean value user will provide to be set.
   */
  public void setUsed(boolean used) {
    this.used = used;
  }


  @Override
  public int getStrengthImpact() {
    return this.strengthImpact;
  }


  @Override
  public int getDexterityImpact() {
    return this.dexterityImpact;
  }


  @Override
  public int getConstitutionImpact() {
    return this.constitutionImpact;
  }


  @Override
  public int getCharismaImpact() {
    return this.charismaImpact;
  }

  @Override
  public String toString() {
    return "Potions{" + "strengthImpact=" + strengthImpact + ", dexterityImpact=" + dexterityImpact
            + ", constitutionImpact=" + constitutionImpact + ", charismaImpact=" + charismaImpact
            + ", used=" + used + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Potions)) {
      return false;
    }
    Potions potions = (Potions) o;
    return strengthImpact == potions.strengthImpact && dexterityImpact == potions.dexterityImpact
            && constitutionImpact == potions.constitutionImpact
            && charismaImpact == potions.charismaImpact && used == potions.used;
  }

  @Override
  public int hashCode() {
    return Objects.hash(strengthImpact, dexterityImpact, constitutionImpact, charismaImpact, used);
  }
}
