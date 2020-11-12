package entity;

public class Rent {
    String rID;
    String cID;
    String rcName;
    String vID;
    String endDate;
    public Rent() {
    }

    public Rent(String rID, String cID, String rcName, String vID,String endDate) {
        this.rID = rID;
        this.cID = cID;
        this.rcName = rcName;
        this.vID = vID;
        this.endDate=endDate;
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

    public String getRcName() {
        return rcName;
    }

    public void setRcName(String rcName) {
        this.rcName = rcName;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rID='" + rID + '\'' +
                ", cID='" + cID + '\'' +
                ", rcName='" + rcName + '\'' +
                ", vID='" + vID + '\'' +
                '}';
    }
}
