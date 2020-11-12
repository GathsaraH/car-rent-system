package bo.custom;

import bo.SuperBO;
import dto.PaymentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymenBO extends SuperBO {
  public   String lastPayID()throws Exception;

  ArrayList<PaymentDTO> loadLineChart() throws SQLException, ClassNotFoundException;

    ArrayList<PaymentDTO> loadAllPayment();
}
