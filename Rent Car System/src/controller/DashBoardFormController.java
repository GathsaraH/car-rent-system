package controller;

import animatefx.animation.*;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardFormController {

    public AnchorPane root;
    public JFXButton btnRent;
    public JFXButton btnBreakDown;
    public JFXButton btnReturn;
    public JFXButton btnHome;
    public JFXButton btnAddClinents;

    public  void initialize() throws IOException {
        loadDefault();
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        btnHome.setStyle("-fx-background-color: chocolate;-fx-background-radius: 30");
        btnAddClinents.setStyle("-fx-background-color: #8682ae;-fx-background-radius: 30");
        btnBreakDown.setStyle("-fx-background-color: #8682ae;-fx-background-radius: 30");
        btnRent.setStyle("-fx-background-color: #8682ae;-fx-background-radius: 30");
        btnReturn.setStyle("-fx-background-color: #8682ae;-fx-background-radius: 30");
/*        Parent parent=FXMLLoader.load(getClass().getResource("../view/StatusForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(parent);
        new RotateInDownRight(parent).play();*/

        setUI("StatusForm");
    }

    public void addclientsOnAction(ActionEvent actionEvent) throws IOException {

        btnAddClinents.setStyle("-fx-background-color: chocolate;-fx-background-radius: 30");
        btnHome.setStyle("-fx-background-color: #8682ae;-fx-background-radius: 30");
        btnReturn.setStyle("-fx-background-color: #8682ae;-fx-background-radius: 30");
        btnRent.setStyle("-fx-background-color: #8682ae;-fx-background-radius: 30");
        btnBreakDown.setStyle("-fx-background-color: #8682ae;-fx-background-radius: 30");
/*        Parent parent=FXMLLoader.load(getClass().getResource("../view/AddClientsForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(parent);
        new SlideInDown(parent).play();*/
        setUI("AddClientsForm");
    }

    public void rentOnAction(ActionEvent actionEvent) throws IOException {
/*        Parent parent=FXMLLoader.load(getClass().getResource("../view/RentForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(parent);
        new SlideInUp(parent).play();*/
        setUI("RentForm");
    }

    public void returnOnAction(ActionEvent mouseEvent) throws IOException {
/*        Parent parent=FXMLLoader.load(getClass().getResource("../view/ReturnForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(parent);
        new SlideInUp(parent).play();*/
   try {
       setUI("ReturnForm");

   }catch (NullPointerException nullPointerException){

   }
    }

    public void breakdownOnAction(ActionEvent actionEvent) throws IOException {
/*        Parent parent=FXMLLoader.load(getClass().getResource("../view/ReturnForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(parent);
        new SlideInDown(parent).play();*/

        setUI("BreakDownForm");
    }

    private void loadDefault() throws IOException {

        setUI("StatusForm");
    }


    private void setUI(String location) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location+".fxml")));
    }
}
