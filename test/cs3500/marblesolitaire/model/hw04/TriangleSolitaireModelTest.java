package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;

/**
 * Class to represent examples and tests for the EnglishSolitaireModel class.
 */
public class TriangleSolitaireModelTest {

  TriangleSolitaireModel t1;
  TriangleSolitaireModel t2;
  TriangleSolitaireModel t3;


  @Test
  public void testValidInitialization() {
    t1 = new TriangleSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(1,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(1,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(1,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(2,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(3,4));


    t2 = new TriangleSolitaireModel(6, 3, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(4,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(3,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(4,0));

    t2 = new TriangleSolitaireModel(3);
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(1,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(1,0));

    t2 = new TriangleSolitaireModel(3, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(3,0));

  }

  // dimension is 0
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons1() {
    t1 = new TriangleSolitaireModel(0);
  }

  // invalid position
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons2() {
    t1 = new TriangleSolitaireModel(0, 3);
  }

  // invalid position
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons3() {
    t1 = new TriangleSolitaireModel(1, 3);
  }

  // invalid position
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons4() {
    t1 = new TriangleSolitaireModel(2, 3);
  }

  // invalid position
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons5() {
    t1 = new TriangleSolitaireModel(3, 4);
  }

  // invalid position
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons6() {
    t1 = new TriangleSolitaireModel(3,4);
  }

  // neg dimension
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons7() {
    t1 = new TriangleSolitaireModel(-4, 3,1);
  }

  // neg dimension
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons8() {
    t1 = new TriangleSolitaireModel(0, 3, 1);
  }

  // invalid empty
  @Test(expected = IllegalArgumentException.class)
  public void invalidCons9() {
    t1 = new TriangleSolitaireModel(5, 3, 4);
  }

  // move directly up
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove10() {
    t1 = new TriangleSolitaireModel();
    t1.move(2,1,0,0);
  }

  // move directly down
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove11() {
    t1 = new TriangleSolitaireModel();
    t1.move(0,0,2,1);
  }

  // beyond position
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove12() {
    t1 = new TriangleSolitaireModel();
    t1.move(22, 0, 0, 0);
  }

  // beyond position
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove13() {
    t1 = new TriangleSolitaireModel();
    t1.move(2, 20, 0, 0);
  }

  // beyond position
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove14() {
    t1 = new TriangleSolitaireModel();
    t1.move(2, 0, 20, 0);
  }

  // beyond position
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove15() {
    t1 = new TriangleSolitaireModel();
    t1.move(2, 0, 0, 20);
  }

  // from position is empty
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove16() {
    t1 = new TriangleSolitaireModel();
    t1.move(0,0,2,0);
  }

  // from position is invalid
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove17() {
    t1 = new TriangleSolitaireModel();
    t1.move(0,4,2,0);
  }

  // to position is invalid
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove18() {
    t1 = new TriangleSolitaireModel();
    t1.move(1,1,1,3);
  }

  // to position is marble
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove19() {
    t1 = new TriangleSolitaireModel();
    t1.move(3,1,1,1);
  }

  // more than 2 positions away HORIZ - left to right
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove20() {
    t1 = new TriangleSolitaireModel();
    t1.move(4,0,4,3);
  }

  // more than 2 positions away HORIZ - right to left
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove21() {
    t1 = new TriangleSolitaireModel();
    t1.move(4,3,4,0);
  }

  // more than 2 positions away diag / dow to up
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove22() {
    t1 = new TriangleSolitaireModel();
    t1.move(4,1,1,1);
  }

  // more than 2 positions away diag / up to down
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove122() {
    t1 = new TriangleSolitaireModel();
    t1.move(1,1,1,4);
  }

  // more than 2 positions away diag \
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove23() {
    t1 = new TriangleSolitaireModel();
    t1.move(4,3,1,0);
  }

  // more than 2 positions away diag \
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove123() {
    t1 = new TriangleSolitaireModel();
    t1.move(1,0,4,3);
  }

  // empty in between diag /
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove24() {
    t1 = new TriangleSolitaireModel();
    t1.move(2,0,0,0);
    t1.move(0,0,2,0);
  }

  // empty in between diag \
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove25() {
    t1 = new TriangleSolitaireModel();
    t1.move(2,2,0,0);
    t1.move(0,0,2,2);
  }

  // empty in between HORIZ
  @Test(expected = IllegalArgumentException.class)
  public void invalidMove26() {
    t1 = new TriangleSolitaireModel(2,1);
    t1.move(2,0,2,2);
  }


  @Test
  public void testMoveGameOverGetScore() {
    t1 = new TriangleSolitaireModel();
    assertEquals(false, this.t1.isGameOver());
    assertEquals(14, this.t1.getScore());
    this.t1.move(2,0,0,0);
    assertEquals(13, this.t1.getScore());
    assertEquals(false, this.t1.isGameOver());
    this.t1.move(2,2,2,0);
    assertEquals(12, this.t1.getScore());
    assertEquals(false, this.t1.isGameOver());
    this.t1.move(0,0,2,2);
    assertEquals(11, this.t1.getScore());
    assertEquals(false, this.t1.isGameOver());
    this.t1.move(4,1,2,1);
    assertEquals(10, this.t1.getScore());
    assertEquals(false, this.t1.isGameOver());
    this.t1.move(3,2,1,0);
    assertEquals(9, this.t1.getScore());
    assertEquals(false, this.t1.isGameOver());
    this.t1.move(2,0,0,0);
    assertEquals(8, this.t1.getScore());
    assertEquals(false, this.t1.isGameOver());
    this.t1.move(3,3,1,1);
    assertEquals(7, this.t1.getScore());
    assertEquals(false, this.t1.isGameOver());
    this.t1.move(0,0,2,2);
    assertEquals(false, this.t1.isGameOver());
    assertEquals(6, this.t1.getScore());
    this.t1.move(4,0,2,0);
    assertEquals(5, this.t1.getScore());
    assertEquals(false, this.t1.isGameOver());
    this.t1.move(4,3,4,1);
    assertEquals(4, this.t1.getScore());
    assertEquals(true, this.t1.isGameOver());
  }

  @Test
  public void moveDiagLeftDown() {
    t1 = new TriangleSolitaireModel();
    t1.move(2,0,0,0);
    t1.move(3,2,1,0);
    t1.move(0,0,2,0);
    assertEquals(false, this.t1.isGameOver());
  }

  @Test
  public void getBoardSize() {
    t1 = new TriangleSolitaireModel();
    assertEquals(5, t1.getBoardSize());
    t2 = new TriangleSolitaireModel(2);
    assertEquals(2, t2.getBoardSize());
    t3 = new TriangleSolitaireModel(3, 2, 0);
    assertEquals(3, t3.getBoardSize());
    t3 = new TriangleSolitaireModel(7, 1,0);
    assertEquals(7, t3.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    t1 = new TriangleSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(1,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(1,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(1,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(2,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(3,4));


    t2 = new TriangleSolitaireModel(6, 3, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(4,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t2.getSlotAt(3,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(4,0));


  }

}