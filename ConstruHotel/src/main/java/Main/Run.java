/*
 * Run
 *
 * Ver 1.0 - Versión funcional final
 *
 * 04/12/2004
 *
 * Copyright - MuñozÁviles2024
 */
package Main;

import Controller.ControllerHotel;
import Model.ReservationData;
import Model.ReservationDataQuerys;
import Model.RoomData;
import Model.RoomDataQuerys;
import Model.User;
import Model.UserQuerys;
import View.AdminEditForm;
import View.AdminMenu;
import View.AdminReservationForm;
import View.MainMenu;
import View.OffersPanel;
import View.PrincipalPanel;
import View.ReservePanel;
import View.RoomFloor;
import View.RoomFloorDeluxe;
import View.UserLogIn;
import View.UserProfile;
import View.UserRegister;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;

/**
 *
 * @author ErPat
 */
public class Run {
    
    public static void main(String[] args) {
     //set Nimbus Look and Feel
     FlatLightOwlIJTheme.setup();
     
     
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
     AdminMenu adminMenu = new AdminMenu();
     AdminReservationForm adminReservationForm = new AdminReservationForm();
     OffersPanel offersPanel = new OffersPanel();
     AdminEditForm adminEditForm = new AdminEditForm();
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
        userRegister,
        adminMenu,
        adminReservationForm,
        offersPanel,
        adminEditForm);              
    
    controllerHotel.startMainMenu();
    }
    
    
}
