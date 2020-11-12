package bo.custom;

import bo.SuperBO;
import dto.SystemDTO;
import entity.System;

import java.util.ArrayList;

public interface UsersStaticBO extends SuperBO {
    public String genaretaUserID() throws Exception;
    public boolean addUser(SystemDTO systemDTO) throws  Exception;
    public  boolean deleteUser(String systemID) throws  Exception;
    public ArrayList<String> getAllUseID() throws  Exception;
    public boolean updateUsers(SystemDTO systemDTO) throws Exception;
    public SystemDTO serchUser(String id) throws  Exception;
    public  ArrayList<SystemDTO> loadUserTable() throws  Exception;
}
