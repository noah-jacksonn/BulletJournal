package cs3500.pa05.model.data;

import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.TaskJson;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a day within a journal
 */
public class Day {

  private final List<Event> events;
  private final List<Task> tasks;

  /**
   * Constructs an empty Day.
   */
  public Day() {
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  /**
   * Constructs a Day with the given lists of events and tasks.
   *
   * @param events the list of events for the day
   * @param tasks the list of tasks for the day
   */
  public Day(List<Event> events, List<Task> tasks) {
    this.events = events;
    this.tasks = tasks;
  }

  /**
   * Removes the specified event from the day.
   *
   * @param event the event to remove
   */
  public void removeEvent(Event event) {
    this.events.remove(event);
  }

  /**
   * Removes the specified task from the day.
   *
   * @param task the task to remove
   */
  public void removeTask(Task task) {
    this.tasks.remove(task);
  }

  /**
   * Resets the day by clearing all tasks and events.
   */
  public void resetDay() {
    this.tasks.clear();
    this.events.clear();
  }

  /**
   * Adds the specified event to the day.
   *
   * @param event the event to add
   */
  public void addEvent(Event event) {
    this.events.add(event);
  }

  /**
   * Returns a deep copy of the list of events for the day.
   *
   * @return a deep copy of the list of events
   */
  public List<Event> getEvents() {
    return new ArrayList<>(this.events);
  }

  /**
   * Returns the number of events in the day.
   *
   * @return the number of events
   */
  public int getNumEvents() {
    return this.events.size();
  }

  /**
   * Returns a list of EventJson objects representing the events in the day.
   *
   * @return a list of EventJson objects
   */
  public List<EventJson> getEventsJson() {
    List<EventJson> events = new ArrayList<>();
    for (Event event : this.events) {
      events.add(new EventJson(event));
    }
    return events;
  }

  /**
   * Adds the specified task to the day.
   *
   * @param task the task to add
   */
  public void addTask(Task task) {
    this.tasks.add(task);
  }

  /**
   * Returns a deep copy of the list of tasks for the day.
   *
   * @return a deep copy of the list of tasks
   */
  public List<Task> getTasks() {
    return new ArrayList<>(this.tasks);
  }

  /**
   * Returns a list of TaskJson objects representing the tasks in the day.
   *
   * @return a list of TaskJson objects
   */
  public List<TaskJson> getTasksJson() {
    List<TaskJson> tasks = new ArrayList<>();
    for (Task task : this.tasks) {
      tasks.add(new TaskJson(task));
    }
    return tasks;
  }

  /**
   * Returns the number of tasks in the day.
   *
   * @return the number of tasks
   */
  public int getNumTasks() {
    return this.tasks.size();
  }
}
