package bo;

import bo.custom.BreakDownFormBO;
import bo.custom.Impl.*;
import org.omg.CORBA.PUBLIC_MEMBER;

public class BOFactory {
    private static  BOFactory boFactory;

    private BOFactory(){
    }

    public static BOFactory getInstance(){
        if (boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    public enum BoTypes{
        ADDCLIENTS,BREAKDOWNFORM,BREAKDOWNSTATICFORM,PAYMENT,RENTFORM,RETURNSFORM,RETURNS,USERSSTATIC,VEHICLESTATIC;

    }
    public SuperBO getBO(BoTypes boTypes){
        switch ( boTypes){
            case ADDCLIENTS:
                return new AddClientsBOImpl();
            case BREAKDOWNFORM:
                return new BreakDownFormBOImpl();
            case BREAKDOWNSTATICFORM:
                return  new  BreakDownStaticFormBOImpl();
            case PAYMENT:
                return  new PaymenBOImpl();
            case RENTFORM:
                return new RentFormBOImpl();
            case RETURNSFORM:
                return new ReturnFormBOImpl();
            case RETURNS:
                return new ReturnsBOImpl();
            case USERSSTATIC:
                return  new UsersStaticBOImpl();
            case VEHICLESTATIC:
                return new VehicleStaticBOImpl();
            default:
                return null;

        }
    }

}
