package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLoginFormController {

    public TextField txtUserName;
    public PasswordField txtPassword;
    public ComboBox cmbrole;
    public AnchorPane root;

    public void initialize() {
        //loadRole();
    }

    private void loadRole() {
        cmbrole.getItems().removeAll(cmbrole.getItems());
        cmbrole.getItems().addAll("Admine", "User");
        cmbrole.getSelectionModel().getSelectedItem();
    }


    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        System.out.println("OK");
        String userName = txtUserName.getText();
        String passWord = txtPassword.getText();
        if (userName.length()>0 && passWord.length()>0) {
            System.out.println("7777777777");
            if (userName.equalsIgnoreCase("Gathsara")
                    && passWord.equals("1234")) {
                System.out.println("88888");
                Stage window = (Stage) this.root.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"))));





            }else {
                if (userName.equalsIgnoreCase("Umesh")
                        && passWord.equals("1234")) {
                    System.out.println("88888");
                    Stage window = (Stage) this.root.getScene().getWindow();
                    window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/AdminDashBordForm.fxml"))));
                }else {
                    new Alert(Alert.AlertType.WARNING, "UserName or Password Empty!", ButtonType.OK).show();
                }
            }
        }else {

            new Alert(Alert.AlertType.WARNING, "UserName or Password Empty!", ButtonType.OK).show();

        }
    }
}