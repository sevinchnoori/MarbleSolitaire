package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.fail;

/**
 * Tests for a corrupt class which checks for IOExceptions being thrown by
 * the 2 render methods.
 */
public class CorruptClassTest {

  // tests message render IO exception - ENG
  @Test
  public void testMessageRenderIO() throws IOException {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderMessage("Some message");
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new EnglishSolitaireModel();
      MarbleSolitaireView viewC = new MarbleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderMessage("Hi");
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }

  // tests message render IO exception
  @Test
  public void testMessageRenderIO2() throws IOException {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderMessage("How are you?");
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new EnglishSolitaireModel();
      MarbleSolitaireView viewC = new MarbleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderMessage("Good.");
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }


  // tests board render IO exception
  @Test
  public void testBoardRenderIO() throws IOException {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderBoard();
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new EnglishSolitaireModel();
      MarbleSolitaireView viewC = new MarbleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderBoard();
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }

  // tests message render IO exception - TRI
  @Test
  public void testMessageRenderIOT() throws IOException {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderMessage("Some message");
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new TriangleSolitaireModel();
      MarbleSolitaireView viewC = new TriangleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderMessage("Hi");
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }

  // tests message render IO exception
  @Test
  public void testMessageRenderIO2T() throws IOException {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderMessage("How are you?");
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new TriangleSolitaireModel();
      MarbleSolitaireView viewC = new TriangleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderMessage("Good.");
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }


  // tests board render IO exception
  @Test
  public void testBoardRenderIOT() throws IOException {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderBoard();
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new TriangleSolitaireModel();
      MarbleSolitaireView viewC = new TriangleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderBoard();
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }

  // tests message render IO exception - EURO
  @Test
  public void testMessageRenderIOE() throws IOException {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderMessage("Some message");
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new EuropeanSolitaireModel();
      MarbleSolitaireView viewC = new MarbleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderMessage("Hi");
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }

  // tests message render IO exception
  @Test
  public void testMessageRenderIO2E() throws IOException {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderMessage("How are you?");
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new EuropeanSolitaireModel();
      MarbleSolitaireView viewC = new MarbleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderMessage("Good.");
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }


  // tests board render IO exception
  @Test
  public void testBoardRenderIOE() throws IOException {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, System.out);

    // catches exception without corrupt class
    try {
      view.renderBoard();
    } catch (IOException e) {
      if (!(e.getMessage().contains("IO Exception"))) {
        fail();
      }

      MarbleSolitaireModel corrupt = new EuropeanSolitaireModel();
      MarbleSolitaireView viewC = new MarbleSolitaireTextView(corrupt, System.out);

      // catches exception with corrupt class
      try {
        viewC.renderBoard();
        fail("IOException was not thrown");
      } catch (IOException e2) {
        if (!(e2.getMessage().contains("IO Exception"))) {
          fail();
        }
      }
    }
  }
}