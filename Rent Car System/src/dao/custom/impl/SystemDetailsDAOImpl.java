package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.SystemDetailsDAO;
import entity.System;
import entity.SystemDetails;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SystemDetailsDAOImpl implements SystemDetailsDAO {
    @Override
    public boolean add(SystemDetails systemDetails) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(SystemDetails systemDetails) throws Exception {
        return false;
    }

    @Override
    public SystemDetails search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<SystemDetails> getAll() throws Exception {
        String sql="select * from system";
        ResultSet rst= CrudUtil.executeQuery(sql);
        ArrayList<System> allSystem=new ArrayList<>();
        while (rst.next()){
            allSystem.add(new System(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(4),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return null;
    }
}
