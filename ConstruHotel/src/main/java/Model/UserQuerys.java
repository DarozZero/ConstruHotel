/*
 * UserQuerys
 *
 * Ver 1.0 - Versión funcional final
 *
 * 04/12/2004
 *
 * Copyright - MuñozÁviles2024
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ErPat
 */
public class UserQuerys extends DataBaseConnection{
    
    public boolean Register (User user) throws Exception{
        PreparedStatement query = null;
        Connection databaseConnection = getConnection();
        
        String sql = "INSERT INTO `usershotel` (`Username`, `Password`, `Name`, `Family Names`, `Pets`, `Impaired movement`) VALUES (?,?,?,?,?,?)";
        
        try {
            query = databaseConnection.prepareStatement(sql);
            query.setString(1,user.getUsername());
            query.setString(2, user.getPassword());
            query.setString(3, user.getName());
            query.setString(4, user.getFamilyNames());
            query.setBoolean(5, user.hasPets());
            query.setBoolean(6, user.isImpaired());
            query.execute();
            return true;
        }catch(SQLException e){
            if (isUserNameTaken(e)) 
            throw new UsernameTakenViolation("El nombre de usuario ya ha sido tomado!");
            
            return false;
        } finally{
            try {
                databaseConnection.close();
            } catch (SQLException e) {                        
                System.out.println(e);
            }
        }
        
    }
    
    private boolean isUserNameTaken(SQLException e){
        return(e.getSQLState().equals("23000") && e.getErrorCode() == 1062);
    }
    
    public boolean LoginUser (User user){
        PreparedStatement query = null;
        ResultSet resultSet = null;
        Connection databaseConnection = getConnection();
        
        String sql = "SELECT * FROM usershotel WHERE Username = ? AND Password =?";
        
        try {
            query = databaseConnection.prepareStatement(sql);
            query.setString(1,user.getUsername());
            query.setString(2, user.getPassword());   
            resultSet = query.executeQuery();
            
            if(resultSet.next()){
                user.setName(resultSet.getString("Name"));
                user.setFamilyNames(resultSet.getString("Family Names"));
                user.setHasPets(resultSet.getBoolean("Pets"));
                user.setIsImpaired(resultSet.getBoolean("Impaired movement"));
                user.setIsAdmin(resultSet.getBoolean("Admin"));
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
