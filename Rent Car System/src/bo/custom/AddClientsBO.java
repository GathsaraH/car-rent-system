package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddClientsBO extends SuperBO {
    public boolean addClients(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception;

    public boolean deleteClients(String cID) throws ClassNotFoundException, SQLException, Exception;

    public CustomerDTO searchClients(String cID) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<String> getAllClients() throws SQLException, ClassNotFoundException, Exception;

    public ArrayList<CustomerDTO> getAllClientsForTable() throws SQLException, ClassNotFoundException, Exception;

    public boolean updateClients(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception;

    public  String lastClientsID() throws Exception;
}
