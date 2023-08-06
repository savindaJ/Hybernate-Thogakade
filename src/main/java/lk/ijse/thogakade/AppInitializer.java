package lk.ijse.thogakade;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AppInitializer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = FXMLLoader.load(getClass().getResource(""));
        primaryStage.setTitle("thogakade");
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();

        TranslateTransition tt = new TranslateTransition(Duration.millis(350), scene.getRoot());
        tt.setFromX(-scene.getWidth());
        tt.setToX(0);
        tt.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
