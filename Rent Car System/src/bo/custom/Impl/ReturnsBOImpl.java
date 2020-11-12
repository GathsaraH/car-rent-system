package bo.custom.Impl;

import bo.custom.ReturnsBO;
import dao.DAOFactory;
import dao.custom.PaymentDAO;
import dao.custom.ReturndtailsDAO;
import dao.custom.ReturnsDAO;
import dao.custom.VehicleDAO;
import dao.custom.impl.PaymentDAOImpl;
import dao.custom.impl.ReturndtailsDAOImpl;
import dao.custom.impl.ReturnsDAOImpl;
import dao.custom.impl.VehicleDAOImpl;
import db.DBConnection;
import dto.PaymentDTO;
import dto.ReturndtailsDTO;
import dto.ReturnsDTO;
import dto.VehicleDTO;
import entity.Payment;
import entity.Returndtails;
import entity.Returns;
import entity.Vehicle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnsBOImpl implements ReturnsBO {

    ReturnsDAO returnsDAO = (ReturnsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RETURNSDAO);
    ReturndtailsDAO returndtailsDAO = (ReturndtailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RETURNDTAILSDAO);
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLEDAO);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENTDAO);



    @Override
    public boolean addReturns(ReturnsDTO returnsDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            Returns returns = new Returns(
                    returnsDTO.getReturnID(),
                    returnsDTO.getrID(),
                    returnsDTO.getcID(),
                    returnsDTO.getReturnDate()
            );

            boolean addRents = returnsDAO.add(returns);
            System.out.println(" Add Rent : " + addRents);

            if (addRents) {
                boolean isaddRDetails = false;

                for (PaymentDTO pay : returnsDTO.getPy()) {
                    Returndtails returndtails = new Returndtails(
                            returnsDTO.getReturnID(),
                            pay.getRentDate(),
                            pay.getVehicleID(),
                            pay.getChargePerday(),
                            pay.getRentAdvance()
                    );
                    isaddRDetails = returndtailsDAO.add(returndtails);

                }
                System.out.println(" Add  rentdetails : " + isaddRDetails);

                if (isaddRDetails) {
                    for (PaymentDTO p : returnsDTO.getPy()) {
                        Payment payment = new Payment(
                                returnsDTO.getReturnID(),
                                returnsDTO.getcID(),
                                p.getVehicleID(),
                                p.getPayDate(),
                                p.getPayment()
                        );
                        System.out.println("payment : " + payment);
                        boolean isPayed = paymentDAO.add(payment);
                        System.out.println(" Add  Payment : " + isPayed);

                        if (isPayed) {
                            for (PaymentDTO pa : returnsDTO.getPy()) {
                                Vehicle vehicle = new Vehicle(
                                        pa.getVehicleID()
                                );

                                boolean Isupdate = vehicleDAO.updateReturnStatus(vehicle);
                                System.out.println(" Add  isUpdate : " + Isupdate);
                                if (!Isupdate) {
                                    connection.rollback();
//                                    connection.setAutoCommit(true);
                                    return false;
                                }

                            }

                        } else {
                            connection.rollback();
//                            connection.setAutoCommit(true);
                            return false;
                        }
                    }
                    connection.commit();
//                    connection.setAutoCommit(true);
                    return true;

                } else {
                    connection.rollback();
//                    connection.setAutoCommit(true);
                    return false;
                }
            } else {
                connection.rollback();
//                connection.setAutoCommit(true);
                return false;
            }
        }finally {
            connection.setAutoCommit(true);
        }
    }
}