package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.data.MeridiemEnum;
import cs3500.pa05.model.data.Time;

/**
 * The TimeJson record represents a JSON object that encapsulates the information of a time.
 */
public record TimeJson(@JsonProperty("hours") int hours,
                       @JsonProperty("minutes") int minutes,
                       @JsonProperty("meridiem") MeridiemEnum meridiem) {

  /**
   * Constructs a TimeJson object from the given Time object.
   *
   * @param time the Time object
   */
  public TimeJson(Time time) {
    this(time.getHour(), time.getMinutes(), time.getMeridiem());
  }

  /**
   * Converts the TimeJson object back to a Time object.
   *
   * @return the Time object
   */
  public Time toTime() {
    return new Time(this.hours, this.minutes, this.meridiem);
  }
}
