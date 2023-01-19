package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * The triangular version of the English Solitaire Model in which the board is in the shape of a
 * triangle and the user can move diagonally in addition to horizontally.
 */
public class TriangleSolitaireModel implements MarbleSolitaireModel {
  private final int dimensions;
  private final int sRow; // acts as x-coordinate for empty slot
  private final int sCol; // acts as y-coordinate for empty slot

  private SlotState[][] state;

  private int marblesPresent;

  /**
   * Default constructor that creates a 5-row game with the empty slot
   * at position (0,0).
   */
  public TriangleSolitaireModel() {
    this.dimensions = 5;
    this.sRow = 0;
    this.sCol = 0;
    this.state = new SlotState[dimensions][dimensions];
    this.state = this.makeGame();

  }


  /**
   * Constructor that creates a game with the given dimensions and the empty
   * slot positioned at (0,0).
   * @param dimensions the dimension of the game (the number of slots in the bottom
   *                   most row
   * @throws IllegalArgumentException if the dimension is not a positive number
   */
  public TriangleSolitaireModel(int dimensions) throws IllegalArgumentException {

    if (dimensions <= 0) {
      throw new IllegalArgumentException("Dimension must not be negative or even.");
    }

    this.dimensions = dimensions;
    this.sRow = 0;
    this.sCol = 0;
    this.state = new SlotState[dimensions][dimensions];
    this.state = this.makeGame();

  }

  /**
   * Constructor that creates the game with the given position for the empty slot.
   * @param sRow the row in which the empty slot is located
   * @param sCol the column in which the empty slot is located
   * @throws IllegalArgumentException if the position of the empty slot is invalid
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.dimensions = 5;
    this.sRow = sRow;
    this.sCol = sCol;
    this.state = new SlotState[dimensions][dimensions];
    this.state = this.makeGame();

    if (state[sRow][sCol] == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow
              + ", " + sCol + ")");
    }
  }

  /**
   * Constructs the game with the given dimensions and position for the empty slot.
   * @param dimensions the dimension of the game (the number of slots in the bottom
   *                   most row
   * @param sRow the row in which the empty slot is located
   * @param sCol the column in which the empty slot is located
   * @throws IllegalArgumentException if the dimension is equal to or less than 0 or the given
   *                                  position for the empty slot is invalid
   */
  public TriangleSolitaireModel(int dimensions, int sRow, int sCol)
          throws IllegalArgumentException {

    if (dimensions <= 0) {
      throw new IllegalArgumentException("Dimension cannot be negative or even.");
    }

    this.dimensions = dimensions;
    this.sRow = sRow;
    this.sCol = sCol;
    this.state = new SlotState[dimensions][dimensions];
    this.state = this.makeGame();

    if (state[sRow][sCol] == SlotState.Invalid || state[sRow][sCol] == SlotState.Marble) {
      throw new IllegalArgumentException("Invalid empty cell position"); }
  }

  // can jump to positions in its own row two cols away right or left
  // or positions that are two rows above and below in the 4 diagonal directions
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    // if the values are neg
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // cannot move directly up or down
    // (2,1) to (0,0)
    else if (Math.abs(fromCol - toCol) == 1) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // more than two positions away
    else if (Math.abs(fromCol - toCol) > 2 || Math.abs(fromRow - toRow) > 2) {
      throw new IllegalArgumentException("Invalid move.");
    }


    // if the values are equal to or larger than the board size
    else if (fromRow >= this.getBoardSize() || fromCol >= this.getBoardSize()
            || toRow >= this.getBoardSize() || toCol >= this.getBoardSize()) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // marble is not present at the from position or is invalid
    else if (state[fromRow][fromCol] == MarbleSolitaireModel.SlotState.Empty
            || state[fromRow][fromCol] == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // the to position is invalid or has a marble
    else if ((state[toRow][toCol] == MarbleSolitaireModel.SlotState.Marble)
            || (state[toRow][toCol] == SlotState.Invalid)) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // to and from position more than 2 positions away HORIZ
    else if ((fromRow == toRow) && (((Math.abs(fromCol - toCol)) != 2))) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // to and from position more than 2 positions away diag/
    else if ((fromCol == toCol) && (((Math.abs(fromRow - toRow)) != 2))) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // to and from positions are more than 2 positions away diag\
    else if ((fromRow == fromCol) && (toRow == toCol) && ((Math.abs(fromCol - toCol)) != 2)
            && ((Math.abs(fromRow - toRow)) != 2)) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // marble is not present between to and from positions HORIZ (left to right)
    else if (fromRow == toRow && fromCol < toCol && state[fromRow][fromCol + 1]
            == MarbleSolitaireModel.SlotState.Empty) {
      throw new IllegalArgumentException("Invalid move.");
    }
    // marble is not present between to and from positions HORIZ (right to left)
    else if (fromRow == toRow && fromCol > toCol && state[fromRow][fromCol - 1]
            == SlotState.Empty) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // marble is not present between to and from positions diag/ (up to down)
    else if (fromCol == toCol && fromRow < toRow && state[fromRow + 1][fromCol]
            == SlotState.Empty) {
      throw new IllegalArgumentException("Invalid move.");
    }
    // marble is not present between to and from positions diag/ (down to up)
    else if (fromCol == toCol && fromRow > toRow && state[fromRow - 1][fromCol]
            == SlotState.Empty) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // marble is not present between to and from positions diag\ (down to up)
    else if (((fromCol - toCol) == 2) && ((fromRow - toRow) == 2)
            && state[fromRow - 1][fromCol - 1]
            == SlotState.Empty) {
      throw new IllegalArgumentException("Invalid move.");
    }
    // marble is not present between to and from positions diag\ (up to down)
    else if (((fromCol - toCol) == -2) && ((fromRow - toRow) == -2)
            && state[fromRow + 1][fromCol + 1]
            == SlotState.Empty) {
      throw new IllegalArgumentException("Invalid move.");
    }

    else if ((fromRow < this.getBoardSize()) && (fromCol < this.getBoardSize())
            && (toRow < this.getBoardSize()) && (toCol < this.getBoardSize())
            && (fromRow >= 0) && (fromCol >= 0) && (toRow >= 0) && (toCol >= 0)) {

      // horizontal move (left to right)
      if (fromRow == toRow && fromCol < toCol) {
        // marble attempting to get rid of
        state[fromRow][fromCol + 1] = SlotState.Empty;
        this.marblesPresent = this.marblesPresent - 1;
        // changes from and to
        state[fromRow][fromCol] = SlotState.Empty;
        state[toRow][toCol] = SlotState.Marble;
      }

      // horizontal move (right to left)
      else if (fromRow == toRow && fromCol > toCol) {
        // marble attempting to get rid of
        state[fromRow][fromCol - 1] = SlotState.Empty;
        this.marblesPresent = this.marblesPresent - 1;
        // changes from and to
        state[fromRow][fromCol] = SlotState.Empty;
        state[toRow][toCol] = SlotState.Marble;
      }

      // diag/ move (up to down)
      else if (fromCol == toCol && fromRow < toRow && fromRow - toRow == -2) {
        // marble attempting to get rid of
        state[fromRow + 1][fromCol] = SlotState.Empty;
        this.marblesPresent = this.marblesPresent - 1;
        // changes from and to
        state[fromRow][fromCol] = SlotState.Empty;
        state[toRow][toCol] = SlotState.Marble;
      }

      // diag/ move (down to up)
      else if (fromCol == toCol && fromRow > toRow && fromRow - toRow == 2) {
        // marble attempting to get rid of
        state[fromRow - 1][fromCol] = SlotState.Empty;
        this.marblesPresent = this.marblesPresent - 1;
        // changes from and to
        state[fromRow][fromCol] = SlotState.Empty;
        state[toRow][toCol] = SlotState.Marble;
      }

      // diag\ move (down to up)
      else if (((fromCol - toCol) == 2) && ((fromRow - toRow) == 2)) {
        // marble attempting to get rid of
        state[fromRow - 1][fromCol - 1] = SlotState.Empty;
        this.marblesPresent = this.marblesPresent - 1;
        // changes from and to
        state[fromRow][fromCol] = SlotState.Empty;
        state[toRow][toCol] = SlotState.Marble;
      }

      // diag\ move (up to down)
      else if (((fromCol - toCol) == - 2) && ((fromRow - toRow) == - 2)) {
        // marble attempting to get rid of
        state[fromRow + 1][fromCol + 1] = SlotState.Empty;
        this.marblesPresent = this.marblesPresent - 1;
        // changes from and to
        state[fromRow][fromCol] = SlotState.Empty;
        state[toRow][toCol] = SlotState.Marble;
      }

    }

  }

  protected SlotState[][] makeGame() {
    for (int r = 0; r < this.dimensions; r = r + 1) { //row
      for (int c = 0; c < this.dimensions; c = c + 1) { //col


        // row isnt the last row and the columns is larger than rows
        if (r != this.dimensions && c > r) {
          this.state[r][c] = SlotState.Invalid;
        }

        // empty
        else if (r == sRow && c == sCol) {
          this.state[r][c] = SlotState.Empty;

          // all else are marbles
        } else {
          this.state[r][c] = SlotState.Marble;
          this.marblesPresent = this.marblesPresent + 1;
        }
      }
    }
    return this.state;
  }

  /**
   * Determines if a move can be made.
   * @param fromRow the row from which the marble to be moved is located
   * @param fromCol the column from which the marble to be moved is located
   * @return true if a move can be made
   */
  protected boolean canMove(int fromRow, int fromCol, int toRow, int toCol) {
    return
            (state[fromRow][fromCol] == SlotState.Marble // marble at from
                    && state[toRow][toCol] == SlotState.Empty // empty at to
                    // marble in between
                    && state[((fromRow + toRow) / 2)][(fromCol + toCol) / 2] == SlotState.Marble
                    // row is same and cols are 2 spaces away OR  (horiz)
                    && ((((Math.abs(fromCol - toCol)) == 2) && ((fromRow - toRow) == 0))
                    // col is same and rows are 2 spaces away OR (diag/)
                    || (((Math.abs(fromRow - toRow)) == 2) && ((fromCol - toCol) == 0))
                    // col and row are two spaces away (diag\)
                    || (((Math.abs(fromRow - toRow)) == 2) && (Math.abs(fromCol - toCol) == 2))));

  }

  @Override
  public boolean isGameOver() {
    // if there is 1 peg left on the board
    if (this.getScore() == 1) {
      return true;
    }

    // checks for patterns
    for (int rF = 0; rF < this.dimensions; rF++) {
      for (int cF = 0; cF < this.dimensions; cF++) {
        for (int rT = 0; rT < this.dimensions; rT++) {
          for (int cT = 0; cT < this.dimensions; cT++) {

            if (canMove(rF, cF, rT, cT)) {
              return false;

            }
          }
        }
      }
    }

    // all else return
    return true;

  }

  @Override
  public int getBoardSize() {
    return this.dimensions;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("This position is beyond the scopes of the board");
    } else if (row > (this.getBoardSize() - 1) || col > (this.getBoardSize() - 1)) {

      throw new IllegalArgumentException("This position is beyond the scopes of the board");
    }

    return this.state[row][col];
  }

  @Override
  public int getScore() {
    return this.marblesPresent;
  }
}
