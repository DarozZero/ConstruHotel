/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ErPat
 */
public class RoomDataQuerys extends DataBaseConnection{
    
    public boolean obtainRoomData(RoomData roomData){
        PreparedStatement query = null; 
        Connection databaseConnection = getConnection();
        ResultSet resultSet = null;
        
        String sql = "SELECT * FROM reservacionhotel WHERE roomId = ?";
        
        try {
            query = databaseConnection.prepareStatement(sql);
            query.setString(1,roomData.getRoomId());   
            resultSet = query.executeQuery();
            
            if(resultSet.next()){
                roomData.setPricePerDay(resultSet.getFloat("pricePerDay"));
                roomData.setIsPetAvaliable(resultSet.getBoolean("petAvailable"));
                roomData.setIsImpairedAvailable(resultSet.getBoolean("impairedAvailable"));
                roomData.setCommodities(resultSet.getString("commodities"));
                return true;
            }
            
            return false;
        }catch(SQLException e){         
            System.out.println(e);     
            return false;
        } finally{
            try {
                databaseConnection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        
    }
    
    
}
