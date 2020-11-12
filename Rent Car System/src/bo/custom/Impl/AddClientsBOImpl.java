package bo.custom.Impl;

import bo.custom.AddClientsBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddClientsBOImpl implements AddClientsBO {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERDAO);
    @Override
    public boolean addClients(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception {
        return customerDAO.add(new Customer(customerDTO.getCustomerID(),customerDTO.getCustomerAddress(),customerDTO.getCustomerName(),customerDTO.getCustomertpNumber()));
    }

    @Override
    public boolean deleteClients(String cID) throws ClassNotFoundException, SQLException, Exception {
        return customerDAO.delete(cID);
    }

    @Override
    public CustomerDTO searchClients(String cID) throws ClassNotFoundException, SQLException, Exception {
        Customer customer=customerDAO.search(cID);
        return new CustomerDTO(customer.getcID(),customer.getcAddress(),customer.getcName(),customer.getcNumber());
    }

    @Override
    public ArrayList<String> getAllClients() throws SQLException, ClassNotFoundException, Exception {
       ArrayList<Customer> list=customerDAO.getAll();
       ArrayList<String> customerlist=new ArrayList<>();
       for (Customer customer : list){
           customerlist.add(customer.getcID());
       }
       return customerlist;
    }

    @Override
    public ArrayList<CustomerDTO> getAllClientsForTable() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Customer> all=customerDAO.getAll();
        ArrayList<CustomerDTO> loadCutomer=new ArrayList<>();
        System.out.println(all);
        for (Customer c:all){
            loadCutomer.add(new CustomerDTO(
                    c.getcID(),
                    c.getcName(),
                    c.getcAddress(),
                    c.getcNumber()
            ));
        }

        return loadCutomer;
    }

    @Override
    public boolean updateClients(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception {
        return false;
    }

    @Override
    public String lastClientsID() throws Exception {
        return   customerDAO.lastClients();

    }

}
