package bo.custom;

import bo.SuperBO;
import dto.CustomDTO;
import dto.RentDTO;
import dto.RentdtailsDTO;
import dto.ReturndtailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReturnFormBO extends SuperBO {
    public boolean addreturn(ReturndtailsDTO returndtailsDTO) throws ClassNotFoundException, SQLException, Exception;

    public boolean deleteReturn(String rdID) throws ClassNotFoundException, SQLException, Exception;

    public CustomDTO searchReturn(String rdID) throws ClassNotFoundException, SQLException;

    public ArrayList<String> getAllRentsForCombobox() throws SQLException, ClassNotFoundException, Exception;

    public ArrayList<RentdtailsDTO> getAllReturnForTable() throws SQLException, ClassNotFoundException, Exception;

    public boolean updateReturn(ReturndtailsDTO returndtailsDTO) throws ClassNotFoundException, SQLException, Exception;

    public  String lastReturnID() throws Exception;


}
