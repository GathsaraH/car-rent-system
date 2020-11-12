package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class AdminDashBordFormController {
    public BorderPane root;

    public void initialize() throws IOException {
        loadDefault();
    }

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {
        setUI("AdminStatusForm");
    }

    public void UsersStaticOnAction(ActionEvent actionEvent) throws IOException {
       setUI("UsersStaticForm");

    }

    public void VehicleStaticOnAction(ActionEvent actionEvent) throws IOException {
        setUI("VehicleStaticForm");
    }

    public void BreakDownOnAction(ActionEvent actionEvent) throws IOException {
        setUI("BreakDownStaticForm");
    }

    public void BusinessStaticOnAction(ActionEvent actionEvent) throws IOException {
        setUI("BusinessStaticForm");
    }
    public void clientstaticOnAction(ActionEvent actionEvent) throws IOException {
        setUI("ClientsStaticForm");
    }

    public void loadDefault() throws IOException {
        setUI("AdminStatusForm");
    }

    public void setUI(String location) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/" +location+ ".fxml")));

    }


}
