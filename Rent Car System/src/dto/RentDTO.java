package dto;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class RentDTO {
    String rentID;
    String customerID;
    String rentcustName;
    String vehicleID;
    String endDate;
    ArrayList<RentdtailsDTO> dtos;

    public RentDTO() {
    }

    public RentDTO(String rentID, String customerID, String rentcustName,String vehicleID) {
        this.rentID = rentID;
        this.customerID = customerID;
        this.rentcustName = rentcustName;
        this.vehicleID=vehicleID;
    }

    public RentDTO(String rentID, String customerID, String rentcustName,String vehicleID,String endDate, ArrayList<RentdtailsDTO> dtos) {
        this.rentID = rentID;
        this.customerID = customerID;
        this.rentcustName = rentcustName;
        this.vehicleID=vehicleID;
        this.endDate=endDate;
        this.dtos = dtos;
    }

    public ArrayList<RentdtailsDTO> getDtos() {
        return dtos;
    }

    public void setDtos(ArrayList<RentdtailsDTO> dtos) {
        this.dtos = dtos;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public String getCustomerID() {
        return customerID;
    }

    @Override
    public String toString() {
        return "RentDTO{" +
                "rentID='" + rentID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", rentcustName='" + rentcustName + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", dtos=" + dtos +
                '}';
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getRentcustName() {
        return rentcustName;
    }

    public void setRentcustName(String rentcustName) {
        this.rentcustName = rentcustName;
    }



}
