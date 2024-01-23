package cs3500.pa05.view;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.JournalModel;
import cs3500.pa05.model.data.EventData;
import cs3500.pa05.model.data.TaskData;
import cs3500.pa05.model.data.ThemeEnum;
import java.util.Collection;
import java.util.Optional;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * The interface for the JournalView, responsible for displaying the journal to the user and
 * handling user interactions.
 */
public interface JournalView {

  /**
   * Loads the journal view with the specified theme.
   *
   * @param themeEnum the theme to apply to the journal view
   * @return the loaded Scene object
   * @throws IllegalStateException if the journal view cannot be loaded
   */
  Scene load(ThemeEnum themeEnum) throws IllegalStateException;

  /**
   * Sets the controller for the journal view.
   *
   * @param journalController the journal controller
   */
  void setController(JournalController journalController);

  /**
   * Updates the event count label with the new count and applies the appropriate styling based on
   * the current theme.
   *
   * @param eventLabel the event count label
   * @param newCount the new event count
   * @param maxEvents the maximum number of events
   * @param theme the current theme
   */
  void updateEventCount(Label eventLabel, int newCount, int maxEvents, ThemeEnum theme);

  /**
   * Updates the task count label with the new count and applies the appropriate styling based on
   * the current theme.
   *
   * @param taskLabel the task count label
   * @param newCount the new task count
   * @param maxTasks the maximum number of tasks
   * @param theme the current theme
   */
  void updateTaskCount(Label taskLabel, int newCount, int maxTasks, ThemeEnum theme);

  /**
   * Prompts the user to edit a task and returns the user input as an optional task data object.
   *
   * @param taskData the task data to prepopulate the form with
   * @param themeFromModel the current theme from the model
   * @return an optional task data object representing the user input, or an empty optional if the
   *     user cancels the operation
   */
  Optional getEditTaskFromUser(TaskData taskData, ThemeEnum themeFromModel);

  /**
   * Updates the task and event label themes based on the current model and theme.
   *
   * @param taskLabels the collection of task labels
   * @param eventLabels the collection of event labels
   * @param model the journal model
   * @param theme the current theme
   */
  void updateTaskAndEventLabelTheme(Collection<Label> taskLabels, Collection<Label> eventLabels,
                                    JournalModel model, ThemeEnum theme);

  /**
   * Shows an alert with the specified alert type and message.
   *
   * @param alertType the alert type
   * @param message the alert message
   */
  void showAlert(Alert.AlertType alertType, String message);

  /**
   * Prompts the user to enter a new task and returns the user input as an optional task data
   * object.
   *
   * @param theme the current theme
   * @return an optional task data object representing the user input, or an empty optional if the
   *     user cancels the operation
   */
  Optional getTaskFromUser(ThemeEnum theme);

  /**
   * Prompts the user to display a task and returns the user selection as an optional task data
   * object.
   *
   * @param task the task data to display
   * @param currentTheme the current theme
   * @return an optional task data object representing the user selection, or an empty optional if
   *     the user cancels the operation
   */
  Optional getDisplayTaskFromUser(TaskData task, ThemeEnum currentTheme);

  /**
   * Prompts the user to edit an event and returns the user input as an optional event data object.
   *
   * @param data the event data to prepopulate the form with
   * @param currentTheme the current theme
   * @return an optional event data object representing the user input, or an empty optional if the
   *     user cancels the operation
   */
  Optional getEditEventFromUser(EventData data, ThemeEnum currentTheme);


  /**
   * Prompts the user to display an event and returns the user selection as an optional event data
   * object.
   *
   * @param event the event data to display
   * @param currentTheme the current theme
   * @return an optional event data object representing the user selection, or an empty optional if
   *     the user cancels the operation
   */
  Optional getDisplayEventFromUser(EventData event, ThemeEnum currentTheme);

  /**
   * Prompts the user to enter a maximum number of tasks and returns the user input as an optional
   * integer value.
   *
   * @param maxTasks the maximum number of tasks
   * @param theme the current theme
   * @return an optional integer representing the user input, or an empty optional if the user
   *     cancels the operation
   */
  Optional getMaxTasksFromUser(int maxTasks, ThemeEnum theme);

  /**
   * Prompts the user to enter a new event and returns the user input as an optional event data
   * object.
   *
   * @param theme the current theme
   * @return an optional event data object representing the user input, or an empty optional if the
   *     user cancels the operation
   */
  Optional getEventFromUser(ThemeEnum theme);

  /**
   * Prompts the user to enter a maximum number of events and returns the user input as an optional
   * integer value.
   *
   * @param maxEvents the maximum number of events
   * @param theme the current theme
   * @return an optional integer representing the user input, or an empty optional if the user
   *     cancels the operation
   */
  Optional getMaxEventsFromUser(int maxEvents, ThemeEnum theme);

  /**
   * Prompts the user to enter notes and returns the user input as an optional string.
   *
   * @param notes the notes to prepopulate the form with
   * @param theme the current theme
   * @return an optional string representing the user input, or an empty optional if the user
   *     cancels the operation
   */
  Optional getNotesFromUser(String notes, ThemeEnum theme);

  /**
   * Prompts the user to enter a password and returns the user input as an optional string.
   *
   * @return an optional string representing the user input, or an empty optional if the user
   *     cancels the operation
   */
  Optional promptUserForPassword();

  /**
   * Returns the current Scene object.
   *
   * @return the current Scene object
   */
  Scene getScene();
}
