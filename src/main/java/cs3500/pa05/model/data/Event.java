package cs3500.pa05.model.data;

import cs3500.pa05.model.json.TimeJson;
import javafx.scene.control.Button;

/**
 * The Event class represents an event with a name, start time, duration, and description.
 */
public class Event {

  private String name;
  private Time startTime;
  private int duration;
  private String description;

  /**
   * Constructs an Event with the specified name, start time, duration, and description.
   *
   * @param name        the name of the event
   * @param startTime   the start time of the event
   * @param duration    the duration of the event
   * @param description the description of the event
   */
  public Event(String name, Time startTime, int duration, String description) {
    this.name = name;
    this.startTime = startTime;
    this.duration = duration;
    this.description = description;
  }

  /**
   * Returns the name of the event.
   *
   * @return the name of the event
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the description of the event.
   *
   * @return the description of the event
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the start time of the event.
   *
   * @return the start time of the event
   */
  public Time getStartTime() {
    return startTime;
  }

  /**
   * Returns the duration of the event.
   *
   * @return the duration of the event
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Returns the JSON representation of the start time.
   *
   * @return the JSON representation of the start time
   */
  public TimeJson getStartTimeJson() {
    return new TimeJson(this.startTime);
  }

  /**
   * Returns the string representation of the event.
   *
   * @return the string representation of the event
   */
  @Override
  public String toString() {
    String formattedDurationMinutes = (this.getDuration() == 1) ? "minute" : "minutes";
    return this.getName() + ": " + this.getDescription()
        + " Starts at: " + this.getStartTime().toString()
        + " Duration: " + this.getDuration() + " " + formattedDurationMinutes;
  }

  /**
   * Converts the event to a Button component.
   *
   * @return the Button representing the event
   */
  public Button toButton() {
    Button button = new Button(this.toString());
    button.setText(this.toString());
    button.setWrapText(true);
    button.setPrefWidth(160);
    return button;
  }
}
