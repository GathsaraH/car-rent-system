package controller;

import bo.BOFactory;
import bo.custom.Impl.PaymenBOImpl;
import bo.custom.PaymenBO;
import com.jfoenix.controls.JFXComboBox;
import dto.PaymentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class BusinessStaticFormController {

    public TableView<PaymentDTO> tblTotalIncome;
    public TableColumn<PaymentDTO,String> colCustomerID;
    public TableColumn<PaymentDTO, String> colPayID;
    public TableColumn<PaymentDTO,String> colDate;
    public TableColumn<PaymentDTO,Double> colPayment;



    public JFXComboBox cmbEarningStatus;

    public TableView tblDateWhiseDetails;
    public TableColumn <PaymentDTO,String> col2CustomerID;
    public TableColumn <PaymentDTO,String> col2PayID;
    public TableColumn<PaymentDTO,String>  col2Date;
    public TableColumn<PaymentDTO,String>  col2Payment;

   PaymenBO paymenBO= (PaymenBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.PAYMENT);


    public void initialize(){
        colCustomerID.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("customerID"));
        colPayID.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("vehicleID"));
        colDate.setCellValueFactory(new PropertyValueFactory<PaymentDTO,String>("payDate"));
        colPayment.setCellValueFactory(new PropertyValueFactory<PaymentDTO,Double>("payment"));
        tblTotalIncome.setItems(loadPayment());
    }


    public ObservableList<PaymentDTO> loadPayment(){
        ArrayList<PaymentDTO> all=paymenBO.loadAllPayment();
        ObservableList<PaymentDTO> observableList= FXCollections.observableArrayList();
        for (PaymentDTO p:all){
            observableList.add(new PaymentDTO(
                    p.getReturnID(),
                    p.getCustomerID(),
                    p.getVehicleID(),
                    p.getPayDate(),
                    p.getPayment()
            ));
        }

        return observableList;
    }


    public void earningstatusOnAction(ActionEvent actionEvent) {
    }

    public void getstatusOnAction(ActionEvent actionEvent) {
    }
}
