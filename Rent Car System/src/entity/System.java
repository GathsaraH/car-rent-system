package entity;

public class System {
    String sID;
    String sName;
    String sAddress;
    String sNumber;
    String sEmail;
    String sPassword;


    public System() {
    }

    public System(String sID, String sName, String sAddress, String sNumber) {
        this.sID = sID;
        this.sName = sName;
        this.sAddress = sAddress;
        this.sNumber = sNumber;

    }

    public System(String sID, String sName, String sAddress, String sNumber, String sEmail, String sPassword) {
        this.sID = sID;
        this.sName = sName;
        this.sAddress = sAddress;
        this.sNumber = sNumber;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }


}
