package cs3500.pa05.controller;

import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.MeridiemEnum;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * The InputValidator class to validate input for time, day, and name.
 */
public class InputValidator {

  /**
   * Validates the time input in the given HBox.
   *
   * @param hbox the HBox containing the time input components
   * @return true if the time input is valid, false otherwise
   */
  public static boolean validateTime(HBox hbox) {
    try {
      Spinner hour = (Spinner) hbox.getChildren().get(1);
      Spinner minute = (Spinner) hbox.getChildren().get(3);
      ComboBox meridiem = (ComboBox) hbox.getChildren().get(5);

      int timeHour = (int) hour.getValue();
      int timeMinute = (int) minute.getValue();
      MeridiemEnum timeMeridiem = (MeridiemEnum) meridiem.getValue();
      if (timeMeridiem == null) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Validates the day input in the given ComboBox.
   *
   * @param box the ComboBox containing the day input
   * @return true if the day input is valid, false otherwise
   */
  public static boolean validateDay(ComboBox box) {
    try {
      if (box.getValue() == null) {
        return false;
      }
      DayEnum day = (DayEnum) box.getValue();
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Validates the name input in the given TextField.
   *
   * @param box the TextField containing the name input
   * @return true if the name input is valid, false otherwise
   */
  public static boolean validateName(TextField box) {
    try {
      if (box.getText() == null) {
        return false;
      } else if (box.getText().trim().length() == 0) {
        return false;
      }
      String name =  box.getText();
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
