package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test for TaskData
 */
public class TaskDataTest {

  private Task task;
  private TaskData taskData;

  /**
   * sets up new task and new taskdata before each test
   */
  @BeforeEach
  public void setUp() {
    this.task = new Task("Test Task", "Test Description");
    this.taskData = new TaskData(this.task, DayEnum.MONDAY);
  }

  /**
   * tests getName
   */
  @Test
  public void testGetName() {
    assertEquals("Test Task", this.taskData.getName());
  }

  /**
   * tests getDay
   */
  @Test
  public void testGetDay() {
    assertEquals(DayEnum.MONDAY, this.taskData.getDay());
  }

  /**
   * tests getDescription
   */
  @Test
  public void testGetDescription() {
    assertEquals("Test Description", this.taskData.getDescription());
  }

  /**
   * tests getTask
   */
  @Test
  public void testGetTask() {
    assertEquals(this.task, this.taskData.getTask());
  }
}
