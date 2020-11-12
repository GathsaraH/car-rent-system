package dao.custom;

import dao.CrudDAO;
import entity.System;

public interface SystemDAO extends CrudDAO<System,String> {
    public  String genarateUserID() throws  Exception;
}
