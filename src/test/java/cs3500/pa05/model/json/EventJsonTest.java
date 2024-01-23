package cs3500.pa05.model.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.MeridiemEnum;
import cs3500.pa05.model.data.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test class for eventJson
 */
public class EventJsonTest {
  private Event event;
  private EventJson eventJson;

  /**
   * creates new event, new time, and new eventjson before each test
   */
  @BeforeEach
  public void setUp() {
    Time time = new Time(10, 30, MeridiemEnum.AM);
    event = new Event("Event Test", time, 60, "Event Description");
    eventJson = new EventJson(event);
  }

  /**
   * tests event to json
   */
  @Test
  public void testEventToJson() {
    assertEquals(new EventJson(event), eventJson);
  }

  /**
   * tests json to event
   */
  @Test
  public void testJsonToEvent() {
    assertTrue(eventJson.toEvent() instanceof Event);
  }
}
