package cs3500.pa05.view.dialogs;

import cs3500.pa05.controller.InputValidator;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.Event;
import cs3500.pa05.model.data.EventData;
import cs3500.pa05.model.data.MeridiemEnum;
import cs3500.pa05.model.data.Time;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * The EventDialog class represents a dialog for creating or editing events.
 * It implements the DialogCreator interface.
 */
public class EventDialog implements DialogCreator {
  private TextField nameField;
  private ComboBox<DayEnum> dayField;
  private HBox startTimeHbox;
  private Spinner<Integer> durationField;
  private TextArea descriptionField;
  private Label statusMessage;

  /**
   * Creates and returns a dialog for creating or editing events.
   *
   * @return the created dialog
   */
  @Override
  public Dialog createDialog() {
    Dialog dialog = new Dialog();
    dialog.setTitle("New Event");
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    GridPane grid = setupGridPane();
    dialog.getDialogPane().setContent(grid);

    final Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
    okButton.addEventFilter(ActionEvent.ACTION, event -> {
      if (!InputValidator.validateName(this.nameField)
          || !InputValidator.validateDay(this.dayField)
          || !InputValidator.validateTime(this.startTimeHbox)) {
        this.statusMessage.setText("invalid inputs");
        event.consume();
      }
    });
    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == ButtonType.OK) {
        DayEnum dayEnum = this.dayField.getValue();
        Spinner<Integer> hourSpinner =
            (Spinner<Integer>) this.startTimeHbox.getChildren().get(1);
        Spinner<Integer> minuteSpinner =
            (Spinner<Integer>) this.startTimeHbox.getChildren().get(3);
        ComboBox<MeridiemEnum> meridiemComboBox =
            (ComboBox<MeridiemEnum>) this.startTimeHbox.getChildren().get(5);

        int hours = hourSpinner.getValue();
        int minutes = minuteSpinner.getValue();
        MeridiemEnum meridiem = meridiemComboBox.getValue();

        Time startTime = new Time(hours, minutes, meridiem);
        int duration = this.durationField.getValue();
        Event event = new Event(this.nameField.getText(), startTime,
            duration, this.descriptionField.getText());
        EventData eventData = new EventData(event, dayEnum);
        return eventData;
      }
      return null;
    });

    return dialog;
  }

  /**
   * Sets the data for the dialog.
   *
   * @param data the data to be set for the dialog
   */
  @Override
  public void setData(Object data) {
    this.nameField = new TextField();
    DayEnum[] weekDaysEnum = DayEnum.values();
    this.dayField = new ComboBox<>(FXCollections.observableArrayList(weekDaysEnum));
    this.startTimeHbox = buildTimeSpinner(null);
    this.durationField = buildDurationSpinner();
    this.descriptionField = new TextArea();
    this.statusMessage = new Label("");

    if (data instanceof EventData) {
      EventData eventData = (EventData) data;
      this.nameField = new TextField(eventData.getName());;
      this.dayField.getSelectionModel().select(eventData.getDay());
      this.startTimeHbox = buildTimeSpinner(eventData.getStartTime());
      this.durationField = new Spinner(1, 1440, eventData.getDuration());
      this.descriptionField = new TextArea(eventData.getDescription());
    }
  }

  /**
   * Sets up the grid pane for the dialog.
   *
   * @return the configured grid pane
   */
  private GridPane setupGridPane() {
    this.nameField.setPromptText("Name");
    this.nameField.setPrefSize(150, 50);

    this.descriptionField.setWrapText(true);
    this.descriptionField.setPrefHeight(100);
    this.statusMessage.setTextFill(Color.RED);

    GridPane grid = new GridPane();
    grid.add(new Label("Name:"), 0, 0);
    grid.add(this.nameField, 1, 0);

    grid.add(new Label("Day:"), 0, 1);
    grid.add(this.dayField, 1, 1);

    HBox durationBox = new HBox();
    Label minuteLabel = new Label("minutes");
    durationBox.getChildren().addAll(this.durationField, minuteLabel);
    durationBox.setSpacing(10);

    Label startTimeLabel = new Label("Start Time:");
    GridPane.setValignment(startTimeLabel, VPos.TOP); // Align the label to the top
    grid.add(startTimeLabel, 0, 2);
    grid.add(this.startTimeHbox, 1, 2);
    grid.add(new Label("Duration:"), 0, 3);
    grid.add(durationBox, 1, 3);

    Label descriptionLabel = new Label("Description:");
    GridPane.setValignment(descriptionLabel, VPos.CENTER); // Align the label to the top

    grid.add(descriptionLabel, 0, 4);
    grid.add(this.descriptionField, 1, 4);
    grid.add(this.statusMessage, 1, 5);

    // Add vertical spacing between rows
    grid.setVgap(10);

    return grid;
  }

  /**
   * Builds the time spinner for the dialog.
   *
   * @param data the data to prepopulate the spinner with
   * @return the constructed HBox containing the time spinner
   */
  private HBox buildTimeSpinner(Object data) {
    HBox hbox = null;
    Spinner<Integer> hourSpinner = null;
    Spinner<Integer> minuteSpinner = null;
    ComboBox<MeridiemEnum> meridiemField = null;
    meridiemField = new ComboBox<>(FXCollections.observableArrayList(MeridiemEnum.values()));
    if (data instanceof Time) {
      Time time = (Time) data;
      hourSpinner = new Spinner<>(1, 12, time.getHour());
      minuteSpinner = new Spinner<>(0, 59, time.getMinutes());
      meridiemField.getSelectionModel().select(time.getMeridiem());
    } else {
      hourSpinner = new Spinner<>(1, 12, 1);
      minuteSpinner = new Spinner<>(0, 59, 0);
    }
    hbox = new HBox(5);
    hbox.setPadding(new Insets(10, 10, 10, 25));
    hbox.getChildren()
        .addAll(new Label("Hour: "), hourSpinner, new Label("Minute: "), minuteSpinner,
            new Label("Meridiem: "), meridiemField);

    return hbox;
  }

  /**
   * Builds the duration spinner for the dialog.
   *
   * @return the constructed duration spinner
   */
  private Spinner<Integer> buildDurationSpinner() {
    Spinner<Integer> durationSpinner = new Spinner<>(1, 1440, 1);
    return durationSpinner;
  }
}
