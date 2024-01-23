package cs3500.pa05.view.dialogs;

import cs3500.pa05.controller.InputValidator;
import cs3500.pa05.model.data.DayEnum;
import cs3500.pa05.model.data.Task;
import cs3500.pa05.model.data.TaskData;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * The TaskDialog class represents a dialog for creating a new task.
 * It implements the DialogCreator interface.
 */
public class TaskDialog implements DialogCreator {
  private TextField nameField;
  private ComboBox<DayEnum> dayField;
  private TextArea descriptionField;
  private Label statusMessage;


  /**
   * Creates and returns a dialog for creating a new task.
   *
   * @return the created dialog
   */
  @Override
  public Dialog createDialog() {
    Dialog dialog = new Dialog();
    dialog.setTitle("New Task Event");

    // Set the button types
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    GridPane grid = setUpGridPane();

    dialog.getDialogPane().setContent(grid);

    final Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
    okButton.addEventFilter(ActionEvent.ACTION, event -> {
      if (!InputValidator.validateName(this.nameField)
          || !InputValidator.validateDay(this.dayField)) {
        this.statusMessage.setText("invalid inputs");
        event.consume();
      }
    });

    // setResultConverter is used to process the result
    dialog.setResultConverter(dialogButton -> {
      if (ButtonType.OK == dialogButton) {
        Task task = new Task(this.nameField.getText(), this.descriptionField.getText());
        TaskData taskData =
            new TaskData(task, this.dayField.getValue());
        return taskData;
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
    this.descriptionField = new TextArea();
    this.statusMessage = new Label("");
    if (data instanceof TaskData) {
      TaskData taskData = (TaskData) data;
      this.nameField = new TextField(taskData.getName());;
      this.dayField.getSelectionModel().select(taskData.getDay());
      this.descriptionField = new TextArea(taskData.getDescription());
    }
  }

  /**
   * Sets up the GridPane layout for the dialog fields.
   *
   * @return the configured GridPane layout
   */
  private GridPane setUpGridPane() {
    // Create the name, day, and description labels and fields
    this.nameField.setPromptText("Name");
    this.nameField.setPrefSize(150, 50);

    this.descriptionField.setWrapText(true);
    this.descriptionField.setPrefSize(200, 200);

    // Layout the fields in a GridPane
    GridPane grid = new GridPane();
    grid.add(new Label("Name:"), 0, 0);
    grid.add(this.nameField, 1, 0);

    grid.add(new Label("Day:"), 0, 1);
    grid.add(this.dayField, 1, 1);

    // Create the description label
    Label descriptionLabel = new Label("Description:");
    GridPane.setValignment(descriptionLabel, VPos.TOP); // Align the label to the top

    grid.add(descriptionLabel, 0, 2);
    grid.add(this.descriptionField, 1, 2);

    this.statusMessage.setTextFill(Color.RED);
    grid.add(this.statusMessage, 1, 3);

    // Add vertical spacing between rows
    grid.setVgap(10);

    return grid;
  }
}
