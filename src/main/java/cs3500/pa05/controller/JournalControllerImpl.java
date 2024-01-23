package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.FileHandler;
import cs3500.pa05.model.JournalModel;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.data.Day;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.EventData;
import cs3500.pa05.model.data.MiniViewerEnum;
import cs3500.pa05.model.data.Task;
import cs3500.pa05.model.data.TaskData;
import cs3500.pa05.model.data.ThemeEnum;
import cs3500.pa05.model.json.WeekJson;
import cs3500.pa05.view.ApplyCss;
import cs3500.pa05.view.JournalView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Implementation of the JournalController interface that handles user interactions and
 * controls the flow of the journal application.
 */
public class JournalControllerImpl implements JournalController {
  JournalModel model;
  JournalView view;
  FileHandler fileHandler;
  @FXML
  private MenuItem createTaskMenuItem;
  @FXML
  private MenuItem setMaximumTasksMenuItem;
  @FXML
  private MenuItem createEventMenuItem;
  @FXML
  private MenuItem setMaximumEventsMenuItem;
  @FXML
  private MenuItem saveFileMenuItem;
  @FXML
  private MenuItem openFileMenuItem;
  @FXML
  private MenuItem createNewWeekMenuItem;
  @FXML
  private MenuItem editNotesMenuItem;
  @FXML
  private Label notesText;
  @FXML
  private ListView<Button> sundayEvents;
  @FXML
  private ListView<Button> sundayTasks;
  @FXML
  private ListView<Button> mondayEvents;
  @FXML
  private ListView<Button> mondayTasks;
  @FXML
  private ListView<Button> tuesdayEvents;
  @FXML
  private ListView<Button> tuesdayTasks;
  @FXML
  private ListView<Button> wednesdayEvents;
  @FXML
  private ListView<Button> wednesdayTasks;
  @FXML
  private ListView<Button> thursdayEvents;
  @FXML
  private ListView<Button> thursdayTasks;
  @FXML
  private ListView<Button> fridayEvents;
  @FXML
  private ListView<Button> fridayTasks;
  @FXML
  private ListView<Button> saturdayEvents;
  @FXML
  private ListView<Button> saturdayTasks;
  @FXML
  private MenuItem setLightTheme;
  @FXML
  private MenuItem setDarkTheme;
  @FXML
  private MenuItem setRetroTheme;
  @FXML
  private Label sundayEventLabel;
  @FXML
  private Label mondayEventLabel;

  @FXML
  private Label tuesdayEventLabel;

  @FXML
  private Label wednesdayEventLabel;

  @FXML
  private Label thursdayEventLabel;

  @FXML
  private Label fridayEventLabel;

  @FXML
  private Label saturdayEventLabel;
  @FXML
  private Label sundayTaskLabel;

  @FXML
  private Label mondayTaskLabel;

  @FXML
  private Label tuesdayTaskLabel;

  @FXML
  private Label wednesdayTaskLabel;

  @FXML
  private Label thursdayTaskLabel;

  @FXML
  private Label fridayTaskLabel;

  @FXML
  private Label saturdayTaskLabel;
  @FXML
  private Menu fileNameMenu;
  @FXML
  private MenuItem editWeekNameMenuItem;
  @FXML
  private MenuItem openFileTemplate;
  @FXML
  private MenuItem setPasswordMenuItem;
  @FXML
  private ImageView squigglyLineImage;
  @FXML
  private ImageView bulletJournalImage;
  private List<Label> taskLabels;
  private List<Label> eventLabels;
  private String currentFilePath;

  /**
   * Constructs a JournalControllerImpl object with the specified model and view.
   *
   * @param journalModel the journal model
   * @param journalView the journal view
   */
  public JournalControllerImpl(JournalModel journalModel, JournalView journalView) {
    this.model = journalModel;
    this.view = journalView;
    this.fileHandler = new FileHandler();
    this.currentFilePath = null;
  }

  /**
   * Runs the journal application by initializing the controller.
   */
  @Override
  public void run() {
    this.initialize();
  }

  /**
   * Initializes the journal application by setting up event handlers, menu shortcuts, and theme
   * menu items.
   */
  @Override
  public void initialize() {
    this.initTaskLabelCollection();
    this.initEventLabelCollection();
    this.initMenuShortcuts();

    this.editWeekNameMenuItem.setOnAction(e -> this.handleEditWeekName());

    this.createTaskMenuItem.setOnAction(e -> this.handleTaskInput());
    this.setMaximumTasksMenuItem.setOnAction(e -> this.handleMaxTasksInput());

    this.createEventMenuItem.setOnAction(e -> this.handleEventInput());
    this.setMaximumEventsMenuItem.setOnAction(e -> this.handleMaxEventsInput());

    this.openFileMenuItem.setOnAction(e -> this.handleOpenFile());
    this.saveFileMenuItem.setOnAction(e -> this.handleSaveFile());

    this.createNewWeekMenuItem.setOnAction(e -> this.handleCreateNewWeek());
    this.editNotesMenuItem.setOnAction(e -> this.handleEditNotes());

    this.openFileTemplate.setOnAction(e -> this.handleOpenFileTemplate());
    this.setPasswordMenuItem.setOnAction(e -> this.handleSetPassword());

    this.initThemeMenuItems();
    this.view.updateTaskAndEventLabelTheme(this.taskLabels, this.eventLabels,
        this.model, this.getThemeFromModel());
  }

  /**
   * Initializes the menu shortcuts.
   * Assigns keyboard shortcuts to various menu items.
   * Use the specified key combinations to trigger the corresponding actions.
   */
  public void initMenuShortcuts() {
    this.createEventMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E,
        KeyCombination.META_DOWN));
    this.createTaskMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.T,
        KeyCombination.META_DOWN));
    this.saveFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S,
        KeyCombination.META_DOWN));
    this.openFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O,
        KeyCombination.META_DOWN));
    this.createNewWeekMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N,
        KeyCombination.META_DOWN));
    this.editNotesMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.D,
        KeyCombination.META_DOWN));
    this.setMaximumTasksMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.M,
        KeyCombination.META_DOWN));
    this.setMaximumEventsMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.H,
        KeyCombination.META_DOWN));
  }

  /**
   * Initializes the task label collection.
   * Populates the taskLabels list with the corresponding labels.
   */
  private void initTaskLabelCollection() {
    this.taskLabels = new ArrayList<>(Arrays.asList(
        this.sundayTaskLabel, this.mondayTaskLabel, this.tuesdayTaskLabel,
        this.wednesdayTaskLabel, this.thursdayTaskLabel,
        this.fridayTaskLabel, this.saturdayTaskLabel));
  }

  /**
   * Initializes the event label collection.
   * Populates the eventLabels list with the corresponding labels.
   */
  private void initEventLabelCollection() {
    this.eventLabels = new ArrayList<>(Arrays.asList(
        this.sundayEventLabel, this.mondayEventLabel, this.tuesdayEventLabel,
        this.wednesdayEventLabel, this.thursdayEventLabel,
        this.fridayEventLabel, this.saturdayEventLabel
    ));
  }


  /**
   * Initializes the theme menu items.
   * Sets the event handlers for the theme menu items to handle theme switching.
   */
  private void initThemeMenuItems() {
    this.setLightTheme.setOnAction(e -> handleThemeSwitch(ThemeEnum.LIGHT));
    this.setDarkTheme.setOnAction(e -> handleThemeSwitch(ThemeEnum.DARK));
    this.setRetroTheme.setOnAction(e -> handleThemeSwitch(ThemeEnum.RETRO));
  }

  /**
   * Method to handle saving the current state of the journal to a file.
   * It opens a FileChooser dialog and lets the user pick a location and name for the file.
   * The file will have a .bujo extension.
   */
  private void handleSaveFile() {
    FileChooser fileChooser = new FileChooser();

    fileChooser.getExtensionFilters()
        .add(new FileChooser.ExtensionFilter("BUJO files (.bujo)", "*.bujo"));

    File file = fileChooser.showSaveDialog(new Stage());

    if (file != null) {
      try {
        this.saveToFile(file.getAbsolutePath());
      } catch (IOException e) {
        // Do nothing if caught
      }
    }
  }

  /**
   * Method to handle opening a .bujo file and load its contents into the journal.
   * It opens a FileChooser dialog and lets the user select a .bujo file to open.
   */
  private void handleOpenFile() {
    FileChooser fileChooser = new FileChooser();

    fileChooser.getExtensionFilters()
        .add(new FileChooser.ExtensionFilter("BUJO files (.bujo)", "*.bujo"));

    File file = fileChooser.showOpenDialog(new Stage());

    if (file != null) {
      try {
        String jsonString = this.fileHandler.readFile(file.getAbsolutePath());
        ObjectMapper mapper = new ObjectMapper();
        WeekJson weekJson = mapper.readValue(jsonString, WeekJson.class);

        if (weekJson.getPassword() != null) {
          Optional<String> result = this.view.promptUserForPassword();
          if (result.isPresent() && result.get().equals(weekJson.getPassword())) {
            this.openFile(file.getAbsolutePath(), weekJson);
          } else {
            this.view.showAlert(Alert.AlertType.ERROR,
                "Incorrect password. Please try again.");
          }
        } else {
          this.openFile(file.getAbsolutePath(), weekJson);
        }
      } catch (IOException e) {
        // Do nothing if caught
      }
    }
  }

  /**
   * Saves the current week data to a file with the specified file path.
   *
   * @param filePath the file path to save the data to
   * @throws IOException if an I/O error occurs while saving the file
   */
  @Override
  public void saveToFile(String filePath) throws IOException {
    this.currentFilePath = filePath;
    ObjectMapper mapper = new ObjectMapper();
    WeekJson weekJson = new WeekJson(this.model.getWeek());
    String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(weekJson);

    this.fileHandler.writeFile(filePath, prettyJson);
  }

  /**
   * Opens a file with the specified file path and loads the week data from it.
   *
   * @param filePath the file path to open
   * @param weekJson the WeekJson object representing the week data
   * @throws IOException if an I/O error occurs while opening the file
   */
  @Override
  public void openFile(String filePath, WeekJson weekJson) throws IOException {
    this.currentFilePath = filePath;
    Week week = weekJson.toWeek();
    this.model.setWeek(week);
    this.handleThemeSwitch(this.getThemeFromModel());
    this.notesText.setText(week.getNotes());
    this.clearAllListsViews();

    for (DayEnum dayEnum : DayEnum.values()) {
      Day day = week.getDay(dayEnum);

      ListView<Button> taskListView = this.getTaskListView(dayEnum);
      for (Task task : day.getTasks()) {
        Button button = task.toButton();
        TaskData data = new TaskData(task, dayEnum);
        button.setOnAction(e -> this.handleTaskClick(data, button));
        taskListView.getItems().add(button);
      }

      ListView<Button> eventListView = this.getEventListView(dayEnum);
      for (Event event : day.getEvents()) {
        Button button = event.toButton();
        EventData data = new EventData(event, dayEnum);
        button.setOnAction(e -> this.handleEventClick(data, button));
        eventListView.getItems().add(button);
      }
    }

    this.updateLabels();
  }

  /**
   * Handles the edit notes operation.
   * Prompts the user to edit the notes and updates the model and view accordingly.
   */
  private void handleEditNotes() {
    Optional<String> notesData = this.view.getNotesFromUser(this.model.getWeek().getNotes(),
        this.getThemeFromModel());
    notesData.ifPresent(data -> {
      String substring = notesData.toString().substring(9, notesData.toString().length() - 1);
      this.model.setNotes(substring);
      this.notesText.setText(substring);
    });
  }

  /**
   * Handles the task input operation.
   * Prompts the user to input a task and adds it to the model and view.
   */
  private void handleTaskInput() {
    Optional<TaskData> inputData = view.getTaskFromUser(this.getThemeFromModel());
    inputData.ifPresent(data -> {
      TaskData taskData = inputData.get();
      Task task = taskData.getTask();
      this.model.addTask(task, taskData.getDay());

      ListView<Button> taskListView = this.getTaskListView(taskData.getDay());
      Button button = task.toButton();
      taskListView.getItems().add(button);
      button.setOnAction(e -> this.handleTaskClick(taskData, button));

      this.updateLabels();
    });
  }

  /**
   * Handles the event input operation.
   * Prompts the user to input an event and adds it to the model and view.
   */
  private void handleEventInput() {
    Optional<EventData> inputData = this.view.getEventFromUser(getThemeFromModel());
    inputData.ifPresent(data -> {
      EventData eventData = inputData.get();
      Event event = eventData.getEvent();
      this.model.addEvent(event, eventData.getDay());

      ListView<Button> eventListView = this.getEventListView(eventData.getDay());
      Button button = event.toButton();
      eventListView.getItems().add(button);
      button.setOnAction(e -> this.handleEventClick(eventData, button));

      this.updateLabels();
    });
  }

  /**
   * This method handles the task click operation.
   *
   * @param taskData TaskData object that contains information about the task.
   * @param button Button object that ties to the TaskData
   */
  private void handleTaskClick(TaskData taskData, Button button) {
    Optional clickData = this.view.getDisplayTaskFromUser(taskData, getThemeFromModel());
    clickData.ifPresent(data -> {
      if (clickData.get().equals(MiniViewerEnum.EDIT)) {
        this.handleEditTask(taskData, button);
      } else if (clickData.get().equals(MiniViewerEnum.DELETE)) {
        this.handleDeleteTask(taskData, button);
      }
    });
  }

  /**
   * Handles the event click operation.
   *
   * @param eventData the EventData object containing information about the event
   * @param button    the Button associated with the event
   */
  private void handleEventClick(EventData eventData, Button button) {
    Optional clickData = this.view.getDisplayEventFromUser(eventData, getThemeFromModel());
    clickData.ifPresent(data -> {
      if (clickData.get().equals(MiniViewerEnum.EDIT)) {
        this.handleEditEvent(eventData, button);
      } else if (clickData.get().equals(MiniViewerEnum.DELETE)) {
        this.handleDeleteEvent(eventData, button);
      }
    });
  }

  /**
   * Handles the edit task operation.
   *
   * @param taskData the TaskData object containing information about the task
   * @param button   the Button associated with the task
   */
  private void handleEditTask(TaskData taskData, Button button) {
    Optional editData = this.view.getEditTaskFromUser(taskData, this.getThemeFromModel());
    editData.ifPresent(data -> {
      TaskData editTaskData = (TaskData) editData.get();
      this.handleDeleteTask(taskData, button);
      Task task = editTaskData.getTask();
      this.model.addTask(task, editTaskData.getDay());

      ListView<Button> taskListView = this.getTaskListView(editTaskData.getDay());
      Button newButton = task.toButton();
      newButton.setOnAction(e ->
          this.handleTaskClick(editTaskData, newButton));
      taskListView.getItems().add(newButton);

      this.updateLabels();
    });
  }

  /**
   * Handles the edit event operation.
   *
   * @param eventData the EventData object containing information about the event
   * @param button    the Button associated with the event
   */
  private void handleEditEvent(EventData eventData, Button button) {
    Optional editData = this.view.getEditEventFromUser(eventData, this.getThemeFromModel());
    editData.ifPresent(data -> {
      EventData editEventData = (EventData) editData.get();
      this.handleDeleteEvent(eventData, button);

      Event event = editEventData.getEvent();
      this.model.addEvent(event, editEventData.getDay());

      ListView<Button> eventListView = this.getEventListView(editEventData.getDay());
      Button newButton = event.toButton();
      eventListView.getItems().add(newButton);
      newButton.setOnAction(e ->
          this.handleEventClick(editEventData, newButton));

      this.updateLabels();
    });
  }

  /**
   * Handles the delete task operation.
   *
   * @param taskData the TaskData object containing information about the task
   * @param button   the Button associated with the task
   */
  private void handleDeleteTask(TaskData taskData, Button button) {
    ListView<Button> taskListView = this.getTaskListView(taskData.getDay());
    taskListView.getItems().remove(button);
    this.model.getWeek().removeTask(taskData.getTask(), taskData.getDay());

    this.updateLabels();
  }

  /**
   * Handles the delete event operation.
   *
   * @param eventData the EventData object containing information about the event
   * @param button    the Button associated with the event
   */
  private void handleDeleteEvent(EventData eventData, Button button) {
    ListView<Button> eventListView = this.getEventListView(eventData.getDay());
    eventListView.getItems().remove(button);
    this.model.getWeek().removeEvent(eventData.getEvent(), eventData.getDay());

    this.updateLabels();
  }

  /**
   * Handles the max tasks input operation.
   * Prompts the user to input the maximum number of tasks and updates the model
   * and view accordingly.
   */
  private void handleMaxTasksInput() {
    Optional<Integer> maxTasksData =
        this.view.getMaxTasksFromUser(this.model.getWeek().getMaxTasks(),
            this.getThemeFromModel());
    maxTasksData.ifPresent(data -> {
      int maxTasks = maxTasksData.get();
      this.model.getWeek().setMaxTasks(maxTasks);
    });
    this.view.updateTaskAndEventLabelTheme(this.taskLabels, this.eventLabels,
        this.model, this.getThemeFromModel());
  }

  /**
   * Handles the max events input operation.
   * Prompts the user to input the maximum number of events and updates the model
   * and view accordingly.
   */
  private void handleMaxEventsInput() {
    Optional<Integer> maxEventsData =
        this.view.getMaxEventsFromUser(this.model.getWeek().getMaxEvents(), getThemeFromModel());
    maxEventsData.ifPresent(data -> {
      int maxEvents = maxEventsData.get();
      this.model.getWeek().setMaxEvents(maxEvents);
    });
    this.view.updateTaskAndEventLabelTheme(this.taskLabels, this.eventLabels,
        this.model, getThemeFromModel());
  }

  /**
   * Handles the theme switch operation.
   * Updates the theme of the journal and applies the corresponding styles and images to the view.
   *
   * @param theme the ThemeEnum representing the new theme
   */
  private void handleThemeSwitch(ThemeEnum theme) {
    Scene scene = this.view.getScene();
    scene.getStylesheets().clear();
    this.model.getWeek().setTheme(theme);

    ApplyCss.applyTheme(scene, theme);
    this.view.updateTaskAndEventLabelTheme(this.taskLabels, this.eventLabels, this.model, theme);

    Image imageForSquigglyLine;
    Image imageForBulletJournal;

    if (theme == ThemeEnum.LIGHT || theme == ThemeEnum.RETRO) {
      // Load images for LIGHT or RETRO theme
      imageForSquigglyLine = new Image("file:src/main/resources/squigglyLineLightMode.png");
      imageForBulletJournal = new Image("file:src/main/resources/BJLogoLightMode.png");
    }
    if (theme == ThemeEnum.DARK) {
      // Load images for DARK theme
      imageForSquigglyLine = new Image("file:src/main/resources/squigglyLineDarkMode.png");
      imageForBulletJournal = new Image("file:src/main/resources/BJLogoDarkMode.png");
    } else {
      // Default or fallback images if needed
      imageForSquigglyLine = new Image("file:src/main/resources/squigglyLineLightMode.png");
      imageForBulletJournal = new Image("file:src/main/resources/BJLogoLightMode.png");
    }

    // Apply the images to the ImageViews
    squigglyLineImage.setImage(imageForSquigglyLine);
    bulletJournalImage.setImage(imageForBulletJournal);
  }

  /**
   * Handles the set password operation.
   * Prompts the user to set a password for the current week and saves the file if successful.
   */
  private void handleSetPassword() {
    if (this.currentFilePath == null) {
      this.view.showAlert(Alert.AlertType.ERROR,
          "Please save the file before setting a password.");
      return;
    }

    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Set Password");
    dialog.setHeaderText("Enter a password for this week:");
    Optional<String> result = dialog.showAndWait();

    result.ifPresent(password -> {
      this.model.getWeek().setPassword(password);
      try {
        this.saveToFile(this.currentFilePath);
      } catch (IOException e) {
        this.view.showAlert(Alert.AlertType.ERROR, "Could not save the file.");
      }
    });
  }

  /**
   * Handles the creation of a new week.
   * Resets the week data and updates the GUI accordingly.
   */
  public void handleCreateNewWeek() {
    this.fileNameMenu.setText("[Week Name]");
    this.model.getWeek().resetWeek();
    this.resetGui();
  }

  /**
   * Handles the editing of the week name.
   * Prompts the user to enter a new name for the week and updates the week name label.
   */
  public void handleEditWeekName() {
    TextInputDialog dialog = new TextInputDialog(this.fileNameMenu.getText());
    ApplyCss.applyDialogStyles(dialog, getThemeFromModel());
    dialog.setTitle("Edit Week Name");
    dialog.setHeaderText("Enter a new name for the week");
    dialog.setContentText("Name:");

    Optional<String> result = dialog.showAndWait();
    result.ifPresent(name -> this.fileNameMenu.setText(name));
  }

  /**
   * Handles the opening of a file template.
   * Opens a file, creates a new week, and sets the week name based on user input.
   */
  private void handleOpenFileTemplate() {
    this.handleOpenFile();
    this.handleCreateNewWeek();
    this.handleEditWeekName();
    try {
      String fileName = this.fileNameMenu.getText().replaceAll("\\s", "_");
      this.saveToFile(fileName + ".bujo");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Resets the GUI to its initial state.
   * Updates the theme, notes, and lists views based on the current week data.
   */
  private void resetGui() {
    this.handleThemeSwitch(this.getThemeFromModel());
    this.notesText.setText(this.model.getWeek().getNotes());

    this.clearAllListsViews();

    for (DayEnum dayEnum : DayEnum.values()) {
      Day day = this.model.getDay(dayEnum);

      ListView<Button> taskListView = getTaskListView(dayEnum);
      for (Task task : day.getTasks()) {
        taskListView.getItems().add(task.toButton());
      }

      ListView<Button> eventListView = getEventListView(dayEnum);
      for (Event event : day.getEvents()) {
        eventListView.getItems().add(event.toButton());
      }
    }
  }

  /**
   * Clears all lists views.
   * Removes all items from the task and event lists views.
   */
  private void clearAllListsViews() {
    this.sundayEvents.getItems().clear();
    this.sundayTasks.getItems().clear();
    this.mondayEvents.getItems().clear();
    this.mondayTasks.getItems().clear();
    this.tuesdayEvents.getItems().clear();
    this.tuesdayTasks.getItems().clear();
    this.wednesdayEvents.getItems().clear();
    this.wednesdayTasks.getItems().clear();
    this.thursdayEvents.getItems().clear();
    this.thursdayTasks.getItems().clear();
    this.fridayEvents.getItems().clear();
    this.fridayTasks.getItems().clear();
    this.saturdayEvents.getItems().clear();
    this.saturdayTasks.getItems().clear();
  }

  /**
   * Returns the task list view associated with the specified day.
   *
   * @param dayEnum the DayEnum representing the day of the week
   * @return associated with the tasks of the specified day
   * @throws IllegalArgumentException if an invalid day of the week is provided
   */
  private ListView<Button> getTaskListView(DayEnum dayEnum) {
    switch (dayEnum) {
      case SUNDAY:
        return this.sundayTasks;
      case MONDAY:
        return this.mondayTasks;
      case TUESDAY:
        return this.tuesdayTasks;
      case WEDNESDAY:
        return this.wednesdayTasks;
      case THURSDAY:
        return this.thursdayTasks;
      case FRIDAY:
        return this.fridayTasks;
      case SATURDAY:
        return this.saturdayTasks;
      default:
        throw new IllegalArgumentException("Invalid day of the week");
    }
  }

  /**
   * Returns the event list view associated with the specified day.
   *
   * @param dayEnum the DayEnum representing the day of the week
   * @return List of buttons associated with the events of the specified day
   * @throws IllegalArgumentException if an invalid day of the week is provided
   */
  private ListView<Button> getEventListView(DayEnum dayEnum) {
    switch (dayEnum) {
      case SUNDAY:
        return this.sundayEvents;
      case MONDAY:
        return this.mondayEvents;
      case TUESDAY:
        return this.tuesdayEvents;
      case WEDNESDAY:
        return this.wednesdayEvents;
      case THURSDAY:
        return this.thursdayEvents;
      case FRIDAY:
        return this.fridayEvents;
      case SATURDAY:
        return this.saturdayEvents;
      default:
        throw new IllegalArgumentException("Invalid day of the week");
    }
  }

  /**
   * Updates the labels displaying the task and event counts for each day.
   */
  private void updateLabels() {
    for (DayEnum day : DayEnum.values()) {
      Label eventLabel = this.eventLabels.get(day.ordinal());
      int currentEventCount = this.model.getWeek().getDay(day).getNumEvents();
      this.view.updateEventCount(eventLabel, currentEventCount,
          this.model.getWeek().getMaxEvents(), this.getThemeFromModel());

      Label taskLabel = this.taskLabels.get(day.ordinal());
      int currentTaskCount = this.model.getWeek().getDay(day).getNumTasks();
      this.view.updateTaskCount(taskLabel, currentTaskCount,
          this.model.getWeek().getMaxTasks(), this.getThemeFromModel());
    }
  }

  /**
   * Retrieves the theme from the model.
   *
   * @return the current theme of the journal
   */
  private ThemeEnum getThemeFromModel() {
    return this.model.getWeek().getTheme();
  }

  /**
   * Sets the view for this controller.
   *
   * @param view the journal view
   */
  public void setView(JournalView view) {
    this.view = view;
  }
}