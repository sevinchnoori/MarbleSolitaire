package cs3500.marblesolitaire.controller;

/**
 * Represents the controller of the game.
 * Offers a method, playGame() that is void and renders the game feature
 * of the model, EnglishSolitaireModel
 */
public interface MarbleSolitaireController {

  /**
   * Represents the controller of the game.
   //   * @return a new game of Marble Solitaire to play
   * @throws IllegalArgumentException when the controller is unable to
   *         successfully read input or transmit output
   */
  void playGame() throws IllegalStateException;
}
