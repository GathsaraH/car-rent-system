package controller;

import bo.BOFactory;
import bo.custom.AddClientsBO;
import bo.custom.Impl.AddClientsBOImpl;
import bo.custom.Impl.RentFormBOImpl;
import bo.custom.Impl.VehicleStaticBOImpl;
import bo.custom.RentFormBO;
import bo.custom.VehicleStaticBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.CustomDTO;
import dto.CustomerDTO;
import dto.RentDTO;
import dto.RentdtailsDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class RentFormController {
    public JFXComboBox cmbCustomer;
    public JFXTextField txtRentID;
    public JFXTextField txtCustomerName;
    public JFXDatePicker txtRentDate;
    public JFXComboBox cmbVehicle;
    public JFXTextField txtChargePerday;
    public JFXComboBox cmbRentStatus;

    public TableView<RentdtailsDTO> tblRentForm;
    public TableColumn<RentdtailsDTO, String> colCustomerName;
    public TableColumn<RentdtailsDTO, String> colRentID;
    public TableColumn<RentdtailsDTO, String> colRentDate;
    public TableColumn<RentdtailsDTO, String> colVehicle;
    public TableColumn<RentdtailsDTO, String> colAdvance;
    public TableColumn<RentdtailsDTO, String> colRentStatus;

    public JFXTextField txtRentAdvance;
    public Label txtcmbRents;
    public JFXButton txtrentOnAction;
    public JFXButton txtcancelOnAction;
    public JFXButton txtclearOnAction;
    public TableColumn colChargePerDay;
    public AnchorPane root;
    public JFXDatePicker txtReturnDate;
    public JFXTextField txtSerchRents;
    public JFXTextField txtCSerch;

    RentFormBO rentFormBO = (RentFormBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.RENTFORM);
    AddClientsBO addClientsBO = (AddClientsBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.ADDCLIENTS);
    VehicleStaticBO vehicleStaticBO = (VehicleStaticBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VEHICLESTATIC);

    ArrayList<RentdtailsDTO> rentdtailsDTOS = new ArrayList<>();

    public void initialize() {
        //loadCustomer();
        genarateRendID();
        loadVehicleId();
        rentStatus();
        txtrentOnAction.setVisible(false);
        //txtcancelOnAction.setVisible(false);
        txtclearOnAction.setVisible(false);

    }

/*
    public void cmbCustomerOnAction(ActionEvent actionEvent) {
        String cID = (String) cmbCustomer.getValue();
        try {
            CustomerDTO customerDTO = addClientsBO.searchClients(cID);
            if (customerDTO != null) {
                txtCustomerName.setText(customerDTO.getCustomerName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
*/

    public void cmbVehicleOnAction(ActionEvent actionEvent) {

    }

    public void txtRentAdvance(ActionEvent actionEvent) {
    }

    public void cmbRentStatusOnAction(ActionEvent actionEvent) {
    }

    public void rentOnAction(ActionEvent actionEvent) {
        try {
        String rentId = txtRentID.getText();
        String custId = txtCSerch.getText();
        String custName = txtCustomerName.getText();
        String vehicle = (String) cmbVehicle.getValue();
        String returnDAte = txtReturnDate.getValue() + "";
        ArrayList<RentdtailsDTO> dtos = new ArrayList<>();

            for (RentdtailsDTO c : rentdtailsDTOS) {
                RentdtailsDTO rentdtailsDTO = new RentdtailsDTO(
                        c.getRentID(),
                        c.getRentDate(),
                        c.getVehicleID(),
                        c.getChargePerday(),
                        c.getRentAdvance(),
                        c.getRentStatus()
                );
                dtos.add(rentdtailsDTO);
                System.out.println(c.getRentDate());
                System.out.println("Charge per Date : " + c.getChargePerday());
                System.out.println(" id " + c.getVehicleID());
            }
            RentDTO rentDTO = new RentDTO(rentId, custId, custName, vehicle, returnDAte, dtos);
            System.out.println("rent DTO : " + rentDTO);

            boolean isAdded = addRent(rentDTO);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Added Success", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Added UnSuccesss", ButtonType.OK).show();
            }

            printReport();

        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "You Have An Emty Feild", ButtonType.OK).show();

           // e.printStackTrace();
        }



    }

    private boolean addRent(RentDTO rentDTO) throws Exception {
        return rentFormBO.addRent(rentDTO);
    }

    public void cancelOnAction(ActionEvent actionEvent) {
    }

    public void clearOnAction(ActionEvent actionEvent) {
    }

/*    public void loadCustomer() {
        try {
            ArrayList<String> list = addClientsBO.getAllClients();
            ObservableList observableList = FXCollections.observableArrayList(list);
            cmbCustomer.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void genarateRendID() {
        String lastRentID = null;
        try {
            lastRentID = lastRentID();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (lastRentID != null) {
            lastRentID = lastRentID.split("[A-Z]")[1];
            lastRentID = "R00" + (Integer.parseInt(lastRentID) + 1);
            txtRentID.setText(lastRentID);
        } else {
            txtRentID.setText("R001");
        }

    }

    public String lastRentID() throws Exception {
        return rentFormBO.lastRentID();
    }

    public void loadVehicleId() {
        try {
            ArrayList<String> list = vehicleStaticBO.getAllVehicleFromStatus();
            ObservableList observableList = FXCollections.observableArrayList(list);
            cmbVehicle.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rentStatus() {
        cmbRentStatus.getItems().removeAll(cmbRentStatus.getItems());
        cmbRentStatus.getItems().addAll("Complete", "Cancel");
        cmbRentStatus.getSelectionModel().getSelectedItem();
    }

    public void deletecomformOnAction(ActionEvent actionEvent) {
        //  CustomDTO c =new CustomDTO(txtCustomerName.getText(),txtRentID.getText(),txtRentDate.getValue()+"",cmbVehicle.getValue()+"",Double.parseDouble(txtRentAdvance.getText()),cmbRentStatus.getValue()+"");

        RentdtailsDTO rentdtailsDTO = tblRentForm.getSelectionModel().getSelectedItem();
        tblRentForm.getItems().remove(rentdtailsDTO);


    }

    public void AddcomformOnAction(ActionEvent actionEvent) {
        try {



        RentdtailsDTO c = new RentdtailsDTO(txtCustomerName.getText(), txtRentID.getText(), txtRentDate.getValue() + "", cmbVehicle.getValue() + "", Double.parseDouble(txtChargePerday.getText()), Double.parseDouble(txtRentAdvance.getText()), cmbRentStatus.getValue() + "");
//        tblRentForm.getItems().clear();
        rentdtailsDTOS.add(c);
        tblRentForm.getItems().add(c);
        colCustomerName.setCellValueFactory(new PropertyValueFactory<RentdtailsDTO, String>("custName"));
        colRentID.setCellValueFactory(new PropertyValueFactory<RentdtailsDTO, String>("rentID"));
        colRentDate.setCellValueFactory(new PropertyValueFactory<RentdtailsDTO, String>("rentDate"));
        colVehicle.setCellValueFactory(new PropertyValueFactory<RentdtailsDTO, String>("vehicleID"));
        colChargePerDay.setCellValueFactory(new PropertyValueFactory<RentdtailsDTO, String>("chargePerday"));
        colAdvance.setCellValueFactory(new PropertyValueFactory<RentdtailsDTO, String>("rentAdvance"));
        colRentStatus.setCellValueFactory(new PropertyValueFactory<RentdtailsDTO, String>("rentStatus"));


        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING, "You Have An Emty Feild", ButtonType.OK).show();
        }

    }


    public void cmbRentsOnAction(MouseEvent mouseEvent) {

    }

//    double chargePerday = Double.parseDouble(txtChargePerday.getText());
//    double chargePerday = Double.parseDouble(txtChargePerday.getText());

    public void comformOnAction(ActionEvent actionEvent) {
        try {
            txtrentOnAction.setVisible(true);
//          txtcancelOnAction.setVisible(true);
            txtclearOnAction.setVisible(true);


            String rentID = txtRentID.getText();
            String customerID = txtCSerch.getText();
            String rentcustName = txtCustomerName.getText();
            double chargePerday = Double.parseDouble(txtChargePerday.getText());

            ObservableList<RentdtailsDTO> rentdtailsDTOS = FXCollections.observableArrayList();
            for (int i = 0; i < tblRentForm.getSelectionModel().getTableView().getItems().size(); i++) {

                //String id= colVehicle.
                double rentAdvance = Double.parseDouble(txtRentAdvance.getText());
                String rentStatus = (String) cmbRentStatus.getValue();
                LocalDate rentDate = txtRentDate.getValue();

            }
        } catch (NumberFormatException ex) {
        }
    }

    public void txtSerchRentsOnAction(ActionEvent actionEvent) {
    }

    public void txtCSerchOnAction(ActionEvent actionEvent) {
        String cID = txtCSerch.getText();
        try {
            CustomerDTO customerDTO = addClientsBO.searchClients(cID);
            if (customerDTO != null) {
                txtCustomerName.setText(customerDTO.getCustomerName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  void printReport(){
        try {
            InputStream is =this.getClass().getResourceAsStream("/report/SanaraRentCar.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);
            HashMap hs=new HashMap();
            hs.put("Rent Id",txtRentID.getText());
            hs.put("Rent Date",txtRentDate.getValue()+"");
            hs.put("Return Date",txtReturnDate.getValue()+"");
            hs.put("Vehicle Id",cmbVehicle.getValue()+"");
            hs.put("Charge Per Day",txtChargePerday.getText());
            hs.put("Advance",txtRentAdvance.getText());
            JasperPrint jp= JasperFillManager.fillReport(jr,hs, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
