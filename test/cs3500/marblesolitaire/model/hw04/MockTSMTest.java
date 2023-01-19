package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the mock version of the TriangleSolitaireModel class to test that confirms that
 * the controller is passing the inputs through correctly.
 */
public class MockTSMTest {

  // mock test constructor 1
  @Test
  public void testMockTSM() {
    Reader in = new StringReader("1 2 3 4 q");
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MockTSM mock = new MockTSM();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);
    controller.playGame();

    assertEquals("fromRow = 0, fromCol = 1, toRow = 2, toCol = 3", mock.getLog());
  }

  // mock test constructor 1
  @Test
  public void testMockTSM1() {
    Reader in = new StringReader("3 4 5 2 q");
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MockTSM mock = new MockTSM();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);
    controller.playGame();

    assertEquals("fromRow = 2, fromCol = 3, toRow = 4, toCol = 1", mock.getLog());
  }

  // mock test constructor 1
  @Test
  public void testMockTSM2() {
    Reader in = new StringReader("6 4 4 4 Q");
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MockTSM mock = new MockTSM();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, in);
    controller.playGame();

    assertEquals("fromRow = 5, fromCol = 3, toRow = 3, toCol = 3", mock.getLog());
  }

}
