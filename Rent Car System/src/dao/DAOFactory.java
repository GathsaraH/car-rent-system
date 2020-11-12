package dao;

import bo.SuperBO;
import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }

    public static DAOFactory getInstance(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();

        }
        return daoFactory;
    }

    public enum DAOTypes{
        BREAKDOWNDAO,BREAKDOWNDETAILSDAO,CUSTOMERDAO,PAYMENTDAO,QUERYDAO,RENTDAO,RENTDTAILSDAO,RETURNDTAILSDAO,RETURNSDAO,SYSTEMDAO,VEHICLEDAO;
    }

    public SuperDAO getDAO (DAOTypes daoTypes){
        switch (daoTypes){
            case BREAKDOWNDAO:
                return new BreakdownDAOImpl();
            case BREAKDOWNDETAILSDAO:
                return new BreakdowndetailsDAOImpl();
            case CUSTOMERDAO:
                return new CustomerDAOImpl();
            case PAYMENTDAO:
                return new PaymentDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            case RENTDAO:
                return new RentDAOImpl();
            case RENTDTAILSDAO:
                return new RentdtailsDAOImpl();
            case RETURNDTAILSDAO:
                return new ReturndtailsDAOImpl();
            case RETURNSDAO:
                return new ReturnsDAOImpl();
            case SYSTEMDAO:
                return new SystemDAOImpl();
            case VEHICLEDAO:
                return  new VehicleDAOImpl();
            default:
                return null;
        }
    }


}
