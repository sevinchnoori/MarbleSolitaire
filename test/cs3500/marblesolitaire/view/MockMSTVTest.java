package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the mock version of the MarbleSolitaireTextView class to test that confirms that
 * the controller is passing the inputs through correctly.
 */
public class MockMSTVTest {

  // tests the message mocked version
  @Test
  public void testMockMSTV() {
    Reader in = new StringReader("q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MockMSTV mock = new MockMSTV();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, mock, in);
    controller.playGame();

    assertEquals("The message is: \n" +
            "Score: 32\n" +
            "The message is: Game quit!\n" +
            "The message is: State of game when quit:\n" +
            "The message is: \n" +
            "Score: 32\n", mock.getLog());
  }

  // tests the message mocked version
  @Test
  public void testMockMSTV2() {
    Reader in = new StringReader("6 4 4 4 Q");
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MockMSTV mock = new MockMSTV();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, mock, in);
    controller.playGame();

    assertEquals("The message is: \n" +
            "Score: 32\n" +
            "The message is: \n" +
            "Score: 31\n" +
            "The message is: Game quit!\n" +
            "The message is: State of game when quit:\n" +
            "The message is: \n" +
            "Score: 31\n", mock.getLog());
  }
}