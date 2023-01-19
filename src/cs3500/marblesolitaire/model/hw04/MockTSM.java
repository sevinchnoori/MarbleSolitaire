package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Mock version of the TriangleSolitaireModel class to test that confirms that
 * the controller is passing the inputs through correctly.
 */
public class MockTSM implements MarbleSolitaireModel {

  private final StringBuilder log;


  /**
   * Constucts a default mock for the TriangleSolitaireModel class which initializes
   * the log/destination as a StringBuilder.
   */
  public MockTSM() {
    this.log = new StringBuilder();
  }

  /**
   * Getter method for the log as a string.
   * @return the log as a string
   */
  public String getLog() {
    return this.log.toString();
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(String.format("fromRow = %d, fromCol = %d, toRow = %d, toCol = %d",
            fromRow, fromCol, toRow, toCol));
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
