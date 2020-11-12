package controller;

import bo.BOFactory;
import bo.custom.Impl.UsersStaticBOImpl;
import bo.custom.UsersStaticBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.SystemDAO;
import dto.SystemDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import sun.security.timestamp.TSRequest;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.util.ArrayList;

public class UsersStaticFormController {
    public JFXTextField txtUserID;
    public JFXTextField txtUserName;
    public JFXTextField txtUserAddress;
    public JFXTextField txtUserTNumber;
    public JFXTextField txtUserPassword;
    public JFXTextField txtUserEmail;

    public TableView<SystemDTO> tblUserDetails;
    public TableColumn<SystemDTO,String> colUserName;
    public TableColumn<SystemDTO,String> colUserId;
    public TableColumn<SystemDTO,String> colUserAddress;
    public TableColumn <SystemDTO,String>colUserRNumber;
    public TableColumn <SystemDTO,String>colUserPassword;
    public TableColumn<SystemDTO,String> colUserEmail;

    public JFXComboBox cmbselectUser;

    UsersStaticBO usersStaticBO= (UsersStaticBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.USERSSTATIC);


    public void initialize() throws Exception {
        genarateUserID();
        loadUserID();

        colUserId.setCellValueFactory(new PropertyValueFactory<SystemDTO,String>("systemID"));
        colUserName.setCellValueFactory(new PropertyValueFactory<SystemDTO,String>("systemName"));
        colUserAddress.setCellValueFactory(new PropertyValueFactory<SystemDTO,String>("systemAddress"));
        colUserRNumber.setCellValueFactory(new PropertyValueFactory<SystemDTO,String>("systemNumber"));
        colUserEmail.setCellValueFactory(new PropertyValueFactory<SystemDTO,String>("systemEmail"));
        colUserPassword.setCellValueFactory(new PropertyValueFactory<SystemDTO,String>("systemPassword"));
        tblUserDetails.setItems(loadTable());
    }


    public ObservableList<SystemDTO> loadTable() throws Exception {
        ArrayList<SystemDTO>all=usersStaticBO.loadUserTable();
        ObservableList<SystemDTO> observableList=FXCollections.observableArrayList();
            for (SystemDTO systemDTO:all){
              observableList.add(new SystemDTO(
              systemDTO.getSystemID(),
              systemDTO.getSystemName(),
              systemDTO.getSystemAddress(),
              systemDTO.getSystemNumber(),
              systemDTO.getSystemEmail(),
              systemDTO.getSystemPassword()
      ));
                System.out.println(systemDTO);
            }
    return observableList;
}

    public void addOnAction(ActionEvent actionEvent) {
        String systemID = txtUserID.getText();
        String systemName=txtUserName.getText();
        String systemAddress=txtUserAddress.getText();
        String systemNumber=txtUserTNumber.getText();
        String systemEmail=txtUserEmail.getText();
        String systemPassword=txtUserPassword.getText();
        SystemDTO systemDTO=new SystemDTO(systemID,systemName,systemAddress,systemNumber,systemEmail,systemPassword);

        try {
            boolean issAdded=usersStaticBO.addUser(systemDTO);
            if (issAdded){
                TrayNotification tray=new TrayNotification();
                tray.setAnimationType(AnimationType.FADE);
                tray.setTitle("Conformation");
                tray.setMessage("Succed");
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(2000));
            }else {
                TrayNotification tray=new TrayNotification();
                tray.setAnimationType(AnimationType.FADE);
                tray.setTitle("Failed");
                tray.setMessage("Failed");
                tray.setNotificationType(NotificationType.WARNING);
                tray.showAndDismiss(Duration.millis(2000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String systemID=cmbselectUser.getValue()+"";
        try {
            boolean isDelete=usersStaticBO.deleteUser(systemID);
            if (isDelete){
                TrayNotification tray=new TrayNotification();
                tray.setAnimationType(AnimationType.FADE);
                tray.setTitle("Conformation");
                tray.setMessage("Succed");
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(2000));
            }else {
                TrayNotification tray=new TrayNotification();
                tray.setAnimationType(AnimationType.FADE);
                tray.setTitle("Failed");
                tray.setMessage("Failed");
                tray.setNotificationType(NotificationType.WARNING);
                tray.showAndDismiss(Duration.millis(2000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        String systemID = txtUserID.getText();
        String systemName=txtUserName.getText();
        String systemAddress=txtUserAddress.getText();
        String systemNumber=txtUserTNumber.getText();
        String systemEmail=txtUserEmail.getText();
        String systemPassword=txtUserPassword.getText();
        SystemDTO systemDTO=new SystemDTO(systemID,systemName,systemAddress,systemNumber,systemEmail,systemPassword);

        try {
            boolean isUpdate=usersStaticBO.updateUsers(systemDTO);
            if (isUpdate){
                TrayNotification tray=new TrayNotification();
                tray.setAnimationType(AnimationType.FADE);
                tray.setTitle("Conformation");
                tray.setMessage("Succed");
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(2000));
            }else {
                TrayNotification tray=new TrayNotification();
                tray.setAnimationType(AnimationType.FADE);
                tray.setTitle("Failed");
                tray.setMessage("Failed");
                tray.setNotificationType(NotificationType.WARNING);
                tray.showAndDismiss(Duration.millis(2000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearOnAction(ActionEvent actionEvent) {
        txtUserID.setText(" ");
        txtUserAddress.setText(" ");
        txtUserEmail.setText(" ");
        txtUserPassword.setText(" ");
        txtUserTNumber.setText(" ");
        txtUserName.setText(" ");
        cmbselectUser.setValue( " ");
    }

    public void cmbselectUserOnAction(ActionEvent actionEvent) {
        String systemID=cmbselectUser.getValue()+"";
        try {
            SystemDTO systemDTO=usersStaticBO.serchUser(systemID);
            if (systemDTO!=null){
                txtUserID.setText(systemDTO.getSystemID());
                txtUserName.setText(systemDTO.getSystemName());
                txtUserAddress.setText(systemDTO.getSystemAddress());
                txtUserTNumber.setText(systemDTO.getSystemNumber());
                txtUserEmail.setText(systemDTO.getSystemEmail());
                txtUserPassword.setText(systemDTO.getSystemPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void genarateUserID(){
        String userid=null;
        try {
            userid=usersStaticBO.genaretaUserID();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userid !=null){
            userid=userid.split("[A-Z]")[1];
            userid="U00" + (Integer.parseInt(userid)+1);
            txtUserID.setText(userid);
        }else {
            txtUserID.setText("U001");
        }
    }



    public  void loadUserID(){
        try {
            ArrayList<String> list=usersStaticBO.getAllUseID();
            ObservableList observableList= FXCollections.observableArrayList(list);
            cmbselectUser.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
