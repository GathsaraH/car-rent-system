package entity;

public class Returns {
    String returnID;
    String rID;
    String cID;
    String returnDate;

    public Returns() {
    }

    public Returns(String returnID, String rID, String cID, String returnDate) {
        this.returnID = returnID;
        this.rID = rID;
        this.cID = cID;
        this.returnDate = returnDate;
    }


    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
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

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
