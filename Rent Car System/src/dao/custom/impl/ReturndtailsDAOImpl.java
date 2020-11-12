package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ReturndtailsDAO;
import entity.Returndtails;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ReturndtailsDAOImpl implements ReturndtailsDAO {

    @Override
    public String getreturnID() throws Exception {
        String sql="select returnID from returndtails order By returnID desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        return (rst.next()) ? rst.getString("returnID"):null;
    }


    @Override
    public boolean add(Returndtails returndtails) throws Exception {
        String sql="insert into returndtails values (?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,
                returndtails.getReturnID(),
                returndtails.getRentDate(),
                returndtails.getvID(),
                returndtails.getChargePerday(),
                returndtails.getrAdvance()
                   );
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Returndtails returndtails) throws Exception {
        return false;
    }

    @Override
    public Returndtails search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Returndtails> getAll() throws Exception {
        return null;
    }
}

