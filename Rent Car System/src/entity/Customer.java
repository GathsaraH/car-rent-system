package entity;

public class Customer {
    String cID;
    String cAddress;
    String cName;
    String cNumber;

    public Customer() {
    }

    public Customer(String cID, String cAddress, String cName, String cNumber) {
        this.cID = cID;
        this.cAddress = cAddress;
        this.cName = cName;
        this.cNumber = cNumber;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cID='" + cID + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", cName='" + cName + '\'' +
                ", cNumber='" + cNumber + '\'' +
                '}';
    }
}
