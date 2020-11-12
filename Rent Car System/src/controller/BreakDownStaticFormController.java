package controller;

import bo.BOFactory;
import bo.custom.BreakDownFormBO;
import bo.custom.BreakDownStaticFormBO;
import bo.custom.Impl.BreakDownFormBOImpl;
import bo.custom.Impl.BreakDownStaticFormBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.BreakdowndetailsDTO;
import dto.VehicleDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class BreakDownStaticFormController {
    public TableView<BreakdowndetailsDTO> tblBreakdownDetails;
    public TableColumn <BreakdowndetailsDTO,String> colBreakdownID;
    public TableColumn <BreakdowndetailsDTO,String> colVehicleID;
    public TableColumn <BreakdowndetailsDTO,String> colBrokenDate;
    public TableColumn <BreakdowndetailsDTO,String> colBreakdownStatus;



    public TableColumn colFixDate;
    public JFXComboBox cmbBreakdID;
    public JFXTextField txtVehicleID;
    public JFXTextField txtBrokenDate;
    public JFXDatePicker txtFixDate;
    public JFXComboBox cmbBreakdownStatus;
    public JFXComboBox cmbVehicleID;
    public JFXTextField txtBreakdownID;
    public JFXTextField test;
    public JFXComboBox test2;

    BreakDownStaticFormBO breakDownStaticFormBO= (BreakDownStaticFormBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.BREAKDOWNSTATICFORM);


    public void initialize() throws Exception {
        loadVehicleNumber();
        loadCombo();
        colBreakdownID.setCellValueFactory(new PropertyValueFactory<BreakdowndetailsDTO,String>("breakdowndID"));
        colVehicleID.setCellValueFactory(new PropertyValueFactory<BreakdowndetailsDTO,String>("vehicleID"));
        colBrokenDate.setCellValueFactory(new PropertyValueFactory<BreakdowndetailsDTO,String>("brokenDate"));
        colBreakdownStatus.setCellValueFactory(new PropertyValueFactory<BreakdowndetailsDTO,String>("breakdownStatus"));
        tblBreakdownDetails.setItems(loadTable());

    }



    private ObservableList <BreakdowndetailsDTO> loadTable() throws Exception {
        ArrayList<BreakdowndetailsDTO> all=breakDownStaticFormBO.loadVehicle();
        ObservableList<BreakdowndetailsDTO>observableList= FXCollections.observableArrayList();
        for (BreakdowndetailsDTO breakdowndetailsDTO:all){
            observableList.add(new BreakdowndetailsDTO(
               breakdowndetailsDTO.getBreakdowndID(),
               breakdowndetailsDTO.getVehicleID(),
               breakdowndetailsDTO.getBreakdownStatus(),
               breakdowndetailsDTO.getBrokenDate()
            ));
        }

        return observableList;
    }



    public void loadVehicleNumber(){
        try {
            ArrayList<String> loadVehicleID=breakDownStaticFormBO.loadVehicleID();
            ObservableList observableList=FXCollections.observableArrayList(loadVehicleID);
            cmbVehicleID.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public  void loadCombo(){
        cmbBreakdownStatus.getItems().removeAll(cmbBreakdownStatus.getItems());
        cmbBreakdownStatus.getItems().addAll("Fixed");
        cmbBreakdownStatus.getSelectionModel().getSelectedItem();

    }










    public void cmbVehicleIDOnAction(ActionEvent actionEvent) {
        String vehicleID=cmbVehicleID.getValue()+"";

        try {
            BreakdowndetailsDTO breakdowndetailsDTO=breakDownStaticFormBO.searchDown(vehicleID);
            System.out.println("check 01"+breakdowndetailsDTO);
            if (breakdowndetailsDTO!=null){

                txtBreakdownID.setText(breakdowndetailsDTO.getBreakdowndID());
                txtBrokenDate.setText(breakdowndetailsDTO.getBrokenDate());
                test.setText(breakdowndetailsDTO.getBreakdownStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


















    public void fixOnAction(ActionEvent actionEvent) {

        String vehilceid=cmbVehicleID.getValue()+"";
        String brkndate = txtBrokenDate.getText();
        String brkid = txtBreakdownID.getText();
        String bstatus= cmbBreakdownStatus.getValue()+"";


        BreakdowndetailsDTO breakdowndetailsDTO=new BreakdowndetailsDTO(vehilceid,brkndate,brkid,bstatus);

        try {
            boolean isUpdate=breakDownStaticFormBO.updateBDown(breakdowndetailsDTO);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Added", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }












    public void clearOnAction(MouseEvent mouseEvent) {

    }
































    public void BreakdownSatusOnAction(ActionEvent actionEvent) {

    }



    public void fixvehicleOnAction(MouseEvent mouseEvent) {
    }



}
