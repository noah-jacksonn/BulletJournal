package cs3500.pa05.view;

import cs3500.pa05.controller.JournalControllerImpl;
import cs3500.pa05.model.data.ThemeEnum;
import java.net.URL;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

/**
 * Utility class for applying CSS styles to JavaFX dialogs and scenes based on a specified theme.
 */
public class ApplyCss {

  /**
   * Applies the CSS styles for the specified theme to the given dialog.
   *
   * @param dialog the dialog to apply the CSS styles to
   * @param theme  the theme to apply
   * @throws IllegalArgumentException if the CSS file for the specified theme is not found
   */
  public static void applyDialogStyles(Dialog dialog, ThemeEnum theme) {
    URL url = getThemeUrl(theme);
    if (url == null) {
      throw new IllegalArgumentException("Couldn't find CSS file for theme: " + theme);
    }
    DialogPane dialogPane = dialog.getDialogPane();
    dialogPane.getStylesheets().clear();
    dialogPane.getStylesheets().add(url.toExternalForm());
  }

  /**
   * Applies the CSS styles for the specified theme to the given scene.
   *
   * @param scene the scene to apply the CSS styles to
   * @param theme the theme to apply
   * @throws IllegalArgumentException if the CSS file for the specified theme is not found
   */
  public static void applyTheme(Scene scene, ThemeEnum theme) {
    URL url = getThemeUrl(theme);
    if (url == null) {
      throw new IllegalArgumentException("Couldn't find CSS file for theme: " + theme);
    }
    scene.getStylesheets().clear();
    scene.getStylesheets().add(url.toExternalForm());
  }

  /**
   * Returns the URL of the CSS file for the specified theme.
   *
   * @param theme the theme to retrieve the CSS file URL for
   * @return the URL of the CSS file for the specified theme
   * @throws IllegalArgumentException if the specified theme is not recognized
   */
  private static URL getThemeUrl(ThemeEnum theme) {
    switch (theme) {
      case LIGHT:
        return JournalControllerImpl.class.getResource("/light-theme.css");
      case DARK:
        return JournalControllerImpl.class.getResource("/dark-theme.css");
      case RETRO:
        return JournalControllerImpl.class.getResource("/retro-theme.css");
      default:
        throw new IllegalArgumentException("Unexpected value: " + theme);
    }
  }
}
