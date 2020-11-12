package dao.custom;

import dao.CrudDAO;
import entity.Vehicle;

import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<Vehicle,String> {
    public String lastVehicleID() throws Exception;


    boolean updateStatusOnly(Vehicle vID) throws Exception;

    boolean updateReturnStatus (Vehicle id) throws  Exception;

    boolean updateOnUse (Vehicle id) throws  Exception;

    ArrayList<Vehicle> serchvehicleFromStatus() throws Exception;

    public ArrayList<Vehicle> getAllvehicleForBD() throws Exception;

    public ArrayList<Vehicle> getAllvehicleForReturns() throws Exception;


    boolean updateStatusForRent (Vehicle id) throws  Exception;


    public String getcarCount() throws  Exception;
    public String getvanCount() throws  Exception;
    public String getbusCount() throws  Exception;
    public String getbikeCount() throws  Exception;


}
