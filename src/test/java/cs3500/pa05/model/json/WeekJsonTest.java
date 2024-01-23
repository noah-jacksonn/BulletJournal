package cs3500.pa05.model.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.ThemeEnum;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * tests weekJson class
 */
public class WeekJsonTest {

  private Week week;
  private WeekJson weekJson;

  /**
   * sets up new week and week json before each test
   */
  @BeforeEach
  void setUp() {
    Map<DayEnum, Day> dayMap = new HashMap<>();
    dayMap.put(DayEnum.MONDAY, new Day());

    week = new Week(ThemeEnum.LIGHT, "Some notes", 5, 5, DayEnum.MONDAY, dayMap, "password");
    weekJson = new WeekJson(this.week);
  }

  /**
   * tests json to week
   */
  @Test
  void testJsonToWeek() {
    Week fromJson = this.weekJson.toWeek();
    assertEquals(this.week.getTheme(), fromJson.getTheme());
    assertEquals(this.week.getNotes(), fromJson.getNotes());
    assertEquals(this.week.getMaxTasks(), fromJson.getMaxTasks());
    assertEquals(this.week.getMaxEvents(), fromJson.getMaxEvents());
    assertEquals(this.week.getStartingDay(), fromJson.getStartingDay());
    assertEquals(this.week.getPassword(), fromJson.getPassword());

  }

  /**
   * tests week to json
   */
  @Test
  void testWeekToJson() {
    WeekJson fromWeek = new WeekJson(this.week);
    assertEquals(this.week.getTheme(), fromWeek.theme());
    assertEquals(this.week.getNotes(), fromWeek.notes());
    assertEquals(this.week.getMaxTasks(), fromWeek.maxTasks());
    assertEquals(this.week.getMaxEvents(), fromWeek.maxEvents());
    assertEquals(this.week.getStartingDay(), fromWeek.startingDay());
    assertEquals(this.week.getPassword(), fromWeek.getPassword());

  }
}
