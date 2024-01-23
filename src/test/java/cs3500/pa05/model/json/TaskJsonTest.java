package cs3500.pa05.model.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.data.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * tests for TaskJson
 */
public class TaskJsonTest {

  private Task task;
  private TaskJson taskJson;

  /**
   * setup new task and taskjson before each test
   */
  @BeforeEach
  void setUp() {
    task = new Task("Test Task", false, "Task Description");
    taskJson = new TaskJson(task);
  }

  /**
   * tests for JsonToTask
   */
  @Test
  void testJsonToTask() {
    Task fromJson = taskJson.toTask();
    assertEquals(task.getName(), fromJson.getName());
    assertEquals(task.getDescription(), fromJson.getDescription());
    assertEquals(task.isComplete(), fromJson.isComplete());
  }

  /**
   * tests for TaskToJson
   */
  @Test
  void testTaskToJson() {
    TaskJson fromTask = new TaskJson(task);
    assertEquals(task.getName(), fromTask.name());
    assertEquals(task.getDescription(), fromTask.description());
    assertEquals(task.isComplete(), fromTask.isComplete());
  }
}
