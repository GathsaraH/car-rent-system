package bo.custom.Impl;

import bo.custom.PaymenBO;
import dao.DAOFactory;
import dao.custom.PaymentDAO;
import dao.custom.impl.PaymentDAOImpl;
import dto.PaymentDTO;
import entity.Payment;
import entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;


public class PaymenBOImpl implements PaymenBO {

    PaymentDAO paymentDAO= (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENTDAO);


    @Override
    public String lastPayID() throws Exception {
        return paymentDAO.lastPayID();
    }

    @Override
    public ArrayList<PaymentDTO> loadLineChart() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> firstone=paymentDAO.getChartone();
        ArrayList<PaymentDTO> addlist=new ArrayList<>();
        for (Payment payment:firstone){
            addlist.add(new PaymentDTO(payment.getpDate(),payment.getLinechart()));
        }

        return addlist;
    }

    @Override
    public ArrayList<PaymentDTO> loadAllPayment() {
        ArrayList<Payment> all= null;
        try {
            all = paymentDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<PaymentDTO> paymentDTOS=new ArrayList<>();
        for (Payment p:all){
            paymentDTOS.add(new PaymentDTO(
               p.getReturnID(),
               p.getcID(),
               p.getvID(),
               p.getpDate(),
               p.getPayment()
            ));
        }

        return paymentDTOS;
    }
}
