package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.ThemeEnum;
import java.util.HashMap;
import java.util.Map;

/**
 * The WeekJson record represents a JSON object that encapsulates the information of a week.
 */
public record WeekJson(
    @JsonProperty("theme") ThemeEnum theme,
    @JsonProperty("notes") String notes,
    @JsonProperty("maxTasks") int maxTasks,
    @JsonProperty("maxEvents") int maxEvents,
    @JsonProperty("startingDay") DayEnum startingDay,
    @JsonProperty("dayDetails") Map<DayEnum, DayJson> days,
    @JsonProperty("password") String password) {

  /**
   * Constructs a WeekJson object from the given Week object.
   *
   * @param week the Week object
   */
  public WeekJson(Week week) {
    this(week.getTheme(), week.getNotes(), week.getMaxTasks(),
        week.getMaxEvents(), week.getStartingDay(), week.getDaysJson(), week.getPassword());
  }

  /**
   * Converts the WeekJson object back to a Week object.
   *
   * @return the Week object
   */
  public Week toWeek() {
    Map<DayEnum, Day> dayMap = new HashMap<>();
    for (Map.Entry<DayEnum, DayJson> entry : this.days.entrySet()) {
      DayEnum key = entry.getKey();
      Day value = entry.getValue().toDay();
      dayMap.put(key, value);
    }
    return new Week(this.theme, this.notes, this.maxTasks,
        this.maxEvents, this.startingDay, dayMap, this.password);
  }

  /**
   * Returns the password for the week.
   *
   * @return the password
   */
  public String getPassword() {
    return this.password;
  }
}
