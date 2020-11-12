package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BreakdowndetailsDAO;
import entity.Breakdowndetails;
import entity.Vehicle;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BreakdowndetailsDAOImpl implements BreakdowndetailsDAO {
    @Override
    public boolean add(Breakdowndetails b) throws Exception {
        String sql="Insert into breakdowndetails Values(?,?,?,?)  ";
        return CrudUtil.executeUpdate(sql,b.getbID(),b.getvID(),b.getBreakdownStatus(),b.getBrokenDate());

    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Breakdowndetails vID) throws Exception {
        String sql="update breakdownStatus from breakdowndetails  set breakdownStatus='Good' where vID=?";
        return CrudUtil.executeUpdate(sql,vID.getvID());
        //return CrudUtil.executeUpdate(sql,vID.getbID(),vID.getvID(),vID.getBrokenDate(),vID.getBreakdownStatus());
    }

    @Override
    public Breakdowndetails search(String vID) throws Exception {
        String sql="select * from breakdowndetails where vID=? ";
        ResultSet rst=CrudUtil.executeQuery(sql,vID);
        if (rst.next()){
            return  new Breakdowndetails(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }
        return null;
    }

    @Override
    public ArrayList<Breakdowndetails> getAll() throws Exception {
        String sql="select * from breakdowndetails";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Breakdowndetails> loadTable=new ArrayList<>();
        while (rst.next()){
            loadTable.add(new Breakdowndetails(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }

        return loadTable;
    }
}
