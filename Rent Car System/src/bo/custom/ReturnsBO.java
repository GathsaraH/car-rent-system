package bo.custom;

import bo.SuperBO;
import dto.ReturnsDTO;

import java.sql.SQLException;

public interface ReturnsBO extends SuperBO {
    public boolean addReturns(ReturnsDTO returnsDTO) throws  ClassNotFoundException, SQLException, Exception;
}
