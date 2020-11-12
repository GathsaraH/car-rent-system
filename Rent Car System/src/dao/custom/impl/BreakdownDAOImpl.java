package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BreakdownDAO;
import entity.Breakdown;
import entity.Breakdowndetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BreakdownDAOImpl implements BreakdownDAO {

    @Override
    public String getBreakDownID() throws Exception {
       String sql="select bID  from breakdowndetails  order By bID desc limit 1";
        ResultSet rst=CrudUtil.executeQuery(sql);
        return (rst.next()) ? rst.getString("bID"):null;
    }

    @Override
    public boolean add(Breakdown breakdown) throws SQLException, ClassNotFoundException {
        String sql="insert into breakdown values(?,?)";
        return  CrudUtil.executeUpdate(sql,breakdown.getbID(),breakdown.getvID());
    }

    @Override
    public boolean add(Breakdowndetails breakdowndetails) throws Exception {
  /*      String sql="insert into breakdown values(?,?)";
        return  CrudUtil.executeUpdate(sql,breakdowndetails.getbID(),breakdowndetails.getvID());*/
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Breakdowndetails breakdowndetails) throws Exception {
        return false;
    }

    @Override
    public Breakdowndetails search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Breakdowndetails> getAll() throws Exception {
        return null;
    }
}
