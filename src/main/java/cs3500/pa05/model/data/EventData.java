package cs3500.pa05.model.data;

/**
 * The EventData class represents a combination of an Event and a DayEnum, providing access to
 * information about the event and the day it belongs to.
 */
public class EventData {

  private final Event event;
  private final DayEnum day;

  /**
   * Constructs an EventData object with the specified event and day.
   *
   * @param event the event
   * @param day   the day the event belongs to
   */
  public EventData(Event event, DayEnum day) {
    this.event = event;
    this.day = day;
  }

  /**
   * Returns the name of the event.
   *
   * @return the name of the event
   */
  public String getName() {
    return this.event.getName();
  }

  /**
   * Returns the description of the event.
   *
   * @return the description of the event
   */
  public String getDescription() {
    return this.event.getDescription();
  }

  /**
   * Returns the start time of the event.
   *
   * @return the start time of the event
   */
  public Time getStartTime() {
    return this.event.getStartTime();
  }

  /**
   * Returns the duration of the event.
   *
   * @return the duration of the event
   */
  public int getDuration() {
    return this.event.getDuration();
  }

  /**
   * Returns the day the event belongs to.
   *
   * @return the day the event belongs to
   */
  public DayEnum getDay() {
    return this.day;
  }

  /**
   * Returns the event.
   *
   * @return the event
   */
  public Event getEvent() {
    return this.event;
  }
}
