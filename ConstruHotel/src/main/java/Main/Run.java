/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.ControllerHotel;
import Model.ReservationData;
import Model.ReservationDataQuerys;
import Model.RoomData;
import Model.RoomDataQuerys;
import Model.User;
import Model.UserQuerys;
import View.MainMenu;
import View.PrincipalPanel;
import View.ReservePanel;
import View.RoomFloor;
import View.RoomFloorDeluxe;
import View.UserLogIn;
import View.UserProfile;
import View.UserRegister;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

/**
 *
 * @author ErPat
 */
public class Run {
    
    public static void main(String[] args) {
     //set Nimbus Look and Feel
     FlatMaterialLighterIJTheme.setup();
     
     User user = new User();
     UserQuerys userQuerys = new UserQuerys();
     RoomData roomData = new RoomData();
     RoomDataQuerys roomDataQuerys = new RoomDataQuerys();
     ReservationData reservationData = new ReservationData();
     ReservationDataQuerys reservationDataQuerys = new ReservationDataQuerys();
     MainMenu mainMenu = new MainMenu();
     PrincipalPanel principalPanel = new PrincipalPanel();
     ReservePanel reservePanel = new ReservePanel();
     RoomFloor roomFloor = new RoomFloor();
     RoomFloorDeluxe roomFloorDeluxe = new RoomFloorDeluxe();
     UserLogIn userLogIn = new UserLogIn();
     UserProfile userProfile = new UserProfile();
     UserRegister userRegister = new UserRegister();
     ControllerHotel controllerHotel = new ControllerHotel(
        user, 
        userQuerys,
        roomData,
        roomDataQuerys,
        reservationData,
        reservationDataQuerys,
        mainMenu, 
        principalPanel, 
        reservePanel, 
        roomFloor, 
        roomFloorDeluxe,                 
        userLogIn, 
        userProfile, 
        userRegister);              
    
    controllerHotel.startMainMenu();
    }
    
    
}
