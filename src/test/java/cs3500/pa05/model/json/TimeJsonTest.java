package cs3500.pa05.model.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.data.MeridiemEnum;
import cs3500.pa05.model.data.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test class for timjson
 */
public class TimeJsonTest {

  private Time time;
  private TimeJson timeJson;

  /**
   * sets up new time and timejson before each test
   */
  @BeforeEach
  void setUp() {
    time = new Time(12, 30, MeridiemEnum.PM);
    timeJson = new TimeJson(time);
  }

  /**
   * tests json to time
   */
  @Test
  void testJsonToTime() {
    Time fromJson = timeJson.toTime();
    assertEquals(time.getHour(), fromJson.getHour());
    assertEquals(time.getMinutes(), fromJson.getMinutes());
    assertEquals(time.getMeridiem(), fromJson.getMeridiem());
  }

  /**
   * tests time to json
   */
  @Test
  void testTimeToJson() {
    TimeJson fromTime = new TimeJson(time);
    assertEquals(time.getHour(), fromTime.hours());
    assertEquals(time.getMinutes(), fromTime.minutes());
    assertEquals(time.getMeridiem(), fromTime.meridiem());
  }
}
