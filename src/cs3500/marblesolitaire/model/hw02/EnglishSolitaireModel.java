package cs3500.marblesolitaire.model.hw02;

/**
 * A class that creates the board of the game.
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {
  protected final int armThickness;
  protected final int sRow; // acts as x-coordinate for empty slot
  protected final int sCol; // acts as y-coordinate for empty slot

  protected final int rows; // x-coordinate

  protected final int cols; // y-coordinate

  protected SlotState[][] state;

  protected int marblesPresent;

  /**
   * Creates the default board with an arm thickness of 3 with the empty slot
   * at the center of the board.
   */
  // constructor 1
  public EnglishSolitaireModel() {
    this.armThickness = 3;
    this.sRow = armThickness;
    this.sCol = armThickness;
    this.rows = ((armThickness * 3) - 2);
    this.cols = ((armThickness * 3) - 2);
    this.state = new SlotState[7][7];
    this.marblesPresent = 0;
    this.state = this.makeGame(); // creates board
  }

  /**
   * Creates a board in terms of a given empty slot.
   * @param sRow row in which the empty slot is located
   * @param sCol column in which the empty slot is located
   * @throws IllegalArgumentException when the given empty slot is an invalid position
   */
  // constructor 2
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {

    this.armThickness = 3;
    if (sRow < 0 || sCol < 0 || sRow > this.getBoardSize() - 1 || sCol > this.getBoardSize() - 1) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow
              + ", " + sCol + ")");
    }
    this.sRow = sRow;
    this.sCol = sCol;
    this.rows = ((armThickness * 3) - 2);
    this.cols = ((armThickness * 3) - 2);
    this.state = new SlotState[7][7];
    this.marblesPresent = 0;
    this.state = this.makeGame();

    if (state[sRow][sCol] == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow
              + ", " + sCol + ")");
    }
  }

  /**
   * Creates a board in terms of arm thickness with the empty slot at the center.
   * @param armThickness the arm thickness of the board
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number
   */
  // constructor 3
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness % 2 == 0) { // if even?
      throw new IllegalArgumentException("Board arms cannot be of an even size");
    }
    if (armThickness <= 0) { // if negative or zero
      throw new IllegalArgumentException("Board arms must be a positive non-zero number");
    }

    this.armThickness = armThickness;
    this.sRow = ((this.getBoardSize() - 1) / 2);
    this.sCol = ((this.getBoardSize() - 1) / 2);
    this.rows = ((armThickness * 3) - 2);
    this.cols = ((armThickness * 3) - 2);
    this.state = new SlotState[rows][cols];
    this.marblesPresent = 0;
    this.state = this.makeGame();
  }

  /**
   * Creates a board based on a given arm thickness and the row and column of the empty slot.
   *     @param armThickness    the arm thickness of the board
   *     @param sRow    the row in which the empty slot is located
   *     @param sCol    the column in which the empty slot is lcoated
   *     @throws IllegalArgumentException    if the arm thickness is not a positive odd number or
   *     the cell position is invalid
   */
  // constructor 4
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    if (armThickness % 2 == 0 || armThickness <= 0) { // if even, neg, zero
      throw new IllegalArgumentException("Board arms cannot be of an even size");
    }
    this.armThickness = armThickness;
    if (sRow < 0 || sCol < 0 || sRow > this.getBoardSize() - 1 || sCol > this.getBoardSize() - 1) {
      throw new IllegalArgumentException("Invalid empty cell position");
    }

    this.sRow = sRow;

    this.sCol = sCol;

    this.rows = ((armThickness * 3) - 2);
    this.cols = ((armThickness * 3) - 2);
    this.state = new SlotState[rows][cols];
    this.marblesPresent = 0;


    this.state = this.makeGame();
    if (state[sRow][sCol] == SlotState.Invalid || state[sRow][sCol] == SlotState.Marble) {
      throw new IllegalArgumentException("Invalid empty cell position"); }
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {

    // if the rows aren't equal to each other and the cols aren't either
    if ((fromRow != toRow) && (fromCol != toCol)) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // if the values are neg
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // if the values are equal to or larger than the board size
    else if (fromRow >= this.getBoardSize() || fromCol >= this.getBoardSize()
            || toRow >= this.getBoardSize() || toCol >= this.getBoardSize()) {
      throw new IllegalArgumentException("Invalid move.");
    }

    // marble is not present at the from position
    else if (state[fromRow][fromCol] == MarbleSolitaireModel.SlotState.Empty) {
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

    // to and from position more than 2 positions away VERT
    else if ((fromCol == toCol) && (((Math.abs(fromRow - toRow)) != 2))) {
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
    // marble is not present between to and from positions VERT (up to down)
    else if (fromCol == toCol && fromRow < toRow && state[fromRow + 1][fromCol]
            == SlotState.Empty) {
      throw new IllegalArgumentException("Invalid move.");
    }
    // marble is not present between to and from positions VERT (down to up)
    else if (fromCol == toCol && fromRow > toRow && state[fromRow - 1][fromCol]
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

      // vertical move (up to down)
      else if (fromCol == toCol && fromRow < toRow) {
        // marble attempting to get rid of
        state[fromRow + 1][fromCol] = SlotState.Empty;
        this.marblesPresent = this.marblesPresent - 1;
        // changes from and to
        state[fromRow][fromCol] = SlotState.Empty;
        state[toRow][toCol] = SlotState.Marble;
      }

      // vertical move (down to up)
      else if (fromCol == toCol && fromRow > toRow) {
        // marble attempting to get rid of
        state[fromRow - 1][fromCol] = SlotState.Empty;
        this.marblesPresent = this.marblesPresent - 1;
        // changes from and to
        state[fromRow][fromCol] = SlotState.Empty;
        state[toRow][toCol] = SlotState.Marble;
      }
    }

  }

  /**
   * Creates the board of the game.
   * @return a 2-D SlotState array
   */
  protected SlotState[][] makeGame() {
    int lessAT = armThickness - 1;
    int moreAT = ((armThickness - 1) * 2);

    for (int r = 0; r < this.rows; r = r + 1) { //row
      for (int c = 0; c < this.cols; c = c + 1) { //col

        // invalid - top left
        if (r < lessAT && c < lessAT) {
          this.state[r][c] = SlotState.Invalid;
        }

        // invalid - top right
        else if (r < lessAT && c > moreAT) {
          this.state[r][c] = SlotState.Invalid;
        }

        // invalid - bottom left
        else if (r > moreAT && c < lessAT) {
          this.state[r][c] = SlotState.Invalid;
        }

        // invalid - bottom right
        else if (r > moreAT && c > moreAT) {
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
            // row is same and cols are 2 spaces away OR
            && ( ( ((Math.abs(fromCol - toCol)) == 2) && ((fromRow - toRow) == 0) )
            // col is same and rows are 2 spaces away
            || ( ((Math.abs(fromRow - toRow)) == 2) && ((fromCol - toCol) == 0) ) ) );

  }

  @Override
  public boolean isGameOver() {

    // if there is 1 peg left on the board
    if (this.getScore() == 1) {
      return true;
    }

    // checks for patterns
    for (int rF = 0; rF < this.rows; rF++) {
      for (int cF = 0; cF < this.rows; cF++) {
        for (int rT = 0; rT < this.rows; rT++) {
          for (int cT = 0; cT < this.rows; cT++) {

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
    return this.armThickness * 3 - 2;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("This position is beyond the scopes of the board");
    }
    else if (row > (this.getBoardSize() - 1) || col > (this.getBoardSize() - 1)) {
      throw new IllegalArgumentException("This position is beyond the scopes of the board");
    }
    return this.state[row][col];
  }

  @Override
  public int getScore() {
    return this.marblesPresent;
  }


}
