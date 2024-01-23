package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test class for Event
 */
class EventTest {
  private Event event;

  /**
   * sets up even and time before each test
   */
  @BeforeEach
  public void setUp() {
    Time startTime = new Time(9, 0, MeridiemEnum.AM);
    this.event = new Event("Meeting", startTime, 60, "Team meeting");
  }

  /**
   * tests getName
   */
  @Test
  public void testGetName() {
    assertEquals("Meeting", this.event.getName());
  }

  /**
   * tests getDescription
   */
  @Test
  public void testGetDescription() {
    assertEquals("Team meeting", this.event.getDescription());
  }

  /**
   * tests getStartTime
   */
  @Test
  public void testGetStartTime() {
    assertEquals(9, this.event.getStartTime().getHour());
    assertEquals(0, this.event.getStartTime().getMinutes());
    assertEquals(MeridiemEnum.AM, this.event.getStartTime().getMeridiem());
  }

  /**
   * tests getDuration
   */
  @Test
  public void testGetDuration() {
    assertEquals(60, this.event.getDuration());
  }

  /**
   * tests toString
   */
  @Test
  public void testToString() {
    String expected = "Meeting: Team meeting Starts at: 9:00 AM Duration: 60 minutes";
    assertEquals(expected, this.event.toString());
  }

  /**
   * tests toString for one minute duration
   */
  @Test
  public void testToStringForOneMinuteDuration() {
    Time startTime = new Time(9, 0, MeridiemEnum.AM);
    Event oneMinuteEvent = new Event("test", startTime, 1, "test");
    String expected = "test: test Starts at: 9:00 AM Duration: 1 minute";
    assertEquals(expected, oneMinuteEvent.toString());
  }

}
