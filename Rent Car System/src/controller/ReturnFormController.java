package controller;

import bo.BOFactory;
import bo.custom.Impl.PaymenBOImpl;
import bo.custom.Impl.RentFormBOImpl;
import bo.custom.Impl.ReturnFormBOImpl;
import bo.custom.Impl.ReturnsBOImpl;
import bo.custom.PaymenBO;
import bo.custom.RentFormBO;
import bo.custom.ReturnFormBO;
import bo.custom.ReturnsBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import entity.CustomEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ReturnFormController {

    public JFXComboBox cmbVehicleNumber;
    public JFXTextField txtCustomerName;
    public JFXTextField txtTentId;
    public JFXTextField txtRentDate;
    public JFXDatePicker txtReturnDate;
    public JFXTextField txtChargePerDay;
    public JFXTextField txtAdvance;
    public JFXTextField txtTotalcost;
    public JFXTextField txtCash;
    public JFXTextField txtBalance;

    public TableView <PaymentDTO> tblReturn;
    public TableColumn <PaymentDTO,String> colRentID;
    public TableColumn <PaymentDTO,String> colCustomerName;
    public TableColumn <PaymentDTO,String> colVehicleNumber;
    public TableColumn <PaymentDTO,String> colRentDate;
    public TableColumn <PaymentDTO,String> colReturnDate;
    public TableColumn <PaymentDTO,String> colTotalCoust;
    public TableColumn <PaymentDTO,String> colChargers;
    public TableColumn <PaymentDTO,String> colAdvance;


    public JFXTextField txtCustomerID;
    public JFXButton txtReturnOnAction;
    public JFXButton txtComformOnAction;
    public JFXButton txtclearOnAction;
    public AnchorPane root;
    public Label txtReturnID;
    public JFXComboBox cmbrentID;
    public JFXTextField txtvehicleID;
    //public JFXTextField txtPaymentid;
    public JFXComboBox cmbVehicleID;
    public JFXTextField txtRentID;
    public JFXTextField txtReturnID2;
    public JFXTextField txtSerchReturnDate;
    public JFXTextField txtCustomerName1;
    public JFXTextField txtSerch;
    public JFXTextField txtSerch1;

    ReturnFormBO returnFormBO = (ReturnFormBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.RETURNSFORM);
    RentFormBO rentFormBO = (RentFormBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.RENTFORM);

    ArrayList<CustomDTO>customDTOS=new ArrayList<>();
    ArrayList<PaymentDTO>paymetFroTable=new ArrayList<>();

    PaymenBO paymenBO= (PaymenBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.PAYMENT);
    ReturnsBO returnsBO= (ReturnsBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.RETURNS);
   // ArrayList<PaymentDTO> paymentDTO=new ArrayList<>();

    public void initialize() {
        txtReturnOnAction.setVisible(false);
        txtclearOnAction.setVisible(false);
      //  txtPaymentid.setVisible(true);
        loadVehicle();
        genarateReturndID();
       // getPayID();
    }

    public void returnOnAction(ActionEvent mouseEvent) throws Exception {


    }

    private boolean addReturds(ReturndtailsDTO returndtailsDTO) throws Exception {
//        return returndtailsDTOS.add(returndtailsDTO);
        return  returnFormBO.addreturn(returndtailsDTO);
    }

    public void clearOnAction(ActionEvent mouseEvent) {
    }

    public void txtCashOnAction(ActionEvent actionEvent) {
        double cahs = Double.parseDouble(txtTotalcost.getText());
        double serchcash = Double.parseDouble(txtCash.getText());
        if (cahs<serchcash){
            String finish=String.valueOf(serchcash-cahs);
            txtBalance.setText(finish);
        }else {
            new Alert(Alert.AlertType.WARNING,"Not Enough Money", ButtonType.OK).show();
        }

    }

    public void ComformOnAction(ActionEvent actionEvent) {
        txtReturnOnAction.setVisible(true);
        txtclearOnAction.setVisible(true);
        //txtPaymentid.setVisible(true);
    }

    public void ReturnOnAction(ActionEvent actionEvent) {
        try {
        String returnID = txtReturnID2.getText();
        String rentID = txtTentId.getText();
        String custId = txtCustomerID.getText();
        String rentDate = txtRentDate.getText();
        String vehicleID = cmbVehicleID.getValue() + "";
        String returnDate = txtReturnDate.getValue() + "";
        double chargePerday = Double.parseDouble(txtChargePerDay.getText());
        double advance = Double.parseDouble(txtAdvance.getText());
        ArrayList<PaymentDTO> a = new ArrayList<>();




            for (PaymentDTO r : paymetFroTable) {
                PaymentDTO paymen = new PaymentDTO(
                        r.getReturnID(),
                        r.getCustomerID(),
                        r.getVehicleID(),
                        r.getPayDate(),
                        r.getPayment(),
                        r.getRentDate(),
                        r.getChargePerday(),
                        r.getRentAdvance()
                );
//          System.out.println(r.getReturnID());
                a.add(paymen);
//
            }
            System.out.println("Table Load :"+a);

            ReturnsDTO returnsDTO=new ReturnsDTO(returnID,rentID,custId,returnDate,a);


//            System.out.println("Big Check :"+returnsDTO);


        boolean isAdded = returnsBO.addReturns(returnsDTO);
            System.out.println(isAdded);

        if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Added",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Failed",ButtonType.OK).show();
            }




        } catch (Exception e) {
           new Alert(Alert.AlertType.WARNING,"Emty",ButtonType.OK).show();
//            System.out.println("e : "+e);
        }
    }
    public void addOnAction(ActionEvent actionEvent) {
       try {



        PaymentDTO r=new PaymentDTO(txtReturnID2.getText(),txtCustomerID.getText(),cmbVehicleID.getValue()+"",txtRentDate.getText(),
                txtReturnDate.getValue()+"",Double.parseDouble(txtTotalcost.getText()),Double.parseDouble(txtChargePerDay.getText()),
                Double.parseDouble(txtAdvance.getText()));
//        System.out.println("ForTable : "+r);
        paymetFroTable.add(r);
//        System.out.println(paymetFroTable);
        tblReturn.getItems().add(r);
        colRentID.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("returnID"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("customerID"));
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("vehicleID"));
        colRentDate.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("rentDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("payDate"));
        colTotalCoust.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("payment"));
        colChargers.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("chargePerday"));
        colAdvance.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("rentAdvance"));

       }catch (Exception e){
           new Alert(Alert.AlertType.WARNING,"Have An Emty Feild",ButtonType.OK).show();
       }


    }



    public void genarateReturndID() {
        String lastReturntID = null;
        try {
            lastReturntID = lastReturntID();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (lastReturntID != null) {
            lastReturntID = lastReturntID.split("[A-Z]")[1];
            lastReturntID = "E00" + (Integer.parseInt(lastReturntID) + 1);
            txtReturnID2.setText(lastReturntID);
        } else {
            txtReturnID2.setText("E001");
        }

    }




    public String lastReturntID() throws Exception {
        return returnFormBO.lastReturnID();
    }


    public String lastPayID() throws Exception {
    return paymenBO.lastPayID();
    }


    public void cmbVehicleNumberOnAction(ActionEvent actionEvent) {

    }
    @FXML
    void cmbVehicleIDOnActionNew(ActionEvent event) {
//        System.out.println(cmbVehicleID.getValue());
        try {
            CustomDTO  customDTO=returnFormBO.searchReturn(cmbVehicleID.getValue()+"");

//            System.out.println( " controller : "+ customDTO);
//            System.out.println("DATE CHECK :"+customDTO.getEndDate());
            if (customDTO!=null){
                txtAdvance.setText(customDTO.getRentAdvance()+"");
                txtCustomerID.setText(customDTO.getCustomerID());
                txtTentId.setText(customDTO.getRentID());
                txtCustomerName1.setText(customDTO.getCustomerName());
                txtChargePerDay.setText(customDTO.getChargePerday()+"");
                txtRentDate.setText(customDTO.getRentDate());
                txtSerchReturnDate.setText(customDTO.getEndDate());

                //txtTentId.setText(customDTO.getRentID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
















    public void loadVehicle(){
       try {
            ArrayList<String> list=returnFormBO.getAllRentsForCombobox();
            ObservableList observableList=FXCollections.observableArrayList(list);
            cmbVehicleID.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void cmbrentIDOnAction(ActionEvent actionEvent) {
//        System.out.println(cmbrentID.getValue());

    }

    public void txtReturnDateOnAction(ActionEvent actionEvent) {
        double charge = Double.parseDouble(txtChargePerDay.getText());
        double advance = Double.parseDouble(txtAdvance.getText());
        LocalDate d1 = LocalDate.parse(txtRentDate.getText());
        LocalDate d2=txtReturnDate.getValue();
        Long date= ChronoUnit.DAYS.between(d1,d2);
        double fnal=Double.parseDouble(String.valueOf(date));

        double end=date*charge;
        double all=end-advance;
//
//        System.out.println(date);
//        System.out.println(end);
//        System.out.println(all);
        txtTotalcost.setText(String.valueOf(all));
    }

    public void cmbVehicleIDOnAction(ActionEvent actionEvent) {
        try {
            CustomDTO  customDTO=returnFormBO.searchReturn(cmbVehicleID.getValue()+"");
            if (customDTO!=null){
                txtTentId.setText(customDTO.getRentID());
                //txtRentID.getText(customDTO.getRentID());
                txtAdvance.setText(customDTO.getRentAdvance()+"");
                txtCustomerID.setText(customDTO.getCustomerID());
                txtCustomerName.setText(customDTO.getCustomerName());
                txtChargePerDay.setText(customDTO.getChargePerday()+"");
                txtRentDate.setText(customDTO.getRentDate());
                txtSerchReturnDate.setText(customDTO.getEndDate());


            }
        } catch (Exception e) {

            //e.printStackTrace();
        }
    }



    public void txtSerch1OnAction(ActionEvent actionEvent) {
    }
}
