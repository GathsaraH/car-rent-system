package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.VehicleDAO;
import entity.Vehicle;

import java.sql.ResultSet;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public boolean add(Vehicle vehicle) throws Exception {
        String sql="insert into vehicle values(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,vehicle.getvID(),vehicle.getvName(),vehicle.getvStates(),vehicle.getvModle(),vehicle.getvType(),vehicle.getvColor());
    }

    @Override
    public boolean delete(String vID) throws Exception {
        String sql="delete from vehicle where vID=?";
        return CrudUtil.executeUpdate(sql,vID);

    }

    @Override
    public boolean update(Vehicle vID) throws Exception {
        String sql="update vehicle set vName=?,vStates=?,vModle=?,vType=?,vColor=? where vID=?";
        return CrudUtil.executeUpdate(sql,vID.getvName(),vID.getvStates(),vID.getvModle(),vID.getvType(),vID.getvColor(),vID.getvID());
    }

    @Override
    public Vehicle search(String vID) throws Exception{
        String sql="select * from vehicle where vID=?";
        ResultSet rst=CrudUtil.executeQuery(sql,vID);
        if (rst.next()){
            return new Vehicle(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4), rst.getString(5),rst.getString(6));

        }
        return null;
    }

    @Override
    public ArrayList<Vehicle> getAll() throws Exception {
        String sql="select * from vehicle";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Vehicle> allVehicle =new ArrayList<>();
        while (rst.next()){
            allVehicle.add(new Vehicle(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return allVehicle;
    }



    @Override
    public String lastVehicleID() throws Exception {
        String sql="select  vID from  vehicle order BY vID desc limit 1 ";
        ResultSet rst= CrudUtil.executeQuery(sql);
        //return (rst.next())?rst.getString("vID"):null;
        return (rst.next())?rst.getString("vId"):null;
    }

    @Override
    public boolean updateStatusOnly(Vehicle vehicle) throws Exception {
        String sql="update vehicle set vStates='OnUseBreakDown' WHERE vID=?";
        return CrudUtil.executeUpdate(sql,vehicle.getvID());
    }

    @Override
    public boolean updateReturnStatus(Vehicle vehicle) throws Exception {
        String sql="update vehicle set vStates='Good' WHERE vID=?";
        return CrudUtil.executeUpdate(sql,vehicle.getvID());
    }

    @Override
    public boolean updateOnUse(Vehicle id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Vehicle> serchvehicleFromStatus() throws Exception {
        String sql="select * from vehicle WHERE vStates='Good'";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Vehicle> allVehicle =new ArrayList<>();
        while (rst.next()){
            allVehicle.add(new Vehicle(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return allVehicle;
    }

    @Override
    public ArrayList<Vehicle> getAllvehicleForBD() throws Exception {
        String sql="select * from vehicle where vStates='OnUseBreakDown' ";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Vehicle> allVehicle =new ArrayList<>();
        while (rst.next()){
            allVehicle.add(new Vehicle(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return allVehicle;
    }

    @Override
    public ArrayList<Vehicle> getAllvehicleForReturns() throws Exception {
        String sql="select * from vehicle where vStates='OnUse' ";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<Vehicle> allVehicle =new ArrayList<>();
        while (rst.next()){
            allVehicle.add(new Vehicle(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return allVehicle;
    }

    @Override
    public boolean updateStatusForRent(Vehicle id) throws Exception {
        String sql="update vehicle set vStates='OnUse' WHERE vID=?";
        return CrudUtil.executeUpdate(sql,id.getvID());
    }


    @Override
    public String getcarCount() throws Exception {
        String sql="SELECT COUNT(vType) FROM vehicle WHERE vType='car' && vStates='Good' order BY vID desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        //return (rst.next())?rst.getString("vID"):null;
        return (rst.next())?rst.getString(1):null;
    }

    @Override
    public String getvanCount() throws Exception {
        String sql="SELECT COUNT(vType) FROM vehicle WHERE vType='Van' && vStates='Good' order BY vID desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        //return (rst.next())?rst.getString("vID"):null;
        return (rst.next())?rst.getString(1):null;
    }

    @Override
    public String getbusCount() throws Exception {
        String sql="SELECT COUNT(vType) FROM vehicle WHERE vType='Bus' && vStates='Good' order BY vID desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        //return (rst.next())?rst.getString("vID"):null;
        return (rst.next())?rst.getString(1):null;
    }

    @Override
    public String getbikeCount() throws Exception {
        String sql="SELECT COUNT(vType) FROM vehicle WHERE vType='Bike' && vStates='Good' order BY vID desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        //return (rst.next())?rst.getString("vID"):null;
        return (rst.next())?rst.getString(1):null;
    }

}
