package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




/**
 * Test class for FileHandler
 */
public class FileHandlerTest {

  private FileHandler fileHandler;

  /**
   * sets up new filehandler before each test
   */
  @BeforeEach
  public void setUp() {
    this.fileHandler = new FileHandler();
  }

  /**
   * tests write and read file
   *
   * @throws IOException throws ioexception
   */
  @Test
  public void testWriteAndReadFile() throws IOException {
    String filePath = "sample.txt";
    String content = "Sample content of file";

    this.fileHandler.writeFile(filePath, content);

    File file = new File(filePath);
    assertTrue(file.exists());

    String fileContent = this.fileHandler.readFile(filePath);
    assertEquals(content, fileContent);
  }

  /**
   * tests write and read for exceptions invalid path
   */
  @Test
  public void testWriteFileThrowsIoExceptionWhenPathInvalid() {
    assertThrows(IOException.class, () -> this.fileHandler.writeFile("", "content"));
  }

  /**
   * tests write and read for exceptions file not found
   */
  @Test
  public void testReadFileThrowsIoExceptionWhenFileNotFound() {
    assertThrows(IOException.class, () -> this.fileHandler.readFile("invalidPath.txt"));
  }

  /**
   * cleans test file after every test
   */
  @AfterEach
  public void cleanTests() {
    File file = new File("sample.txt");
    if (file.exists()) {
      file.delete();
    }
  }

  /**
   * tests overwriting an existing file
   *
   * @throws IOException throws io exception
   */
  @Test
  public void testOverwriteExistingFile() throws IOException {
    String filePath = "src/test/resources/overwritesample.txt";
    String content1 = "Original content of file";

    this.fileHandler.writeFile(filePath, content1);
    File file = new File(filePath);
    assertTrue(file.exists());
    String fileContent1 = this.fileHandler.readFile(filePath);
    assertEquals(content1, fileContent1);

    String content2 = "Overwritten content of file";

    this.fileHandler.writeFile(filePath, content2);
    assertTrue(file.exists());
    String fileContent2 = this.fileHandler.readFile(filePath);
    assertEquals(content2, fileContent2);
  }

}
