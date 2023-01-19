package cs3500.marblesolitaire.view;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Class representing the text view of a triangular model board and a destination. Contains
 * methods to view the board as a string, render the board to the destination, and
 * view messages.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView
        implements MarbleSolitaireView {

  /**
   * Constructs the text view of the model with a destination.
   *
   * @param model model of the board
   * @throws IllegalArgumentException when the model is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model)
          throws IllegalArgumentException {
    super(model);
  }

  /**
   * Constructs the model with a given destination.
   *
   * @param model       model of the board
   * @param destination destination of the data
   * @throws IllegalArgumentException when the model or destination are null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable destination)
          throws IllegalArgumentException {
    super(model, destination);
  }

  @Override
  public String toString() {
    StringBuilder board = new StringBuilder();
    for (int r = 0; r < this.model.getBoardSize(); r = r + 1) {
      for (int c = 0; c < this.model.getBoardSize(); c = c + 1) {

        switch (model.getSlotAt(r, c)) {
          case Marble:
            // very last marble in the last row
            if (c == r && r == this.model.getBoardSize() - 1) {
              board.append("O");
            }


            // marble at the very top
            else if (c == 0 & r == 0) {
              board.append(addSpaces(r));
              board.append("O\n");
            }

            // first marble in row
            else if (c == 0) {
              board.append(addSpaces(r));
              board.append("O ");
            }

            // last marble in all other rows
            else if (c == r) {
              board.append("O\n");
            }

            // all other marbles
            else {
              board.append("O ");
            }

            break;

          case Invalid:
            if (c > r) {
              board.append("");
            }

            break;

          case Empty:

            // the very last empty
            if (c == r && r == this.model.getBoardSize() - 1) {
              board.append("_");
            }

            // top most empty

            else if (c == 0 & r == 0) {
              board.append(addSpaces(r));
              board.append("_\n");
            }


            // first empty in row in all other rows
            else if (c == 0 && r != 0) {
              board.append(addSpaces(r));
              board.append("_ ");
            }

            // last empty on any other row
            else if (r == c) {
              board.append("_\n");
            }

            // all other emptys
            else {
              board.append("_ ");
            }
            break;

          default:
            // no action is needed
        }
      }

    }
    return board.toString();
  }

  /**
   * Adds the appropriate amount of spaces before each first marble or empty slot at the
   * beginning of the row.
   * @param r the row location
   * @return String of spaces
   */
  private String addSpaces(int r) {
    String empty = " ";
    int spacesNum = this.model.getBoardSize() - 1 - r;
    return empty.repeat(spacesNum);
  }

}
