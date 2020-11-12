package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public CustomEntity getserchReturn(String vID) throws ClassNotFoundException, SQLException {
      //String sql="SELECT r.rID,r.cID,r.rcName,r.endDate, rd.rentDate,rd.vID,rd.chargePerday,rd.rAdvance FROM rent r,vehicle v,rentdtails rd WHERE r.rID=rd.rID && v.vStates='OnUse'&& rd.vID= ?";
        String sql="SELECT r.rID,r.cID,r.rcName,r.endDate, rd.rentDate,rd.vID,rd.chargePerday,rd.rAdvance FROM rent r,rentdtails rd WHERE r.rID=rd.rID  && rd.vID= ?";
       //String sql= "SELECT r.rID,r.rentDate,r.vID,r.chargePerday,r.rAdvance,rcName,s.cID FROM rentdtails r,rent s WHERE (r.rID= s.rID) and s.rID=?";
       ResultSet rst= CrudUtil.executeQuery(sql,vID);

        if (rst.next()){
           CustomEntity c = new CustomEntity(
                   rst.getString(1),
                   rst.getString(2),
                   rst.getString(3),
                   rst.getString(4),
                   rst.getString(5),
                   rst.getString(6),
                   Double.parseDouble(rst.getString(7)),
                   Double.parseDouble(rst.getString(8))

           );
            return c;
        }
        return null;
    }
}

