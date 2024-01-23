package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * test class for EventData class
 */
public class EventDataTest {

  Event testEvent = new Event("Test Event", new Time(10, 10, MeridiemEnum.AM), 60, "test");
  EventData eventData = new EventData(this.testEvent, DayEnum.MONDAY);

  /**
   * tests getName
   */
  @Test
  public void testGetName() {
    assertEquals("Test Event", this.eventData.getName());
  }

  /**
   * tests getDescription
   */
  @Test
  public void testGetDescription() {
    assertEquals("test", this.eventData.getDescription());
  }

  /**
   * tests getStartTime
   */
  @Test
  public void testGetStartTime() {
    assertEquals(10, this.eventData.getStartTime().getHour());
    assertEquals(10, this.eventData.getStartTime().getMinutes());
    assertEquals(MeridiemEnum.AM, this.eventData.getStartTime().getMeridiem());
  }

  /**
   * tests getDuration
   */
  @Test
  public void testGetDuration() {
    assertEquals(60, this.eventData.getDuration());
  }

  /**
   * tests getDay
   */
  @Test
  public void testGetDay() {
    assertEquals(DayEnum.MONDAY, this.eventData.getDay());
  }

  /**
   * tests getEvent
   */
  @Test
  public void testGetEvent() {
    assertEquals(this.testEvent, this.eventData.getEvent());
  }
}
