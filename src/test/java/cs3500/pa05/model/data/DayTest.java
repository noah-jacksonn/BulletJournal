package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.TaskJson;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for Day class
 */
public class DayTest {


  private Day day;
  private Event testEvent;
  private Task testTask;

  /**
   * creates a new day, event, and task before each test
   */
  @BeforeEach
  public void setUp() {
    this.day = new Day();
    this.testEvent = new Event("test", new Time(10, 10, MeridiemEnum.AM), 20, "test");
    this.testTask = new Task("hello", "test");
  }

  /**
   * tests add event
   */
  @Test
  public void testAddEvent() {
    this.day.addEvent(this.testEvent);
    assertTrue(this.day.getEvents().contains(this.testEvent));
  }

  /**
   * tests remove event
   */
  @Test
  public void testRemoveEvent() {
    this.day.addEvent(this.testEvent);
    this.day.removeEvent(this.testEvent);
    assertFalse(this.day.getEvents().contains(this.testEvent));
  }

  /**
   * tests getNumEvents
   */
  @Test
  public void testGetNumEvents() {
    assertEquals(0, this.day.getNumEvents());
    this.day.addEvent(this.testEvent);
    assertEquals(1, this.day.getNumEvents());
  }

  /**
   * tests getEventsJson
   */
  @Test
  public void testGetEventsJson() {
    this.day.addEvent(this.testEvent);
    List<EventJson> eventJsons = this.day.getEventsJson();
    assertTrue(eventJsons.get(0) instanceof EventJson);
  }

  /**
   * tests addTask
   */
  @Test
  public void testAddTask() {
    this.day.addTask(this.testTask);
    assertTrue(this.day.getTasks().contains(this.testTask));
  }

  /**
   * tests removeTask
   */
  @Test
  public void testRemoveTask() {
    this.day.addTask(this.testTask);
    this.day.removeTask(this.testTask);
    assertFalse(this.day.getTasks().contains(this.testTask));
  }

  /**
   * tests getNumTasks
   */
  @Test
  public void testGetNumTasks() {
    assertEquals(0, this.day.getNumTasks());
    this.day.addTask(this.testTask);
    assertEquals(1, this.day.getNumTasks());
  }

  /**
   * tests getTasksJson
   */
  @Test
  public void testGetTasksJson() {
    this.day.addTask(this.testTask);
    List<TaskJson> taskJsons = this.day.getTasksJson();
    assertTrue(taskJsons.get(0) instanceof TaskJson);
  }

  /**
   * tests resetDay
   */
  @Test
  public void testResetDay() {
    this.day.addEvent(this.testEvent);
    this.day.addTask(this.testTask);
    this.day.resetDay();
    assertEquals(0, this.day.getNumEvents());
    assertEquals(0, this.day.getNumTasks());
  }
}
