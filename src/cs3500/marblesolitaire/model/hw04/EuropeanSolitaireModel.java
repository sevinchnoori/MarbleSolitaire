package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * The European version of the English Solitaire Model in which the corners are filled with marbles.
 */
public class EuropeanSolitaireModel extends EnglishSolitaireModel implements MarbleSolitaireModel {

  /**
   * Default constructor which creates an octagonal board with side lengths of
   * 3 and the empty slot at the center of the board.
   */
  public EuropeanSolitaireModel() {
    super();
  }

  /**
   * Constructor that creates a game with the given side length and an empty
   * slot at the center of the board.
   *
   * @param armThickness the length of the sides of the board
   */
  public EuropeanSolitaireModel(int armThickness) {
    super(armThickness);
  }

  /**
   * Constructor that creates a game with a side length of 3 and the empty slot
   * at the given row and column.
   * @param sRow the row in which the empty slot is located
   * @param sCol the column in which the empty slot is located
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow,sCol);
  }

  /**
   * Constructor creates a game with the given side length and positions the
   * empty slot to be at the given row and column.
   * @param armThickness the length of the sides of the board
   * @param sRow the row in which the empty slot is located
   * @param sCol the column in which the empty slot is located
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    super(armThickness, sRow, sCol);
  }

  /**
   * Creates the board of the game.
   *
   * @return a 2-D SlotState array
   */
  protected SlotState[][] makeGame() {

    for (int r = 0; r < this.rows; r = r + 1) { //row
      for (int c = 0; c < this.cols; c = c + 1) { //col


        // top left invalids
        if (r < armThickness - 1 && c <= armThickness - 1 && c < armThickness - 1 - r) {
          this.state[r][c] = SlotState.Invalid;
        }

        // top right invalids
        else if (r < armThickness - 1 && c >= ((armThickness - 1) * 2)
                && c > ((armThickness - 1) * 2) + r) {
          this.state[r][c] = SlotState.Invalid;
        }

        // bottom left invalid
        else if (r > ((armThickness - 1) * 2) && c <= armThickness - 1
                && c < armThickness - (getBoardSize() - r)) {
          this.state[r][c] = SlotState.Invalid;
        }

        // bottom right
        else if (r > ((armThickness - 1) * 2) && c >= ((armThickness - 1) * 2)
                && c > ((armThickness - 1) * 2) + (getBoardSize() - r - 1)) {
          this.state[r][c] = SlotState.Invalid;
        }

        // empty
        else if (r == sRow && c == sCol) {
          this.state[r][c] = SlotState.Empty;
        }


        // marbles
        else {
          this.state[r][c] = SlotState.Marble;
          this.marblesPresent = this.marblesPresent + 1;
        }

      }
    }

    return this.state;
  }

}

