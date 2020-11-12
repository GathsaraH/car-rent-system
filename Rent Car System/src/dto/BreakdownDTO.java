package dto;

import java.util.ArrayList;

public class BreakdownDTO {
    String breakdownID;
    String vehicleID;
    String brokenDate;
    String brokenStatus;
    ArrayList<BreakdowndetailsDTO> BreakDetails;


    public BreakdownDTO() {
    }

    public BreakdownDTO(ArrayList<BreakdowndetailsDTO> breakDetails) {
        BreakDetails = breakDetails;
    }

  public BreakdownDTO(String breakdownID, String vehicleID, String brokenDate, String brokenStatus) {
        this.breakdownID = breakdownID;
        this.vehicleID = vehicleID;
        this.brokenDate = brokenDate;
        this.brokenStatus = brokenStatus;
    }

    public BreakdownDTO(String breakdownID, String vehicleID, String brokenDate,ArrayList<BreakdowndetailsDTO> BreakDetails) {
        this.breakdownID = breakdownID;
        this.vehicleID = vehicleID;
        this.brokenDate = brokenDate;
        this.BreakDetails=BreakDetails;
    }



    public ArrayList<BreakdowndetailsDTO> getBreakDetails() {
        return BreakDetails;
    }

    public void setBreakDetails(ArrayList<BreakdowndetailsDTO> breakDetails) {
        BreakDetails = breakDetails;
    }


    @Override
    public String toString() {
        return "BreakdownDTO{" +
                "breakdownID='" + breakdownID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", brokenDate='" + brokenDate + '\'' +
                ", brokenStatus='" + brokenStatus + '\'' +
                ", BreakDetails=" + BreakDetails +
                '}';
    }

    public String getBreakdownID() {
        return breakdownID;
    }

    public void setBreakdownID(String breakdownID) {
        this.breakdownID = breakdownID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrokenDate() {
        return brokenDate;
    }

    public void setBrokenDate(String brokenDate) {
        this.brokenDate = brokenDate;
    }

    public String getBrokenStatus() {
        return brokenStatus;
    }

    public void setBrokenStatus(String brokenStatus) {
        this.brokenStatus = brokenStatus;
    }
}
