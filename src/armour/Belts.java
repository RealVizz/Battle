package armour;


import java.util.Objects;

import utils.Utils;


/**
 * This class represents the Belt item in the scenario.
 * It has it impact over any two kind of abilities, which is selected at random with random values
 * in a preset range.
 */
public class Belts extends ArmourAbstractClass implements ArmourInterface {
  private int strengthImpact;
  private int dexterityImpact;
  private int constitutionImpact;
  private int charismaImpact;
  private int beltSizeUnit;
  private BeltSize beltSize;

  /**
   * This the constructor of BELT object, it initialises the value of a belt object.
   */
  public Belts() {
    unBiasedInitialize();
    setBeltSize();
  }

  /**
   * This the constructor of BELT object, it initialises the value of a belt object.
   * It also allows keeping values either positive or negative.
   */
  public Belts(int signController) {
    unBiasedInitialize();
    rectifySigns(signController);
    setBeltSize();
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
    int randomCount = Utils.generateRandomIntInRAnge(1, 2);
    this.strengthImpact = 0;
    this.dexterityImpact = 0;
    this.constitutionImpact = 0;
    this.charismaImpact = 0;
    for (int i = 0; i < randomCount; i++) {
      int randomCase = Utils.generateRandomIntInRAnge(1, 4);
      switch (randomCase) {
        case 1:
          this.strengthImpact += generateAbilityImpactValue();
          break;
        case 2:
          this.dexterityImpact += generateAbilityImpactValue();
          break;
        case 3:
          this.constitutionImpact += generateAbilityImpactValue();
          break;
        case 4:
          this.charismaImpact += generateAbilityImpactValue();
          break;
        default:
          break;
      }
    }
  }


  private void setBeltSize() {
    int randomBeltSize = Utils.generateRandomIntInRAnge(1, 3);
    switch (randomBeltSize) {
      case 1:
        this.beltSize = BeltSize.SMALL;
        this.beltSizeUnit = 1;
        break;
      case 2:
        this.beltSize = BeltSize.MEDIUM;
        this.beltSizeUnit = 2;
        break;
      case 3:
        this.beltSize = BeltSize.LARGE;
        this.beltSizeUnit = 4;
        break;
      default:
        break;
    }
  }

  /**
   * Method to return the belt size unit, Small --> 1, Medium --> 2, Large --> 4 .
   *
   * @return The unit count corresponding to the size of the current belt object.
   */
  public int getBeltSizeUnit() {
    return this.beltSizeUnit;
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
    return "Belts{" +
            "strengthImpact=" + strengthImpact + ", dexterityImpact=" + dexterityImpact
            + ", constitutionImpact=" + constitutionImpact + ", charismaImpact=" + charismaImpact
            + ", beltSizeUnit=" + beltSizeUnit + ", beltSize=" + beltSize + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Belts)) {
      return false;
    }
    Belts belts = (Belts) o;
    return strengthImpact == belts.strengthImpact && dexterityImpact == belts.dexterityImpact
            && constitutionImpact == belts.constitutionImpact
            && charismaImpact == belts.charismaImpact && beltSizeUnit == belts.beltSizeUnit
            && beltSize == belts.beltSize;
  }

  @Override
  public int hashCode() {
    return Objects.hash(strengthImpact, dexterityImpact, constitutionImpact,
            charismaImpact, beltSizeUnit, beltSize);
  }
}
