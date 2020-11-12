package dto;

public class PaymentDTO {


    String returnID;
    String customerID;
    String vehicleID;
    String rentDate;
    String payDate;
    double payment;
    double chargePerday;
    double rentAdvance;

    int linechart;

    public PaymentDTO() {

    }

    public PaymentDTO(String returnID, String customerID, String vehicleID, String rentDate, String payDate, double payment,double chargePerday,double rentAdvance) {
        this.returnID = returnID;
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.rentDate = rentDate;
        this.payDate = payDate;
        this.payment = payment;
        this.chargePerday=chargePerday;
        this.rentAdvance=rentAdvance;
    }

    public  PaymentDTO(String returnID,String customerID,String vehicleID,String payDate,double payment,String rentDate,double chargePerday,double rentAdvance){
        this.returnID=returnID;
        this.customerID=customerID;
        this.vehicleID=vehicleID;
        this.payDate=payDate;
        this.payment=payment;
        this.rentDate=rentDate;
        this.chargePerday=chargePerday;
        this.rentAdvance=rentAdvance;
    }


    public PaymentDTO(String returnID, String customerID, String vehicleID, String payDate, double payment){
        this.returnID=returnID;
        this.customerID=customerID;
        this.vehicleID=vehicleID;
        this.payDate=payDate;
        this.payment=payment;
    }


    public PaymentDTO(String returnID,String customerID, String payDate, double payment) {
        this.returnID=returnID;
        this.customerID = customerID;
        this.payDate = payDate;
        this.payment = payment;
    }



    public  PaymentDTO(String payDate,int linechart){
        this.payDate=payDate;
        this.linechart=linechart;
    }

    public int getLinechart() {
        return linechart;
    }

    public void setLinechart(int linechart) {
        this.linechart = linechart;
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

/*
    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }
*/

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
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

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "returnID='" + returnID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", rentDate='" + rentDate + '\'' +
                ", payDate='" + payDate + '\'' +
                ", chargePerday='" + chargePerday + '\'' +
                ", rentAdvance='" + rentAdvance + '\'' +
                ", payment=" + payment +

                '}';
    }
}
