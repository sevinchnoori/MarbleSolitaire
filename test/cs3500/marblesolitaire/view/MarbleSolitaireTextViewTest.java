package cs3500.marblesolitaire.view;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Class to represent the examples and tests of the MarbleSolitaireTextView class.
 */
public class MarbleSolitaireTextViewTest {

  private MarbleSolitaireTextView m;
  private MarbleSolitaireTextView m2;
  private MarbleSolitaireTextView m3;
  private MarbleSolitaireTextView m4;
  private MarbleSolitaireTextView m5;
  private MarbleSolitaireTextView m6;
  private EnglishSolitaireModel e;

  private EuropeanSolitaireModel euro1;

  // test invalid initialization of first constructor - eng
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    this.e = null;
    this.m = new MarbleSolitaireTextView(this.e);
  }

  // test invalid initialization of 2nd constructor - eng
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    this.e = null;
    this.m = new MarbleSolitaireTextView(this.e, new StringBuilder());
  }

  // test invalid initialization of 2nd constructor - eng
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor3() {
    this.e = new EnglishSolitaireModel();
    this.m = new MarbleSolitaireTextView(this.e, null);
  }

  // test invalid initialization of first constructor - euro
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor4() {
    this.euro1 = null;
    this.m = new MarbleSolitaireTextView(this.euro1);
  }

  // test invalid initialization of 2nd constructor - euro
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor5() {
    this.euro1 = null;
    this.m = new MarbleSolitaireTextView(this.euro1, new StringBuilder());
  }

  // test invalid initialization of 2nd constructor - euro
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor6() {
    this.euro1 = new EuropeanSolitaireModel();
    this.m = new MarbleSolitaireTextView(this.euro1, null);
  }

  // test valid initialization of first constructor - eng
  @Test
  public void testValidInitializationNew1() throws IOException {
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel());
    this.m.renderBoard();
    assertEquals("    O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "O O O _ O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "    O O O", this.m.toString());
  }

  // test valid initialization of 2nd constructor - eng
  @Test
  public void testValidInitializationNew2() throws IOException {
    Appendable app = new StringBuilder();
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel(), app);
    this.m.renderBoard();
    assertEquals("    O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "O O O _ O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "    O O O", app.toString());
  }

  // test valid initialization of first constructor - euro
  @Test
  public void testValidInitializationNew3() throws IOException {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    this.m.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", this.m.toString());
  }

  // test valid initialization of 2nd constructor - euro
  @Test
  public void testValidInitializationNew4() throws IOException {
    Appendable app = new StringBuilder();
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel(), app);
    this.m.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", app.toString());
  }


  @Test
  public void testValidInitialization() {
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel());

    assertEquals("    O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "O O O _ O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "    O O O", this.m.toString());
  }

  @Test
  public void testValidInitialization2() {
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel(4, 6));

    assertEquals("    O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "O O O O O O _" + "\n"
            +
            "    O O O" + "\n"
            +
            "    O O O", this.m.toString());
  }

  @Test
  public void testValidInitialization3() {
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel(2, 4));

    assertEquals("    O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "O O O O _ O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "O O O O O O O" + "\n"
            +
            "    O O O" + "\n"
            +
            "    O O O", this.m.toString());
  }



  @Test
  public void testValidInitializationEuro() {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", this.m.toString());
  }

  @Test
  public void testValidInitializationEuro2() {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel(4, 6));

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O _\n" +
            "  O O O O O\n" +
            "    O O O", this.m.toString());
  }

  @Test
  public void testValidInitializationEuro3() {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel(2, 4));

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", this.m.toString());
  }

  @Before
  public void init() {
    EnglishSolitaireModel e = new EnglishSolitaireModel();
    m = new MarbleSolitaireTextView(e);
    EnglishSolitaireModel e2 = new EnglishSolitaireModel(2, 4);
    m2 = new MarbleSolitaireTextView(e2);
    EnglishSolitaireModel e3 = new EnglishSolitaireModel(4, 6);
    m3 = new MarbleSolitaireTextView(e3);
    EnglishSolitaireModel e4 = new EnglishSolitaireModel(3);
    m4 = new MarbleSolitaireTextView(e4);
    EnglishSolitaireModel e5 = new EnglishSolitaireModel(5);
    m5 = new MarbleSolitaireTextView(e5);
    EnglishSolitaireModel e6 = new EnglishSolitaireModel(3, 0, 2);
    m6 = new MarbleSolitaireTextView(e6);
  }

  @Test
  public void testToString() {
    assertEquals("    O O O" + "\n" +
            "    O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "O O O _ O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "    O O O" + "\n" +
            "    O O O", m.toString());


    assertEquals("    _ O O" + "\n" +
            "    O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "    O O O" + "\n" +
            "    O O O", m6.toString());

    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O _ O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O", m2.toString());

    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O _" + "\n"
            + "    O O O" + "\n"
            + "    O O O", m3.toString());


    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O", m4.toString());

    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O _ O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", m5.toString());
  }

  // draws correctly after one move - eng
  @Test
  public void testToStringMove() {
    e = new EnglishSolitaireModel();
    e.move(5, 3, 3, 3);
    m = new MarbleSolitaireTextView(e);
    assertEquals("    O O O" + "\n" +
            "    O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "O O O _ O O O" + "\n" +
            "    O _ O" + "\n" +
            "    O O O", m.toString());
  }

  // draws correctly after one move - euro
  @Test
  public void testToStringMove2() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(5, 3, 3, 3);
    m = new MarbleSolitaireTextView(euro1);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", m.toString());
  }

  // render board
  @Test
  public void boardRender() throws IOException {
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel());
    Appendable app = new StringBuilder();
    app.append(m.toString());

    assertEquals("    O O O" + "\n" +
            "    O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "O O O _ O O O" + "\n" +
            "O O O O O O O" + "\n" +
            "    O O O" + "\n" +
            "    O O O", app.toString());

  }

  // render board
  @Test
  public void boardRender2() throws IOException {
    Appendable app = new StringBuilder();
    app.append(m2.toString());

    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O _ O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O", app.toString());
  }

  // render board
  @Test
  public void boardRender3() throws IOException {
    Appendable app = new StringBuilder();
    app.append(m5.toString());

    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O _ O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", app.toString());
  }

  // render board
  @Test
  public void boardRenderEuro() throws IOException {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    Appendable app = new StringBuilder();
    app.append(m.toString());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", app.toString());
  }

  // render board
  @Test
  public void boardRenderEuro2() throws IOException {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel(3,5));
    Appendable app = new StringBuilder();
    app.append(m.toString());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", app.toString());
  }

  // render board
  @Test
  public void boardRenderEuro3() throws IOException {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel(7));
    Appendable app = new StringBuilder();
    app.append(m.toString());

    assertEquals("            O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "            O O O O O O O", app.toString());
  }

  // render message
  @Test
  public void messageRender() throws IOException {
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel());
    Appendable app = new StringBuilder();
    app.append("Hi");

    assertEquals("Hi", app.toString());
  }

  // render message
  @Test
  public void messageRender2() throws IOException {
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel());
    Appendable app = new StringBuilder();
    app.append("Bye");

    assertEquals("Bye", app.toString());
  }

  // render message
  @Test
  public void messageRender3() throws IOException {
    this.m = new MarbleSolitaireTextView(new EnglishSolitaireModel());
    Appendable app = new StringBuilder();
    app.append("Game over!");

    assertEquals("Game over!", app.toString());
  }

  // render message
  @Test
  public void messageRenderEuro() throws IOException {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    Appendable app = new StringBuilder();
    app.append("Hi");

    assertEquals("Hi", app.toString());
  }

  // render message
  @Test
  public void messageRenderEuro2() throws IOException {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    Appendable app = new StringBuilder();
    app.append("Bye");

    assertEquals("Bye", app.toString());
  }

  // render message
  @Test
  public void messageRenderEuro3() throws IOException {
    this.m = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    Appendable app = new StringBuilder();
    app.append("Game over!");

    assertEquals("Game over!", app.toString());
  }


  // European toString default
  @Test
  public void euroString1() throws IOException {
    euro1 = new EuropeanSolitaireModel();
    this.m = new MarbleSolitaireTextView(euro1);
    this.m.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", this.m.toString());
  }

  // European toString
  @Test
  public void euroString2() throws IOException {
    euro1 = new EuropeanSolitaireModel(5);
    this.m = new MarbleSolitaireTextView(euro1);
    this.m.renderBoard();
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", this.m.toString());
  }

  // European toString
  @Test
  public void euroString3() throws IOException {
    euro1 = new EuropeanSolitaireModel(5, 3, 7);
    this.m = new MarbleSolitaireTextView(euro1);
    this.m.renderBoard();
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O _ O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", this.m.toString());
  }


  // European toString
  @Test
  public void euroString4() throws IOException {
    euro1 = new EuropeanSolitaireModel( 3,5);
    this.m = new MarbleSolitaireTextView(euro1);
    this.m.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", this.m.toString());
  }

}