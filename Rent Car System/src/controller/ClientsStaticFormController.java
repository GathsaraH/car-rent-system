package controller;

import bo.BOFactory;
import bo.custom.AddClientsBO;
import bo.custom.Impl.AddClientsBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ClientsStaticFormController {
    public JFXTextField txtCustomerID;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAddress;
    public JFXTextField txtCustomerTPNumber;
    public JFXButton txtaddcustomerOnAction;

    public TableView tblCustomer;
    public TableColumn colCustomerID;
    public TableColumn colCustomerName;
    public TableColumn colCustomerAddress;
    public TableColumn colCustomerTPNumber;

    public JFXButton txtdeletecustomerOnAction;
    public JFXButton txtupdatecustomerOnAction;
    public JFXButton txtclearcustomerOnAction;
    public JFXComboBox cmbCustomerID;

    AddClientsBO addClientsBO= (AddClientsBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.ADDCLIENTS);

    public  void initialize() throws Exception {
        loadAllCustomer();

        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        colCustomerTPNumber.setCellValueFactory(new PropertyValueFactory<>("customertpNumber"));
        tblCustomer.setItems(loadCustomer());

    }


    public ObservableList<CustomerDTO> loadCustomer() throws Exception {
        ArrayList<CustomerDTO> all=addClientsBO.getAllClientsForTable();
        ObservableList observableList= FXCollections.observableArrayList();
        for (CustomerDTO c:all){
           observableList.add(new CustomerDTO(
                   c.getCustomerID(),
                   c.getCustomerName(),
                   c.getCustomerAddress(),
                   c.getCustomertpNumber()
           ));

        }
        return observableList;
    }



    public void CustomerIdOnAction(ActionEvent actionEvent) {

    }

    public void addcustomerOnAction(ActionEvent actionEvent) {
    }

    public void deletecustomerOnAction(ActionEvent actionEvent) {

    }

    public void updatecustomerOnAction(ActionEvent actionEvent) {
    }

    public void clearcustomerOnAction(ActionEvent actionEvent) {
    }

    public void cmbCustomerIDOnAction(ActionEvent actionEvent) {
        String customerID=cmbCustomerID.getValue()+"";
        try {
            CustomerDTO customerDTO=addClientsBO.searchClients(customerID);
            if (customerDTO!=null){
                txtCustomerID.setText(customerDTO.getCustomerID());
                txtCustomerName.setText(customerDTO.getCustomerName());
                txtCustomerAddress.setText(customerDTO.getCustomerAddress());
                txtCustomerTPNumber.setText(customerDTO.getCustomertpNumber());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void addtolistOnAction(ActionEvent actionEvent) {
    }


    public void loadAllCustomer(){
        try {
            ArrayList<String> all=addClientsBO.getAllClients();
            ObservableList observableList=FXCollections.observableArrayList(all);
            cmbCustomerID.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
