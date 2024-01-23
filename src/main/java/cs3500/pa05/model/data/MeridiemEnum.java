package cs3500.pa05.model.data;

/**
 * The MeridiemEnum enum represents the meridiem (AM/PM) values.
 */
public enum MeridiemEnum {

  /**
   * AM enum
   */
  AM("AM"),

  /**
   * PM enum
   */
  PM("PM");

  private final String meridiemString;

  /**
   * Constructs a MeridiemEnum with the specified meridiem string.
   *
   * @param meridiemString the string representation of the meridiem
   */
  MeridiemEnum(String meridiemString) {
    this.meridiemString = meridiemString;
  }

  /**
   * Returns the string representation of the meridiem.
   *
   * @return the string representation of the meridiem
   */
  public String toString() {
    return this.meridiemString;
  }
}
