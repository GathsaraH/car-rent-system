package dao.custom;

import dao.CrudDAO;
import entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    public String lastClients() throws Exception;
}
