package cs3500.marblesolitaire.view;

import java.io.IOException;


/**
 * Mock version of the MarbleSolitaireTextView class to test that confirms that
 * the controller is passing the inputs through correctly.
 */
public class MockMSTV implements MarbleSolitaireView {
  private final StringBuilder log;

  /**
   * Constucts a default mock for the MarbleSolitaireTextView class which initializes
   * the log/destination as a StringBuilder.
   */
  public MockMSTV() {
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
  public void renderBoard() throws IOException {
    return;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.log.append("The message is: " + message);
  }
}
