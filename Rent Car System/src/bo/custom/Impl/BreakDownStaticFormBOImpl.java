package bo.custom.Impl;

import bo.custom.BreakDownStaticFormBO;
import dao.DAOFactory;
import dao.custom.BreakdowndetailsDAO;
import dao.custom.VehicleDAO;
import dao.custom.impl.BreakdowndetailsDAOImpl;
import dao.custom.impl.VehicleDAOImpl;
import dto.BreakdowndetailsDTO;
import entity.Breakdowndetails;
import entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;


public class BreakDownStaticFormBOImpl implements BreakDownStaticFormBO {
    BreakdowndetailsDAO breakdowndetailsDAO = (BreakdowndetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BREAKDOWNDETAILSDAO);
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLEDAO);

    @Override

    public ArrayList<BreakdowndetailsDTO> loadVehicle() throws Exception {
        ArrayList<Breakdowndetails> all = breakdowndetailsDAO.getAll();
        ArrayList<BreakdowndetailsDTO> loadVehicle = new ArrayList<>();
        for (Breakdowndetails b : all) {
            loadVehicle.add(new BreakdowndetailsDTO(
                    b.getbID(),
                    b.getvID(),
                    b.getBreakdownStatus(),
                    b.getBrokenDate()
            ));
        }

        return loadVehicle;
    }

    @Override
    public ArrayList<String> loadVehicleID() throws Exception {
        ArrayList<Vehicle> list = vehicleDAO.getAllvehicleForBD();
        ArrayList<String> vehicleList = new ArrayList<>();
        for (Vehicle vehicle : list) {
            vehicleList.add(vehicle.getvID());
        }
        return vehicleList;
    }

    @Override
    public BreakdowndetailsDTO searchDown(String rID) throws ClassNotFoundException, SQLException, Exception {
        Breakdowndetails b=breakdowndetailsDAO.search(rID);
        System.out.println("chekck 2"+b);
        return new BreakdowndetailsDTO(b.getbID(),b.getvID(),b.getBrokenDate(),b.getBreakdownStatus());

    }



    @Override
    public boolean updateBDown(BreakdowndetailsDTO b) throws Exception {

        Breakdowndetails breakdowndetails=new Breakdowndetails(
                b.getVehicleID()

        );
        System.out.println("Check  :"+breakdowndetails);

        boolean isAdded=breakdowndetailsDAO.update(breakdowndetails);

        if (isAdded){
            Vehicle vehicle=new Vehicle(
                     b.getVehicleID()
            );

            System.out.println("Update :"+vehicle);

            boolean isUpdae=vehicleDAO.updateReturnStatus(vehicle);
        }


        //return breakdowndetailsDAO.update(new Breakdowndetails(b.getVehicleID(),b.getBreakdowndID(),b.getBrokenDate(),b.getBreakdownStatus()));




        //return breakdowndetailsDAO.update(new Breakdowndetails(breakdowndetailsDTO.getBreakdownID(),breakdowndetailsDTO.getVehicleID(),breakdowndetailsDTO.getBrokenDate(),breakdowndetailsDTO.getBreakdownStatus()));
        return true;
    }
}
