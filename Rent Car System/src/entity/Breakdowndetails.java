package entity;

public class Breakdowndetails {

    String bID;
    String vID;
    String breakdownStatus;
    String brokenDate ;

    public Breakdowndetails() {
    }

    public Breakdowndetails(String bID, String vID, String breakdownStatus, String brokenDate) {
        this.bID = bID;
        this.vID = vID;
        this.breakdownStatus = breakdownStatus;
        this.brokenDate = brokenDate;
    }

    public Breakdowndetails(String brokenDate, String breakdownStatus) {
        this.brokenDate=brokenDate;
        this.breakdownStatus=breakdownStatus;
    }

    public Breakdowndetails(String vID, String brokenDate, String breakdownStatus) {
        this.vID=vID;
        this.brokenDate=brokenDate;
        this.breakdownStatus=breakdownStatus;
    }

    public Breakdowndetails(String vID) {
        this.vID=vID;
    }

    @Override
    public String toString() {
        return "Breakdowndetails{" +
                "bID='" + bID + '\'' +
                ", vID='" + vID + '\'' +
                ", breakdownStatus='" + breakdownStatus + '\'' +
                ", brokenDate='" + brokenDate + '\'' +
                '}';
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public String getBreakdownStatus() {
        return breakdownStatus;
    }

    public void setBreakdownStatus(String breakdownStatus) {
        this.breakdownStatus = breakdownStatus;
    }

    public String getBrokenDate() {
        return brokenDate;
    }

    public void setBrokenDate(String brokenDate) {
        this.brokenDate = brokenDate;
    }
}
