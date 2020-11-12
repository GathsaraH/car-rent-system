package controller;

import bo.BOFactory;
import bo.custom.Impl.VehicleStaticBOImpl;
import bo.custom.VehicleStaticBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.VehicleDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.util.ArrayList;

public class VehicleStaticFormController {
    public JFXTextField txtVehicleID;
    public JFXTextField txtVehicleName;
    public JFXTextField txtVehicleModel;
    public JFXTextField txtVehicleType;
    public JFXTextField txtVehicleColor;
    public JFXComboBox cmbVehicleStatus;

    @FXML
    private TableView<VehicleDTO> tblVehicleStatus;

    @FXML
    private TableColumn<VehicleDTO, String> colVhicleID;

    @FXML
    private TableColumn<VehicleDTO, String> colVehicleName;

    @FXML
    private TableColumn<VehicleDTO, String> colVehiclModel;

    @FXML
    private TableColumn<VehicleDTO, String> colVehicleType;

    @FXML
    private TableColumn<VehicleDTO, String> colVehicleColor;

    @FXML
    private TableColumn<VehicleDTO, String> colVehicleStatus;


    public JFXComboBox cmbVehicleType;
    public JFXComboBox cmbVehicle;

    VehicleStaticBO vehicleStaticBO= (VehicleStaticBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VEHICLESTATIC);

    public void initialize() throws Exception {
        loadvehicleSatus();
        genarateVehicleId();
        vehicleType();
        loadAllVehicle();
        //loadVehicleTable();

        colVhicleID.setCellValueFactory(new PropertyValueFactory<VehicleDTO, String>("id"));
        colVehicleName.setCellValueFactory(new PropertyValueFactory<VehicleDTO, String>("name"));
        colVehicleStatus.setCellValueFactory(new PropertyValueFactory<VehicleDTO, String>("status"));
        colVehiclModel.setCellValueFactory(new PropertyValueFactory<VehicleDTO, String>("model"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<VehicleDTO, String>("type"));
        colVehicleColor.setCellValueFactory(new PropertyValueFactory<VehicleDTO, String>("color"));
        tblVehicleStatus.setItems(loadVehicleTable());




    }


    private ObservableList<VehicleDTO> loadVehicleTable() throws Exception {
        ArrayList<VehicleDTO> all=vehicleStaticBO.getAllVehicleForTable();
        ObservableList<VehicleDTO> dtoObservableList=FXCollections.observableArrayList();
        for (VehicleDTO vehicleDTO:all){
            dtoObservableList.add(new VehicleDTO(vehicleDTO.getId(),
                    vehicleDTO.getName(),
                    vehicleDTO.getStatus(),
                    vehicleDTO.getModel(),
                    vehicleDTO.getType(),
                    vehicleDTO.getColor()));

        }
        return dtoObservableList;
    }

    public void addOnAction(ActionEvent actionEvent) throws Exception {

        InputMap im= (InputMap) UIManager.get("Button.focusInputMap");
        im.put(KeyStroke.getKeyStroke("ENTER"),"pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"),"released");
        String vID=txtVehicleID.getText();
        String vName=txtVehicleName.getText();
        String vStates= (String) cmbVehicleStatus.getValue();
        String vModle=txtVehicleModel.getText();
        String vType= (String) cmbVehicleType.getValue();
        String vColor=txtVehicleColor.getText();
        VehicleDTO vehicleDTO=new VehicleDTO(vID,vName,vStates,vModle,vType,vColor);
        boolean addVehicle=vehicleStaticBO.addVehicle(vehicleDTO);
        if(addVehicle){
            new Alert(Alert.AlertType.CONFIRMATION,"Vehicle Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Failed", ButtonType.OK).show();
        }

    }






   public void VehicleOnAction(ActionEvent actionEvent) {
        String vID= (String) cmbVehicle.getValue();
        try {
            VehicleDTO vehicleDTO=vehicleStaticBO.searchVehicle(vID);
            if(vehicleDTO!=null){
                System.out.println(vehicleDTO);
                txtVehicleID.setText(vehicleDTO.getId());
                txtVehicleName.setText(vehicleDTO.getName());
                cmbVehicleStatus.setValue(vehicleDTO.getStatus());
                txtVehicleModel.setText(vehicleDTO.getModel());
                cmbVehicleType.setValue(vehicleDTO.getType());
                txtVehicleColor.setText(vehicleDTO.getColor());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    public void deleteOnAction(ActionEvent actionEvent) {
        String vID=txtVehicleID.getText();
        try {
            boolean vehicleDTO=vehicleStaticBO.deleteVehicle(vID);
            if (vehicleDTO){
                new Alert(Alert.AlertType.CONFIRMATION,"Sucessed",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateOnAction(ActionEvent actionEvent) {
        String vID=txtVehicleID.getText();
        String vName=txtVehicleName.getText();
        String vStates= (String) cmbVehicleStatus.getValue();
        String vModle=txtVehicleModel.getText();
        String vType= (String) cmbVehicleType.getValue();
        String vColor=txtVehicleColor.getText();

        VehicleDTO vehicleDTO=new VehicleDTO(vID,vName,vStates,vModle,vType,vColor);
        try {
            boolean updateVehicle=vehicleStaticBO.updateVehicle(vehicleDTO);
            if (updateVehicle){
                new Alert(Alert.AlertType.CONFIRMATION,"Added",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Added",ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearOnAction(ActionEvent actionEvent) {

        txtVehicleID.setText("");
        txtVehicleName.setText("");
        cmbVehicleStatus.setValue("");
        txtVehicleModel.setText("");
        cmbVehicleType.setValue("");
        txtVehicleColor.setText("");
    }

    public void loadvehicleSatus(){
        cmbVehicleStatus.getItems().removeAll(cmbVehicleStatus.getItems());
        cmbVehicleStatus.getItems().addAll("Good", "OnUse");
        cmbVehicleStatus.getSelectionModel().getSelectedItem();
    }
    public void genarateVehicleId(){
        String lastVehicleid=null;
        try {
            lastVehicleid = lastVehicleID();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(lastVehicleid !=null){
            lastVehicleid = lastVehicleid.split("[A-Z]")[1];
            lastVehicleid = "V0" + (Integer.parseInt(lastVehicleid) + 1);
            txtVehicleID.setText(lastVehicleid);
        }else {
            txtVehicleID.setText("V001");
        }
    }

    public String lastVehicleID() throws Exception {

        return vehicleStaticBO.lastVehicleID();
    }

    public void vehicleType(){
        cmbVehicleType.getItems().removeAll(cmbVehicleType.getItems());
        cmbVehicleType.getItems().addAll("Car","Van","Bus","Bike");
        cmbVehicleType.getSelectionModel().getSelectedItem();
    }

    public void loadAllVehicle(){
        try {
            ArrayList<String > vehicleList=vehicleStaticBO.getAllVehicle();
            ObservableList observableList= FXCollections.observableList(vehicleList);
            cmbVehicle.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }










}
