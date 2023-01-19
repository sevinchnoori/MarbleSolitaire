package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;

/**
 * Class to represent examples and tests for the EuropeanSolitaireModel class.
 */
public class EuropeanSolitaireModelTest {

  EuropeanSolitaireModel euro1;
  EuropeanSolitaireModel euro2;
  EuropeanSolitaireModel euro3;


  @Test
  public void validInitialization() {
    euro1 = new EuropeanSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(0, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(0, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(1, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, euro1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(5, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(5, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(6, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(6, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(6, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(6, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(6, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(6, 6));

    euro2 = new EuropeanSolitaireModel(5);
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro2.getSlotAt(11, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro2.getSlotAt(12, 12));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro2.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro2.getSlotAt(1,1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro2.getSlotAt(4,7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro2.getSlotAt(8,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro2.getSlotAt(11,7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro2.getSlotAt(7,6));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, euro2.getSlotAt(6,6));

    euro2 = new EuropeanSolitaireModel(7, 11, 7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, euro2.getSlotAt(11,7));

    euro2 = new EuropeanSolitaireModel(3,3,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, euro2.getSlotAt(3,2));


  }

  // if even sidelength
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons1() {
    euro1 = new EuropeanSolitaireModel(2);
  }

  // if 0 sidelength
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons2() {
    euro1 = new EuropeanSolitaireModel(0);
  }

  // if neg sidelength
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons3() {
    euro1 = new EuropeanSolitaireModel(-9);
  }

  // invalid empty - top left
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons4() {
    euro1 = new EuropeanSolitaireModel(0,0);
  }

  // invalid empty - top right
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons5() {
    euro1 = new EuropeanSolitaireModel(0, 6);
  }

  // invalid empty - bottom left
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons6() {
    euro1 = new EuropeanSolitaireModel(6,0);
  }

  // invalid empty - bottom right
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons7() {
    euro1 = new EuropeanSolitaireModel(6,6);
  }

  // invalid empty - neg
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons8() {
    euro1 = new EuropeanSolitaireModel(-5,3);
  }

  // invalid empty - neg
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons9() {
    euro1 = new EuropeanSolitaireModel(3,10);
  }

  // invalid empty - beyond
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons10() {
    euro1 = new EuropeanSolitaireModel(14,3);
  }

  // invalid empty - beyond
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons11() {
    euro1 = new EuropeanSolitaireModel(3,-8);
  }

  // even side length
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons12() {
    euro3 = new EuropeanSolitaireModel(2,0,0);
  }

  // zero side length
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons13() {
    euro3 = new EuropeanSolitaireModel(0,0,0);
  }

  // neg side length
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons14() {
    euro3 = new EuropeanSolitaireModel(-5,0,0);
  }

  // invalid empty
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons15() {
    euro3 = new EuropeanSolitaireModel(5,0,0);
  }

  // invalid empty - neg
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons16() {
    euro3 = new EuropeanSolitaireModel(5,-1,3);
  }

  // invalid empty - neg
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons17() {
    euro3 = new EuropeanSolitaireModel(5,3,-3);
  }

  // invalid empty - beyond
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons18() {
    euro3 = new EuropeanSolitaireModel(5,3,13);
  }

  // invalid empty - beyond
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons19() {
    euro3 = new EuropeanSolitaireModel(5,13,3);
  }

  // rows and cols are not equal
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove1() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,5,2,2);
  }

  // diagonal move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove2() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(5, 3, 3, 5);
  }

  // neg move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove3() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(-5, 3, 3, 3);
  }

  // neg move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove4() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(5, -3, 3, 3);
  }

  // neg move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove5() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(5, 3, -3, 3);
  }

  // neg move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove6() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(5, 3, 3, -3);
  }

  // beyond move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove7() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(15, 3, 3, 3);
  }

  // beyond move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove8() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(5, 13, 3, 3);
  }

  // beyond move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove9() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(5, 3, 13, 3);
  }

  // beyond move
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove10() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(5, 3, 3, 13);
  }

  // from position is empty
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove11() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3, 3, 5, 3);
  }

  // from position is invalid
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove12() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(1,1,1,3);
  }

  // to position is invalid
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove13() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(1,4,1,6);
  }

  // to position is marble
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove14() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,2,3,4);
  }

  // to and from more than 2 positions away HORIZ
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove15() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,2, 3, 6);
  }

  // to and from more than 2 positions away HORIZ left to right
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove16() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,2, 3, 6);
  }

  // to and from more than 2 positions away HORIZ right to left
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove17() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,6, 3, 2);
  }

  // to and from more than 2 positions away VERT up to down
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove18() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,3, 6, 3);
  }

  // to and from more than 2 positions away VERT down to up
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove19() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,6, 3, 3);
  }

  // no marble in between HORIZ left to right
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove20() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,2,3,4);
  }

  // no marble in between HORIZ right to left
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove21() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(3,4,3,2);
  }

  // no marble in between VERT up to down
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove22() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(2,3,4,3);
  }

  // no marble in between VERT down to up
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove23() {
    euro1 = new EuropeanSolitaireModel();
    euro1.move(4,3,2,3);
  }

  @Test
  public void moveGameOverGetScoreTest() {
    euro1 = new EuropeanSolitaireModel();
    assertEquals(36, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(3,1,3,3);
    assertEquals(35, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(3,4,3,2);
    assertEquals(34, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(5,4,3,4);
    assertEquals(33, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(3,5,3,3);
    assertEquals(32, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(3,3,3,1);
    assertEquals(31, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(3,0,3,2);
    assertEquals(30, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(5,5,3,5);
    assertEquals(29, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(2,5,4,5);
    assertEquals(28, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(4,6,4,4);
    assertEquals(27, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(4,3,4,5);
    assertEquals(26, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(1,1,3,1);
    assertEquals(25, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(4,1,2,1);
    assertEquals(24, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(2,6,4,6);
    assertEquals(23, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(4,6,4,4);
    assertEquals(22, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(6,3,4,3);
    assertEquals(21, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(1,3,3,3);
    assertEquals(20, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(3,3,5,3);
    assertEquals(19, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(5,2,5,4);
    assertEquals(18, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(2,1,2,3);
    assertEquals(17, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(2,3,2,5);
    assertEquals(16, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(1,5,3,5);
    assertEquals(15, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(0,4,2,4);
    assertEquals(14, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(0,2,2,2);
    assertEquals(13, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(3,2,1,2);
    assertEquals(12, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(5,4,3,4);
    assertEquals(11, euro1.getScore());
    assertEquals(false, this.euro1.isGameOver());
    this.euro1.move(3,5,3,3);
    assertEquals(10, euro1.getScore());
    assertEquals(true, this.euro1.isGameOver());

  }



  @Test
  public void getBoardSize() {
    euro1 = new EuropeanSolitaireModel();
    assertEquals(7, euro1.getBoardSize());
    euro2 = new EuropeanSolitaireModel(4,5);
    assertEquals(7, euro2.getBoardSize());
    euro3 = new EuropeanSolitaireModel(5);
    assertEquals(13, euro3.getBoardSize());
    euro3 = new EuropeanSolitaireModel(5,3,3);
    assertEquals(13, euro3.getBoardSize());
    euro3 = new EuropeanSolitaireModel(7,4, 4);
    assertEquals(19, euro3.getBoardSize());
    euro3 = new EuropeanSolitaireModel(7);
    assertEquals(19, euro3.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    euro1 = new EuropeanSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(0, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(0, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(1, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(2, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, euro1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(3, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(4, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(5, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(5, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(6, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(6, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(6, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(6, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro1.getSlotAt(6, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro1.getSlotAt(6, 6));

    euro2 = new EuropeanSolitaireModel(5);
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro2.getSlotAt(11, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro2.getSlotAt(12, 12));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro2.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, euro2.getSlotAt(1,1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro2.getSlotAt(4,7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro2.getSlotAt(8,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro2.getSlotAt(11,7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, euro2.getSlotAt(7,6));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, euro2.getSlotAt(6,6));

    euro2 = new EuropeanSolitaireModel(7, 11, 7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, euro2.getSlotAt(11,7));


  }

}