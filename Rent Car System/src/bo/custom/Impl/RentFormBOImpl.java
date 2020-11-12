package bo.custom.Impl;

import bo.custom.RentFormBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.RentDAO;
import dao.custom.RentdtailsDAO;
import dao.custom.VehicleDAO;
import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.RentDAOImpl;
import dao.custom.impl.RentdtailsDAOImpl;
import dao.custom.impl.VehicleDAOImpl;
import db.DBConnection;
import dto.CustomDTO;
import dto.RentDTO;
import dto.RentdtailsDTO;
import entity.Rent;
import entity.Rentdtails;
import entity.Vehicle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;




public class RentFormBOImpl implements RentFormBO {
    RentDAO rentDAO = (RentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENTDAO);
    RentdtailsDAO rentdtailsDAO = (RentdtailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENTDTAILSDAO);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERDAO);
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLEDAO);


    @Override
    public boolean addRent(RentDTO r) throws ClassNotFoundException, SQLException, Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        Rent rent = new Rent(r.getRentID(), r.getCustomerID(), r.getRentcustName(),r.getVehicleID(),r.getEndDate());
        boolean add = rentDAO.add(rent);

        System.out.println("Rent : " + rent);
        System.out.println(add);
        try {
            if (add) {
                //System.out.println("Inside");
                for (RentdtailsDTO dto : r.getDtos()) {
                    Rentdtails rentdtails = new Rentdtails(r.getRentID(), dto.getRentDate(), dto.getVehicleID(), dto.getChargePerday(), dto.getRentAdvance(), dto.getRentStatus());
                    //System.out.println(rentdtails);
                    boolean isAdded = rentdtailsDAO.add(rentdtails);
                    if (isAdded) {
                        Vehicle vehicle = new Vehicle(dto.getVehicleID(), dto.getRentStatus());
                        boolean isUpdate = vehicleDAO.updateStatusForRent(vehicle);
                        if (!isUpdate) {
                            connection.rollback();
                            connection.setAutoCommit(true);
                            return false;
                        }
                    } else {
                        connection.rollback();
                        connection.setAutoCommit(true);
                        return false;
                    }
                }
                connection.commit();
                connection.setAutoCommit(true);
                return true;

            } else {
                connection.rollback();
                return false;
            }
        }catch (SQLException ex){
            connection.rollback();
            return false;
        }
        finally {
            connection.setAutoCommit(true);
        }


    }


    @Override
    public boolean deleteRent(String rID) throws ClassNotFoundException, SQLException, Exception {

        return false;
    }

    @Override
    public CustomDTO searchRent(String rID) throws ClassNotFoundException, SQLException, Exception {

        return null;
    }

    @Override
    public ArrayList<String> getAllRentsForCombobox() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Rentdtails> list=rentdtailsDAO.getAll();
        ArrayList<String> getallVehicleNumber=new ArrayList<>();
        for (Rentdtails rentdtails: list){
            getallVehicleNumber.add(rentdtails.getvID());
        }
        return null;
    }

    @Override
    public ArrayList<CustomDTO> getAllRentsForTable() throws SQLException, ClassNotFoundException, Exception {
        return null;
    }

    @Override
    public boolean updateRents(CustomDTO customDTO) throws ClassNotFoundException, SQLException, Exception {
        return false;
    }

    @Override
    public String lastRentID() throws Exception {
        return rentDAO.lastRentID();
    }
}
