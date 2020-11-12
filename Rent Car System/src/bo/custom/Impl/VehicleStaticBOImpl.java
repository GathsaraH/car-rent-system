package bo.custom.Impl;

import bo.custom.VehicleStaticBO;
import dao.DAOFactory;
import dao.custom.VehicleDAO;
import dao.custom.impl.VehicleDAOImpl;
import dto.VehicleDTO;
import entity.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleStaticBOImpl implements VehicleStaticBO {
     VehicleDAO vehicleDAO= (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLEDAO);
    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) throws ClassNotFoundException, SQLException, Exception {
        return  vehicleDAO.add(new Vehicle(vehicleDTO.getId(),vehicleDTO.getName(),vehicleDTO.getStatus(),vehicleDTO.getModel(),vehicleDTO.getType(),vehicleDTO.getColor()));
    }

    @Override
    public boolean deleteVehicle(String vID) throws ClassNotFoundException, SQLException, Exception {
        return vehicleDAO.delete(vID);
    }

    @Override
    public VehicleDTO searchVehicle(String vID) throws ClassNotFoundException, SQLException, Exception {
        Vehicle serch =vehicleDAO.search(vID);
        return new VehicleDTO(serch.getvID(),serch.getvName(),serch.getvStates(),serch.getvModle(),serch.getvType(),serch.getvColor());
    }

    @Override
    public ArrayList<String> getAllVehicle() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Vehicle> list=vehicleDAO.getAll();
        ArrayList<String> vehicleList=new ArrayList<>();
        for (Vehicle vehicle : list){
            vehicleList.add(vehicle.getvID());
        }
        return vehicleList;
    }

    @Override
    public ArrayList<String> getAllVehicleFromStatus() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Vehicle> list=vehicleDAO.serchvehicleFromStatus();
        ArrayList<String> vehicleList=new ArrayList<>();
        for (Vehicle vehicle : list){
            vehicleList.add(vehicle.getvID());
        }
        return vehicleList;
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicleForTable() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Vehicle> all=vehicleDAO.getAll();
        ArrayList<VehicleDTO> allVehicle=new ArrayList<>();
        for (Vehicle v : all){
            allVehicle.add(new VehicleDTO(v.getvID(),v.getvName(),v.getvStates(),v.getvModle(),v.getvType(),v.getvColor()));
        }
        return allVehicle;
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws ClassNotFoundException, SQLException, Exception {
        return vehicleDAO.update(new Vehicle(vehicleDTO.getId(),vehicleDTO.getName(),vehicleDTO.getStatus(),vehicleDTO.getModel(),vehicleDTO.getType(),vehicleDTO.getColor()));

    }

    @Override
    public String lastVehicleID() throws Exception {
        return vehicleDAO.lastVehicleID();
    }

    @Override
    public String getcarCount() throws Exception {
        return vehicleDAO.getcarCount();
    }

    @Override
    public String getvanCount() throws Exception {
        return vehicleDAO.getvanCount();
    }

    @Override
    public String getbusCount() throws Exception {
        return vehicleDAO.getbusCount();
    }

    @Override
    public String getBikeCount() throws Exception {
        return vehicleDAO.getbikeCount();
    }
}
