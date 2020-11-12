package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static  DBConnection dbConnection;
    private Connection connection;

    private  DBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager. getConnection("jdbc:mysql://127.0.0.1:3306/rentcar","root","root");
    }
    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }
    public  Connection getConnection(){
        return  connection;
    }
}

