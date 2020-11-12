package bo.custom.Impl;

import bo.custom.UsersStaticBO;
import dao.DAOFactory;
import dao.custom.SystemDAO;
import dao.custom.impl.SystemDAOImpl;
import dto.SystemDTO;
import entity.System;

import java.util.ArrayList;

public class UsersStaticBOImpl implements UsersStaticBO {
SystemDAO systemDAO= (SystemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SYSTEMDAO);
    @Override
    public String genaretaUserID() throws Exception {
        return systemDAO.genarateUserID();
    }

    @Override
    public boolean addUser(SystemDTO s) throws Exception {
        return systemDAO.add(new System(s.getSystemID(),s.getSystemName(),s.getSystemAddress(),s.getSystemNumber(),s.getSystemEmail(),s.getSystemPassword()));
    }

    @Override
    public boolean deleteUser(String systemID) throws Exception {
        return systemDAO.delete(systemID);
    }

    @Override
    public ArrayList<String> getAllUseID() throws Exception {
        ArrayList<System> list=systemDAO.getAll();
        ArrayList<String> allId=new ArrayList<>();
        for (System system:list){
            allId.add(system.getsID());
        }

        return allId;
    }

    @Override
    public boolean updateUsers(SystemDTO sy) throws Exception {
        return systemDAO.update(new System(sy.getSystemID(),sy.getSystemName(),sy.getSystemAddress(),sy.getSystemNumber(),sy.getSystemEmail(),sy.getSystemPassword()));
    }

    @Override
    public SystemDTO serchUser(String id) throws Exception {
        System serch=systemDAO.search(id);
        return new SystemDTO(serch.getsID(),serch.getsName(),serch.getsAddress(),serch.getsNumber(),serch.getsEmail(),serch.getsPassword());
    }

    @Override
    public ArrayList<SystemDTO> loadUserTable() throws Exception {
        ArrayList<System> all=systemDAO.getAll();
        ArrayList<SystemDTO> loadUsers=new ArrayList<>();

        for (System s:all){
            loadUsers.add(new SystemDTO(
                    s.getsID(),
                    s.getsName(),
                    s.getsAddress(),
                    s.getsNumber(),
                    s.getsEmail(),
                    s.getsPassword()
            ));

        }

        return loadUsers;

    }

}
