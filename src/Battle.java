import java.util.Objects;

import constants.Constants;

/**
 * This class represents the elements of a Battle.
 * these elements could be anything, from living entity like players to nonliving entity like
 * weapons and other stuff, does also represent the actionable in a battle like strike, avoidance
 * etc.
 */
public class Battle {
  private final Player thePlayer1;
  private final Player thePLayer2;
  private int totalTurns;
  private boolean gameOver;
  private Player winner;


  /**
   * Takes values of Players to assign them to a possible battle.
   *
   * @param p1 The player 1.
   * @param p2 The player 2.
   */
  public Battle(Player p1, Player p2) {
    this.thePlayer1 = p1;
    this.thePLayer2 = p2;
    this.totalTurns = 0;
    this.gameOver = false;
    this.winner = null;
  }


  /**
   * Takes in 2 PLAYER class objects, and based in the charisma value of the two players,
   * it returns the order in which they will start and continue the battle.
   *
   * @return A PLAYER class array, with first player being at 0th index.
   */
  public Player[] getsStrikeOrder() {
    Player[] pso = new Player[2];
    if (this.thePlayer1.getOverallCharisma() > this.thePLayer2.getOverallCharisma()) {
      pso[0] = this.thePlayer1;
      pso[1] = this.thePLayer2;
    } else {
      pso[0] = this.thePLayer2;
      pso[1] = this.thePlayer1;
    }
    return pso;
  }

  /**
   * Makes a move and lets a player hit another player.
   */
  public void makeMove() {
    Player firstPlayer = this.getsStrikeOrder()[0];
    Player secondPlayer = this.getsStrikeOrder()[1];

    if (this.totalTurns < Constants.MAX_GAME_ROUNDS) {
      if (!this.gameOver) {
        if (this.totalTurns % 2 == 0) {
          if (secondPlayer.getHealth() > 0) {
            firstPlayer.attacksOn(secondPlayer);
            if (secondPlayer.getHealth() <= 0) {
              System.out.println("Second Player is Dead, First Player Winner");
              this.winner = firstPlayer;
              this.gameOver = true;
            }

          }
        } else {
          if (firstPlayer.getHealth() > 0) {
            secondPlayer.attacksOn(firstPlayer);
            if (firstPlayer.getHealth() <= 0) {
              System.out.println("First Player is Dead, Second Player Winner");
              this.winner = secondPlayer;
              this.gameOver = true;
            }
          }
        }
      } else {
        System.out.println("Game already Over");
        this.gameOver = true;
      }
    } else {
      this.gameOver = true;
      System.out.println("Game stopped because " + Constants.MAX_GAME_ROUNDS + " Round were done.");
    }


    this.totalTurns += 1;

  }

  /**
   * tell whether the game is on or terminated.
   *
   * @return The status of the game is running or not as bool val.
   */
  public boolean isGameOver() {
    return gameOver;
  }

  @Override
  public String toString() {
    return "Battle{" + "thePlayer1=" + thePlayer1 + ", thePLayer2=" + thePLayer2 + ", totalTurns="
            + totalTurns + ", gameOver=" + gameOver + ", winner=" + winner + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Battle)) {
      return false;
    }
    Battle battle = (Battle) o;
    return totalTurns == battle.totalTurns && gameOver == battle.gameOver
            && thePlayer1.equals(battle.thePlayer1)
            && thePLayer2.equals(battle.thePLayer2)
            && winner.equals(battle.winner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(thePlayer1, thePLayer2, totalTurns, gameOver, winner);
  }
}
