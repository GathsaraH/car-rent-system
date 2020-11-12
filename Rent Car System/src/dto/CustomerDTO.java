package dto;

public class CustomerDTO {
    String customerID;
    String customerAddress;
    String customerName;
    String customertpNumber;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerID,String customerName, String customerAddress, String customertpNumber) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customertpNumber = customertpNumber;
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

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerID='" + customerID + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customertpNumber='" + customertpNumber + '\'' +
                '}';
    }
}
