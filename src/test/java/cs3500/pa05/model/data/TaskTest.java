package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * tests for Task class
 */
public class TaskTest {

  /**
   * task creation and getter tests
   */
  @Test
  public void testTaskCreationAndGetters() {
    Task task = new Task("Test", "This is a test task");
    assertEquals("Test", task.getName());
    assertEquals("This is a test task", task.getDescription());
    assertFalse(task.isComplete());

    Task task2 = new Task("Test2", true, "This is a second test task");
    assertEquals("Test2", task2.getName());
    assertEquals("This is a second test task", task2.getDescription());
    assertTrue(task2.isComplete());
  }

  /**
   * tests for task setters
   */
  @Test
  public void testSetters() {
    Task task = new Task("Test", "This is a test task");
    task.setName("NewTest");
    task.setDescription("This is a new test task");
    task.setComplete(true);

    assertEquals("NewTest", task.getName());
    assertEquals("This is a new test task", task.getDescription());
    assertTrue(task.isComplete());
  }

  /**
   * tests for toString
   */
  @Test
  public void testToString() {
    Task task = new Task("Test", "This is a test task");
    assertEquals("Test: This is a test task", task.toString());
  }


}
