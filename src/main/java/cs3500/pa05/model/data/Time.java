package cs3500.pa05.model.data;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;

/**
 * The Time class represents a time with hour, minutes, and meridiem (AM/PM).
 */
public class Time {

  private int hour;
  private int minutes;
  private MeridiemEnum meridiem;

  /**
   * Constructs a Time object with the specified hour, minutes, and meridiem.
   *
   * @param hour     the hour value of the time
   * @param minutes  the minutes value of the time
   * @param meridiem the meridiem (AM/PM) of the time
   */
  public Time(int hour, int minutes, MeridiemEnum meridiem) {
    this.hour = hour;
    this.minutes = minutes;
    this.meridiem = meridiem;
  }

  /**
   * Returns the hour value of the time.
   *
   * @return the hour value
   */
  public int getHour() {
    return this.hour;
  }

  /**
   * Returns the minutes value of the time.
   *
   * @return the minutes value
   */
  public int getMinutes() {
    return this.minutes;
  }

  /**
   * Returns the meridiem (AM/PM) of the time.
   *
   * @return the meridiem of the time
   */
  public MeridiemEnum getMeridiem() {
    return this.meridiem;
  }

  /**
   * Returns the string representation of the time in "hh:mm AM/PM" format.
   *
   * @return the string representation of the time
   */
  @Override
  public String toString() {
    String formattedMinutes =
        (this.minutes < 10) ? "0" + this.minutes : String.valueOf(this.minutes);
    return this.hour + ":" + formattedMinutes + " " + this.meridiem.toString();
  }
}
