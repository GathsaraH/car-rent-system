package dao.custom.impl;

import com.sun.istack.internal.FinalArrayList;
import dao.CrudUtil;
import dao.custom.PaymentDAO;
import entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(Payment payment) throws Exception {
        String sql="insert into payment values (?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,
                payment.getReturnID(),
                payment.getcID(),
                payment.getvID(),
                payment.getpDate(),
                payment.getPayment()
                );
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Payment payment) throws Exception {
        return false;
    }

    @Override
    public Payment search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        String sql="select * from payment";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Payment> all=new ArrayList<>();
        while (rst.next()){
            all.add(new Payment(
               rst.getString(1),
               rst.getString(2),
               rst.getString(3),
               rst.getString(4),
                    Double.parseDouble(rst.getString(5))
            ));
        }


        return all;
    }

    @Override
    public String lastPayID() throws Exception {
        String sql="select pID from payment order By pID desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        return (rst.next()) ? rst.getString("pID"):null;
    }

    @Override
    public ArrayList<Payment> getChartone() throws SQLException, ClassNotFoundException {
       String sql="SELECT  pDate,COUNT(*)FROM payment WHERE payment >1000.00  group BY pDate";
       ResultSet rst=CrudUtil.executeQuery(sql);
       ArrayList<Payment> chart=new ArrayList<>();

       while (rst.next()){
           chart.add(new Payment(rst.getString(1),rst.getInt(2)));
       }

        return chart;
    }
}
