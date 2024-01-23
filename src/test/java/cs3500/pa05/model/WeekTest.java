package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.MeridiemEnum;
import cs3500.pa05.model.data.Task;
import cs3500.pa05.model.data.ThemeEnum;
import cs3500.pa05.model.data.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * test class for week
 */
public class WeekTest {
  private Week week;
  private Task task1;
  private Event event1;

  /**
   * creates new week before each test
   */
  @BeforeEach
  public void setUp() {
    this.week = new Week();
    this.task1 = new Task("Task 1", "Task 1 Description");
    this.event1 = new Event("Event 1", new Time(10, 10, MeridiemEnum.AM), 30, "description");
  }

  /**
   * tests add task
   */
  @Test
  public void testAddTask() {
    this.week.addTask(this.task1, DayEnum.MONDAY);
    assertTrue(this.week.getDay(DayEnum.MONDAY).getTasks().contains(this.task1));
  }

  /**
   * tests add event
   */
  @Test
  public void testAddEvent() {
    this.week.addEvent(this.event1, DayEnum.MONDAY);
    assertTrue(this.week.getDay(DayEnum.MONDAY).getEvents().contains(this.event1));
  }

  /**
   * tests remove task
   */
  @Test
  public void testRemoveTask() {
    this.week.addTask(this.task1, DayEnum.MONDAY);
    this.week.removeTask(this.task1, DayEnum.MONDAY);
    assertFalse(this.week.getDay(DayEnum.MONDAY).getTasks().contains(this.task1));
  }

  /**
   * tests remove event
   */
  @Test
  public void testRemoveEvent() {
    this.week.addEvent(this.event1, DayEnum.MONDAY);
    this.week.removeEvent(this.event1, DayEnum.MONDAY);
    assertFalse(this.week.getDay(DayEnum.MONDAY).getEvents().contains(this.event1));
  }

  /**
   * tests set and get notes
   */
  @Test
  public void testSetAndGetNotes() {
    this.week.setNotes("Some notes");
    assertEquals("Some notes", this.week.getNotes());
  }

  /**
   * tests reset week
   */
  @Test
  public void testResetWeek() {
    this.week.addTask(this.task1, DayEnum.MONDAY);
    this.week.addEvent(this.event1, DayEnum.MONDAY);
    this.week.setNotes("Some notes");

    this.week.resetWeek();

    assertEquals("", week.getNotes());
    assertTrue(this.week.getDay(DayEnum.MONDAY).getTasks().isEmpty());
    assertTrue(this.week.getDay(DayEnum.MONDAY).getEvents().isEmpty());
  }

  /**
   * tests max tasks
   */
  @Test
  public void testMaxTasks() {
    this.week.setMaxTasks(10);
    assertEquals(10, this.week.getMaxTasks());
  }

  /**
   * tests max events
   */
  @Test
  public void testMaxEvents() {
    this.week.setMaxEvents(10);
    assertEquals(10, this.week.getMaxEvents());
  }

  /**
   * tests theme setting
   */
  @Test
  public void testTheme() {
    this.week.setTheme(ThemeEnum.DARK);
    assertEquals(ThemeEnum.DARK, this.week.getTheme());
  }

}
