package dto;

import java.util.ArrayList;

public class ReturnsDTO {
    String returnID;
    String rID;
    String cID;
    String returnDate;

    //String rentDate;
    //String vehicleID;
    //double chargePerday;
    //double rAdvance;

    ArrayList<PaymentDTO> py;

    ReturndtailsDTO returndtailsDTO;
    
    

    public ReturnsDTO() {
    }

    public ReturnsDTO(String returnID, String rID, String cID, String returnDate,ArrayList<PaymentDTO> py ){
        this.returnID=returnID;
        this.rID=rID;
        this.cID=cID;
        this.returnDate=returnDate;
        this.py=py;


    }

    public ReturnsDTO(String returnID, String rID, String cID, String returnDate) {
        this.returnID = returnID;
        this.rID = rID;
        this.cID = cID;
        this.returnDate = returnDate;
    }


/*
    public  ReturnsDTO(String returnDate,String rentDate,String vehicleID,double chargePerday,double rAdvance){
        this.returnDate=returnDate;
        this.rentDate=rentDate;
        this.vehicleID=vehicleID;
        this.chargePerday=chargePerday;
        this.rAdvance=rAdvance;
    }
*/

/*    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }*/

/*    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
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
    }*/

/*    public ReturnsDTO(String returnID, String rID, String cID, String returnDate, ReturndtailsDTO returndtailsDTO, ArrayList<PaymentDTO> py) {
        this.returnID=returnID;
        this.rID=rID;
        this.cID=cID;
        this.returnDate=returnDate;
        this.returndtailsDTO=returndtailsDTO;
        this.py=py;

    }*/

    @Override
    public String toString() {
        return "ReturnsDTO{" +
                "returnID='" + returnID + '\'' +
                ", rID='" + rID + '\'' +
                ", cID='" + cID + '\'' +
                ", returnDate='" + returnDate + '\'' +
               // ", rentDate='" + rentDate + '\'' +
                //", vehicleID='" + vehicleID + '\'' +
                //", chargePerday=" + chargePerday +
               // ", rAdvance=" + rAdvance +
                ", py=" + py +
                ", returndtailsDTO=" + returndtailsDTO +
                '}';
    }

    public ArrayList<PaymentDTO> getPy() {
        return py;
    }

    public void setPy(ArrayList<PaymentDTO> py) {
        this.py = py;
    }

    public ReturndtailsDTO getReturndtailsDTO() {
        return returndtailsDTO;
    }

    public void setReturndtailsDTO(ReturndtailsDTO returndtailsDTO) {
        this.returndtailsDTO = returndtailsDTO;
    }

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
