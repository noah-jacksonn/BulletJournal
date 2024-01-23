package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * tests for Time class
 */
public class TimeTest {

  /**
   * tests for time constructor and getter
   */
  @Test
  public void testConstructorAndGetters() {
    Time time = new Time(10, 45, MeridiemEnum.AM);
    assertEquals(10, time.getHour());
    assertEquals(45, time.getMinutes());
    assertEquals(MeridiemEnum.AM, time.getMeridiem());
  }

  /**
   * test for toString with less than 10 minutes
   */
  @Test
  public void testToStringWithLessThan10Minutes() {
    Time time = new Time(8, 9, MeridiemEnum.PM);
    assertEquals("8:09 PM", time.toString());
  }

  /**
   * test for toString with more than 10 minutes
   */
  @Test
  public void testToStringWithMoreThan10Minutes() {
    Time time = new Time(8, 15, MeridiemEnum.PM);
    assertEquals("8:15 PM", time.toString());
  }

  /**
   * test for toString with AM
   */
  @Test
  public void testToStringWithAmMeridiem() {
    Time time = new Time(8, 9, MeridiemEnum.AM);
    assertEquals("8:09 AM", time.toString());
  }

  /**
   * test for toString with PM
   */
  @Test
  public void testToStringWithPmMeridiem() {
    Time time = new Time(8, 9, MeridiemEnum.PM);
    assertEquals("8:09 PM", time.toString());
  }
}
