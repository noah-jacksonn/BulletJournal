package cs3500.pa05.view.dialogs;

import cs3500.pa05.controller.UrlController;
import cs3500.pa05.model.data.EventData;
import cs3500.pa05.model.data.MiniViewerEnum;
import cs3500.pa05.model.data.ThemeEnum;
import cs3500.pa05.view.ApplyCss;
import javafx.geometry.VPos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The DisplayEventDialog class represents a dialog for displaying an event.
 * It implements the DialogCreator interface.
 */
public class DisplayEventDialog implements DialogCreator {
  private Label nameField;
  private Label dayField;
  private Label startTimeHbox;
  private Label durationField;
  private VBox descriptionField;

  /**
   * Creates and returns a dialog for displaying an event.
   *
   * @return the created dialog
   */
  @Override
  public Dialog createDialog() {
    Dialog dialog = new Dialog();
    dialog.setTitle("New Event");

    ButtonType editButton = new ButtonType("Edit");
    ButtonType deleteButton = new ButtonType("Delete");
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, editButton, deleteButton);

    GridPane grid = setupGridPane();

    dialog.getDialogPane().setContent(grid);

    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == editButton) {
        return MiniViewerEnum.EDIT;
      } else if (dialogButton == deleteButton) {
        return MiniViewerEnum.DELETE;
      } else {
        return MiniViewerEnum.OK;
      }
    });

    ApplyCss.applyDialogStyles(dialog, ThemeEnum.LIGHT);
    return dialog;
  }

  /**
   * Sets the data for the dialog.
   *
   * @param data the data to be set for the dialog
   */
  @Override
  public void setData(Object data) {
    if (data instanceof EventData) {
      EventData eventData = (EventData) data;
      this.nameField = new Label(eventData.getName());
      this.dayField = new Label(eventData.getDay().toString());
      this.startTimeHbox = new Label(eventData.getStartTime().toString());
      this.durationField = new Label(Integer.toString(eventData.getDuration()));
      this.descriptionField = new VBox();
      parseDescription(eventData.getDescription(), this.descriptionField);
    }
  }

  /**
   * Sets up the grid pane for the dialog.
   *
   * @return the configured grid pane
   */
  private GridPane setupGridPane() {
    GridPane grid = new GridPane();

    grid.add(new Label("Name:"), 0, 0);
    grid.add(this.nameField, 1, 0);

    grid.add(new Label("Day:"), 0, 1);
    grid.add(this.dayField, 1, 1);

    this.nameField.setWrapText(true);
    this.dayField.setWrapText(true);

    HBox durationBox = new HBox();
    Label minuteLabel = new Label("minutes");
    durationBox.getChildren().addAll(this.durationField, minuteLabel);
    durationBox.setSpacing(10);

    Label startTimeLabel = new Label("Start Time:");
    GridPane.setValignment(startTimeLabel, VPos.TOP);

    grid.add(startTimeLabel, 0, 2);
    grid.add(this.startTimeHbox, 1, 2);

    grid.add(new Label("Duration:"), 0, 3);
    grid.add(durationBox, 1, 3);

    this.startTimeHbox.setWrapText(true);
    this.durationField.setWrapText(true);
    this.nameField.setPrefWidth(400);

    Label descriptionLabel = new Label("Description:");
    GridPane.setValignment(descriptionLabel, VPos.CENTER);

    grid.add(descriptionLabel, 0, 4);
    grid.add(this.descriptionField, 1, 4);

    this.descriptionField.setSpacing(10);
    this.descriptionField.setPrefWidth(400);

    grid.setVgap(10);
    return grid;
  }

  /**
   * Parses the description string and adds labels and hyperlinks to the description field.
   *
   * @param description the description string to be parsed
   * @param box         the VBox container for the description field
   */
  private void parseDescription(String description, VBox box) {
    int startIndex = 0;
    while (true) {
      Hyperlink link = UrlController.parseUrl(description.substring(startIndex));
      if (link == null) {
        break;
      }
      int linkStart = description.indexOf(link.getText(), startIndex);
      if (linkStart > startIndex) {
        Label label = new Label(description.substring(startIndex, linkStart));
        box.getChildren().add(label);
      }
      box.getChildren().add(link);
      startIndex = linkStart + link.getText().length();
    }
    if (startIndex < description.length()) {
      Label label = new Label(description.substring(startIndex));
      box.getChildren().add(label);
    }
  }
}
