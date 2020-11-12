package entity;

import javafx.collections.ObservableList;

public class Vehicle {
    String vID;
    String vName;
    String vStates;
    String vModle;
    String vType;
    String vColor;

    public Vehicle() {
    }

    public Vehicle(String vID) {
        this.vID = vID;
    }

    public Vehicle(String vID, String vName, String vStates, String vModle, String vType, String vColor) {
        this.vID = vID;
        this.vName = vName;
        this.vStates = vStates;
        this.vModle = vModle;
        this.vType = vType;
        this.vColor = vColor;
    }

    public Vehicle(String vID, String vStates) {
        this.vID = vID;
        this.vStates = vStates;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
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


    @Override
    public String toString() {
        return "Vehicle{" +
                "vID='" + vID + '\'' +
                ", vName='" + vName + '\'' +
                ", vStates='" + vStates + '\'' +
                ", vModle='" + vModle + '\'' +
                ", vType='" + vType + '\'' +
                ", vColor='" + vColor + '\'' +
                '}';
    }
}
