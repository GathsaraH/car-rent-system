package dao.custom;

import dao.CrudDAO;
import entity.Rent;

public interface RentDAO extends CrudDAO<Rent,String> {
    public String lastRentID() throws Exception;

}
