package entity;

public class SystemDetails {
    int sdID;
    String sID;
    String sEmail;
    String sPassword ;

    public SystemDetails() {
    }

    public SystemDetails(int sdID, String sID, String sEmail, String sPassword) {
        this.sdID = sdID;
        this.sID = sID;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
    }

    public int getSdID() {
        return sdID;
    }

    public void setSdID(int sdID) {
        this.sdID = sdID;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
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
}
