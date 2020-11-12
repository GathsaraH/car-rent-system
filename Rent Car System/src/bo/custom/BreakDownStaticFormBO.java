package bo.custom;

import bo.SuperBO;
import dto.BreakdowndetailsDTO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BreakDownStaticFormBO extends SuperBO {

    public ArrayList<BreakdowndetailsDTO> loadVehicle() throws Exception;

    public ArrayList<String> loadVehicleID() throws  Exception;

    public BreakdowndetailsDTO searchDown(String rID) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateBDown(BreakdowndetailsDTO breakdowndetailsDTO) throws  Exception;
}
