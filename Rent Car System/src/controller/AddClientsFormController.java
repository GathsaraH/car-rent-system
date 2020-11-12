package controller;

import bo.BOFactory;
import bo.custom.AddClientsBO;
import bo.custom.Impl.AddClientsBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import dto.VehicleDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class AddClientsFormController {
    //public JFXTextField txtCustomerID;
   // public JFXTextField txtCustomerName;
    //public JFXTextField txtCustomerAddress;
    //public JFXTextField txtCustomerTPNumber;
    
    
    public TableView<CustomerDTO> tblCustomer;
    public TableColumn<CustomerDTO,String> colCustomerID;
    public TableColumn<CustomerDTO,String>  colCustomerName;
    public TableColumn <CustomerDTO,String> colCustomerAddress;
    public TableColumn<CustomerDTO,String>  colCustomerTPNumber;
    //public JFXComboBox cmbCustomerID;
    public JFXButton txtaddcustomerOnAction;
    public JFXButton txtdeletecustomerOnAction;
    public JFXButton txtupdatecustomerOnAction;
    public JFXButton txtclearcustomerOnAction;
    public TextField txtCustomerTPNumber;
    public TextField txtCustomerAddress;
    public TextField txtCustomerName;
    public TextField txtCustomerID;
    public ComboBox cmbCustomerID;

    
    ArrayList<CustomerDTO> custome=new ArrayList<>();


    AddClientsBO addClientsBO= (AddClientsBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.ADDCLIENTS);



    public void initialize(){
        genarateLadtClintsID();
        //customeidLoad();
  /*      txtaddcustomerOnAction.setVisible(false);
        txtclearcustomerOnAction.setVisible(false);
        txtdeletecustomerOnAction.setVisible(false);
        txtupdatecustomerOnAction.setVisible(false);
*/


    }

    public ObservableList<CustomerDTO> loadTable(){
        try {
            ArrayList<CustomerDTO> list=addClientsBO.getAllClientsForTable();
            ObservableList<CustomerDTO> observableList=FXCollections.observableArrayList();
            for (CustomerDTO c:list){
                c.getCustomerName();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }




    public void CustomerIdOnAction(ActionEvent actionEvent) throws Exception {

    }

    public void addcustomerOnAction(ActionEvent actionEvent) {

        try {
        String cID=txtCustomerID.getText();
        String cAddress=txtCustomerAddress.getText();
        String cName=txtCustomerName.getText();
        String cNumber=txtCustomerTPNumber.getText();
        CustomerDTO customerDTO=new CustomerDTO(cID,cAddress,cName,cNumber);


         boolean addClients=addClientsBO.addClients(customerDTO);
            if (addClients){
                new Alert(Alert.AlertType.CONFIRMATION,"AddedSucced", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"AddedFailed", ButtonType.OK).show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING,"You Have An Emty Feild", ButtonType.OK).show();
        }

    }

    public void deletecustomerOnAction(ActionEvent actionEvent) {

        String cID=txtCustomerID.getText();
        try {
            boolean  customerDTO=addClientsBO.deleteClients(cID);
            if (customerDTO){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Suceed",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Delete Suceed",ButtonType.OK).show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updatecustomerOnAction(ActionEvent actionEvent) {
        String cID=txtCustomerID.getText();
        String cAddress=txtCustomerAddress.getText();
        String cName=txtCustomerName.getText();
        String cNumber=txtCustomerTPNumber.getText();
        CustomerDTO  customerDTO=new CustomerDTO(cID,cAddress,cName,cNumber);

        try {
            boolean updateCustomer=addClientsBO.updateClients(customerDTO);
            if (updateCustomer){
                new Alert(Alert.AlertType.CONFIRMATION,"UpdateSuceed",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Faild",ButtonType.OK).show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearcustomerOnAction(ActionEvent actionEvent) {
        txtCustomerID.setText("");
        txtCustomerAddress.setText("");
        txtCustomerName.setText("");
        txtCustomerTPNumber.setText("");
        genarateLadtClintsID();

    }

    public void genarateLadtClintsID(){

        String lastClinerts=null;
        try {
            lastClinerts = lastClientsID();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(lastClinerts !=null){
            lastClinerts = lastClinerts.split("[A-Z]")[1];
            lastClinerts = "C00" + (Integer.parseInt(lastClinerts) + 1);
            txtCustomerID.setText(lastClinerts);
        }else {
            txtCustomerID.setText("C001");
        }

    }

    public String lastClientsID() throws Exception {
        return   addClientsBO.lastClientsID();

    }

    public  void customeidLoad(){
        try {
            ArrayList<String> list=addClientsBO.getAllClients();
            ObservableList observableList= FXCollections.observableArrayList(list);
            cmbCustomerID.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cmbCustomerIDOnAction(ActionEvent actionEvent) {
        String cID= (String) cmbCustomerID.getValue();

        try {
            CustomerDTO customerDTO=addClientsBO.searchClients(cID);
            if (customerDTO!=null){
                txtCustomerID.setText(customerDTO.getCustomerID());
                txtCustomerAddress.setText(customerDTO.getCustomerAddress());
                txtCustomerName.setText(customerDTO.getCustomerName());
                txtCustomerTPNumber.setText(customerDTO.getCustomertpNumber());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void custnameOnKey(InputMethodEvent inputMethodEvent) {
    }


    public void addtolistOnAction(ActionEvent actionEvent) {
        txtaddcustomerOnAction.setVisible(true);
        txtclearcustomerOnAction.setVisible(true);
        txtdeletecustomerOnAction.setVisible(true);
        txtupdatecustomerOnAction.setVisible(true);

        CustomerDTO customerDTO=new CustomerDTO(txtCustomerID.getText(),txtCustomerName.getText(),txtCustomerAddress.getText(),txtCustomerTPNumber.getText());
        custome.add(customerDTO);
        tblCustomer.getItems().add(customerDTO);


        colCustomerID.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String >("customerID"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("customerName"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("customerAddress"));
        colCustomerTPNumber.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("customertpNumber"));






    }

    public void customeridOnKeyRelese(KeyEvent keyEvent) {
    }



    public void custnameOnKeyRelese(KeyEvent keyEvent) {

        //txtCustomerAddress.requestFocus();
    }

    public void custaddressOnKeyReles(KeyEvent keyEvent) {

       // txtCustomerTPNumber.requestFocus();
    }
}
