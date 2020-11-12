package dto;

import java.util.ArrayList;

public class BreakdowndetailsDTO {
    String breakdowndID;
    String vehicleID;
    String breakdownStatus;
    String fixDate ;
    String brokenDate;
    ArrayList<BreakdownDTO> bre;


    public BreakdowndetailsDTO() {
    }

    public BreakdowndetailsDTO(ArrayList<BreakdownDTO> bre) {
        this.bre = bre;
    }

    public BreakdowndetailsDTO(String breakdowndID, String vehicleID, String breakdownStatus, String brokenDate) {
        this.breakdowndID = breakdowndID;
        this.vehicleID=vehicleID;
        this.breakdownStatus = breakdownStatus;
        this.brokenDate = brokenDate;
    }

/*
    public BreakdowndetailsDTO(String brokenDate, String breakdownStatus) {
        this.brokenDate=brokenDate;
        this.breakdownStatus=breakdownStatus;
    }

    public BreakdowndetailsDTO(String breakdownStatus) {
        this.breakdownStatus=breakdownStatus;
    }

    public BreakdowndetailsDTO(String vehicleID, String brokenDate, String breakdownStatus) {
        this.vehicleID=vehicleID;
        this.brokenDate=brokenDate;
        this.breakdownStatus=breakdownStatus;
    }
*/


    public ArrayList<BreakdownDTO> getBre() {
        return bre;
    }

    public String getBrokenDate() {
        return brokenDate;
    }

    public void setBrokenDate(String brokenDate) {
        this.brokenDate = brokenDate;
    }

    public void setBre(ArrayList<BreakdownDTO> bre) {
        this.bre = bre;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBreakdowndID() {
        return breakdowndID;
    }

    public void setBreakdowndID(String breakdowndID) {
        this.breakdowndID = breakdowndID;
    }



    public String getBreakdownStatus() {
        return breakdownStatus;
    }

    public void setBreakdownStatus(String breakdownStatus) {
        this.breakdownStatus = breakdownStatus;
    }

    public String getFixDate() {
        return fixDate;
    }

    public void setFixDate(String fixDate) {
        this.fixDate = fixDate;
    }

    @Override
    public String toString() {
        return "BreakdowndetailsDTO{" +
                "breakdowndID='" + breakdowndID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                //", breakdownID='" + breakdownID + '\'' +
                ", breakdownStatus='" + breakdownStatus + '\'' +
                ", fixDate='" + fixDate + '\'' +
                '}';
    }
}
