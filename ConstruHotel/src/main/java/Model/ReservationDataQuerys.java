/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Daroz
 */
public class ReservationDataQuerys extends DataBaseConnection {
    
    public boolean isAvalible(ReservationData reservationData){
        String consultStartDay = reservationData.getStartDate().toString();
        String consultEndDay = reservationData.getEndDate().toString();
        PreparedStatement query = null; 
        Connection databaseConnection = getConnection();
        ResultSet resultSet = null;
        
         String sql = "SELECT * FROM reservations WHERE roomId = ?";
         try {
            query = databaseConnection.prepareStatement(sql);
            query.setString(1,reservationData.getRoomID());
            resultSet = query.executeQuery();
             while(resultSet.next()){
                 String baseStartDate = resultSet.getDate("StartDate").toString();
                 String baseEndDate = resultSet.getDate("EndDate").toString();
                 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                 
                 boolean sameStartDay = consultStartDay.equals(baseStartDate); 
                 boolean startBetweenDays = (format.parse(consultStartDay).after(
                         format.parse(baseStartDate))) && 
                         (format.parse(consultStartDay).before(
                         format.parse(baseEndDate)));
                 boolean endBetweenDays = (format.parse(consultEndDay).after(
                         format.parse(baseStartDate))) && 
                         (format.parse(consultEndDay).before(
                         format.parse(baseEndDate)));
                 boolean coverExistReservation = (format.parse(consultStartDay).before(
                         format.parse(baseStartDate))) &&
                         (format.parse(consultEndDay).after(
                         format.parse(baseEndDate)));
              if(sameStartDay || startBetweenDays || endBetweenDays || coverExistReservation)
                  return false;
              else
                  return true;
             }
        } catch (SQLException e) {
             System.out.println(e);
        } catch (ParseException ex) {
             System.out.println(ex);
        } finally {
             try {
                databaseConnection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return true;
    }
    
    public boolean makeReservation(ReservationData reservationData){
        PreparedStatement query = null;
        Connection databaseConnection = getConnection();
        
        String sql= "INSERT INTO `reservations` (`ReservationID`, `Username`, `roomId`, `StartDate`, `EndDate`, `Fee`) VALUES (?,?,?,?,?,?) ";
        
        try {
          query = databaseConnection.prepareStatement(sql);
          query.setInt(1, reservationData.getReservationID());
          query.setString(2,reservationData.getUserName());
          query.setString(3, reservationData.getRoomID());
          query.setDate(4, reservationData.getStartDate());
          query.setDate(5,reservationData.getEndDate());
          query.setFloat(6, reservationData.getFee());
          query.execute();
          return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                databaseConnection.close();
            } catch (SQLException e) {                        
                System.out.println(e);
            }
        }
    }
    
}
