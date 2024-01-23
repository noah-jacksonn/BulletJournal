package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.data.Task;

/**
 * The TaskJson record represents a JSON object that encapsulates the information of a task.
 */
public record TaskJson(
    @JsonProperty("name") String name,
    @JsonProperty("isComplete") boolean isComplete,
    @JsonProperty("description") String description) {

  /**
   * Constructs a TaskJson object from the given Task object.
   *
   * @param task the Task object
   */
  public TaskJson(Task task) {
    this(task.getName(), task.isComplete(), task.getDescription());
  }

  /**
   * Converts the TaskJson object back to a Task object.
   *
   * @return the Task object
   */
  public Task toTask() {
    return new Task(this.name, this.isComplete, this.description);
  }
}
