package bo.custom;

import bo.SuperBO;
import dto.BreakdownDTO;
import dto.BreakdowndetailsDTO;

public interface BreakDownFormBO extends SuperBO {

    public  String getBreakDownID() throws  Exception;

    public boolean addVehicle (BreakdowndetailsDTO breakdowndetailsDTO) throws  Exception;
}
