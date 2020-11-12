package dao.custom.impl;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import dao.CrudUtil;
import dao.custom.SystemDAO;
import entity.System;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SystemDAOImpl implements SystemDAO {
    @Override
    public boolean add(System s) throws Exception {
        String sql="insert into system values (?,?,?,?,?,?)";
       return CrudUtil.executeUpdate(sql,s.getsID(),s.getsName(),s.getsAddress(),s.getsNumber(),s.getsPassword(),s.getsEmail());


    }

    @Override
    public boolean delete(String vid) throws Exception {
        String sql="delete from system where sID=?";
        return CrudUtil.executeUpdate(sql,vid);
    }

    @Override
    public boolean update(System s) throws Exception {
        String sql="update system set sName=?,sAddress=?,sNumber=?,sEmail=?,sPassword=? where sID=?";
        return  CrudUtil.executeUpdate(sql,s.getsName(),s.getsAddress(),s.getsNumber(),s.getsEmail(),s.getsPassword(),s.getsID());
    }

    @Override
    public System search(String sID) throws Exception {
        String sql="select* from system where sID=?";
        ResultSet rst=CrudUtil.executeQuery(sql,sID);
        while (rst.next()){
            return new System(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
        }
        return null;
    }

    @Override
    public ArrayList<System> getAll() throws Exception {
        String sql="select * from  system";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<System> list=new ArrayList<>();
        while (rst.next()){
            list.add(new System(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }

        return list;
    }


    @Override
    public String genarateUserID() throws Exception {
        String sql="select sID from system order By sID desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        return (rst.next()) ? rst.getString("sID"):null;
    }
}
