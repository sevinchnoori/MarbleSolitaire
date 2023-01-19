package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Class that represents the controller of the english solitaire model, using the
 * playGame() method which handle cases for quitting, moving the marbles, and when
 * the game is over based on the inputs of the user, all while displaying the board.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable inputReader; // in

  /**
   * Constructs a default controller of the game given the model,
   * view, and input reader.
   *
   * @param model       model of the board
   * @param view        view of the board (output sent to user is transmitted here
   *                    and then will transmit it to whichever Appendable object was
   *                    used to set it up)
   * @param inputReader input reader of the board (receives input from user)
   * @throws IllegalArgumentException if any of the fields are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable inputReader)
          throws IllegalArgumentException {
    if (model == null || view == null || inputReader == null) {
      throw new IllegalArgumentException("The model, view, nor the input reader can be null");
    }

    this.model = model;
    this.view = view;
    this.inputReader = inputReader;
  }


  @Override
  public void playGame() throws IllegalStateException {
    try {

      Scanner scan = new Scanner(inputReader);
      boolean quit = false;

      addBoardAddScore();

      // 5. while the game is not over ...
      while (!model.isGameOver()) {

        // leave outer loops if user has quitted
        if (quit) {
          break;
        }

        // empties arraylist of inputs
        List<Integer> inputNums = new ArrayList<Integer>();

        // 3. while there is inputs ...
        while (inputNums.size() < 4 && !quit) {

          // scan for next input
          String input = scan.next();

          // checks if user quit and breaks if so
          if (input.equals("q") || input.equals("Q")) {
            quit = true;
            break;
          }

          // checks for neg number and for invalid chars and adds integers to ArrList
          try {
            int parseInt = Integer.parseInt(input);
            checkNeg(parseInt);
            inputNums.add(parseInt);
          } catch (IllegalArgumentException e) {
            view.renderMessage("Please re-enter value again.\n");
          }
        } // break out of inner while loop

        // checks if the size of the ArrList is 4
        if (inputNums.size() == 4) {
          try {
            // 4. parse inputs and pass onto the model to make a move
            this.model.move(inputNums.get(0) - 1,
                    inputNums.get(1) - 1,
                    inputNums.get(2) - 1,
                    inputNums.get(3) - 1);
            addBoardAddScore();
            inputNums = new ArrayList<Integer>();
          } catch (IllegalArgumentException e) {
            view.renderMessage("Invalid move. Play again.\n");
          }
        }

        // if the game is over
        if (model.isGameOver()) {
          view.renderMessage("Game over!\n");
          addBoardAddScore();
        }


        // Quitting:
        if (quit) {
          view.renderMessage("Game quit!\n");
          view.renderMessage("State of game when quit:\n");
          addBoardAddScore();
        }


      } // outter close
    }
    catch (IOException | NoSuchElementException e) {
      throw new IllegalStateException("Some transmission has failed");
    }
  } // end of method

  /**
   * Helper method which checks to see if the number is negative.
   * @param num the number
   * @return the number if it is not negative
   * @throws IllegalArgumentException if the number is negative
   */
  private int checkNeg(int num) throws IllegalArgumentException {
    if (num < 0) {
      throw new IllegalArgumentException("Must be positive number");
    }

    return num;
  }

  /**
   * Helper method for the controller that renders the board and the current score of the game.
   * @throws IOException when renderBoard() or renderMessage() throws an IOException due to
   *         failing transmission
   */
  private void addBoardAddScore() throws IOException {
    view.renderBoard();
    view.renderMessage("\nScore: " + this.model.getScore() + "\n");
  }

}
