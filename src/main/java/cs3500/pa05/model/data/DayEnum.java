package cs3500.pa05.model.data;

/**
 * The DayEnum enum represents the days of the week.
 */
public enum DayEnum {

  /**
   * Sunday enum
   */
  SUNDAY("Sunday"),

  /**
   * monday enum
   */
  MONDAY("Monday"),

  /**
   * tuesday enum
   */
  TUESDAY("Tuesday"),

  /**
   * wednesday enum
   */
  WEDNESDAY("Wednesday"),

  /**
   * Thursday enum
   */
  THURSDAY("Thursday"),

  /**
   * Friday enum
   */
  FRIDAY("Friday"),

  /**
   * Saturday enum
   */
  SATURDAY("Saturday");

  private final String dayString;

  /**
   * Constructs a DayEnum with the specified day string.
   *
   * @param dayString the string representation of the day
   */
  DayEnum(String dayString) {
    this.dayString = dayString;
  }

  /**
   * Returns the string representation of the day.
   *
   * @return the string representation of the day
   */
  public String toString() {
    return this.dayString;
  }

}
