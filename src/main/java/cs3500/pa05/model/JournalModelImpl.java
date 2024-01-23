package cs3500.pa05.model;

import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.Task;

/**
 * Implementation of the JournalModel interface.
 * It keeps track of a week with its corresponding days and their tasks and events.
 */
public class JournalModelImpl implements JournalModel {
  private Week week;

  /**
   * Constructs a new JournalModelImpl instance.
   * Initializes a new Week instance.
   */
  public JournalModelImpl() {
    this.week = new Week();
  }

  /**
   * Creates an event and adds it to the respective day in the week.
   *
   * @param event      the event to be added
   * @param dayOfWeek  the day of the week for the event
   */
  @Override
  public void addEvent(Event event, DayEnum dayOfWeek) {
    this.week.addEvent(event, dayOfWeek);
  }


  /**
   * Creates a task and adds it to the respective day in the week.
   *
   * @param task       the task to be added
   * @param dayOfWeek  the day of the week for the task
   */
  @Override
  public void addTask(Task task, DayEnum dayOfWeek) {
    this.week.addTask(task, dayOfWeek);
  }

  /**
   * Sets the week of the journal.
   *
   * @param week  the week to set
   */
  public void setWeek(Week week) {
    this.week = week;
  }

  /**
   * Returns the week of the journal.
   *
   * @return the week of the journal
   */
  public Week getWeek() {
    return this.week;
  }

  /**
   * Returns the Day instance for the given day of the week.
   *
   * @param dayOfWeek  the day of the week
   * @return the Day instance for the given day of the week
   */
  @Override
  public Day getDay(DayEnum dayOfWeek) {
    return this.week.getDay(dayOfWeek);
  }

  /**
   * Sets the notes data of the journal.
   *
   * @param notesData  the notes data to set
   */
  @Override
  public void setNotes(String notesData) {
    this.week.setNotes(notesData);
  }
}
