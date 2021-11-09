package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import armour.ArmourInterface;
import armour.Belts;
import armour.Footwear;
import armour.Headgear;
import armour.Potions;
import constants.Constants;

/**
 * Represents the collection of items like "headgear" , "footWears", "belts", "potions" .
 */
public class Bag {
  private List<Headgear> headgearList;
  private List<Footwear> footWearsList;
  private List<Belts> beltsList;
  private List<Potions> potionsList;
  List<ArmourInterface> listOfItems;

  /**
   * Constructor for Bag, this constructor initialises the values for the items inside the bag.
   */
  public Bag() {
    initializeHeadGears();
    initializeFootWears();
    initializeBelts();
    initializePotions();

    generateItemList();
  }

  private void initializeFootWears() {
    this.footWearsList = new ArrayList<>();
    int footWearCount = this.getInRangeRandomItemCount("footWear");
    for (int i = 0; i < footWearCount; i++) {
      this.footWearsList.add(new Footwear(1));
    }
    for (int i = 0; i < Math.round(footWearCount * 0.33333); i++) {
      this.footWearsList.add(new Footwear(-1));
    }
  }

  private void initializeHeadGears() {
    this.headgearList = new ArrayList<>();
    int headGearCount = this.getInRangeRandomItemCount("headGear");
    for (int i = 0; i < headGearCount; i++) {
      this.headgearList.add(new Headgear(1));
    }
    for (int i = 0; i < Math.round(headGearCount * 0.33333); i++) {
      this.headgearList.add(new Headgear(-1));
    }
  }

  private void initializeBelts() {
    this.beltsList = new ArrayList<>();
    int beltsCount = this.getInRangeRandomItemCount("belts");
    for (int i = 0; i < beltsCount; i++) {
      this.beltsList.add(new Belts(1));
    }
    for (int i = 0; i < Math.round(beltsCount * 0.33333); i++) {
      this.beltsList.add(new Belts(-1));
    }
  }

  private void initializePotions() {
    this.potionsList = new ArrayList<>();
    int potionsCount = this.getInRangeRandomItemCount("potions");
    for (int i = 0; i < potionsCount; i++) {
      this.potionsList.add(new Potions(1));
    }
    for (int i = 0; i < Math.round(potionsCount * 0.33333); i++) {
      this.potionsList.add(new Potions(-1));
    }
  }

  private int getInRangeRandomItemCount(String itemName) {
    int itemCount = 0;
    switch (itemName) {
      case "headGear":
        itemCount = Utils.generateRandomIntInRAnge(Constants.MIN_HEADGEAR_IN_BAG,
                Constants.BAG_COUNT_RANGE_FACTOR * Constants.MIN_HEADGEAR_IN_BAG);
        break;

      case "footWear":
        itemCount = Utils.generateRandomIntInRAnge(Constants.MIN_FOOTWEAR_IN_BAG,
                Constants.BAG_COUNT_RANGE_FACTOR * Constants.MIN_FOOTWEAR_IN_BAG);
        break;

      case "belts":
        itemCount = Utils.generateRandomIntInRAnge(Constants.MIN_BELTS_IN_BAG,
                Constants.BAG_COUNT_RANGE_FACTOR * Constants.MIN_BELTS_IN_BAG);
        break;
      case "potions":
        itemCount = Utils.generateRandomIntInRAnge(Constants.MIN_POTIONS_IN_BAG,
                Constants.BAG_COUNT_RANGE_FACTOR * Constants.MIN_POTIONS_IN_BAG);
        break;
      default:
        break;
    }
    return itemCount;
  }

  private void generateItemList() {
    listOfItems = new ArrayList<>();
    listOfItems.addAll(this.headgearList);
    listOfItems.addAll(this.footWearsList);
    listOfItems.addAll(this.potionsList);
    listOfItems.addAll(this.beltsList);
  }


  /**
   * Shuffles the bag , and then yield out a random object belonging to
   * [Belt, Footwear, Headgear, Potions].
   *
   * @return An Item of either of Belt, Footwear, Headgear, Potions.
   */
  public ArmourInterface pickRandomItem() {
    Collections.shuffle(listOfItems);
    ArmourInterface item = listOfItems.get(0);
    listOfItems.remove(0);
    return item;
  }


  @Override
  public String toString() {
    return "Bag{" + "headgearList=" + headgearList + ", footWearsList=" + footWearsList
            + ", beltsList=" + beltsList + ", potionsList=" + potionsList + ", listOfItems="
            + listOfItems + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Bag)) {
      return false;
    }
    Bag bag = (Bag) o;
    return headgearList.equals(bag.headgearList) && footWearsList.equals(bag.footWearsList)
            && beltsList.equals(bag.beltsList) && potionsList.equals(bag.potionsList)
            && listOfItems.equals(bag.listOfItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headgearList, footWearsList, beltsList, potionsList, listOfItems);
  }
}
