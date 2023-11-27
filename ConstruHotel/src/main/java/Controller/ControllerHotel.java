/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ReservationData;
import Model.ReservationDataQuerys;
import Model.RoomData;
import Model.RoomDataQuerys;
import Model.User;
import Model.UserQuerys;
import Model.UsernameTakenViolation;
import View.MainMenu;
import View.PrincipalPanel;
import View.ReservePanel;
import View.RoomFloor;
import View.RoomFloorDeluxe;
import View.UserLogIn;
import View.UserProfile;
import View.UserRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ErPat
 */
public class ControllerHotel implements ActionListener{
    
    private User user;
    private UserQuerys userQuerys;
    private RoomData roomData;
    private RoomDataQuerys roomDataQuerys;
    private ReservationData reservationData;
    private ReservationDataQuerys reservationDataQuerys;
    private MainMenu mainMenu;
    private PrincipalPanel principalPanel;
    private ReservePanel reservePanel;
    private RoomFloor roomFloor;
    private RoomFloorDeluxe roomFloorDeluxe;
    private UserLogIn userLogIn;
    private UserProfile userProfile;
    private UserRegister userRegister;
    private final int NUMBER_OF_FLOORS = 6;
    private final int NUMBER_OF_ROOMS = 6;
    private int currentFloor;
    
    public ControllerHotel(
            User user, 
            UserQuerys userQuerys,
            RoomData roomData ,
            RoomDataQuerys roomDataQuerys,
            ReservationData reservationData,
            ReservationDataQuerys reservationDataQuerys,
            MainMenu mainMenu, PrincipalPanel principalPanel,
            ReservePanel reservePanel, RoomFloor roomFloor,
            RoomFloorDeluxe roomFloorDeluxe, UserLogIn userLogIn,
            UserProfile userProfile,
            UserRegister userRegister) {
        this.user = user;
        this.userQuerys = userQuerys;
        this.roomData = roomData;
        this.roomDataQuerys = roomDataQuerys;
        this.reservationData = reservationData;
        this.reservationDataQuerys = reservationDataQuerys;
        this.mainMenu = mainMenu;
        this.principalPanel = principalPanel;
        this.reservePanel = reservePanel;
        this.roomFloor = roomFloor;
        this.roomFloorDeluxe = roomFloorDeluxe;
        this.userLogIn = userLogIn;
        this.userProfile = userProfile;
        this.userRegister = userRegister;
        mainMenu.btnAdmin.addActionListener(this);
        mainMenu.btnLogin.addActionListener(this);
        mainMenu.btnLogOut.addActionListener(this);
        mainMenu.btnReserve.addActionListener(this);
        mainMenu.btnUserProfile.addActionListener(this);
        userLogIn.btnRegisterLogin.addActionListener(this);
        userLogIn.btnLogin.addActionListener(this);
        userRegister.btnRegister.addActionListener(this);
        reservePanel.btnUpAFloor.addActionListener(this);
        reservePanel.btnDownAFloor.addActionListener(this);
        roomFloor.btnRoom1.addActionListener(this);
        roomFloor.btnRoom2.addActionListener(this);
        roomFloor.btnRoom3.addActionListener(this);
        roomFloor.btnRoom4.addActionListener(this);
        roomFloor.btnRoom5.addActionListener(this);
        roomFloor.btnRoom6.addActionListener(this);
        roomFloorDeluxe.btnDeluxe1.addActionListener(this);
        roomFloorDeluxe.btnDeluxe2.addActionListener(this);
    }
    
    public void startMainMenu(){
        mainMenu.setTitle("Bienvenido al hotel - nombre - ");
        mainMenu.showPanel(principalPanel);
        mainMenu.showAdminButton(false);
        isUserLogedIn(false);
        mainMenu.setVisible(true);
    }
    
    public void startLogin() {
        userLogIn.setTitle("Inicie sesión");
        userLogIn.setLocationRelativeTo(null);
        userLogIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void startRegister(){
        userRegister.setTitle("Registro");
        userRegister.setLocationRelativeTo(null);
        userRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void startProfile(){
        userProfile.setTitle("Perfil de " + user.getUsername());
        userProfile.setLocationRelativeTo(mainMenu);
        userProfile.lblNames.setText(user.getName());
        userProfile.lblFamilyNames.setText(user.getFamilyNames());
        userProfile.chckPetsProfile.setSelected(user.hasPets());
        userProfile.chckImpairedProfile.setSelected(user.isImpaired());
    
    }
    
    public void startRoomPanels(){
        currentFloor = 1;
        reservePanel.showPanel(roomFloor);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if (actionEvent.getSource() == mainMenu.btnReserve) {
            startRoomPanels();
            mainMenu.showPanel(reservePanel);
        }
        if (actionEvent.getSource() == mainMenu.btnLogin) {
            userLogIn.setVisible(true);
        }
        if(actionEvent.getSource() == mainMenu.btnUserProfile){
            userProfile.setVisible(true);
        }
        if (actionEvent.getSource() == userLogIn.btnLogin) {
            buttonLogin();
        }
        if (actionEvent.getSource() == mainMenu.btnLogOut) {
            isUserLogedIn(false);
            mainMenu.showAdminButton(false);
            mainMenu.repaint();
        }
        if (actionEvent.getSource() == userLogIn.btnRegisterLogin) {
            userLogIn.dispose();
            userRegister.setVisible(true);
            cleanRegisterText();
        }
        if (actionEvent.getSource() == userRegister.btnRegister){
            if(isNoTextBoxEmpty()){
                buttonRegister();
            }else{
                JOptionPane.showMessageDialog(null,"No se han llenado todos los campos");
            }
        }
        if (actionEvent.getSource() == roomFloor.btnRoom1) {
            String roomId = roomFloor.btnRoom1.getText();
            buttonRoom(roomId);
        }
        if (actionEvent.getSource() == roomFloor.btnRoom2) {
            String roomId = roomFloor.btnRoom2.getText();
            buttonRoom(roomId);
        }
        if (actionEvent.getSource() == roomFloor.btnRoom3) {
            String roomId = roomFloor.btnRoom3.getText();
            buttonRoom(roomId);
        }
        if (actionEvent.getSource() == roomFloor.btnRoom4) {
            String roomId = roomFloor.btnRoom4.getText();
            buttonRoom(roomId);
        }
        if (actionEvent.getSource() == roomFloor.btnRoom5) {
            String roomId = roomFloor.btnRoom5.getText();
            buttonRoom(roomId);
        }
        if (actionEvent.getSource() == roomFloor.btnRoom6) {
            String roomId = roomFloor.btnRoom6.getText();
            buttonRoom(roomId);
        }
        if (actionEvent.getSource() == roomFloorDeluxe.btnDeluxe1) {
            String roomId = roomFloorDeluxe.btnDeluxe1.getText();
            buttonRoom(roomId);
        }
        if (actionEvent.getSource() == roomFloorDeluxe.btnDeluxe2) {
            String roomId = roomFloorDeluxe.btnDeluxe2.getText();
            buttonRoom(roomId);
        }
        if (actionEvent.getSource() == reservePanel.btnUpAFloor) {
            if (currentFloor<NUMBER_OF_FLOORS) {
                currentFloor+=1;
            }
            changeFloor(currentFloor);
        }
        if (actionEvent.getSource() == reservePanel.btnDownAFloor) {
            if (currentFloor>0) {
                currentFloor-=1;
            }
            changeFloor(currentFloor);
        }
       
    
    }
    
   public void changeFloor(int floor){
        if (floor > 0 && floor<NUMBER_OF_FLOORS) {
        roomFloor.btnRoom1.setText(floor + "1");
        roomFloor.btnRoom2.setText(floor + "2");
        roomFloor.btnRoom3.setText(floor + "3");
        roomFloor.btnRoom4.setText(floor + "4");
        roomFloor.btnRoom5.setText(floor + "5");
        roomFloor.btnRoom6.setText(floor + "6");
        reservePanel.showPanel(roomFloor);
       }
        if (floor == 6) {
           reservePanel.showPanel(roomFloorDeluxe);
       }
    }
    
    
    public void cleanRegisterText (){
        userRegister.txtUserName1.setText(null);
        userRegister.txtPassword.setText(null);
        userRegister.txtNames.setText(null);
        userRegister.txtFatherName.setText(null);
        userRegister.txtMotherName.setText(null);
    }
    
    public void cleanLoginText(){
        userLogIn.txtUsernameLogin.setText(null);
        userLogIn.txtPaswordLogin.setText(null);
    }
    
    public boolean isNoTextBoxEmpty(){
        if (
            userRegister.txtFatherName.getText().isEmpty() ||
            userRegister.txtMotherName.getText().isEmpty() ||
            userRegister.txtNames.getText().isEmpty() ||
            new String(userRegister.txtPassword.getPassword()).isEmpty() ||
            userRegister.txtUserName1.getText().isEmpty()) {
            
            return false;
        }else{
            return true;
        }
    
    }
    
    public void isUserLogedIn(boolean isUserLogedIn){
        mainMenu.showProfileButton(isUserLogedIn);
        mainMenu.showLogInButton(isUserLogedIn);
        mainMenu.showLogOutButton(isUserLogedIn);
    
    }
    
    
    public void buttonLogin(){
        char[] passwordChar = userLogIn.txtPaswordLogin.getPassword();
        String password = new String (passwordChar);
        user.setUsername(userLogIn.txtUsernameLogin.getText());
        user.setPassword(password);
        
        
        try {
            if (userQuerys.LoginUser(user)) {
                userLogIn.dispose();
                cleanLoginText();
                JOptionPane.showMessageDialog(null, "Bienvenido : " + user.getName() + " " + user.getFamilyNames());     
                mainMenu.showAdminButton(user.IsAdmin());
                isUserLogedIn(true);
                startProfile();
                mainMenu.repaint();
            }
            else{
                userLogIn.txtUsernameLogin.setText(null);
                userLogIn.txtPaswordLogin.setText(null);
                JOptionPane.showMessageDialog(null, "El ingreso no ha sido exitoso");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña erróneo");
        }
    }
    
    public void buttonRegister(){
        char[] passwordChar = userRegister.txtPassword.getPassword();
        String password = new String (passwordChar);
        user.setUsername(userRegister.txtUserName1.getText());
        user.setPassword(password);
        user.setName(userRegister.txtNames.getText());
        user.setFamilyNames(userRegister.txtFatherName.getText() + " " + userRegister.txtMotherName.getText());
        user.setHasPets(userRegister.chckBoxPets.getState());
        user.setIsImpaired(userRegister.chckboxHandicaped.getState());
            
        try {
            userQuerys.Register(user);
            JOptionPane.showMessageDialog(null, "Registrado con éxito");
            userRegister.dispose();
            userLogIn.setVisible(true);
        } catch (UsernameTakenViolation e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detectado, porfavor registre de nuevo");
        }
    }

   public void buttonRoom(String roomId){
       roomData.setRoomId(roomId);
       try {
           roomDataQuerys.obtainRoomData(roomData);
           reservePanel.txtRoom.setText(roomId);
           reservePanel.txtRoomPrice.setText(String.valueOf(roomData.getPricePerDay()));
           reservePanel.chckRoomPets.setSelected(roomData.isPetAvaliable());
           reservePanel.chckRoomImpaired.setSelected(roomData.isImpairedAvailable());
           reservePanel.txtRoomCommodities.setText(roomData.getCommodities());
           reservePanel.repaint();
           
       } catch (Exception e) {
       }
   }
    
}
