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
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

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
    
    public List<ReservationData> showReservation(){
        PreparedStatement query = null;
        Connection databaseConnection = getConnection();
        ResultSet resultSet = null;
        
        String sql= "SELECT * FROM reservations";
        
        try {
            query = databaseConnection.prepareStatement(sql);
            resultSet = query.executeQuery(sql);
            List<ReservationData> reservations = new LinkedList<>();
            
            while(resultSet.next()){
                ReservationData reservation = new ReservationData();
                reservation.setReservationID(resultSet.getInt(1));
                reservation.setUserName(resultSet.getString(2));
                reservation.setRoomID(resultSet.getString(3));
                reservation.setStartDate(resultSet.getDate(4));
                reservation.setEndDate(resultSet.getDate(5));
                reservation.setFee(resultSet.getFloat(6));
                reservations.add(reservation);
            }
            return reservations;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                databaseConnection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public List<ReservationData> showUserReservations(String userName){
        PreparedStatement query = null;
        Connection databaseConnection = getConnection();
        ResultSet resultSet = null;
        
        String sql= "SELECT * FROM reservations WHERE Username=?";
        
        try {
            query = databaseConnection.prepareStatement(sql);
            query.setString(1, userName);
            resultSet = query.executeQuery();
            List<ReservationData> reservations = new LinkedList<>();
            
            while(resultSet.next()){
                ReservationData reservation = new ReservationData();
                reservation.setReservationID(resultSet.getInt(1));
                reservation.setUserName(resultSet.getString(2));
                reservation.setRoomID(resultSet.getString(3));
                reservation.setStartDate(resultSet.getDate(4));
                reservation.setEndDate(resultSet.getDate(5));
                reservation.setFee(resultSet.getFloat(6));
                reservations.add(reservation);
            }
            return reservations;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                databaseConnection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }    
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
    
    public boolean deleteReservation(int roomID){
        PreparedStatement query = null;
        Connection databaseConnection = getConnection();
        
        String sql= "DELETE FROM `reservations` WHERE ReservationID = ?";
        
        try {
             query = databaseConnection.prepareStatement(sql);
             query.setInt(1,roomID);
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
    
    public boolean editReservation(ReservationData reservationData){
        PreparedStatement query = null;
        Connection databaseConnection = getConnection();
        
        String sql= "UPDATE `reservations` SET Username=?, roomId=?, StartDate=?, EndDate=?, Fee=? "
                + "WHERE ReservationID=?";
        
        try {
            query = databaseConnection.prepareStatement(sql);
            query.setString(1, reservationData.getUserName());
            query.setString(2, reservationData.getRoomID());
            query.setDate(3, reservationData.getStartDate());
            query.setDate(4, reservationData.getEndDate());
            query.setFloat(5, reservationData.getFee());
            query.setInt(6, reservationData.getReservationID());
            
                query.execute();
                JOptionPane.showMessageDialog(null, "La reservacion ha sido modificada!");
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
