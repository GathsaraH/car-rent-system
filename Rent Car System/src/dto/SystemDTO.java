package dto;

public class SystemDTO {
    String systemID;
    String systemName;
    String systemAddress;
    String systemNumber;
    String systemEmail;
    String systemPassword;

    public SystemDTO() {
    }

    public SystemDTO(String systemID) {
        this.systemID = systemID;
    }

    public SystemDTO(String systemID, String systemName, String systemAddress, String systemNumber) {
        this.systemID = systemID;
        this.systemName = systemName;
        this.systemAddress = systemAddress;
        this.systemNumber = systemNumber;
    }

    public SystemDTO(String systemID, String systemName, String systemAddress, String systemNumber, String systemEmail, String systemPassword) {
        this.systemID = systemID;
        this.systemName = systemName;
        this.systemAddress = systemAddress;
        this.systemNumber = systemNumber;
        this.systemEmail = systemEmail;
        this.systemPassword = systemPassword;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }

    public String getSystemPassword() {
        return systemPassword;
    }

    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }

    public String getSystemID() {
        return systemID;
    }

    public void setSystemID(String systemID) {
        this.systemID = systemID;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemAddress() {
        return systemAddress;
    }

    public void setSystemAddress(String systemAddress) {
        this.systemAddress = systemAddress;
    }

    public String getSystemNumber() {
        return systemNumber;
    }

    public void setSystemNumber(String systemNumber) {
        this.systemNumber = systemNumber;
    }

    @Override
    public String toString() {
        return "SystemDTO{" +
                "systemID='" + systemID + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemAddress='" + systemAddress + '\'' +
                ", systemNumber='" + systemNumber + '\'' +
                ", systemEmail='" + systemEmail + '\'' +
                ", systemPassword='" + systemPassword + '\'' +
                '}';
    }
}
