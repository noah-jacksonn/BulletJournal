package cs3500.pa05.view.dialogs;

import javafx.scene.control.Dialog;

/**
 * The DialogCreator interface represents a creator for dialogs.
 * It provides methods to create a dialog and set data for the dialog.
 */
public interface DialogCreator {

  /**
   * Creates a dialog.
   *
   * @return the created dialog
   */
  Dialog createDialog();

  /**
   * Sets the data for the dialog.
   *
   * @param data the data to be set for the dialog
   */
  void setData(Object data);
}
