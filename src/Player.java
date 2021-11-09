import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import armour.ArmourInterface;
import armour.Belts;
import armour.Footwear;
import armour.Headgear;
import armour.Potions;
import armour.weapon.Weapon;
import armour.weapon.WeaponType;
import constants.Constants;
import utils.Bag;
import utils.Dice;
import utils.Utils;

/**
 * This class represents the PLAYER in a battle, and its attributes like ability and gears it may
 * wield etc.
 * Strength --> How effective the player is at striking their opponent.
 * Constitution --> How much damage a player can take when they are hit in battle.
 * Dexterity --> How effective the player is at avoiding a strike from their opponent.
 * Charisma --> How their opponent views them.
 */
public class Player {
  private int baseStrength;
  private int baseConstitution;
  private int baseDexterity;
  private int baseCharisma;
  private Headgear headgear;
  private List<Potions> potionsList;
  private List<Belts> beltsList;
  private Footwear footWears;
  private List<Weapon> weaponList;
  private int health;

  /**
   * The constructor of class player, this initializes the values for a Player in a battle alongside
   * other attributes.
   */
  public Player() {
    this.baseStrength = this.generateAbilityValue();
    this.baseConstitution = this.generateAbilityValue();
    this.baseDexterity = this.generateAbilityValue();
    this.baseCharisma = this.generateAbilityValue();

    this.headgear = null;
    this.potionsList = new ArrayList<Potions>();
    this.beltsList = new ArrayList<Belts>();
    this.footWears = null;

    this.weaponList = new ArrayList<Weapon>();

    this.updateHealth();
  }

  /**
   * This helper method calculates the Ability values for a player.
   *
   * @return The randomly calculated Ability value.
   */
  private int generateAbilityValue() {
    int numberOfFaces = Constants.DICE_FACE_COUNT;

    Dice dice1 = new Dice(numberOfFaces);
    Dice dice2 = new Dice(numberOfFaces);
    Dice dice3 = new Dice(numberOfFaces);
    Dice dice4 = new Dice(numberOfFaces);

    int rollVal1 = dice1.getFaceValue();
    int rollVal2 = dice2.getFaceValue();
    int rollVal3 = dice3.getFaceValue();
    int rollVal4 = dice4.reRoll().getFaceValue();

    ArrayList<Integer> rollValuesArray = new ArrayList<>();

    rollValuesArray.add(rollVal1);
    rollValuesArray.add(rollVal2);
    rollValuesArray.add(rollVal3);
    rollValuesArray.add(rollVal4);

    Collections.sort(rollValuesArray);

    rollValuesArray.remove(0);

    double sum = 0;
    for (Integer i : rollValuesArray) {
      sum += i;
    }

    if (sum < 6) {
      sum = generateAbilityValue();
    }

    return (int) sum;
  }

  /**
   * This method applies the given headgear to the player.
   *
   * @param givenHeadgear The Headgear object that has to be applied.
   */
  private void wearHeadgear(Headgear givenHeadgear) {
    if (this.headgear == null) {
      this.headgear = givenHeadgear;
      this.headgear.setInUse(true);
    }
    this.updateHealth();
  }


  /**
   * This method removes the headgear from the player.
   */
  private void removeHeadgear() {
    this.headgear.setInUse(false);
    this.headgear = null;
    this.updateHealth();
  }


  /**
   * This method sets up another potion drink to be drink by the Player.
   *
   * @param givenPotion The Potion object to drink.
   */
  private void addPotion(Potions givenPotion) {
    this.potionsList.add(givenPotion);
    this.updateHealth();
  }


  /**
   * This method marks that an available potion is drank by the Player and is used.
   *
   * @return Whether a potion is drank or not.
   */
  private boolean useAPotion() {
    boolean drank = false;
    for (Potions aPotion : this.potionsList) {
      if (!aPotion.isUsed()) {
        aPotion.setUsed(true);
        drank = true;
        break;
      }
    }
    this.updateHealth();
    return drank;
  }


  /**
   * This method marks that the given potion is drank by Player and is used.
   *
   * @param givenPotion The Potion object to drink.
   */
  private void useThisPotion(Potions givenPotion) {
    givenPotion.setUsed(true);
    this.potionsList.add(givenPotion);
    this.updateHealth();
  }

  private void useBelt(Belts givenBelt) {
    int tmpCount = 0;
    for (Belts value : this.beltsList) {
      tmpCount += value.getBeltSizeUnit();
    }
    if (givenBelt.getBeltSizeUnit() + tmpCount <= Constants.MAX_WEARABLE_BELT_UNIT_COUNT) {
      this.beltsList.add(givenBelt);
    }
    this.updateHealth();
  }

  private void useFootWear(Footwear givenFootWear) {
    if (this.footWears == null) {
      this.footWears = givenFootWear;
    }
    this.updateHealth();
  }

  private void removeFootWear() {
    this.footWears = null;
    this.updateHealth();
  }


  /**
   * Takes in a Bag object and equips the items from it whatever it can.
   *
   * @param theBag The Bag class object.
   */
  public void equip(Bag theBag) {
    ArmourInterface anItem;
    for (int i = 0; i < Constants.EQUIP_ITEM_COUNT; i++) {
      anItem = theBag.pickRandomItem();
      if (anItem instanceof Belts) {
        this.useBelt((Belts) anItem);
      } else if (anItem instanceof Headgear) {
        this.wearHeadgear((Headgear) anItem);
      } else if (anItem instanceof Potions) {
        this.addPotion((Potions) anItem);
      } else if (anItem instanceof Footwear) {
        this.useFootWear((Footwear) anItem);
      }

    }
    this.updateHealth();
  }


  /**
   * Takes in a Weapon object and equips the item if it can.
   *
   * @param e The weapon object.
   */
  public void pickWeapon(Weapon e) {
    int holdedWeapons = 0;
    for (Weapon weapon : this.weaponList) {
      if (weapon != null) {
        holdedWeapons += 1;
      }
    }

    if (holdedWeapons == 0) {
      this.weaponList.add(e);
    } else if (holdedWeapons == 1) {
      if (this.weaponList.get(0).getWeaponType() == WeaponType.KATANAS
              && e.getWeaponType() == WeaponType.KATANAS) {
        this.weaponList.add(e);
      }
    }

    this.updateHealth();
  }


  /**
   * If a case comes where player have to drop his weapons, this method will let me do that.
   */
  public void dropWeapons() {
    this.weaponList = new ArrayList<Weapon>();
    this.updateHealth();
  }

  private void updateHealth() {
    int baseline =
            this.baseStrength + this.baseConstitution + this.baseDexterity + this.baseCharisma;
    int footWearHealthImpact = 0;
    int headGearHealthImpact = 0;
    int potionHealthImpact = 0;
    int beltsHealthImpact = 0;

    if (this.headgear != null) {
      headGearHealthImpact = this.headgear.getCharismaImpact()
              + this.headgear.getConstitutionImpact() + this.headgear.getDexterityImpact()
              + this.headgear.getStrengthImpact();
    }

    for (Potions aPotion : this.potionsList) {
      potionHealthImpact += (aPotion.getCharismaImpact() + aPotion.getConstitutionImpact()
              + aPotion.getDexterityImpact() + aPotion.getStrengthImpact());
    }

    for (Belts aBelt : this.beltsList) {
      beltsHealthImpact += (aBelt.getCharismaImpact() + aBelt.getConstitutionImpact()
              + aBelt.getDexterityImpact() + aBelt.getStrengthImpact());
    }

    if (this.footWears != null) {
      footWearHealthImpact = this.footWears.getCharismaImpact()
              + this.footWears.getConstitutionImpact() + this.footWears.getDexterityImpact()
              + this.footWears.getStrengthImpact();
    }

    this.health = baseline + headGearHealthImpact + potionHealthImpact + beltsHealthImpact
            + footWearHealthImpact;
  }


  /**
   * Return the current health of the Player.
   *
   * @return The current health of the player.
   */
  public int getHealth() {
    return this.health;
  }

  private void setHealth(int healthValue) {
    this.health = healthValue;
  }

  /**
   * Return the overall Strength, that is the base Strength along with all Strength it has by the
   * use of additional items.
   *
   * @return The overall Strength.
   */
  public int getOverallStrength() {
    int baseline = this.baseStrength;
    int headgearPow = 0;
    int footWearPow = 0;
    int potionPow = 0;
    int beltPow = 0;
    if (this.headgear != null) {
      headgearPow = this.headgear.getStrengthImpact();
    }
    if (this.footWears != null) {
      footWearPow = this.footWears.getStrengthImpact();
    }

    for (Potions aPotion : this.potionsList) {
      potionPow += aPotion.getStrengthImpact();
    }

    for (Belts aBelt : this.beltsList) {
      beltPow += aBelt.getStrengthImpact();
    }

    return baseline + headgearPow + footWearPow + potionPow + beltPow;
  }

  /**
   * Return the overall Dexterity, that is the base Dexterity along with all Dexterity it has by the
   * use of additional items.
   *
   * @return The overall Dexterity.
   */
  public int getOverallDexterity() {
    int baseline = this.baseDexterity;
    int headgearPow = 0;
    int footWearPow = 0;
    int potionPow = 0;
    int beltPow = 0;
    if (this.headgear != null) {
      headgearPow = this.headgear.getDexterityImpact();
    }
    if (this.footWears != null) {
      footWearPow = this.footWears.getDexterityImpact();
    }

    for (Potions aPotion : this.potionsList) {
      potionPow += aPotion.getDexterityImpact();
    }

    for (Belts aBelt : this.beltsList) {
      beltPow += aBelt.getDexterityImpact();
    }

    return baseline + headgearPow + footWearPow + potionPow + beltPow;
  }

  /**
   * Return the overall Charisma, that is the base Charisma along with all Charisma it has by the
   * use of additional items.
   *
   * @return The overall Charisma.
   */
  public int getOverallCharisma() {
    int baseline = this.baseCharisma;
    int headgearPow = 0;
    int footWearPow = 0;
    int potionPow = 0;
    int beltPow = 0;
    if (this.headgear != null) {
      headgearPow = this.headgear.getCharismaImpact();
    }
    if (this.footWears != null) {
      footWearPow = this.footWears.getCharismaImpact();
    }

    for (Potions aPotion : this.potionsList) {
      potionPow += aPotion.getCharismaImpact();
    }

    for (Belts aBelt : this.beltsList) {
      beltPow += aBelt.getCharismaImpact();
    }

    return baseline + headgearPow + footWearPow + potionPow + beltPow;
  }

  /**
   * Return the overall Constitution, that is the base Constitution along with all Constitution
   * it has by the use of additional items.
   *
   * @return The overall Constitution.
   */
  public int getOverallConstitution() {
    int baseline = this.baseConstitution;
    int headgearPow = 0;
    int footWearPow = 0;
    int potionPow = 0;
    int beltPow = 0;
    if (this.headgear != null) {
      headgearPow = this.headgear.getConstitutionImpact();
    }
    if (this.footWears != null) {
      footWearPow = this.footWears.getConstitutionImpact();
    }

    for (Potions aPotion : this.potionsList) {
      potionPow += aPotion.getConstitutionImpact();
    }

    for (Belts aBelt : this.beltsList) {
      beltPow += aBelt.getConstitutionImpact();
    }

    return baseline + headgearPow + footWearPow + potionPow + beltPow;
  }

  /**
   * Return the Striking Power.
   * Striking power is the sum of the strength of the player, any of the gear that adds
   * (or subtracts) from strength, and a random number between 1 and 10 (inclusive).
   *
   * @return The Striking Power.
   */
  public int getStrikingPower() {
    int randNum = Utils.generateRandomIntInRAnge(1, 10);
    return getOverallStrength() + randNum;
  }


  /**
   * Return the Avoidance ability.
   * Avoidance ability is the sum of the dexterity of the player, any of the gear that adds
   * (or subtracts) from dexterity, and a random number between 1 and 6 (inclusive).
   *
   * @return The Avoidance ability.
   */
  public int getAvoidanceAbility() {
    int randNum = Utils.generateRandomIntInRAnge(1, 6);
    return this.getOverallDexterity() + randNum;
  }


  int potentialStrikingDamage() {
    int weaponsDamage = 0;
    for (Weapon aWeapon : this.weaponList) {
      weaponsDamage += aWeapon.getPotentialDamage();
    }

    if (weaponsDamage != 0) {
      if (this.weaponList.get(0).getWeaponType() == WeaponType.TWO_HANDED_SWORDS) {
        if (this.getOverallStrength() < Constants.TWO_HANDED_SWORDS_MIN_STRENGTH) {
          weaponsDamage = Math.round(weaponsDamage / 2);
        }
      }
      if (this.weaponList.get(0).getWeaponType() == WeaponType.FLAILS) {
        if (this.getOverallStrength() < Constants.FLAILS_MIN_DEXTERITY) {
          weaponsDamage = Math.round(weaponsDamage / 2);
        }
      }
    }

    return this.baseStrength + weaponsDamage;
  }


  void attacksOn(Player otherPLayer) {
    if (this.getStrikingPower() > otherPLayer.getAvoidanceAbility()) {
      int actualDamage = this.potentialStrikingDamage() - otherPLayer.getOverallConstitution();
      if (actualDamage > 0) {
        otherPLayer.setHealth(otherPLayer.getHealth() - actualDamage);
      }
    }
  }


  @Override
  public String toString() {
    return "Player{" + "baseStrength=" + baseStrength + ", baseConstitution=" + baseConstitution
            + ", baseDexterity=" + baseDexterity + ", baseCharisma=" + baseCharisma + ", health="
            + health + ", weaponList=" + weaponList + ", overallStrength="
            + this.getOverallStrength() + ", overallConstitution=" + this.getOverallConstitution()
            + ", overallCharisma=" + this.getOverallCharisma() + ", overallDexterity="
            + this.getOverallDexterity() + ", momentaryStrikingPower=" + this.getStrikingPower()
            + ", momentaryAvoidanceAbility=" + this.getAvoidanceAbility()
            + ", momentaryPotentialStrikingDamage=" + this.potentialStrikingDamage()
            + ", headgear=" + headgear + ", potionsList=" + potionsList + ", beltsList="
            + beltsList + ", footWears=" + footWears + '}';
  }
}
