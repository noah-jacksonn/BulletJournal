package cs3500.pa05.view.dialogs;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * The EditNotesDialog class represents a dialog for editing notes.
 * It implements the DialogCreator interface.
 */
public class EditNotesDialog implements DialogCreator {
  private TextArea notesField;
  String notes = "";

  /**
   * Creates and returns a dialog for editing notes.
   *
   * @return the created dialog
   */
  @Override
  public Dialog createDialog() {
    Dialog dialog = new Dialog();
    dialog.setTitle("Edit Notes");
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    GridPane grid = setupGridPane();
    dialog.getDialogPane().setContent(grid);
    final Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);

    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == ButtonType.OK) {
        return this.notesField.getText();
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
    if (data instanceof String) {
      this.notes = (String) data;
    }
  }

  /**
   * Sets up the grid pane for the dialog.
   *
   * @return the configured grid pane
   */
  private GridPane setupGridPane() {
    this.notesField = new TextArea(this.notes);
    this.notesField.setWrapText(true);
    GridPane grid = new GridPane();
    grid.add(this.notesField, 0, 0);

    return grid;
  }
}
