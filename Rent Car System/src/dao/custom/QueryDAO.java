package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.CustomEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
   public CustomEntity  getserchReturn(String vID) throws ClassNotFoundException, SQLException;

}
