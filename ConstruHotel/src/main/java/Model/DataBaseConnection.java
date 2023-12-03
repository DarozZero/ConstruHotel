/*
 *DataBaseConnection
 *
 * Ver 1.0 - Versión funcional final
 *
 * 04/12/2004
 *
 * Copyright - MuñozÁviles2024
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author ErPat
 */
public class DataBaseConnection {
    
    private final String base = "construhotel";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection dataBaseConnection = null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dataBaseConnection = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return dataBaseConnection;
    }
    
}
