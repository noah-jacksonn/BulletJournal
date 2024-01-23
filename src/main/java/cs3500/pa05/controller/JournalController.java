package cs3500.pa05.controller;

import cs3500.pa05.model.json.WeekJson;
import java.io.IOException;

/**
 * Represents a controller for a journal.
 */
public interface JournalController {

  /**
   * Runs the journal controller.
   */
  void run();

  /**
   * Initializes the journal.
   */
  void initialize();

  /**
   * Saves the journal to a file at the specified file path.
   *
   * @param filePath the path of the file to save the journal to
   * @throws IOException if an I/O error occurs while saving the file
   */
  void saveToFile(String filePath) throws IOException;

  /**
   * Opens a journal file from the specified file path and loads its contents.
   *
   * @param filePath the path of the file to open
   * @param weekJson the WeekJson object used for deserialization
   * @throws IOException if an I/O error occurs while opening the file
   */
  void openFile(String filePath, WeekJson weekJson) throws IOException;

}
