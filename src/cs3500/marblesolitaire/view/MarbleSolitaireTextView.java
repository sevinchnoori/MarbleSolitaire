package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

/**
 * Class representing the text view of a model board and a destination. Contains
 * methods to view the board as a string, render the board to the destination, and
 * view messages.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  protected final MarbleSolitaireModelState model;
  private final Appendable destination;


  /**
   * Constructs the text view of the model with a destination.
   *
   * @param model model of the board
   * @throws IllegalArgumentException when the model is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Board cannot be rendered if null.");
    }

    this.model = model;
    this.destination = System.out;
  }

  /**
   * Constructs the model with a given destination.
   *
   * @param model       model of the board
   * @param destination destination of the data
   * @throws IllegalArgumentException when the model or destination are null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable destination)
          throws IllegalArgumentException {
    if (model == null || destination == null) {
      throw new IllegalArgumentException("Board cannot be rendered if null.");
    }

    this.model = model;
    this.destination = destination;
  }


  @Override
  public String toString() {
    StringBuilder board = new StringBuilder();
    int armThick = ((this.model.getBoardSize() + 2) / 3);
    int finalFullRow = (armThick - 1) * 2;
    int finalInvalidRow = this.model.getBoardSize() - 1;

    for (int r = 0; r < this.model.getBoardSize(); r = r + 1) {
      for (int c = 0; c < this.model.getBoardSize(); c = c + 1) {
        switch (model.getSlotAt(r, c)) {
          case Marble:

            // very last marble
            if (r == finalInvalidRow && c == finalFullRow) {
              board.append("O");
            }

            // full rows
            else if (c == (this.model.getBoardSize() - 1)) {
              board.append("O\n");
            }

            // row with invalids
            else if (model.getSlotAt(r, c + 1) == SlotState.Invalid) {
              board.append("O\n");
            }

            // all other marbles
            else {
              board.append("O ");
            }

            break;

          case Invalid:
            if (c > armThick) {
              board.append("");
            } else {
              board.append("  ");
            }
            break;

          case Empty:

            // very last empty
            if (r == finalInvalidRow && c == finalFullRow) {
              board.append("_");
            }

            // full rows
            else if (c == (this.model.getBoardSize() - 1)) {
              board.append("_\n");
            }

            // row with invalids
            else if (c > ((this.model.getBoardSize() + 2) / 3)
                    && model.getSlotAt(r, c + 1) == SlotState.Invalid) {
              board.append("_\n");
            }

            // all other empty
            else {
              board.append("_ ");
            }
            break;

          default:
            // no other action needed
        }
      }
    }
    return board.toString();
  }


  @Override
  public void renderBoard() throws IOException {
    try {
      destination.append(this.toString());
    } catch (IOException e) {
      throw new IOException("Transmission failed");
    }

  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      destination.append(message);
    } catch (IOException e) {
      throw new IOException("Transmission failed");
    }
  }

}


