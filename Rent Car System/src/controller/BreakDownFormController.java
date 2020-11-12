package controller;

import bo.BOFactory;
import bo.custom.BreakDownFormBO;
import bo.custom.Impl.BreakDownFormBOImpl;
import bo.custom.Impl.VehicleStaticBOImpl;
import bo.custom.VehicleStaticBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.BreakdownDTO;
import dto.BreakdowndetailsDTO;
import entity.Breakdowndetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.time.LocalDate;
import java.util.ArrayList;

public class BreakDownFormController {

    public JFXTextField txtBreakDownID;
    public JFXComboBox cmbVehicle;
    public JFXDatePicker txtBreateDownDate;
    public JFXComboBox cmbBrokenStatus;
    public TableView tblBreakDown;
    public TableColumn colBreaKDownID;
    public TableColumn colVehicleID;
    public TableColumn colBreaKDownDate;
    public TableColumn colBrokenStatus;
    public JFXButton txtsendOnAction;
    public JFXButton txtClearOnAction;
    ArrayList<BreakdownDTO> breakdown =new ArrayList<>();



    VehicleStaticBO vehicleStaticBO=(VehicleStaticBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VEHICLESTATIC);
    BreakDownFormBO b= (BreakDownFormBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.BREAKDOWNFORM);



    public void initialize(){
        txtsendOnAction.setVisible(false);
        txtClearOnAction.setVisible(false);
        loadVehcile();
        loadVehicleSatud();
        genarateBDID();
    }

    public void AddListONAction(ActionEvent actionEvent) {
        txtsendOnAction.setVisible(true);
        txtClearOnAction.setVisible(true);

        BreakdownDTO breakdownDTO=new BreakdownDTO(txtBreakDownID.getText(),cmbVehicle.getValue()+"",txtBreateDownDate.getValue()+"",cmbBrokenStatus.getValue()+"");
        breakdown.add(breakdownDTO);
        tblBreakDown.getItems().add(breakdownDTO);
        colBreaKDownID.setCellValueFactory(new PropertyValueFactory<>("breakdownID"));
        colVehicleID.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        colBreaKDownDate.setCellValueFactory(new PropertyValueFactory<>("brokenDate"));
        colBrokenStatus.setCellValueFactory(new PropertyValueFactory<>("brokenStatus"));








    }


    public void ClearOnAction(ActionEvent actionEvent) {
    }

    public void sendOnAction(ActionEvent actionEvent) {

        try {
        ArrayList<BreakdownDTO> Bre=new ArrayList<>();


        for (BreakdownDTO brkd :breakdown){
            BreakdownDTO breakdown=new BreakdownDTO(
                    brkd.getBreakdownID(),
                    brkd.getVehicleID(),
                    brkd.getBrokenDate(),
                    brkd.getBrokenStatus()

            );

            System.out.println("change"+breakdown);
            Bre.add(breakdown);
            System.out.println("PaseDate : "+breakdown);

            BreakdowndetailsDTO breakdowndetailsDTO1=new BreakdowndetailsDTO(Bre);




                boolean isAdded=b.addVehicle(breakdowndetailsDTO1);
                if (isAdded){
                    TrayNotification tray=new TrayNotification();
                    tray.setAnimationType(AnimationType.SLIDE);
                    tray.setTitle("Conformation");
                    tray.setMessage("Succed");
                    tray.setNotificationType(NotificationType.SUCCESS);
                    tray.showAndDismiss(Duration.millis(2000));
                }else {
                    TrayNotification tray=new TrayNotification();
                    tray.setAnimationType(AnimationType.SLIDE);
                    tray.setTitle("Conformation");
                    tray.setMessage("Failed");
                    tray.setNotificationType(NotificationType.WARNING);
                    tray.showAndDismiss(Duration.millis(2000));
                }
            }
        } catch (Exception e) {
            TrayNotification tray=new TrayNotification();
            tray.setAnimationType(AnimationType.SLIDE);
            tray.setTitle("Conformation");
            tray.setMessage("You Have And Emty Feild");
            tray.setNotificationType(NotificationType.WARNING);
            tray.showAndDismiss(Duration.millis(2000));
        }








      /*      try {
                boolean isAdded=b.addVehicle(breakdownDTO);
                if (isAdded){
                    TrayNotification tray=new TrayNotification();
                    tray.setAnimationType(AnimationType.SLIDE);
                    tray.setTitle("Conformation");
                    tray.setMessage("Succed");
                    tray.setNotificationType(NotificationType.SUCCESS);
                    tray.showAndDismiss(Duration.millis(2000));

                }else {
                    TrayNotification tray=new TrayNotification();
                    tray.setAnimationType(AnimationType.SLIDE);
                    tray.setTitle("Conformation");
                    tray.setMessage("Failed");
                    tray.setNotificationType(NotificationType.WARNING);
                    tray.showAndDismiss(Duration.millis(2000));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
*/




    }





















    public void loadVehcile(){
        try {
            ArrayList<String> vehicle=vehicleStaticBO.getAllVehicle();
            ObservableList observableList= FXCollections.observableArrayList(vehicle);
            cmbVehicle.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public  void loadVehicleSatud(){
        cmbBrokenStatus.getItems().removeAll(cmbBrokenStatus.getItems());
        cmbBrokenStatus.getItems().addAll("Add To Fix");
        cmbBrokenStatus.getSelectionModel().getSelectedItem();
     }
     public void genarateBDID(){
        String BresakdownID=null;
         try {
             BresakdownID=getBreakdownID();
         } catch (Exception e) {
             e.printStackTrace();
         }
         if (BresakdownID !=null){
             BresakdownID=BresakdownID.split("[A-Z]")[1];
             BresakdownID="B00" + (Integer.parseInt(BresakdownID) + 1);
             txtBreakDownID.setText(BresakdownID);
         }else {
             txtBreakDownID.setText("B001");
         }

     }

     public String getBreakdownID() throws Exception {
        return b.getBreakDownID();
     }
}
