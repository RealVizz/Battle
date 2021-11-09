import java.util.List;

import armour.weapon.Weapon;
import constants.Constants;
import utils.Bag;

/**
 * The Driver class is here to give a demo for the code.
 */
public class Driver {
  /**
   * The "main" function is here to give a demo for the code.
   *
   * @param args Nothing here.
   */
  public static void main(String[] args) {

    System.out.println("\nSo, Here we are again, waiting for another dry run of the program.");
    System.out.println("Lets get started.");
    System.out.println("Lets create a player 1");
    Player p1 = new Player();
    System.out.println("Lets check it's stats");
    System.out.println(p1);
    System.out.println("Okay, we see so many details here. Lets do this for another player");
    System.out.println("We call him player 2");
    Player p2 = new Player();
    System.out.println(p2);
    System.out.println("Okay.... We have another unique player with us");
    System.out.println("Lets put our guys into battle and see the battle ground");
    Battle battle = new Battle(p1, p2);
    System.out.println(battle);
    System.out.println("Okay, the battle ground has two exactly same players as we gave it.");
    System.out.println("Let us ask who must go first, we know that more charismatic will go first");
    System.out.println("Let us see who have more charisma");
    System.out.println("Player 1 charisma  " + p1.getOverallCharisma());
    System.out.println("Player 2 charisma  " + p2.getOverallCharisma());
    System.out.println("Okay we know who will go first, lets ask the battle object to tell "
            + "us who will go first");
    Player firstPlayer = battle.getsStrikeOrder()[0];
    Player secondPlayer = battle.getsStrikeOrder()[1];
    System.out.println(firstPlayer);
    System.out.println("Oh yeah, he really does have more charisma then teh other one.");
    System.out.println("Okay, i think it is show time... let us just put them into a fight.");
    System.out.println("This might be messy there....and here as well, but please hold on.\n");
    System.out.println("We Limit the fight to " + Constants.MAX_GAME_ROUNDS + " rounds, "
            + Constants.MAX_GAME_ROUNDS / 2 + " chances each. \n");

    int switchCase = 0;
    while (!battle.isGameOver()) {
      if (switchCase % 2 == 0) {
        System.out.println("Health of Second player before hit --> " + secondPlayer.getHealth());
        System.out.println("First Player attacks on Second Player ");
        battle.makeMove();
        System.out.println("Health of Second player after hit --> " + secondPlayer.getHealth());
      } else {
        System.out.println("Health of First player before hit --> " + firstPlayer.getHealth());
        System.out.println("Second Player attacks on First Player ");
        battle.makeMove();
        System.out.println("Health of First player after hit --> " + firstPlayer.getHealth());
      }
      System.out.println("");
      switchCase += 1;
    }

    System.out.println("I (DEV) don't who won?? do tell me please, ha haha ha ");
    System.out.println("Now let us not send them straight away, let them now use some items");
    System.out.println("Lets create 2 bag");
    Bag bag1 = new Bag();
    Bag bag2 = new Bag();
    System.out.println("Its done in Background, now lets see its content");
    System.out.println(bag1);
    System.out.println(bag2);
    System.out.println("Lets have 2 new players");
    Player p3 = new Player();
    Player p4 = new Player();
    System.out.println("Its done in Background, now lets see them.");
    System.out.println(p1);
    System.out.println(p2);
    System.out.println("In the right most side we see what items it has, apart from weapon.");
    System.out.println("They are all empty.");
    System.out.println("Let us equip them, with Bag1 and Bag2 respectively.");
    p3.equip(bag1);
    p4.equip(bag2);
    System.out.println("Again....thats done in BG. Lets check our payers");
    System.out.println(p3);
    System.out.println(p4);
    System.out.println("Yeah, they do have some items with them now, also there stats are updated");
    System.out.println("just look at there health now, (for your reference)");
    System.out.println("We can actually check that all the things are in the way as stated.");
    System.out.println("For example, the bag contents are having 25% negative values roughly");
    System.out.println("And so on, the constraints we had over things are well satisfied.");
    System.out.println("We can actually wait and look at them.");
    System.out.println("Pssss....[i have checked them manually so, you can skip it.]");
    System.out.println("Weapon");
    System.out.println("Let us give them a weapon, to both of them...");
    System.out.println("lets create an Armory first.....that will happen in BG...so..check below");
    List<Weapon> armory = Weapon.createArmory();
    System.out.println(armory);
    System.out.println("Yeah so many items we have.... ok.. essentially we have at least 1 "
            + "weapon of each type");
    System.out.println("Dont believe me....you can always check...");
    System.out.println("Lets give random weapon to both of them.");
    p1.pickWeapon(Weapon.requestAWeaponFrom(armory));
    p2.pickWeapon(Weapon.requestAWeaponFrom(armory));
    System.out.println("Let see what they got...");
    System.out.println(p3);
    System.out.println(p4);
    System.out.println("They got there weapons... hurrah!!!");
    System.out.println("What now.....??");
    System.out.println("Yes... A fight...");
    System.out.println("Werent you always waiting for it..??? haha haha");
    System.out.println("New Battle is getting ready..in Back Ground...u see magic happens in BG\n");
    Battle battleNew = new Battle(p3, p4);
    firstPlayer = battleNew.getsStrikeOrder()[0];
    secondPlayer = battleNew.getsStrikeOrder()[1];

    System.out.println("And Here you go...!!\n");

    switchCase = 0;
    while (!battleNew.isGameOver()) {
      if (switchCase % 2 == 0) {
        System.out.println("Health of Second player before hit --> " + secondPlayer.getHealth());
        System.out.println("First Player attacks on Second Player ");
        battleNew.makeMove();
        System.out.println("Health of Second player after hit --> " + secondPlayer.getHealth());
      } else {
        System.out.println("Health of First player before hit --> " + firstPlayer.getHealth());
        System.out.println("Second Player attacks on First Player ");
        battleNew.makeMove();
        System.out.println("Health of First player after hit --> " + firstPlayer.getHealth());
      }
      System.out.println("");
      switchCase += 1;
    }


    System.out.println("\n\n\nThat's All Folks... ");
    System.out.println("Sincere Thanks to you for taking out time ...");
    System.out.println("Have a nice day.");


  }
}
