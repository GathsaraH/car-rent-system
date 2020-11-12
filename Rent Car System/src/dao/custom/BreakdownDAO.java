package dao.custom;

import dao.CrudDAO;
import entity.Breakdown;
import entity.Breakdowndetails;

import java.sql.SQLException;

public interface BreakdownDAO extends CrudDAO<Breakdowndetails,String> {
    public String getBreakDownID() throws  Exception;

    boolean add(Breakdown breakdown) throws SQLException, ClassNotFoundException;
}
