package cs3500.pa05.model;

import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.Task;


/**
 * The JournalModel interface represents a journal.
 */
public interface JournalModel {

  /**
   * Adds an event to the journal for the specified day of the week.
   *
   * @param event      the event to add
   * @param dayOfWeek  the day of the week to add the event to
   */
  void addEvent(Event event, DayEnum dayOfWeek);

  /**
   * Adds a task to the journal for the specified day of the week.
   *
   * @param task       the task to add
   * @param dayOfWeek  the day of the week to add the task to
   */
  void addTask(Task task, DayEnum dayOfWeek);

  /**
   * Returns the week of the journal.
   *
   * @return the week of the journal
   */
  Week getWeek();

  /**
   * Returns the day of the specified day of the week.
   *
   * @param dayOfWeek  the day of the week
   * @return the day object
   */
  Day getDay(DayEnum dayOfWeek);

  /**
   * Sets the week of the journal.
   *
   * @param week  the week to set
   */
  void setWeek(Week week);

  /**
   * Sets the notes data of the journal.
   *
   * @param notesData  the notes data to set
   */
  void setNotes(String notesData);
}
