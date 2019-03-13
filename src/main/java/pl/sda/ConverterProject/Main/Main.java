package pl.sda.ConverterProject.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Remigiusz Zudzin
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //TODO create sceneBuilder and project WindowApplication
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root =
                FXMLLoader.load(
                        getClass()
                                .getResource(""));
        primaryStage.setScene(new Scene(root, 657, 400));
        primaryStage.show();
    }
}
