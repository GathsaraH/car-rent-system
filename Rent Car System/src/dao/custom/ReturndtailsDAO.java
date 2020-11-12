package dao.custom;

import dao.CrudDAO;
import entity.Returndtails;

import java.util.ArrayList;

public interface ReturndtailsDAO extends CrudDAO<Returndtails,String> {
    String  getreturnID() throws Exception;

}
