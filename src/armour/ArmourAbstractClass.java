package armour;

import utils.Utils;

/**
 * It is the abstract class, and it shares the basic and common code functionalities.
 */
public abstract class ArmourAbstractClass implements ArmourInterface {
  private int strengthImpact;
  private int dexterityImpact;
  private int constitutionImpact;
  private int charismaImpact;

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


  /**
   * Helper method for generating random values in range.
   *
   * @return Impact Value ranging from -7 to 7.
   */
  public int generateAbilityImpactValue() {
    return Utils.generateRandomIntInRAnge(ArmourInterface.minItemAbility,
            ArmourInterface.maxItemAbility);
  }

}
