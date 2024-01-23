package cs3500.pa05.view;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * A splash screen that displays an image during application startup.
 */
public class SplashScreen {
  private final Stage splashStage;
  private final FadeTransition fadeIn;
  private final FadeTransition fadeOut;
  private Runnable onSplashFinished;

  /**
   * Constructs a SplashScreen object.
   */
  public SplashScreen() {
    Image image = new Image("file:src/main/resources/BulletJournalSplashScreen.png");
    ImageView imageView = new ImageView(image);

    GridPane pane = new GridPane();
    pane.getChildren().add(imageView);

    this.splashStage = new Stage();
    this.splashStage.initStyle(StageStyle.UNDECORATED);
    this.splashStage.setScene(new Scene(pane, 1442, 785));

    this.fadeIn = new FadeTransition(Duration.seconds(1.5), pane);
    this.fadeIn.setFromValue(0);
    this.fadeIn.setToValue(1);

    this.fadeOut = new FadeTransition(Duration.seconds(1.5), pane);
    this.fadeOut.setFromValue(1);
    this.fadeOut.setToValue(0);
    this.fadeOut.setOnFinished(e -> {
      this.splashStage.close();
      if (this.onSplashFinished != null) {
        this.onSplashFinished.run();
      }
    });
  }

  /**
   * Shows the splash screen.
   */
  public void show() {
    this.fadeIn.play();
    this.splashStage.show();
    PauseTransition delay = new PauseTransition(Duration.seconds(1));
    delay.setOnFinished(e -> close());
    delay.play();
  }

  /**
   * Sets the runnable to be executed when the splash screen is finished.
   *
   * @param onSplashFinished the runnable to be executed
   */
  public void setOnSplashFinished(Runnable onSplashFinished) {
    this.onSplashFinished = onSplashFinished;
  }

  /**
   * Closes the splash screen by playing the fade-out transition.
   */
  public void close() {
    this.fadeOut.play();
  }
}

