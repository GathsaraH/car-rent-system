import animatefx.animation.RotateIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/MainLoginForm.fxml"))));
        primaryStage.show();
/*        Parent parent=(FXMLLoader.load(this.getClass().getResource("view/DashBoardForm.fxml")));
        primaryStage.setScene(new Scene(parent));
        primaryStage.initStyle(StageStyle.UNDECORATED);*/
/*
        primaryStage.show();
        new RotateIn(parent).play();
*/



    }
}
