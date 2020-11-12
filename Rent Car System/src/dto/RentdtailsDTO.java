package dto;

public class RentdtailsDTO {
    private String custName;
    private String rentID;
    private String rentDate;
    private String vehicleID;
    private double chargePerday;
    private double rentAdvance;
    private String rentStatus;

    public RentdtailsDTO() {
    }

    public RentdtailsDTO(String rentID, String rentDate, String vehicleID, double chargePerday, double rentAdvance, String rentStatus) {
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.vehicleID = vehicleID;
        this.chargePerday = chargePerday;
        this.rentAdvance = rentAdvance;
        this.rentStatus = rentStatus;
    }

    public RentdtailsDTO(String custName, String rentID, String rentDate, String vehicleID, double rentAdvance, String rentStatus) {
        this.custName = custName;
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.vehicleID = vehicleID;
        this.rentAdvance = rentAdvance;
        this.rentStatus = rentStatus;
    }

    public RentdtailsDTO(String custName, String rentID, String rentDate, String vehicleID, double chargePerday, double rentAdvance, String rentStatus) {
        this.custName = custName;
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.vehicleID = vehicleID;
        this.chargePerday = chargePerday;
        this.rentAdvance = rentAdvance;
        this.rentStatus = rentStatus;
    }

    @Override
    public String toString() {
        return "RentdtailsDTO{" +
                "custName='" + custName + '\'' +
                ", rentID='" + rentID + '\'' +
                ", rentDate='" + rentDate + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", chargePerday=" + chargePerday +
                ", rentAdvance=" + rentAdvance +
                ", rentStatus='" + rentStatus + '\'' +
                '}';
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getVehicleID() {
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

    public double getRentAdvance() {
        return rentAdvance;
    }

    public void setRentAdvance(double rentAdvance) {
        this.rentAdvance = rentAdvance;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }
}
