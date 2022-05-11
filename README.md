# Battle

It is a program that simulates a typical scenario in an RPG fighting game.

## Installation

Install JAVA version 11 and JUnit 4 dependencies for the smooth working of the program. 

## List of features
1. Create a Player, Weapons (Katanas, Broadswords, Two-handed swords, Axes, Flails), Potions, Belts, HeadGear, Footwear, Bag of items (all of them except weapons), Armory (only weapons).
2. Equip players with different items from Bag & Armory (All Random), they can also go without equipping any item or consuming any item.
3. Bags are containing approximately 25% of items of negative values (min values to be in a bag is as follows: 5 items of headgear, 5 items of footwear, 15 belts, and 15 potions).
4. Auto identify which player will go first (based on their charisma).
5. Every hit runtime dependent, that is, a hit from a player may cause different damage based on few fixed conditions and few random conditions (This is to make it very real).
6. A player can have at max 2 weapons, that is only if it has katanas in his hands.
7. A player can cause different damages, and it depends on his abilities, whether he can make good use of the weapon or not [ex -> min strength for Two-handed swords is 15].
8. A player can yield all and comprehensive details of itself [for that particular moment, a few values are changing all the time].

## How to run the JAR file
Running the jar file is easy, run command in shell/bash/cmd  --> "java -jar 'Project 2.jar' " and no other arguments are needed. This will generate a dry run demonstration for the program.


## How to use the program
The program has several functionalities, Significant of all of its functionality is utilized via an object of Battle Class. This object internally governs the entire program as for the user, the inbuilt functionalities are already handled via multiple classes mostly which are hidden to the user.
Users can add 2 players in battle and do operations on them via method calls over the desired object.

## Example
A dry run demo file is included in the "/res" folder of the directory, with the name "TEST RUN.txt".


## Design/Model  changes
There is 1 version of the design, the version 1 is the latest and final version of it.


## Assumptions
1. All the values are runtime and random.
2. There is no true randomness, but pseudo-randomness.

## Limitations
No limitations (As per Developers limited ability to comprehend the given problem statement).
