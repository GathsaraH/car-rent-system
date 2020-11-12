package dto;

public class SystemDetailsDTO {
    int systemdID;
    String systemID;
    String systemEmail;
    String systemPassword ;

    public SystemDetailsDTO() {
    }

    public SystemDetailsDTO(int systemdID, String systemID, String systemEmail, String systemPassword) {
        this.systemdID = systemdID;
        this.systemID = systemID;
        this.systemEmail = systemEmail;
        this.systemPassword = systemPassword;
    }

    public int getSystemdID() {
        return systemdID;
    }

    public void setSystemdID(int systemdID) {
        this.systemdID = systemdID;
    }

    public String getSystemID() {
        return systemID;
    }

    public void setSystemID(String systemID) {
        this.systemID = systemID;
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
}
