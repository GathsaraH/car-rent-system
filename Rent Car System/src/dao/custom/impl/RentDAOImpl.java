package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RentDAO;
import entity.Customer;
import entity.Rent;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RentDAOImpl implements RentDAO {
    @Override
    public boolean add(Rent rent) throws Exception {
        String sql="insert into rent values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,rent.getrID(),rent.getcID(),rent.getRcName(),rent.getvID(),rent.getEndDate());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Rent rent) throws Exception {
        return false;
    }

    @Override
    public Rent search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Rent> getAll() throws Exception {

        String sql="select * from rent ";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Rent> allRentID=new ArrayList<>();
        while (rst.next()){
            allRentID.add(new Rent(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));

        }
        return allRentID;

    }

    @Override
    public String lastRentID() throws Exception {
        String sql="select rID  from rent  order By rID desc limit 1";
        ResultSet resultSet= CrudUtil.executeQuery(sql);
        return (resultSet.next()) ?resultSet.getString("rID"):null;
    }
}
