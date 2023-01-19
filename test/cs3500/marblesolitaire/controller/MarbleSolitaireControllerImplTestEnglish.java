package cs3500.marblesolitaire.controller;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.CorruptClass;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class that represents examples and tests for the controller of the
 * english solitaire model.
 */
public class MarbleSolitaireControllerImplTestEnglish {

  MarbleSolitaireModel model;
  Appendable out;
  MarbleSolitaireView view;
  Readable in;
  MarbleSolitaireController controller;


  // test first constructor - invalid
  @Test(expected = IllegalArgumentException.class)
  public void controllerInvalidConstruction1() {
    this.model = null;
    this.out = new StringBuilder();
    this.view = new MarbleSolitaireTextView(model, out);
    this.in = new StringReader("q");
    this.controller = new MarbleSolitaireControllerImpl(model, view, in);
  }

  // test first constructor - invalid
  @Test(expected = IllegalArgumentException.class)
  public void controllerInvalidConstruction2() {
    this.model = new EnglishSolitaireModel();
    this.out = new StringBuilder();
    this.view = null;
    this.in = new StringReader("Q");
    this.controller = new MarbleSolitaireControllerImpl(model, view, in);
  }

  // test first constructor - invalid
  @Test(expected = IllegalArgumentException.class)
  public void controllerInvalidConstruction3() {
    this.model = new EnglishSolitaireModel();
    this.out = new StringBuilder();
    this.view = new MarbleSolitaireTextView(model, out);
    this.in = null;
    this.controller = new MarbleSolitaireControllerImpl(model, view, in);
  }

  @Before
  public void init() {
    model = new EnglishSolitaireModel();
    out = new StringBuilder();
    view = new MarbleSolitaireTextView(model, out);
  }

  // tests that there is no inputs left - letter
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft0() {
    Readable in = new StringReader("");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // tests that there is no inputs left - letter
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft() {
    Readable in = new StringReader("a");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // tests that there is no inputs left - number
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft1() {
    Readable in = new StringReader("6");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // tests that there is no inputs left - 2 numbers
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft2() {
    Readable in = new StringReader("6 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // tests that there is no inputs left - 3 numbers
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft2B() {
    Readable in = new StringReader("6 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // tests that there is no inputs left - num and letter
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft3() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Readable in = new StringReader("6 a 4 b");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // tests that there is no inputs left - 4 inputs w/o hitting q
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft4() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Readable in = new StringReader("6 4 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // letter before move
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft5() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Readable in = new StringReader("g 6 4 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // letter after move
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft6() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Readable in = new StringReader("6 4 4 4 z");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // some special character
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft7() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Readable in = new StringReader("6 4 @ 4 4 z");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // multiple letters in a row
  @Test(expected = IllegalStateException.class)
  public void noInputsLeft8() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Readable in = new StringReader("6 dfg 4 4 4 z");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  // tests when input is "q"
  @Test
  public void controller1() {
    Readable in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals(view
            + ("\nScore: " + model.getScore()) + "\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + view
            + ("\nScore: " + model.getScore()) + "\n", out.toString());

  }

  // tests when input is "Q"
  @Test
  public void controller2() throws IOException {
    Readable in = new StringReader("Q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals(view
            + ("\nScore: " + model.getScore()) + "\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + view
            + ("\nScore: " + model.getScore()) + "\n", out.toString());

  }

  // tests bad input
  @Test
  public void controller3() throws IOException {
    Readable in = new StringReader("a q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out.toString());
  }

  // tests when game is over -- no spots left to move to -- all in one
  @Test
  public void controller4() throws IOException {
    Readable in = new StringReader("4 6 4 4 4 3 4 5 6 4 4 4 3 4 5 4 2 3 4 3 5 3 3 3 3 6 " +
            "3 4 2 4 4 4 4 4 6 4 7 4 5 4 5 5 3 5 2 5 4 5 3 2 3 4 4 1 4 3 5 1 5 3 5 3 3 3 3 3 " +
            "3 5 4 5 2 5 1 5 3 5 1 3 1 4 5 7 5 5 5 5 5 3 3 7 5 5 7 5 5 5 6 3 4 3 3 7 5 7 1 3 1 5");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O _ O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O _ _ O O O\n" +
            "O O O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O O _ O O O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O O O _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O _ _ _ O\n" +
            "O O _ O O _ O\n" +
            "O O _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O _ _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O _ _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O O O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 22\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O _ O _ O\n" +
            "O O _ _ _ _ O\n" +
            "O O _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 21\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O O O _ _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 20\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 19\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "_ _ O _ O _ O\n" +
            "O O _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 18\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "_ _ O _ O _ O\n" +
            "_ _ O O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 17\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ O O _ _ O\n" +
            "_ _ _ _ O _ O\n" +
            "_ _ _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 16\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ O _ O\n" +
            "_ _ _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 15\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O _ _ _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 14\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 13\n" +
            "Invalid move. Play again.\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ O O _ _\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 12\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ O _ _ _ _\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 11\n" +
            "Invalid move. Play again.\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ O _ O _ _\n" +
            "    O _ _\n" +
            "    O _ _\n" +
            "Score: 10\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ O _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "Score: 9\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ _\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "Score: 8\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ _\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "Score: 7\n" +
            "Game over!\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ _\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "Score: 7\n", out.toString());

  }

  // tests when game is over -- no spots left to move to -- randomly inputting
  @Test
  public void controllerRand() throws IOException {
    Readable in = new StringReader("4 6 4 4\n 4 3 4 5 6 4 4 4 3 4 5\n 4 2 3 4 3 5 3 3 3 3 6 " +
            "3 4 2 4 4 4 4 4 6 4 7 4 5 4 5 5 3 5 2 5\n 4 5 3 2 3 4 4 1 4 3 5 1 5 3 5 3 3 3 3 3 " +
            "3 5 4 5 2 5 1 5 3 5 1 3 1 4 5 7 5 5 5 5 5 3 3 7 5 5 7 " +
            "5 5 5 6 3 4 3 3 7 5 7 1 3 1 \n5");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O _ O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O _ _ O O O\n" +
            "O O O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O O _ O O O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O O O _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O _ _ _ O\n" +
            "O O _ O O _ O\n" +
            "O O _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O _ _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O _ _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O O O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 22\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O O O _ O _ O\n" +
            "O O _ _ _ _ O\n" +
            "O O _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 21\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O O O _ _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 20\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O O _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 19\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "_ _ O _ O _ O\n" +
            "O O _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 18\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "_ _ O _ O _ O\n" +
            "_ _ O O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 17\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ O O _ _ O\n" +
            "_ _ _ _ O _ O\n" +
            "_ _ _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 16\n" +
            "    O O O\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ O _ O\n" +
            "_ _ _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 15\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O _ _ _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 14\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ O _ O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 13\n" +
            "Invalid move. Play again.\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ _ O O _ _\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 12\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ O _ _ _ _\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 11\n" +
            "Invalid move. Play again.\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ O _ O _ _\n" +
            "    O _ _\n" +
            "    O _ _\n" +
            "Score: 10\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ O\n" +
            "_ _ O _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "Score: 9\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ _\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "Score: 8\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ _\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "Score: 7\n" +
            "Game over!\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "O _ _ _ O _ _\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "Score: 7\n", out.toString());

  }

  // tests 1 valid move - all #s
  @Test
  public void controller5() throws IOException {
    Readable in = new StringReader("6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - letter
  @Test
  public void controller6() throws IOException {
    Readable in = new StringReader("a 6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - letter
  @Test
  public void controller7() throws IOException {
    Readable in = new StringReader("6 b 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - letter
  @Test
  public void controller8() throws IOException {
    Readable in = new StringReader("6 4 c 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - letter
  @Test
  public void controller9() throws IOException {
    Readable in = new StringReader("6 4 4 d 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - letter
  @Test
  public void controller10() throws IOException {
    Readable in = new StringReader("6 4 4 4 g q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Please re-enter value again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - num
  @Test
  public void controller11() throws IOException {
    Readable in = new StringReader("-1 6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - num
  @Test
  public void controller12() throws IOException {
    Readable in = new StringReader("6 -4 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - num
  @Test
  public void controller13() throws IOException {
    Readable in = new StringReader("6 4 -2 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests 1 valid move w bad input - num
  @Test
  public void controller14() throws IOException {
    Readable in = new StringReader("6 4 4 -3 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // correct ove then invalid inputs
  @Test
  public void controller15() throws IOException {
    Readable in = new StringReader("6 4 4 4 -1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Please re-enter value again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests a move that is invalid
  @Test
  public void controller16() throws IOException {
    Readable in = new StringReader("1 4 5 2 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid move. Play again.\nGame quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());

  }

  // tests 2 valid moves in a row
  @Test
  public void controller17() throws IOException {
    Readable in = new StringReader("4 6 4 4 4 3 4 5 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O _ _ O _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 30\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O _ _ O _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 30\n",
            out.toString());

  }

  // tests 3 valid moves in a row
  @Test
  public void controller18() throws IOException {
    Readable in = new StringReader("4 6 4 4 4 3 4 5 6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O _ _ O _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 30\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O _ O O _ O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 29\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O _ O O _ O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 29\n",
            out.toString());

  }

  // tests just 1 input - num
  @Test
  public void controller19() throws IOException {
    Readable in = new StringReader("4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());

  }

  // tests 2 input - num
  @Test
  public void controller20() throws IOException {
    Readable in = new StringReader("4 6 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // tests 3 input - num
  @Test
  public void controller21() throws IOException {
    Readable in = new StringReader("4 6 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }


  // quit after 1 valid move
  @Test
  public void controller23() throws IOException {
    Readable in = new StringReader("4 6 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n",
            out.toString());
  }

  // quit after 1 input
  @Test
  public void controller24() throws IOException {
    Readable in = new StringReader("4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // quit after 2 input
  @Test
  public void controller25() throws IOException {
    Readable in = new StringReader("4 6 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // quit after 3 input
  @Test
  public void controller26() throws IOException {
    Readable in = new StringReader("4 6 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // a valid move after an invalid move
  @Test
  public void controller27() throws IOException {
    Readable in = new StringReader("6 4 4 4\n 1 4 2 6\n 3 4 5 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Invalid move. Play again.\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 30\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 30\n",
            out.toString());
  }

  // quit b/w moves
  @Test
  public void controller28() throws IOException {
    Readable in = new StringReader("6 4 4 4 q 3 4 5 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 31\n",
            out.toString());
  }

  // move diagonnally
  @Test
  public void controller29() throws IOException {
    Readable in = new StringReader("5 5 3 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid move. Play again.\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // move where there from no marble to marble
  @Test
  public void controller30() throws IOException {
    Readable in = new StringReader("4 4 4 2 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid move. Play again.\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // move from marble to marble
  @Test
  public void controller31() throws IOException {
    Readable in = new StringReader("4 1 4 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid move. Play again.\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // move more than 2 spots
  @Test
  public void controller32() throws IOException {
    Readable in = new StringReader("3 3 6 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid move. Play again.\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // move from spot beyond scopes of board
  @Test
  public void controller33() throws IOException {
    Readable in = new StringReader("9 9 3 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid move. Play again.\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n",
            out.toString());
  }

  // 2 invalid inputs next to each other
  @Test
  public void controller90() throws IOException {
    Readable in = new StringReader("6 4 4 4 d -1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Please re-enter value again.\n" +
            "Please re-enter value again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // letters in a row
  @Test
  public void controller935() throws IOException {
    Readable in = new StringReader("6 4 dfg 4 4 d -10 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re-enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Please re-enter value again.\n" +
            "Please re-enter value again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());

  }

  // tests an IOException while rendering messages
  @Test
  public void testRenderMessage() throws IOException {
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel(), new CorruptClass());
    try {
      view.renderMessage("hi");
      fail("exception thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void testRenderMessage2() throws IOException {
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel(3), new CorruptClass());
    try {
      view.renderMessage("bye");
      fail("exception thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
    public void testRenderMessage3() throws IOException {
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel(3,5), new CorruptClass());
    try {
      view.renderMessage("see ya");
      fail("exception thrown");
    } catch (IOException e) {
      e.printStackTrace(); }
  }

  @Test
  public void testRenderMessage4() throws IOException {
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel(3,3,5), new CorruptClass());
    try {
      view.renderMessage("see ya");
      fail("exception thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // tests an IOException while rendering boards
  @Test
  public void testRenderBoard() throws IOException {
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel(), new CorruptClass());
    try {
      view.renderBoard();
      fail("exception thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void testRenderBoard2() throws IOException {
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel(3), new CorruptClass());
    try {
      view.renderBoard();
      fail("exception thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testRenderBoard3() throws IOException {
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel(3,5), new CorruptClass());
    try {
      view.renderBoard();
      fail("exception thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testRenderBoard4() throws IOException {
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel(3,3,5), new CorruptClass());
    try {
      view.renderBoard();
      fail("exception thrown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}