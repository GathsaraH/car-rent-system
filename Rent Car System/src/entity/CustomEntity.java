package entity;

public class CustomEntity {
    String bID;
    String vID;
    String brokenDate;

    int bdID;
    //String bID;
    String breakdownStatus;
    String fixDate ;

    String cID;
    String cAddress;
    String cName;
    String cNumber;

    //String cID;
    //String returnID;
    String pDate;
    double payment;

    String rID;
    //String cID;
    String rcName;
    String endDate;

    //String rID;
    String rentDate;
    //String vID;
    double chargePerday;
    double rAdvance;
    String rStatus;

    String returnID;
    //String rID;
    //String cID;
    //String rentDate;
    //String vID;
    String returnDate;
    //double chargePerday;
    //double rAdvance;

    String sID;
    String sName;
    String sAddress;
    String sNumber;

    int sdID;
    //String sID;
    String sEmail;
    String sPassword ;

    //String vID;
    String vName;
    String vStates;
    String vModle;
    String vType;
    String vColor;

    public CustomEntity() {
    }

    public CustomEntity(String bID, String vID, String brokenDate, int bdID, String breakdownStatus, String fixDate, String cID, String cAddress, String cName, String cNumber,  String pDate, double payment, String rID, String rcName,String endDate, String rentDate, double chargePerday, double rAdvance, String rStatus, String returnID, String returnDate, String sID, String sName, String sAddress, String sNumber, int sdID, String sEmail, String sPassword, String vName, String vStates, String vModle, String vType, String vColor) {
        this.bID = bID;
        this.vID = vID;
        this.brokenDate = brokenDate;
        this.bdID = bdID;
        this.breakdownStatus = breakdownStatus;
        this.fixDate = fixDate;
        this.cID = cID;
        this.cAddress = cAddress;
        this.cName = cName;
        this.cNumber = cNumber;
        this.pDate = pDate;
        this.payment = payment;
        this.rID = rID;
        this.rcName = rcName;
        this.endDate=endDate;
        this.rentDate = rentDate;
        this.chargePerday = chargePerday;
        this.rAdvance = rAdvance;
        this.rStatus = rStatus;
        this.returnID = returnID;
        this.returnDate = returnDate;
        this.sID = sID;
        this.sName = sName;
        this.sAddress = sAddress;
        this.sNumber = sNumber;
        this.sdID = sdID;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
        this.vName = vName;
        this.vStates = vStates;
        this.vModle = vModle;
        this.vType = vType;
        this.vColor = vColor;
    }

    public CustomEntity(String rID,String rentDate,String vID,double chargePerday,double rAdvance,String cName,String cID,String endDate){
        this.rID=rID;
        this.rentDate=rentDate;
        this.vID=vID;
        this.chargePerday=chargePerday;
        this.rAdvance=rAdvance;
        this.cName=cName;
        this.cID=cID;
        this.endDate=rentDate;
        this.endDate=endDate;
    }


    public  CustomEntity(String rID,String cID,String rcName,String endDate,String rentDate,String vID,double chargePerday,double rAdvance){
        this.rID=rID;
        this.cID=cID;
        this.rcName=rcName;
        this.endDate=endDate;
        this.rAdvance=rAdvance;
        this.rentDate=rentDate;
        this.vID=vID;
        this.chargePerday=chargePerday;
        this.rAdvance=rAdvance;
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

    public String getBrokenDate() {
        return brokenDate;
    }

    public void setBrokenDate(String brokenDate) {
        this.brokenDate = brokenDate;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
        this.bdID = bdID;
    }

    public String getBreakdownStatus() {
        return breakdownStatus;
    }

    public void setBreakdownStatus(String breakdownStatus) {
        this.breakdownStatus = breakdownStatus;
    }

    public String getFixDate() {
        return fixDate;
    }

    public void setFixDate(String fixDate) {
        this.fixDate = fixDate;
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

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {


        if(payment>5000){
            this.payment = payment;
        }
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public String getRcName() {
        return rcName;
    }

    public void setRcName(String rcName) {
        this.rcName = rcName;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
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

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
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

    public int getSdID() {
        return sdID;
    }

    public void setSdID(int sdID) {
        this.sdID = sdID;
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

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvStates() {
        return vStates;
    }

    public void setvStates(String vStates) {
        this.vStates = vStates;
    }

    public String getvModle() {
        return vModle;
    }

    public void setvModle(String vModle) {
        this.vModle = vModle;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getvColor() {
        return vColor;
    }

    public void setvColor(String vColor) {
        this.vColor = vColor;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }




 /*   @Override
    public String toString() {
                ", cID='" + cID + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", cName='" + cName + '\'' +
                ", cNumber='" + cNumber + '\'' +
                ", pDate='" + pDate + '\'' +
                ", payment=" + payment +
                ", rID='" + rID + '\'' +
                ", rcName='" + rcName + '\'' +
                ", endDate='" + endDate + '\'' +
                ", rentDate='" + rentDate + '\'' +
                ", chargePerday=" + chargePerday +
                ", rAdvance=" + rAdvance +
                ", rStatus='" + rStatus + '\'' +
                ", returnID='" + returnID + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", sID='" + sID + '\'' +
                ", sName='" + sName + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", sNumber='" + sNumber + '\'' +
                ", sdID=" + sdID +
                ", sEmail='" + sEmail + '\'' +
                ", sPassword='" + sPassword + '\'' +
                ", vName='" + vName + '\'' +
                ", vStates='" + vStates + '\'' +
                ", vModle='" + vModle + '\'' +
                ", vType='" + vType + '\'' +
                ", vColor='" + vColor + '\'' +
                '}';
    }*/
    @Override
    public String toString() {
        return "CustomEntity{" +
                "vID='" + vID + '\'' +
                ", cID='" + cID + '\'' +
                ", rID='" + rID + '\'' +
                ", rcName='" + rcName + '\'' +
                ", rentDate='" + rentDate + '\'' +
                ", chargePerday=" + chargePerday +
                ", rAdvance=" + rAdvance +
                '}';
    }
}
