package bo.custom.Impl;

import bo.custom.BreakDownFormBO;
import dao.DAOFactory;
import dao.custom.BreakdownDAO;
import dao.custom.BreakdowndetailsDAO;
import dao.custom.VehicleDAO;
import dao.custom.impl.BreakdownDAOImpl;
import dao.custom.impl.BreakdowndetailsDAOImpl;
import dao.custom.impl.VehicleDAOImpl;
import db.DBConnection;
import dto.BreakdownDTO;
import dto.BreakdowndetailsDTO;
import entity.Breakdown;
import entity.Breakdowndetails;
import entity.Vehicle;

import java.sql.Connection;

public class BreakDownFormBOImpl implements BreakDownFormBO {
    BreakdownDAO breakdownDAO= (BreakdownDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BREAKDOWNDAO);
    BreakdowndetailsDAO breakdowndetailsDAO= (BreakdowndetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BREAKDOWNDETAILSDAO);
    VehicleDAO vehicleDAO= (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLEDAO);



    @Override
    public String getBreakDownID() throws Exception {

        return breakdownDAO.getBreakDownID();
    }

    @Override
    public boolean addVehicle(BreakdowndetailsDTO br) throws Exception {
        System.out.println("Check 2 :"+br.getBre());
        boolean isAdded = false;
        for (BreakdownDTO c : br.getBre()) {
            Breakdown breakdown=new Breakdown(
              c.getBreakdownID(),
              c.getVehicleID()
            );
            System.out.println("Check 4 :"+breakdown);
            isAdded = breakdownDAO.add(breakdown);

            if (isAdded){
                for (BreakdownDTO b:br.getBre()){
                    Breakdowndetails breakdowndetails=new Breakdowndetails(
                     b.getBreakdownID(),
                     b.getVehicleID(),
                     b.getBrokenStatus(),
                     b.getBrokenDate()
                    );
                    boolean isADD=breakdowndetailsDAO.add(breakdowndetails);


                    if (isADD){
                        for (BreakdownDTO r:br.getBre()){
                            Vehicle vehicle=new Vehicle(
                              r.getVehicleID()
                            );
                            vehicleDAO.updateStatusOnly(vehicle);
                        }
                    }
                }


            }

        }




        return true;
    }

}
