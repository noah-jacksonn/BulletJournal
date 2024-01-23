package cs3500.pa05.model.data;

import javafx.scene.control.Button;

/**
 * The Task class represents a task with a name, completion status, and description.
 */
public class Task {

  private String name;
  private boolean isComplete;
  private String description;

  /**
   * Constructs a Task with the specified name and description. The task is initially marked as
   * incomplete.
   *
   * @param name        the name of the task
   * @param description the description of the task
   */
  public Task(String name, String description) {
    this.name = name;
    this.isComplete = false;
    this.description = description;
  }

  /**
   * Constructs a Task with the specified name, completion status, and description.
   *
   * @param name        the name of the task
   * @param isComplete  the completion status of the task
   * @param description the description of the task
   */
  public Task(String name, boolean isComplete, String description) {
    this.name = name;
    this.isComplete = isComplete;
    this.description = description;
  }

  /**
   * Returns the name of the task.
   *
   * @return the name of the task
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the task.
   *
   * @param name the name of the task
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the description of the task.
   *
   * @return the description of the task
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the task.
   *
   * @param description the description of the task
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns the completion status of the task.
   *
   * @return true if the task is complete, false otherwise
   */
  public boolean isComplete() {
    return this.isComplete;
  }

  /**
   * Sets the completion status of the task.
   *
   * @param complete true if the task is complete, false otherwise
   */
  public void setComplete(boolean complete) {
    this.isComplete = complete;
  }

  /**
   * Returns the string representation of the task.
   *
   * @return the string representation of the task
   */
  @Override
  public String toString() {
    return this.getName() + ": " + this.getDescription();
  }

  /**
   * Converts the task to a Button component.
   *
   * @return the Button representing the task
   */
  public Button toButton() {
    Button button = new Button();
    button.setText(this.toString());
    button.setWrapText(true);
    button.setPrefWidth(160);
    return button;
  }
}
