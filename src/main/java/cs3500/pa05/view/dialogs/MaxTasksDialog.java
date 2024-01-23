package cs3500.pa05.view.dialogs;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;

/**
 * The MaxTasksDialog class represents a dialog for setting the maximum number of tasks.
 * It implements the DialogCreator interface.
 */
public class MaxTasksDialog implements DialogCreator {
  private Spinner maxTasksSpinner;
  int maxTasks = 0;

  /**
   * Creates and returns a dialog for setting the maximum number of tasks.
   *
   * @return the created dialog
   */
  @Override
  public Dialog createDialog() {
    Dialog dialog = new Dialog();
    dialog.setTitle("Set Maximum Tasks");
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    GridPane grid = setupGridPane();
    dialog.getDialogPane().setContent(grid);
    final Button okButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);

    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == ButtonType.OK) {
        return (Integer) this.maxTasksSpinner.getValue();
      }
      return null;
    });

    return dialog;
  }

  /**
   * Sets up the grid pane for the dialog.
   *
   * @return the configured grid pane
   */
  private GridPane setupGridPane() {
    this.maxTasksSpinner = new Spinner(1, 100, maxTasks);
    GridPane grid = new GridPane();
    grid.add(this.maxTasksSpinner, 0, 0);

    return grid;
  }

  /**
   * Sets the data for the dialog.
   *
   * @param data the data to be set for the dialog
   */
  @Override
  public void setData(Object data) {
    if (data instanceof Integer) {
      this.maxTasks = (Integer) data;
    }
  }
}
