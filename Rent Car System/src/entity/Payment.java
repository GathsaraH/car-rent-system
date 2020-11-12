package entity;

public class Payment {
    String returnID;
    String cID;
    String vID;
    String pDate;
    double payment;
    int linechart;

    public Payment() {
    }

    public Payment(String returnID,String cID,String vID, String pDate, double payment) {
        this.returnID=returnID;
        this.cID = cID;
        this.vID=vID;
        this.pDate = pDate;
        this.payment = payment;
    }

    public  Payment(String pDate,int linechart){
        this.pDate=pDate;
        this.linechart=linechart;
    }

    public int getLinechart() {
        return linechart;
    }

    public void setLinechart(int linechart) {
        this.linechart = linechart;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getReturnID() {
        return returnID;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
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
        this.payment = payment;
    }
}
