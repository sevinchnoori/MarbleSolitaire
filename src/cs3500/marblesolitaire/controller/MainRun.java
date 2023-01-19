package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Class that carries the core method of the program, main(String[] args)
 * which calls the view, model, controller, and the playGame()
 * method to run the marble solitaire game.
 */
public class MainRun {

  /**
   * The core method that runs the program/game using the model, view,
   * controller, and method, playGame().
   * @param args the input arguments
   * @throws IOException for methods within classes and method that call this exception
   */
  public static void main(String[] args) throws IOException {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView modelView = new MarbleSolitaireTextView(model, System.out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, modelView,
            new InputStreamReader(System.in));
    controller.playGame();
  }

}
