package dao.custom;

import dao.CrudDAO;
import entity.Rentdtails;

import java.util.ArrayList;

public interface RentdtailsDAO extends CrudDAO<Rentdtails,String> {
    public ArrayList<Rentdtails> getAllForReturn() throws Exception;

}
