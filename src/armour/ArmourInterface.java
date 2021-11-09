package armour;

import constants.Constants;

/**
 * It is the Interface, and it shares the contract for code functionalities.
 */
public interface ArmourInterface {
  int minItemAbility = Constants.MIN_HEADGEAR_ABILITY;
  int maxItemAbility = Constants.MAX_HEADGEAR_ABILITY;

  /**
   * Helper method to return current object's Strength impact value.
   *
   * @return returns current object's Strength impact value.
   */
  int getStrengthImpact();


  /**
   * Helper method to return current object's Dexterity impact value.
   *
   * @return returns current object's Dexterity impact value.
   */
  int getDexterityImpact();


  /**
   * Helper method to return current object's Constitution impact value.
   *
   * @return returns current object's Constitution impact value.
   */
  int getConstitutionImpact();


  /**
   * Helper method to return current object's Charisma impact value.
   *
   * @return returns current object's Charisma impact value.
   */
  int getCharismaImpact();


}
