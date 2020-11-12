package dao.custom;

import dao.CrudDAO;
import dto.PaymentDTO;
import entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentDAO extends CrudDAO<Payment,String> {

    public String lastPayID() throws Exception;

    ArrayList<Payment> getChartone() throws SQLException, ClassNotFoundException;

}
