/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
