package bo.custom.Impl;

import bo.custom.PaymenBO;
import bo.custom.ReturnFormBO;
import dao.DAOFactory;
import dao.custom.*;
import dao.custom.impl.*;
import db.DBConnection;
import dto.CustomDTO;
import dto.PaymentDTO;
import dto.RentdtailsDTO;
import dto.ReturndtailsDTO;
import entity.*;

import java.lang.System;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ReturnFormBOImpl implements ReturnFormBO {


    RentdtailsDAO rentdtailsDAO= (RentdtailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENTDTAILSDAO);
    ReturndtailsDAO returndtailsDAO= (ReturndtailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RETURNDTAILSDAO);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);
    PaymentDAO paymentDAO= (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENTDAO);
    VehicleDAO vehicleDAO= (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLEDAO);

    @Override
    public boolean addreturn(ReturndtailsDTO rt) throws ClassNotFoundException, SQLException, Exception {
/*        Returndtails returndtails=new Returndtails(
                rt.getReturnID(),
                rt.getRentID(),
                rt.getCustomerID(),
                rt.getRentDate(),
                rt.getVehicleID(),
                rt.getReturnDate(),
                rt.getChargePerday(),
                rt.getRentAdvance()
        );
        boolean add=returndtailsDAO.add(returndtails);
        if (add) {
            for (PaymentDTO paymentDTO : rt.getListPay()) {
                System.out.println(rt.getListPay());
                Payment payment = new Payment(rt.getReturnID(), paymentDTO.getCustomerID(), paymentDTO.getPayDate(), paymentDTO.getPayment());
                boolean isAdded = paymentDAO.add(payment);

                if (isAdded) {
                    Vehicle vehicle = new Vehicle(rt.getVehicleID());
                    boolean isUpdate = vehicleDAO.updateStatusOnly(vehicle);


                }
            }

        }*/
        return false;

    }

    @Override
    public boolean deleteReturn(String rdID) throws ClassNotFoundException, SQLException, Exception {
        return false;
    }

    @Override
    public CustomDTO searchReturn(String vID) throws ClassNotFoundException, SQLException{
       CustomEntity c=queryDAO.getserchReturn(vID);
        System.out.println("customEntity : " + c);
        System.out.println("getcName : "+c.getcName());
        System.out.println("getRcName : "+c.getRcName());
        System.out.println("Return DateChecck :"+c.getEndDate());
//        return new CustomDTO(c.getrID(),c.getcID(),c.getcName(),c.getChargePerday(),c.getrAdvance(),c.getRentDate(),c.getEndDate());
        CustomDTO customDTO = new CustomDTO(
                c.getrID(),
                c.getcID(),
                c.getRcName(),
                c.getChargePerday(),
                c.getrAdvance(),
                c.getRentDate(),
                c.getEndDate()
        );
        System.out.println("BO ekke : "+ customDTO);
        return customDTO;
    }


    @Override
    public ArrayList<String> getAllRentsForCombobox() throws SQLException, ClassNotFoundException, Exception {
     ArrayList<Vehicle> list=vehicleDAO.getAllvehicleForReturns();
       ArrayList<String> getallVehicleNumber=new ArrayList<>();
        for (Vehicle rentdtails: list){
            getallVehicleNumber.add(rentdtails.getvID());
        }
        return getallVehicleNumber;
    }

    @Override
    public ArrayList<RentdtailsDTO> getAllReturnForTable() throws SQLException, ClassNotFoundException, Exception {

        return null;
    }

    @Override
    public boolean updateReturn(ReturndtailsDTO returndtailsDTO) throws ClassNotFoundException, SQLException, Exception {
        return false;
    }

    @Override
    public String lastReturnID() throws Exception {
        return returndtailsDAO.getreturnID();
    }
}
