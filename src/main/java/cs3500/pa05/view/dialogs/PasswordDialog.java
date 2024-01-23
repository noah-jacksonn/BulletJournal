package cs3500.pa05.view.dialogs;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;

/**
 * The PasswordDialog class represents a dialog for entering a password.
 * It implements the DialogCreator interface.
 */
public class PasswordDialog implements DialogCreator {
  private String headerText;

  /**
   * Creates and returns a dialog for entering a password.
   *
   * @return the created dialog
   */
  @Override
  public Dialog<String> createDialog() {
    // Create the custom dialog.
    Dialog<String> dialog = new Dialog<>();
    dialog.setTitle("Password Dialog");
    this.headerText = "Enter your password:";
    dialog.setHeaderText(headerText);

    // Set the button types.
    ButtonType loginButtonType = new ButtonType("Enter", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

    // Create the password label and field.
    PasswordField passwordField = new PasswordField();
    passwordField.setPromptText("Password");

    // Create layout for the dialog box.
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.add(new Label("Password:"), 0, 0);
    grid.add(passwordField, 1, 0);

    dialog.getDialogPane().setContent(grid);

    // Request focus on the password field by default.
    javafx.application.Platform.runLater(() -> passwordField.requestFocus());

    // Convert the result to a password when the login button is clicked.
    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == loginButtonType) {
        return passwordField.getText();
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
      this.headerText = (String) data;
    }
  }
}
