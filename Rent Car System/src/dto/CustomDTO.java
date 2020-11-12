package dto;

import java.time.LocalDate;

public class CustomDTO {
    int breakdowndID;
    String breakdownID;
    String breakdownStatus;
    String fixDate ;

    //String breakdownID;
    String vehicleID;
    String brokenDate;

    String customerID;
    String customerAddress;
    String customerName;
    String customertpNumber;

    //String customerID;
    String payID;
    String payDate;
    double payment;

    String rentID;
    String rentDate;
    //String vehicleID;
    double chargePerday;
    double rentAdvance;
    String rentStatus;

    //String rentID;
    //String customerID;
    String rentcustName;
    String endDate;

    String returndID;
    String returnID;
    //String customerID;
    //String rentDate;
    //String vehicleID;
    String returnDate;
    //double chargePerday;
    //double rentAdvance;

    int systemdID;
    String systemID;
    String systemEmail;
    String systemPassword ;

    //String systemID;
    String systemName;
    String systemAddress;
    String systemNumber;

    private String id;
    private String name;
    private String status;
    private String model;
    private String type;
    private String color;
    String serchreturnDate;

    public CustomDTO() {
    }

    public CustomDTO(int breakdowndID, String breakdownID, String breakdownStatus, String fixDate, String vehicleID, String brokenDate, String customerID, String customerAddress, String customerName, String customertpNumber, String payID, String payDate, double payment, String rentID, String rentDate, double chargePerday, double rentAdvance, String rentStatus, String rentcustName,String endDate, String returndID, String returnID, String returnDate, int systemdID, String systemID, String systemEmail, String systemPassword, String systemName, String systemAddress, String systemNumber, String id, String name, String status, String model, String type, String color) {
        this.breakdowndID = breakdowndID;
        this.breakdownID = breakdownID;
        this.breakdownStatus = breakdownStatus;
        this.fixDate = fixDate;
        this.vehicleID = vehicleID;
        this.brokenDate = brokenDate;
        this.customerID = customerID;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
        this.customertpNumber = customertpNumber;
        this.payID = payID;
        this.payDate = payDate;
        this.payment = payment;
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.chargePerday = chargePerday;
        this.rentAdvance = rentAdvance;
        this.rentStatus = rentStatus;
        this.rentcustName = rentcustName;
        this.endDate=endDate;
        this.returndID = returndID;
        this.returnID = returnID;
        this.returnDate = returnDate;
        this.systemdID = systemdID;
        this.systemID = systemID;
        this.systemEmail = systemEmail;
        this.systemPassword = systemPassword;
        this.systemName = systemName;
        this.systemAddress = systemAddress;
        this.systemNumber = systemNumber;
        this.id = id;
        this.name = name;
        this.status = status;
        this.model = model;
        this.type = type;
        this.color = color;
    }

    public CustomDTO(String rentID, String customerID, String rentcustName, LocalDate rentDate, String vehicleID, double chargePerday, double rentAdvance, String rentStatus) {
        this.rentID=rentID;
        this.customerID=customerID;
        this.rentcustName=rentcustName;
        this.rentDate= String.valueOf(rentDate);
        this.vehicleID=vehicleID;
        this.chargePerday=chargePerday;
        this.rentAdvance=rentAdvance;
        this.rentStatus=rentStatus;

    }


    public CustomDTO(String customerName, String rentID, String rentDate,String name, double rentAdvance, String rentStatus) {
        this.customerName = customerName;
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.name = name;
        this.rentAdvance = rentAdvance;
        this.rentStatus = rentStatus;
    }
/*

    public CustomDTO(String vehicleID, String rentID, String rentDate, double chargePerday, double rentAdvance, String rentStatus) {
        this.vehicleID = vehicleID;
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.chargePerday = chargePerday;
        this.rentAdvance = rentAdvance;
        this.rentStatus = rentStatus;
    }
*/

/*    public CustomDTO(String rentID, String rentDate,String vID, double chargePerday, double rentAdvance, String customerName,String customerID) {
        this.rentID = rentID;
        this.rentDate = rentDate;
        this.vehicleID=vID;
        this.chargePerday = chargePerday;
        this.rentAdvance = rentAdvance;
        this.customerName = customerName;
        this.customerID=customerID;
    }*/


    public  CustomDTO(String rentID,String customerID,String customerName,double chargePerday,double rentAdvance,String rentDate){
        this.rentID=rentID;
        this.customerID=customerID;
        this.customerName=customerName;
        this.chargePerday=chargePerday;
        this.rentAdvance=rentAdvance;
        this.rentDate=rentDate;
    }

    public  CustomDTO(String rentID,String customerID,String customerName,double chargePerday,double rentAdvance,String rentDate,String endDate){
        this.rentID=rentID;
        this.customerID=customerID;
        this.customerName=customerName;
        this.chargePerday=chargePerday;
        this.rentAdvance=rentAdvance;
        this.rentDate=rentDate;
        this.endDate=endDate;
    }


    public  CustomDTO(String rentID,String customerName,String vehicleID,String rentDate,String returnDate,double payment){
        this.rentID=rentID;
        this.customerName=customerName;
        this.vehicleID=vehicleID;
        this.rentDate=rentDate;
        this.returnDate=returnDate;
        this.payment=payment;

    }


    public String getSerchreturnDate() {
        return serchreturnDate;
    }

    public void setSerchreturnDate(String serchreturnDate) {
        this.serchreturnDate = serchreturnDate;
    }

    public int getBreakdowndID() {
        return breakdowndID;
    }
    public void setBreakdowndID(int breakdowndID) {
        this.breakdowndID = breakdowndID;
    }

    public String getBreakdownID() {
        return breakdownID;
    }

    public void setBreakdownID(String breakdownID) {
        this.breakdownID = breakdownID;
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomertpNumber() {
        return customertpNumber;
    }

    public void setCustomertpNumber(String customertpNumber) {
        this.customertpNumber = customertpNumber;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
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

    public String getRentcustName() {
        return rentcustName;
    }

    public void setRentcustName(String rentcustName) {
        this.rentcustName = rentcustName;
    }

    public String getReturndID() {
        return returndID;
    }

    public void setReturndID(String returndID) {
        this.returndID = returndID;
    }

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getSystemdID() {
        return systemdID;
    }

    public void setSystemdID(int systemdID) {
        this.systemdID = systemdID;
    }

    public String getSystemID() {
        return systemID;
    }

    public void setSystemID(String systemID) {
        this.systemID = systemID;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }

    public String getSystemPassword() {
        return systemPassword;
    }

    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemAddress() {
        return systemAddress;
    }

    public void setSystemAddress(String systemAddress) {
        this.systemAddress = systemAddress;
    }

    public String getSystemNumber() {
        return systemNumber;
    }

    public void setSystemNumber(String systemNumber) {
        this.systemNumber = systemNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "vehicleID='" + vehicleID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", rentID='" + rentID + '\'' +
                ", rentDate='" + rentDate + '\'' +
                ", chargePerday=" + chargePerday +
                ", rentAdvance=" + rentAdvance +
                ", rentcustName='" + rentcustName + '\'' +
                "endDate='" + endDate + '\'' +
                '}';
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
