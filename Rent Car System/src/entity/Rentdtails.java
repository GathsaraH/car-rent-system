package entity;

public class Rentdtails {
    String rID;
    String rentDate;
    String vID;
    double chargePerday;
    double rAdvance;
    String rStatus;

    public Rentdtails() {
    }

    public Rentdtails(String rID, String rentDate, String vID, double chargePerday, double rAdvance, String rStatus) {
        this.rID = rID;
        this.rentDate = rentDate;
        this.vID = vID;
        this.chargePerday = chargePerday;
        this.rAdvance = rAdvance;
        this.rStatus = rStatus;
    }



    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public double getChargePerday() {
        return chargePerday;
    }

    public void setChargePerday(double chargePerday) {
        this.chargePerday = chargePerday;
    }

    public double getrAdvance() {
        return rAdvance;
    }

    public void setrAdvance(double rAdvance) {
        this.rAdvance = rAdvance;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus;
    }

    @Override
    public String toString() {
        return "Rentdtails{" +
                "rID='" + rID + '\'' +
                ", rentDate='" + rentDate + '\'' +
                ", vID='" + vID + '\'' +
                ", chargePerday=" + chargePerday +
                ", rAdvance=" + rAdvance +
                ", rStatus='" + rStatus + '\'' +
                '}';
    }
}
