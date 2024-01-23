package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.MeridiemEnum;
import cs3500.pa05.model.data.Task;
import cs3500.pa05.model.data.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test class for journalModel
 */
public class JournalModelImplTest {
  JournalModelImpl journalModel;
  Event event;
  Task task;
  Week week;

  /**
   * sets up a new journal model before each test
   */
  @BeforeEach
  public void setup() {
    journalModel = new JournalModelImpl();
    Time startTime = new Time(9, 0, MeridiemEnum.AM);
    event = new Event("Meeting", startTime, 60, "Team meeting");
    task = new Task("test", "hello");
    week = new Week();
  }

  /**
   * tests add event
   */
  @Test
  public void testAddEvent() {
    this.journalModel.addEvent(this.event, DayEnum.MONDAY);
    Day day = this.journalModel.getDay(DayEnum.MONDAY);
    assertTrue(day.getEvents().contains(this.event));
  }

  /**
   * tests add task
   */
  @Test
  public void testAddTask() {
    this.journalModel.addTask(task, DayEnum.MONDAY);
    Day day = this.journalModel.getDay(DayEnum.MONDAY);
    assertTrue(day.getTasks().contains(this.task));
  }

  /**
   * tests set week
   */
  @Test
  public void testSetWeek() {
    this.journalModel.setWeek(this.week);
    assertEquals(this.week, this.journalModel.getWeek());
  }

  /**
   * tests set notes
   */
  @Test
  public void testSetNotes() {
    this.journalModel.setNotes("Test Note");
    assertEquals("Test Note", this.journalModel.getWeek().getNotes());
  }
}
