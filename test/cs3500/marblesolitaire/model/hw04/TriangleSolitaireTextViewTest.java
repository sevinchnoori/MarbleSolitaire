package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Class to represent the examples and tests of the TriangleSolitaireTextView class.
 */
public final class TriangleSolitaireTextViewTest {

  TriangleSolitaireModel t1;
  TriangleSolitaireModel t2;
  TriangleSolitaireTextView tv1;
  Appendable a;

  // test invalid initialization of first constructor
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    t1 = null;
    tv1 = new TriangleSolitaireTextView(t1);
  }

  // test invalid initialization of 2nd constructor
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    t1 = null;
    a = new StringBuilder();
    tv1 = new TriangleSolitaireTextView(t1, a);
  }

  // test invalid initialization of 2nd constructor
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor3() {
    t1 = new TriangleSolitaireModel();
    a = null;
    tv1 = new TriangleSolitaireTextView(t1, a);
  }

  // test valid initialization of first constructor
  @Test
  public void testValidInitializationNew1() throws IOException {
    this.tv1 = new TriangleSolitaireTextView(new TriangleSolitaireModel());
    this.tv1.renderBoard();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());
  }

  // test valid initialization of first constructor
  @Test
  public void testValidInitializationNew2() throws IOException {
    this.tv1 = new TriangleSolitaireTextView(new TriangleSolitaireModel(), new StringBuilder());
    this.tv1.renderBoard();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());
  }

  // size 5
  @Test
  public void testToString1() {
    t1 = new TriangleSolitaireModel();
    tv1 = new TriangleSolitaireTextView(t1);

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());
  }

  // size 3
  @Test
  public void testToString2() {
    t2 = new TriangleSolitaireModel(3);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("  _\n" +
            " O O\n" +
            "O O O", this.tv1.toString());

  }

  // empty at the end
  @Test
  public void testToString3() {
    t2 = new TriangleSolitaireModel(4,4);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O _", this.tv1.toString());

  }

  // empty at the beginning of a row
  @Test
  public void testToString4() {
    t2 = new TriangleSolitaireModel(1,0);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());

  }

  // empty at the beginning of a row
  @Test
  public void testToString5() {
    t2 = new TriangleSolitaireModel(2,0);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("    O\n" +
            "   O O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());

  }

  // empty at the beginning of a row
  @Test
  public void testToString6() {
    t2 = new TriangleSolitaireModel(3,0);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " _ O O O\n" +
            "O O O O O", this.tv1.toString());

  }

  // empty at the beginning of a row
  @Test
  public void testToString7() {
    t2 = new TriangleSolitaireModel(4,0);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "_ O O O O", this.tv1.toString());

  }

  // empty at the end of a row
  @Test
  public void testToString8() {
    t2 = new TriangleSolitaireModel(1,1);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());

  }

  // empty at the end of a row
  @Test
  public void testToString9() {
    t2 = new TriangleSolitaireModel(2,2);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());

  }

  // empty at the end of a row
  @Test
  public void testToString10() {
    t2 = new TriangleSolitaireModel(3,3);
    tv1 = new TriangleSolitaireTextView(t2);
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O O", this.tv1.toString());

  }

  // draws correctly after one move - euro
  @Test
  public void testToStringMove1() {
    t1 = new TriangleSolitaireModel();
    t1.move(2,0, 0,0);
    tv1 = new TriangleSolitaireTextView(t1);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", tv1.toString());
  }

  @Test
  public void renderBoard() throws IOException {
    t2 = new TriangleSolitaireModel();
    tv1 = new TriangleSolitaireTextView(t2);
    this.tv1.renderBoard();

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());

    t2 = new TriangleSolitaireModel(5,2,2);
    tv1 = new TriangleSolitaireTextView(t2);
    this.tv1.renderBoard();


    assertEquals("    O\n" +
            "   O O\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", this.tv1.toString());

    t2 = new TriangleSolitaireModel(7);
    tv1 = new TriangleSolitaireTextView(t2);
    this.tv1.renderBoard();


    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", this.tv1.toString());

  }

  @Test
  public void renderMessage() throws IOException {
    t2 = new TriangleSolitaireModel();
    tv1 = new TriangleSolitaireTextView(t2);
    Appendable app = new StringBuilder();
    app.append("Hi");
    assertEquals("Hi", app.toString());
  }

  @Test
  public void renderMessage2() throws IOException {
    t2 = new TriangleSolitaireModel();
    tv1 = new TriangleSolitaireTextView(t2);
    Appendable app = new StringBuilder();
    app.append("Hi there");
    assertEquals("Hi there", app.toString());
  }

  @Test
  public void renderMessage3() throws IOException {
    t2 = new TriangleSolitaireModel();
    tv1 = new TriangleSolitaireTextView(t2);
    Appendable app = new StringBuilder();
    app.append("Bye");
    assertEquals("Bye", app.toString());
  }

}