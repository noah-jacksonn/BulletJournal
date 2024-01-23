package cs3500.pa05.model.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.MeridiemEnum;
import cs3500.pa05.model.data.Task;
import cs3500.pa05.model.data.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


/**
 * test class for DayJson
 */
public class DayJsonTest {

  /**
   * tests dayJson toDay method
   */
  @Test
  public void testToDay() {
    Time testTime = new Time(10, 10, MeridiemEnum.AM);
    Time testTime2 = new Time(5, 15, MeridiemEnum.PM);

    TaskJson taskJson1 = new TaskJson(new Task("hello", "world"));
    TaskJson taskJson2 = new TaskJson(new Task("test name", "test description"));
    EventJson eventJson1 = new EventJson(new Event("test", testTime, 10, "description"));
    EventJson eventJson2 = new EventJson(new Event("test2", testTime2, 15, "description2"));

    List<TaskJson> tasksJson = new ArrayList<>(Arrays.asList(taskJson1, taskJson2));
    List<EventJson> eventsJson = new ArrayList<>(Arrays.asList(eventJson1, eventJson2));

    DayJson dayJson = new DayJson(tasksJson, eventsJson);
    Day day = dayJson.toDay();

    assertEquals(tasksJson.size(), day.getTasks().size());
    assertEquals(eventsJson.size(), day.getEvents().size());

    for (int i = 0; i < tasksJson.size(); i++) {
      assertFalse(day.getTasks().contains(tasksJson.get(i).toTask()));
    }
    for (int i = 0; i < eventsJson.size(); i++) {
      assertFalse(day.getEvents().contains(eventsJson.get(i).toEvent()));
    }
  }
}
