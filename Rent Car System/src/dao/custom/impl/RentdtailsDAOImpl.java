package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RentdtailsDAO;
import entity.Rent;
import entity.Rentdtails;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RentdtailsDAOImpl implements RentdtailsDAO {
    @Override
    public boolean add(Rentdtails rentdtails) throws Exception {
        String sql="insert into rentdtails values(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,rentdtails.getrID(),rentdtails.getRentDate(),rentdtails.getvID(),rentdtails.getChargePerday(),rentdtails.getrAdvance(),rentdtails.getrStatus());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Rentdtails rentdtails) throws Exception {
        return false;
    }

    @Override
    public Rentdtails search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Rentdtails> getAll() throws Exception {
      String sql="select * from rentdtails";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Rentdtails> allRentID=new ArrayList<>();
        while (rst.next()) {
            allRentID.add(new Rentdtails(rst.getString(1),rst.getString(2),rst.getString(3),Double.parseDouble(rst.getString(4)),Double.parseDouble(rst.getString(5)),rst.getString(6)));
        }
        return allRentID;
    }

    @Override
    public ArrayList<Rentdtails> getAllForReturn() throws Exception {
        String sql="select * from rentdtails where ";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Rentdtails> allRentID=new ArrayList<>();
        while (rst.next()) {
            allRentID.add(new Rentdtails(rst.getString(1),rst.getString(2),rst.getString(3),Double.parseDouble(rst.getString(4)),Double.parseDouble(rst.getString(5)),rst.getString(6)));
        }
        return allRentID;
    }
}
