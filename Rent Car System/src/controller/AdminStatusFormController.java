package controller;

import bo.BOFactory;
import bo.custom.Impl.PaymenBOImpl;
import bo.custom.Impl.VehicleStaticBOImpl;
import bo.custom.PaymenBO;
import bo.custom.VehicleStaticBO;
import dto.PaymentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdminStatusFormController {
    public Label txtCarCount;
    public Label txtVanCount;
    public Label txtBusCount;
    public Label txtBickeCount;
    public Label txtValidDate;
    public Label txtDate;
    public BarChart txtBarChart;
    public javafx.scene.chart.LineChart LineChart;
    public CategoryAxis X;
    public NumberAxis Y;
    public Label lblCar;
    public Label lblVan;
    public Label lblBus;
    public Label lblBike;
    public Label txtCurrentTime;
    public ProgressBar carPrgrs;
    //public Label txtCurrentTime;

    @FXML
    private LineChart<String,Integer> lineChartload;

    PaymenBO paymenBO= (PaymenBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.PAYMENT);


    VehicleStaticBO vehicleStaticBO= (VehicleStaticBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VEHICLESTATIC);

    public void initialize() throws Exception {
        loadlineChart();
        genarateDate();

      //  double s = Double.parseDouble(vehicleStaticBO.getcarCount());
       // carPrgrs.setProgress(s);
        //System.out.println("Car count "+s);
        lblCar.setText(vehicleStaticBO.getcarCount());
        lblVan.setText(vehicleStaticBO.getvanCount());
        lblBus.setText(vehicleStaticBO.getBikeCount());
        lblBike.setText(vehicleStaticBO.getBikeCount());
        //loadBarChart();

    }
    private void genarateDate(){



        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = sdf.format(date);
           txtDate.setText(orderDate);
   /*     SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        //String currentDate = simpleDateFormat.format(date);
        txtValidDate.setText(String.valueOf(date));*/
    }
/*

   private  void loadBarChart() throws Exception {

        XYChart.Series<String ,String> series=new XYChart.Series<>();

        ArrayList<VehicleDTO> barchart=vehicleStaticBO.getAllVehicleForTable();

        for (VehicleDTO vehicleDTO:barchart){

            series.getData().add(new XYChart.Data<String, String>(vehicleDTO.getModel(),vehicleDTO.getStatus()));

        }
        txtBarChart.getData().add(series);

    }
*/


    public  void getcarCount(){
        try {
            vehicleStaticBO.getcarCount();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    public void getvanCount(){
        //ehicleStaticBO

    }

    public void loadlineChart() throws SQLException, ClassNotFoundException {

         //String query="SELECT  pDate,COUNT(*)FROM payment WHERE payment >1000.00  group BY pDate";
         XYChart.Series<String,Integer> series=new XYChart.Series<>();
         ArrayList<PaymentDTO>  linechart=paymenBO.loadLineChart();

         for (PaymentDTO paymentDTO:linechart){
             series.getData().add(new XYChart.Data<>(paymentDTO.getPayDate(),paymentDTO.getLinechart()));
         }


        lineChartload.getData().add(series);

/*
         try{

            Connection connection= DBConnection.getInstance().getConnection();
             ResultSet rst=connection.createStatement().executeQuery(query);

             while (rst.next()){
                 series.getData().add(new XYChart.Data<>(rst.getString(1),rst.getInt(2)));

             }
*/




    }


    public void LoadOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        loadlineChart();
    }
}
