package dao.custom.impl;

import dao.CrudDAO;
import dao.CrudUtil;
import dao.custom.ReturnsDAO;
import entity.Returns;

import java.util.ArrayList;

public class ReturnsDAOImpl implements ReturnsDAO {
    @Override
    public boolean add(Returns returns) throws Exception {
        String sql="insert into returns values (?,?,?,?)";
        return CrudUtil.executeUpdate(sql,returns.getReturnID(),returns.getrID(),returns.getcID(),returns.getReturnDate());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Returns returns) throws Exception {
        return false;
    }

    @Override
    public Returns search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Returns> getAll() throws Exception {
        return null;
    }
}
