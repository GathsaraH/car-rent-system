package bo.custom;

import bo.SuperBO;
import dto.PaymentDTO;
import dto.VehicleDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleStaticBO extends SuperBO {
    public boolean addVehicle(VehicleDTO vehicleDTO) throws ClassNotFoundException, SQLException, Exception;

    public boolean deleteVehicle(String id) throws ClassNotFoundException, SQLException, Exception;

    public VehicleDTO searchVehicle(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<String> getAllVehicle() throws SQLException, ClassNotFoundException, Exception;


    public ArrayList<String> getAllVehicleFromStatus() throws SQLException, ClassNotFoundException, Exception;

    public ArrayList<VehicleDTO> getAllVehicleForTable() throws SQLException, ClassNotFoundException, Exception;

    public boolean updateVehicle(VehicleDTO vehicleDTO) throws ClassNotFoundException, SQLException, Exception;

    public  String lastVehicleID() throws Exception;

    public String getcarCount() throws  Exception;
    public String getvanCount() throws  Exception;
    public String getbusCount() throws  Exception;
    public String getBikeCount() throws  Exception;


    
}
