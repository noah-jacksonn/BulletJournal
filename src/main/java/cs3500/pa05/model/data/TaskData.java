package cs3500.pa05.model.data;

/**
 * The TaskData class represents a combination of a Task and a DayEnum, providing access to
 * information about the task and the day it belongs to.
 */
public class TaskData {

  private final Task task;
  private final DayEnum day;

  /**
   * Constructs a TaskData object with the specified task and day.
   *
   * @param task the task
   * @param day  the day the task belongs to
   */
  public TaskData(Task task, DayEnum day) {
    this.task = task;
    this.day = day;
  }

  /**
   * Returns the name of the task.
   *
   * @return the name of the task
   */
  public String getName() {
    return this.task.getName();
  }

  /**
   * Returns the day the task belongs to.
   *
   * @return the day the task belongs to
   */
  public DayEnum getDay() {
    return this.day;
  }

  /**
   * Returns the description of the task.
   *
   * @return the description of the task
   */
  public String getDescription() {
    return this.task.getDescription();
  }

  /**
   * Returns the task.
   *
   * @return the task
   */
  public Task getTask() {
    return this.task;
  }
}
