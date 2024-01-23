package cs3500.pa05.model;

import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.Task;
import cs3500.pa05.model.data.ThemeEnum;
import cs3500.pa05.model.json.DayJson;
import java.util.HashMap;
import java.util.Map;

/**
 * The Week class represents a week in the bullet journal.
 * It keeps track of the days and the tasks and events assigned to each day.
 */
public class Week {
  private ThemeEnum theme;
  private String notes;
  private int maxTasks;
  private int maxEvents;
  private DayEnum startingDay;
  private final Map<DayEnum, Day> days;
  private String password;

  /**
   * Constructs a new Week instance.
   * Initializes a new Day instance for each day of the week.
   */
  public Week() {
    this.theme = ThemeEnum.LIGHT;
    this.notes = "";
    this.maxTasks = 5;
    this.maxEvents = 5;
    this.startingDay = DayEnum.SUNDAY;
    this.days = new HashMap<>();
    for (DayEnum dayOfWeek : DayEnum.values()) {
      this.days.put(dayOfWeek, new Day());
    }
    this.password = null;
  }

  /**
   * Constructs a new Week instance with the specified parameters.
   *
   * @param theme       the theme of the week
   * @param notes       the notes of the week
   * @param maxTasks    the maximum number of tasks allowed per day
   * @param maxEvents   the maximum number of events allowed per day
   * @param startingDay the starting day of the week
   * @param days        the map of days and their corresponding tasks and events
   * @param password    the password for the week (null if no password)
   */
  public Week(ThemeEnum theme, String notes, int maxTasks, int maxEvents,
              DayEnum startingDay, Map<DayEnum, Day> days, String password) {
    this.theme = theme;
    this.notes = notes;
    this.maxTasks = maxTasks;
    this.maxEvents = maxEvents;
    this.startingDay = startingDay;
    this.days = days;
    this.password = password;
  }

  /**
   * Returns the password for the week.
   *
   * @return the password for the week
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * Sets the password for the week.
   *
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Resets the week by clearing all days and notes.
   */
  public void resetWeek() {
    for (Day day : this.days.values()) {
      day.resetDay();
    }
    this.notes = "";
  }

  /**
   * Removes an event from the given day of the week.
   *
   * @param event     the event to be removed
   * @param dayOfWeek the day of the week
   */
  public void removeEvent(Event event, DayEnum dayOfWeek) {
    this.days.get(dayOfWeek).removeEvent(event);
  }

  /**
   * Removes a task from the given day of the week.
   *
   * @param task      the task to be removed
   * @param dayOfWeek the day of the week
   */
  public void removeTask(Task task, DayEnum dayOfWeek) {
    this.days.get(dayOfWeek).removeTask(task);
  }

  /**
   * Returns the theme of the week.
   *
   * @return the theme of the week
   */
  public ThemeEnum getTheme() {
    return this.theme;
  }

  /**
   * Sets the theme of the week.
   *
   * @param theme the theme to set
   */
  public void setTheme(ThemeEnum theme) {
    this.theme = theme;
  }

  /**
   * Returns the notes of the week.
   *
   * @return the notes of the week
   */
  public String getNotes() {
    return this.notes;
  }

  /**
   * Sets the notes of the week.
   *
   * @param notes the notes to set
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }

  /**
   * Returns the maximum number of tasks allowed per day.
   *
   * @return the maximum number of tasks allowed per day
   */
  public int getMaxTasks() {
    return this.maxTasks;
  }

  /**
   * Sets the maximum number of tasks allowed per day.
   *
   * @param maxTasks the maximum number of tasks to set
   */
  public void setMaxTasks(int maxTasks) {
    this.maxTasks = maxTasks;
  }

  /**
   * Returns the maximum number of events allowed per day.
   *
   * @return the maximum number of events allowed per day
   */
  public int getMaxEvents() {
    return this.maxEvents;
  }

  /**
   * Sets the maximum number of events allowed per day.
   *
   * @param maxEvents the maximum number of events to set
   */
  public void setMaxEvents(int maxEvents) {
    this.maxEvents = maxEvents;
  }

  /**
   * Returns the starting day of the week.
   *
   * @return the starting day of the week
   */
  public DayEnum getStartingDay() {
    return this.startingDay;
  }

  /**
   * Returns the Day instance for the given day of the week.
   *
   * @param dayOfWeek the day of the week
   * @return the Day instance for the given day of the week
   */
  public Day getDay(DayEnum dayOfWeek) {
    return this.days.get(dayOfWeek);
  }

  /**
   * Adds a new task to the given day of the week.
   *
   * @param task      the task to be added
   * @param dayOfWeek the day of the week
   */
  public void addTask(Task task, DayEnum dayOfWeek) {
    this.getDay(dayOfWeek).addTask(task);
  }

  /**
   * Adds a new event to the given day of the week.
   *
   * @param event     the event to be added
   * @param dayOfWeek the day of the week
   */
  public void addEvent(Event event, DayEnum dayOfWeek) {
    this.getDay(dayOfWeek).addEvent(event);
  }

  /**
   * Returns a map of DayEnum and DayJson for all days in the week.
   *
   * @return a map of DayEnum and DayJson for all days in the week
   */
  public Map<DayEnum, DayJson> getDaysJson() {
    Map<DayEnum, DayJson> daysJson = new HashMap<>();
    for (Map.Entry<DayEnum, Day> entry : this.days.entrySet()) {
      DayEnum key = entry.getKey();
      Day value = entry.getValue();
      daysJson.put(key, new DayJson(value));
    }
    return daysJson;
  }
}
