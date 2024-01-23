package cs3500.pa05;

import cs3500.pa05.controller.JournalControllerImpl;
import cs3500.pa05.model.JournalModel;
import cs3500.pa05.model.JournalModelImpl;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.JournalViewImpl;
import cs3500.pa05.view.SplashScreen;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The entry point of the journal application. Launches the application and initializes the
 * model, view, and controller.
 */
public class JournalApp extends Application {

  /**
   * Starts the journal application by initializing the model, view, and controller, and showing
   * the main stage.
   *
   * @param stage the primary stage for the application
   * @throws IOException if an error occurs while loading the view
   */
  @Override
  public void start(Stage stage) throws IOException {

    SplashScreen splashScreen = new SplashScreen();
    splashScreen.show();

    JournalModel journalModel = new JournalModelImpl();
    JournalView journalView = new JournalViewImpl(journalModel);

    JournalControllerImpl journalController =
        new JournalControllerImpl(journalModel, null); // Pass null for the view initially

    journalView.setController(journalController); // Set controller on view
    journalController.setView(journalView); // Set view on controller now that we have a view
    stage.setScene(journalView.load(journalModel.getWeek().getTheme()));

    splashScreen.setOnSplashFinished(() -> {
      journalController.run();
      stage.show();
    });
  }

  /**
   * The main method of the application. Launches the JavaFX application.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}
