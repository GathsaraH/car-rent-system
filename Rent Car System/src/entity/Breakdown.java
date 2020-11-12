package entity;

public class Breakdown {
   String bID;
   String vID;

    public Breakdown() {
    }

    public Breakdown(String bID, String vID) {
        this.bID = bID;
        this.vID = vID;
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


}
