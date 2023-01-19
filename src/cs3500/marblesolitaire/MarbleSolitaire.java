package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Class holding the main method which is the center method of the program, allowing the
 * user to enter arguments to produce the beginning state of their preferred playing style.
 */
public final class MarbleSolitaire {


  /**
   * Produces the beginning state of the user's preferred playing style according to their
   * inputted arguments in the form of a String array.
   */
  public static void main(String[] args) {

    MarbleSolitaireModel model;
    MarbleSolitaireView view;
    MarbleSolitaireController controller;
    Readable in = new InputStreamReader(System.in);

    //defaults
    int size = 0;
    int holeRow = 0;
    int holeCol = 0;
    String shapeInput = "";

    // default english
    if (args[0].equals("english")) {
      shapeInput = "english";
      size = 3;
      holeRow = 3;
      holeCol = 3;
    }

    // default european
    else if (args[0].equals("european")) {
      shapeInput = "european";
      size = 3;
      holeRow = 3;
      holeCol = 3;
    }

    // default triangular
    else if (args[0].equals("triangular")) {
      shapeInput = "triangular";
      size = 5;
      holeRow = 0;
      holeCol = 0;
    }


    // parsing other arguments
    for (int num = 0; num < args.length; num = num + 1) {
      if (args[num].equals("-size")) {
        size = Integer.parseInt(args[num + 1]);
      }
      if (args[num].equals("-hole") || args[num].equals("--caps")) {
        holeRow = Integer.parseInt(args[num + 1]);
        holeCol = Integer.parseInt(args[num + 2]);
      }
    }

    switch (shapeInput) {
      case "english":
        if (args.length == 1) {
          model = new EnglishSolitaireModel();
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }
        else if (args.length == 3) {
          model = new EnglishSolitaireModel(size);
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }
        else if (args.length == 4) {
          model = new EnglishSolitaireModel(holeRow, holeCol);
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }

        else if (args.length == 6) {
          model = new EnglishSolitaireModel(size, holeRow, holeCol);
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }

        break;

      case "european":
        if (args.length == 1) {
          model = new EuropeanSolitaireModel();
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }
        else if (args.length == 3) {
          model = new EuropeanSolitaireModel(size);
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }
        else if (args.length == 4) {
          model = new EuropeanSolitaireModel(holeRow, holeCol);
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }

        else if (args.length == 6) {
          model = new EuropeanSolitaireModel(size, holeRow, holeCol);
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }

        break;

      case "triangular":
        if (args.length == 1) {
          model = new TriangleSolitaireModel();
          view = new TriangleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }
        else if (args.length == 3) {
          model = new TriangleSolitaireModel(size);
          view = new TriangleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }
        else if (args.length == 4) {
          model = new TriangleSolitaireModel(holeRow, holeCol);
          view = new TriangleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }

        else if (args.length == 6) {
          model = new TriangleSolitaireModel(size, holeRow, holeCol);
          view = new MarbleSolitaireTextView(model, System.out);
          controller = new MarbleSolitaireControllerImpl(model, view, in);
          controller.playGame();
        }
        break;

      default:
        // no action is needed
    }
  }


}