package tugasmodul6dahtu;

import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tugasmodul6dahtu.com.main.LibrarySystem;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Start Library System");
        button.setOnAction(event -> LibrarySystem.startLibrarySystem(stage));

        VBox root = new VBox(10, button);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 240);
        stage.setTitle("Library system");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
