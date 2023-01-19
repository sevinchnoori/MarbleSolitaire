package cs3500.marblesolitaire.model.hw02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class to represent examples and tests for the EnglishSolitareModel class.
 */
public final class EnglishSolitaireModelTest {

  EnglishSolitaireModel m1;
  EnglishSolitaireModel m2;
  EnglishSolitaireModel m3;
  EnglishSolitaireModel m4;
  EnglishSolitaireModel m5;
  EnglishSolitaireModel m2B;



  @Test
  public void testValidInitialization() {
    this.m1 = new EnglishSolitaireModel();
    //this.m1.makeGame(); //check entire game
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(0, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(1, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(5, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(5, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(6, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(6, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(6, 4));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(3, 3));
    // top left
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(1, 1));
    // top right
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(0, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(1, 6));
    // bottom left
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(5, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(6, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(6, 1));
    // bottom right
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(5, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(6, 6));

    this.m2 = new EnglishSolitaireModel(4, 4);
    //this.m2.makeGame();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m2.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m2.getSlotAt(0, 0));


    this.m3 = new EnglishSolitaireModel(5);
    //this.m3.makeGame();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m3.getSlotAt(5, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m3.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m3.getSlotAt(0, 0));

    this.m4 = new EnglishSolitaireModel(3, 2, 1);
    //this.m4.makeGame();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m4.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m4.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m4.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m4.getSlotAt(0, 0));

  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC3Pt1() {
    this.m1 = new EnglishSolitaireModel(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC3Pt2() {
    this.m1 = new EnglishSolitaireModel(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt1() {
    this.m1 = new EnglishSolitaireModel(2, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt2() {
    this.m1 = new EnglishSolitaireModel(0,3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt3() {
    this.m1 = new EnglishSolitaireModel(2, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt4() {
    this.m1 = new EnglishSolitaireModel(-5, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt5() {
    this.m1 = new EnglishSolitaireModel(3, -1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt6() {
    this.m1 = new EnglishSolitaireModel(3, 10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt8() {
    this.m1 = new EnglishSolitaireModel(3, 3, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt9() {
    this.m1 = new EnglishSolitaireModel(3, 3, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrownC4Pt15() {
    this.m1 = new EnglishSolitaireModel(3, 0, 0);
  }



  @Before
  public void init() {
    m1 = new EnglishSolitaireModel();
    m2 = new EnglishSolitaireModel(3, 2);
    m2B = new EnglishSolitaireModel(3, 3);
    m3 = new EnglishSolitaireModel(5);
    m4 = new EnglishSolitaireModel(3, 3, 3);

  }

  @Test
  public void move() {
    this.m2.move(5,2,3,2);// tests move for given empty slot
    assertEquals(31, this.m2.getScore());
  }

  @Test
  public void move1() {
    this.m2.move(3,0,3,2);// right move custom
    assertEquals(31, this.m2.getScore());
  }

  @Test
  public void move2() {
    this.m2.move(3,0,3,2);// left move custom
    assertEquals(31, this.m2.getScore());
  }

  @Test
  public void move3() {
    this.m2.move(3,4,3,2);// right move custom
    assertEquals(31, this.m2.getScore());
  }

  @Test
  public void move4() {
    this.m2.move(5,2,3,2);// up move custom
    assertEquals(31, this.m2.getScore());
  }

  @Test
  public void move5() {
    this.m2.move(1,2,3,2);// down move custom
    assertEquals(31, this.m2.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void move6() {
    this.m1.move(0,5,0,3);// move from invalid default
  }

  @Test(expected = IllegalArgumentException.class)
  public void move7() {
    this.m1.move(0,4,0,6);// move to invalid default
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() { // marble present at to location right to left
    this.m1.move(3,4,3,2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() { // marble present at to location left to right
    this.m1.move(3,2,3,4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() { // no marble at from position
    this.m1.move(3,1,3,3);
    this.m1.move(3,1,3,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove4() { // to position has a marble
    this.m1.move(2,3,4,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove5() { // to position is invalid
    this.m1.move(0,3,0,5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove6() { // to and from position > 2 slots H
    this.m1.move(3,1,3,3);
    this.m1.move(3,4,3,1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove7() { // to and from pos > 2 slots V
    this.m1.move(5,3,3,3);
    this.m1.move(2,3,5,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove8() { // move across empty position
    this.m1.move(3,5,3,3);
    this.m1.move(3,6,3,4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove9() { // move from empty position
    this.m1.move(3,3,3,1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove10() { // move to invalid position
    this.m1.move(0,3,0,5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove11() {
    this.m1.move(-1,0,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove12() {
    this.m1.move(0,-1,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove13() {
    this.m1.move(0,0,-1,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove14() {
    this.m1.move(0,0,0,-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove15() {
    this.m1.move(10,0,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove16() {
    this.m1.move(0,10,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove17() {
    this.m1.move(0,0,10,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove18() {
    this.m1.move(0,0,0,10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlot() {
    this.m1.getSlotAt(-1,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlot1() {
    this.m1.getSlotAt(0,-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlot2() {
    this.m1.getSlotAt(10,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlot3() {
    this.m1.getSlotAt(0,10)

    ;
  }

  @org.junit.Test
  public void isGameOver1() {
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(3,5,3,3);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(3,2,3,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(5,3,3,3);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(2,3,4,3);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(1,2,3,2);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(4,2,2,2);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(2,5,2,3);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(1,3,3,3);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(3,3,5,3);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(6,3,4,3);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(4,4,2,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(1,4,3,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(2,1,2,3);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(3,0,3,2);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(4,0,4,2);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(4,2,2,2);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(2,2,2,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(3,4,1,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(0,4,2,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(0,2,0,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(4,6,4,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(4,4,4,2);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(2,6,4,6);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(6,4,4,4);
    assertEquals(false, this.m1.isGameOver());
    this.m1.move(5,2,3,2);
    assertEquals(true, this.m1.isGameOver());

  }

  @org.junit.Test
  public void getBoardSize() {
    assertEquals(7, m1.getBoardSize());
    assertEquals(7, m2.getBoardSize());
    assertEquals(13, m3.getBoardSize());
    assertEquals(7, m4.getBoardSize());
    this.m5 = new EnglishSolitaireModel(7);
    assertEquals(19, m5.getBoardSize());
  }

  @org.junit.Test
  public void getScore() {
    assertEquals(32, this.m1.getScore());
    this.m1.move(3,5,3,3);
    assertEquals(31, this.m1.getScore());
    this.m1.move(3,2,3,4);
    assertEquals(30, this.m1.getScore());
    this.m1.move(5,3,3,3);
    assertEquals(29, this.m1.getScore());
    this.m1.move(2,3,4,3);
    assertEquals(28, this.m1.getScore());
    this.m1.move(1,2,3,2);
    assertEquals(27, this.m1.getScore());
    this.m1.move(4,2,2,2);
    assertEquals(26, this.m1.getScore());
    this.m1.move(2,5,2,3);
    assertEquals(25, this.m1.getScore());
    this.m1.move(1,3,3,3);
    assertEquals(24, this.m1.getScore());
    this.m1.move(3,3,5,3);
    assertEquals(23, this.m1.getScore());
    this.m1.move(6,3,4,3);
    assertEquals(22, this.m1.getScore());
    this.m1.move(4,4,2,4);
    assertEquals(21, this.m1.getScore());
    this.m1.move(1,4,3,4);
    assertEquals(20, this.m1.getScore());
    this.m1.move(2,1,2,3);
    assertEquals(19, this.m1.getScore());
    this.m1.move(3,0,3,2);
    assertEquals(18, this.m1.getScore());
    this.m1.move(4,0,4,2);
    assertEquals(17, this.m1.getScore());
    this.m1.move(4,2,2,2);
    assertEquals(16, this.m1.getScore());
    this.m1.move(2,2,2,4);
    assertEquals(15, this.m1.getScore());
    this.m1.move(3,4,1,4);
    assertEquals(14, this.m1.getScore());
    this.m1.move(0,4,2,4);
    assertEquals(13, this.m1.getScore());
    this.m1.move(0,2,0,4);
    assertEquals(12, this.m1.getScore());
    this.m1.move(4,6,4,4);
    assertEquals(11, this.m1.getScore());
    this.m1.move(4,4,4,2);
    assertEquals(10, this.m1.getScore());
    this.m1.move(2,6,4,6);
    assertEquals(9, this.m1.getScore());
    this.m1.move(6,4,4,4);
    assertEquals(8, this.m1.getScore());
    this.m1.move(5,2,3,2);
    assertEquals(7, this.m1.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove23() { // to position is invalid
    this.m1.move(0,3,4,5);
  }
}