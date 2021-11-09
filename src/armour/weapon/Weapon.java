package armour.weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import armour.ArmourAbstractClass;
import armour.ArmourInterface;
import utils.Utils;
import constants.Constants;

/**
 * Represents the attributes of a weapons.
 * A weapon can be any of the weapons as mentioned in the Weapons Enum.
 */
public class Weapon extends ArmourAbstractClass implements ArmourInterface {
  private final int minStrengthRequired;
  private final int minDexterityRequired;
  private final WeaponType weaponType;

  /**
   * Constructor for Weapons class, Initializes the required values in the created object.
   * A weapon can be any of the weapons as mentioned in the Weapons Enum.
   */
  public Weapon(WeaponType weaponType) {
    this.weaponType = weaponType;

    int[] minMax = this.setMinMaxValues(this.weaponType);
    this.minStrengthRequired = minMax[2];
    this.minDexterityRequired = minMax[3];


  }

  /**
   * Constructor for Weapons class, Initializes the required values in the created object.
   * A weapon can be any of the weapons as mentioned in the Weapons Enum.
   * This constructor works when specified
   */
  public Weapon() {
    int randInt = Utils.generateRandomIntInRAnge(0, WeaponType.values().length);
    this.weaponType = WeaponType.values()[randInt];

    int[] minMax = this.setMinMaxValues(this.weaponType);
    this.minStrengthRequired = minMax[2];
    this.minDexterityRequired = minMax[3];


  }

  /**
   * Gives the minimum and maximum values required by the constructor, like minimum strength
   * required to wield an item or min/max values of damage caused by the item.
   *
   * @param weaponType1 The weapon from Weapon enum set.
   * @return The integer array that contains the min max values in order.
   */
  private int[] setMinMaxValues(WeaponType weaponType1) {
    int min = Constants.DEFAULT;
    int max = Constants.DEFAULT;
    int minDexterityRequired = Constants.DEFAULT;
    int minStrengthRequired = Constants.DEFAULT;

    switch (weaponType1) {
      case KATANAS:
        min = Constants.KATANA_MIN_DAMAGE;
        max = Constants.KATANA_MAX_DAMAGE;
        break;
      case BROADSWORDS:
        min = Constants.BROADSWORDS_MIN_DAMAGE;
        max = Constants.BROADSWORDS_MAX_DAMAGE;
        break;
      case TWO_HANDED_SWORDS:
        minStrengthRequired = Constants.TWO_HANDED_SWORDS_MIN_STRENGTH;
        min = Constants.TWO_HANDED_SWORDS_MIN_DAMAGE;
        max = Constants.TWO_HANDED_SWORDS_MAX_DAMAGE;
        break;
      case AXES:
        min = Constants.AXES_MIN_DAMAGE;
        max = Constants.AXES_MAX_DAMAGE;
        break;
      case FLAILS:
        min = Constants.FLAILS_MIN_DAMAGE;
        max = Constants.FLAILS_MAX_DAMAGE;
        minDexterityRequired = Constants.FLAILS_MIN_DEXTERITY;
        break;
      default:
        break;
    }

    return new int[]{min, max, minStrengthRequired, minDexterityRequired};
  }


  /**
   * Takes in list of objects of weapon and returns a randomly chosen weapon.
   *
   * @param armoury The armoury (list of objects of weapon).
   * @return A randomly chosen weapon.
   */
  public static Weapon requestAWeaponFrom(List<Weapon> armoury) {
    int randomIndex = Utils.generateRandomIntInRAnge(0, armoury.size());
    return armoury.get(randomIndex);
  }

  /**
   * This method yields out List of randomly assorted weapons.
   *
   * @return List of randomly assorted weapons.
   */
  public static List<Weapon> createArmory() {
    List<Weapon> weaponList = new ArrayList<>();
    weaponList.add(new Weapon(WeaponType.AXES));
    weaponList.add(new Weapon(WeaponType.FLAILS));
    weaponList.add(new Weapon(WeaponType.KATANAS));
    weaponList.add(new Weapon(WeaponType.BROADSWORDS));
    weaponList.add(new Weapon(WeaponType.TWO_HANDED_SWORDS));

    for (int i = 0; i < Constants.ARSENAL_SIZE; i++) {
      int randInt = Utils.generateRandomIntInRAnge(0, WeaponType.values().length - 1);
      weaponList.add(new Weapon(WeaponType.values()[randInt]));
    }

    return weaponList;
  }


  /**
   * This method return the weapon type of the object.
   *
   * @return Weapon Type.
   */
  public WeaponType getWeaponType() {
    return this.weaponType;
  }


  /**
   * This method return the potential damage given by that type of the weapon.
   *
   * @return A random integer within range of min-max damage given by that weapon type.
   */
  public int getPotentialDamage() {
    int[] minMax = this.setMinMaxValues(this.weaponType);
    int damageMin = minMax[0];
    int damageMax = minMax[1];
    return Utils.generateRandomIntInRAnge(damageMin, damageMax);
  }

  @Override
  public String toString() {
    return "Weapon{" + "minStrengthRequired=" + minStrengthRequired + ", minDexterityRequired="
            + minDexterityRequired + ", weaponType=" + weaponType + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Weapon)) {
      return false;
    }
    Weapon weapon = (Weapon) o;
    return minStrengthRequired == weapon.minStrengthRequired
            && minDexterityRequired == weapon.minDexterityRequired
            && weaponType == weapon.weaponType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(minStrengthRequired, minDexterityRequired, weaponType);
  }
}
