package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;
import entity.Vehicle;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) throws Exception {
        String sql="insert into customer values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql,customer.getcID(),customer.getcAddress(),customer.getcName(),customer.getcNumber());
    }

    @Override
    public boolean delete(String cID) throws Exception {
        String sql="delete from customer where cID=?";
        return CrudUtil.executeUpdate(sql,cID);
    }

    @Override
    public boolean update(Customer cID) throws Exception {
        String sql="update customer set cAddress=?,cName=?,cNumber=? where cID=?";
        return CrudUtil.executeUpdate(sql,cID.getcAddress(),cID.getcName(),cID.getcNumber(),cID.getcID());
    }

    @Override
    public Customer search(String cID) throws Exception {
        String sql="select * from customer where cID=?";
        ResultSet rst=CrudUtil.executeQuery(sql,cID);
        if (rst.next()){
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));

        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
       String sql="select * from customer ";
       ResultSet rst=CrudUtil.executeQuery(sql);
       ArrayList<Customer> allClients=new ArrayList<>();
       while (rst.next()){
           allClients.add(new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));

       }
       return allClients;
    }

    @Override
    public String lastClients() throws Exception {
        String sql="select  cID from  customer order BY cID desc limit 1 ";
        ResultSet rst= CrudUtil.executeQuery(sql);
        //return (rst.next())?rst.getString("vID"):null;
        return (rst.next())?rst.getString("cID"):null;
    }
}
