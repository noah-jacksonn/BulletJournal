package cs3500.pa05.view;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.JournalModel;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.EventData;
import cs3500.pa05.model.data.TaskData;
import cs3500.pa05.model.data.ThemeEnum;
import cs3500.pa05.view.dialogs.DialogCreator;
import cs3500.pa05.view.dialogs.DisplayEventDialog;
import cs3500.pa05.view.dialogs.DisplayTaskDialog;
import cs3500.pa05.view.dialogs.EditNotesDialog;
import cs3500.pa05.view.dialogs.EventDialog;
import cs3500.pa05.view.dialogs.MaxEventsDialog;
import cs3500.pa05.view.dialogs.MaxTasksDialog;
import cs3500.pa05.view.dialogs.PasswordDialog;
import cs3500.pa05.view.dialogs.TaskDialog;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;


/**
 * Implementation of the JournalView interface that provides a graphical user interface for
 * interacting with a journal.
 */
public class JournalViewImpl implements JournalView {
  FXMLLoader loader;
  DialogCreator taskDialogCreator;
  DialogCreator maxTasksDialogCreator;
  DialogCreator displayTaskDialogCreator;
  DialogCreator eventDialogCreator;
  DialogCreator displayEventDialogCreator;

  DialogCreator maxEventsDialogCreator;
  DialogCreator editNotesDialogCreator;
  DialogCreator passwordDialogCreator;

  private Scene scene;
  private Parent rootNode;
  private JournalModel journalModel;

  /**
   * Constructs a JournalViewImpl object with the given JournalModel.
   *
   * @param journalModel the journal model to be associated with the view
   */
  public JournalViewImpl(JournalModel journalModel) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getResource("/bulletJournal.fxml"));
    this.taskDialogCreator = new TaskDialog();
    this.taskDialogCreator.setData(null);
    this.maxTasksDialogCreator = new MaxTasksDialog();
    this.maxTasksDialogCreator.setData(null);
    this.displayTaskDialogCreator = new DisplayTaskDialog();
    this.displayTaskDialogCreator.setData(null);
    this.eventDialogCreator = new EventDialog();
    this.eventDialogCreator.setData(null);
    this.maxEventsDialogCreator = new MaxEventsDialog();
    this.maxEventsDialogCreator.setData(null);
    this.displayEventDialogCreator = new DisplayEventDialog();
    this.displayEventDialogCreator.setData(null);
    this.editNotesDialogCreator = new EditNotesDialog();
    this.editNotesDialogCreator.setData(null);
    this.passwordDialogCreator = new PasswordDialog();
  }

  @Override
  public void setController(JournalController journalController) {
    this.loader.setController(journalController);
  }

  @Override
  public Scene load(ThemeEnum theme) throws IllegalStateException {
    try {
      this.rootNode = this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException("Failed to load FXML", e);
    }
    this.scene = new Scene(this.rootNode);
    ApplyCss.applyTheme(this.scene, theme);
    return this.scene;
  }

  @Override
  public Scene getScene() {
    return this.scene;
  }

  /**
   * Displays an alert dialog with the specified alert type and message.
   *
   * @param alertType the type of the alert dialog
   * @param message   the message to be displayed in the alert dialog
   */
  public void showAlert(Alert.AlertType alertType, String message) {
    Alert alert = new Alert(alertType);
    alert.setContentText(message);
    alert.showAndWait();
  }

  /**
   * Updates the task count label with the new count and applies the appropriate theme based on
   * the maximum tasks.
   *
   * @param taskLabel the label displaying the task count
   * @param newCount  the new task count
   * @param maxTasks  the maximum number of tasks allowed
   * @param theme     the current theme
   */
  public void updateTaskCount(Label taskLabel, int newCount, int maxTasks, ThemeEnum theme) {
    taskLabel.setText("Tasks: " + newCount + "/" + maxTasks);

    if (newCount > maxTasks) {
      taskLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
    } else {
      taskLabel.setStyle(theme.toStyle());
    }
  }

  /**
   * Updates the event count label with the new count and applies the appropriate theme based on
   * the maximum events.
   *
   * @param eventLabel the label displaying the event count
   * @param newCount   the new event count
   * @param maxEvents  the maximum number of events allowed
   * @param theme      the current theme
   */
  public void updateEventCount(Label eventLabel, int newCount, int maxEvents, ThemeEnum theme) {
    eventLabel.setText("Events: " + newCount + "/" + maxEvents);

    if (newCount > maxEvents) {
      eventLabel.setStyle("-fx-text-fill: red; -fx-font-size: 18px;");
    } else {
      eventLabel.setStyle(theme.toStyle());  // Reset color to current theme
    }
  }

  /**
   * Updates the task and event label themes based on the model and the current theme.
   *
   * @param taskLabels  the collection of task labels
   * @param eventLabels the collection of event labels
   * @param model       the journal model
   * @param theme       the current theme
   */
  public void updateTaskAndEventLabelTheme(Collection<Label> taskLabels,
                                           Collection<Label> eventLabels,
                                           JournalModel model, ThemeEnum theme) {
    for (Label label : taskLabels) {
      DayEnum day =
          DayEnum.valueOf(label.getId().toUpperCase().replace("TASKLABEL", ""));
      int tasksCount = model.getWeek().getDay(day).getNumTasks();
      int maxTasks = model.getWeek().getMaxTasks();
      this.updateTaskCount(label, tasksCount, maxTasks, theme);
    }

    for (Label label : eventLabels) {
      DayEnum day =
          DayEnum.valueOf(label.getId().toUpperCase().replace("EVENTLABEL", ""));
      int eventsCount = model.getWeek().getDay(day).getNumEvents();
      int maxEvents = model.getWeek().getMaxEvents();
      this.updateEventCount(label, eventsCount, maxEvents, theme);
    }
  }

  /**
   * Prompts the user to enter task data and returns the result as an Optional.
   *
   * @param currentTheme the current theme
   * @return an Optional containing the entered task data, or an empty Optional if canceled
   */
  public Optional getTaskFromUser(ThemeEnum currentTheme) {
    this.taskDialogCreator.setData(null);
    Dialog dialog = this.taskDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }

  @Override
  public Optional getMaxTasksFromUser(int maxTasks, ThemeEnum currentTheme) {
    this.maxTasksDialogCreator.setData(maxTasks);
    Dialog dialog = this.maxTasksDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }


  /**
   * Prompts the user to display task data and returns the result as an Optional.
   *
   * @param task         the task data to display
   * @param currentTheme the current theme
   * @return an Optional containing the entered task data, or an empty Optional if canceled
   */
  public Optional getDisplayTaskFromUser(TaskData task, ThemeEnum currentTheme) {
    this.displayTaskDialogCreator.setData(task);
    Dialog dialog = this.displayTaskDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }

  /**
   * Prompts the user to enter event data and returns the result as an Optional.
   *
   * @param currentTheme the current theme
   * @return an Optional containing the entered event data, or an empty Optional if canceled
   */
  public Optional getEventFromUser(ThemeEnum currentTheme) {
    this.eventDialogCreator.setData(null);
    Dialog dialog = this.eventDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }


  /**
   * Prompts the user to enter a password and returns the result as an Optional.
   *
   * @return an Optional containing the entered password, or an empty Optional if canceled
   */
  public Optional promptUserForPassword() {
    Dialog dialog = this.passwordDialogCreator.createDialog();
    return dialog.showAndWait();
  }

  /**
   * Prompts the user to edit task data and returns the result as an Optional.
   *
   * @param data         the task data to edit
   * @param currentTheme the current theme
   * @return an Optional containing the edited task data, or an empty Optional if canceled
   */
  public Optional getEditTaskFromUser(TaskData data, ThemeEnum currentTheme) {
    this.taskDialogCreator.setData(data);
    Dialog dialog = this.taskDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }

  /**
   * Prompts the user to edit event data and returns the result as an Optional.
   *
   * @param data         the event data to edit
   * @param currentTheme the current theme
   * @return an Optional containing the edited event data, or an empty Optional if canceled
   */
  public Optional getEditEventFromUser(EventData data, ThemeEnum currentTheme) {
    this.eventDialogCreator.setData(data);
    Dialog dialog = this.eventDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }

  /**
   * Prompts the user to display event data and returns the result as an Optional.
   *
   * @param event        the event data to display
   * @param currentTheme the current theme
   * @return an Optional containing the entered event data, or an empty Optional if canceled
   */
  public Optional getDisplayEventFromUser(EventData event, ThemeEnum currentTheme) {
    this.displayEventDialogCreator.setData(event);
    Dialog dialog = this.displayEventDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }

  /**
   * Prompts the user to input max number of events and retrieves input
   *
   * @param maxEvents    the max events
   * @param currentTheme the current theme
   * @return an Optional containing the entered event data, or an empty Optional if canceled
   */
  @Override
  public Optional getMaxEventsFromUser(int maxEvents, ThemeEnum currentTheme) {
    this.maxEventsDialogCreator.setData(maxEvents);
    Dialog dialog = this.maxEventsDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }

  /**
   * Prompts the user to enter notes and returns the result as an Optional.
   *
   * @param notes        the initial notes value
   * @param currentTheme the current theme
   * @return an Optional containing the entered notes, or an empty Optional if canceled
   */
  public Optional getNotesFromUser(String notes, ThemeEnum currentTheme) {
    this.editNotesDialogCreator.setData(notes);
    Dialog dialog = this.editNotesDialogCreator.createDialog();
    ApplyCss.applyDialogStyles(dialog, currentTheme);
    return dialog.showAndWait();
  }
}
