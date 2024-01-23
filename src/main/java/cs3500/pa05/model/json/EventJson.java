package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.data.Event;

/**
 * The EventJson record represents a JSON object that encapsulates the information of an event.
 */
public record EventJson(
    @JsonProperty("name") String name,
    @JsonProperty("startTime") TimeJson startTime,
    @JsonProperty("duration") int duration,
    @JsonProperty("description") String description) {


  /**
   * Constructs an EventJson object from the given Event object.
   *
   * @param event the Event object
   */
  public EventJson(Event event) {
    this(event.getName(), event.getStartTimeJson(), event.getDuration(), event.getDescription());
  }

  /**
   * Converts the EventJson object back to an Event object.
   *
   * @return the Event object
   */
  public Event toEvent() {
    return new Event(this.name, this.startTime.toTime(), this.duration, this.description);
  }
}
