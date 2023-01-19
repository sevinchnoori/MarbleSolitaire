package cs3500.marblesolitaire.view;

import java.io.IOException;

/**
 * Corrupt class used for testing the IOExceptions of the renderBoard() and
 * renderMessage(String message) methods.
 */
public class CorruptClass implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Transmission failed.");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Transmission failed.");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Transmission failed.");

  }
}
