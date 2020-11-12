package bo.custom;

import bo.SuperBO;
import dto.CustomDTO;
import dto.CustomerDTO;
import dto.RentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RentFormBO extends SuperBO {
    public boolean addRent(RentDTO rentDTO) throws ClassNotFoundException, SQLException, Exception;

    public boolean deleteRent(String rID) throws ClassNotFoundException, SQLException, Exception;

    public CustomDTO searchRent(String rID) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<String> getAllRentsForCombobox() throws SQLException, ClassNotFoundException, Exception;

    public ArrayList<CustomDTO> getAllRentsForTable() throws SQLException, ClassNotFoundException, Exception;

    public boolean updateRents(CustomDTO customDTO) throws ClassNotFoundException, SQLException, Exception;

    public  String lastRentID() throws Exception;

}
