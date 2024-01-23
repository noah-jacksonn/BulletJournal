package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * The DayJson class represents a JSON object that encapsulates the tasks and events of a day.
 */
public record DayJson(
    @JsonProperty("tasks") List<TaskJson> tasks,
    @JsonProperty("events") List<EventJson> events) {


  /**
   * Constructs a DayJson object from the given Day object.
   *
   * @param day the Day object
   */
  public DayJson(Day day) {
    this(day.getTasksJson(), day.getEventsJson());
  }

  /**
   * Converts the DayJson object back to a Day object.
   *
   * @return the Day object
   */
  public Day toDay() {
    List<Event> events = new ArrayList<>();
    for (EventJson event : this.events) {
      events.add(event.toEvent());
    }
    List<Task> tasks = new ArrayList<>();
    for (TaskJson task : this.tasks) {
      tasks.add(task.toTask());
    }
    return new Day(events, tasks);
  }
}
