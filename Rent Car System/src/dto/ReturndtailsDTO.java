package dto;

import entity.Payment;

import java.util.ArrayList;

public class ReturndtailsDTO {
    String returnID;
    String rentDate;
    String vID;
    double chargePerday;
    double rAdvance;

    public ReturndtailsDTO() {
    }

    public ReturndtailsDTO(String returnID, String rentDate, String vID, double chargePerday, double rAdvance) {
        this.returnID = returnID;
        this.rentDate = rentDate;
        this.vID = vID;
        this.chargePerday = chargePerday;
        this.rAdvance = rAdvance;
    }

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public double getChargePerday() {
        return chargePerday;
    }

    public void setChargePerday(double chargePerday) {
        this.chargePerday = chargePerday;
    }

    public double getrAdvance() {
        return rAdvance;
    }

    public void setrAdvance(double rAdvance) {
        this.rAdvance = rAdvance;
    }

    @Override
    public String toString() {
        return "ReturndtailsDTO{" +
                "returnID='" + returnID + '\'' +
                ", rentDate='" + rentDate + '\'' +
                ", vID='" + vID + '\'' +
                ", chargePerday=" + chargePerday +
                ", rAdvance=" + rAdvance +
                '}';
    }
}
