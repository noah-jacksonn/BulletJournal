package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.json.WeekJson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * The FileHandler class provides utility methods for reading from and writing to files.
 */
public class FileHandler {

  /**
   * Writes the specified content to a file at the given file path.
   *
   * @param filePath the path to the file to write
   * @param content  the content to write to the file
   * @throws IOException if an I/O error occurs
   */
  public void writeFile(String filePath, String content) throws IOException {
    File file = new File(filePath);
    if (file.exists()) {
      file.delete();
    }
    file.createNewFile();

    FileWriter writer = new FileWriter(file, true);
    BufferedWriter bufferedwriter = new BufferedWriter(writer);

    bufferedwriter.write(content);
    bufferedwriter.close();
  }

  /**
   * Reads the content from a file at the given file path.
   *
   * @param filePath the path to the file to read
   * @return the content of the file as a string
   * @throws IOException if an I/O error occurs
   */
  public String readFile(String filePath) throws IOException {
    File file = new File(filePath);
    String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    return content;
  }
}

