/*
 * ControllerHotel
 *
 * Ver 1.0 - Versión funcional final
 *
 * 04/12/2004
 *
 * Copyright - MuñozÁviles2024
 */
package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Float.parseFloat;

/**
 *
 * @author ErPat
 * @author Daroz
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
    private OffersPanel offersPanel;
    private RoomFloor roomFloor;
    private RoomFloorDeluxe roomFloorDeluxe;
    private UserLogIn userLogIn;
    private UserProfile userProfile;
    private UserRegister userRegister;
    private AdminMenu adminMenu;
    private AdminEditForm adminEditForm;
    private AdminReservationForm adminReservationForm;
    private final int NUMBER_OF_FLOORS = 6;
    private final int NUMBER_OF_ROOMS = 6;
    private int currentFloor;
    private boolean isUsrLog = false;
    
    public ControllerHotel(
            User user, 
            UserQuerys userQuerys,
            RoomData roomData ,
            RoomDataQuerys roomDataQuerys,
            ReservationData reservationData,
            ReservationDataQuerys reservationDataQuerys,
            MainMenu mainMenu, 
            PrincipalPanel principalPanel,
            ReservePanel reservePanel, 
            RoomFloor roomFloor,
            RoomFloorDeluxe roomFloorDeluxe, 
            UserLogIn userLogIn,
            UserProfile userProfile,
            UserRegister userRegister,
            AdminMenu adminMenu,
            AdminReservationForm adminReservationForm,
            OffersPanel offersPanel,
            AdminEditForm adminEditForm) {
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
        this.adminMenu = adminMenu;
        this.adminReservationForm = adminReservationForm;
        this.offersPanel = offersPanel;
        this.adminEditForm = adminEditForm;
        mainMenu.btnAdmin.addActionListener(this);
        mainMenu.btnLogin.addActionListener(this);
        mainMenu.btnLogOut.addActionListener(this);
        mainMenu.btnReserve.addActionListener(this);
        mainMenu.btnUserProfile.addActionListener(this);
        mainMenu.btnPromo.addActionListener(this);
        userLogIn.btnRegisterLogin.addActionListener(this);
        userLogIn.btnLogin.addActionListener(this);
        userRegister.btnRegister.addActionListener(this);
        reservePanel.btnUpAFloor.addActionListener(this);
        reservePanel.btnDownAFloor.addActionListener(this);
        reservePanel.btnAvailability.addActionListener(this);
        reservePanel.btnReservation.addActionListener(this);
        reservePanel.btnModififyAdmin.addActionListener(this);
        roomFloor.btnRoom1.addActionListener(this);
        roomFloor.btnRoom2.addActionListener(this);
        roomFloor.btnRoom3.addActionListener(this);
        roomFloor.btnRoom4.addActionListener(this);
        roomFloor.btnRoom5.addActionListener(this);
        roomFloor.btnRoom6.addActionListener(this);
        roomFloorDeluxe.btnDeluxe1.addActionListener(this);
        roomFloorDeluxe.btnDeluxe2.addActionListener(this);
        adminMenu.addButtom.addActionListener(this);
        adminMenu.killButtom.addActionListener(this);
        adminMenu.editButtom.addActionListener(this);
        adminEditForm.editBtn.addActionListener(this);
        adminReservationForm.registerBtn.addActionListener(this);
    }
    
    public void startMainMenu(){
        mainMenu.setTitle("Bienvenido al hotel - nombre - ");
        mainMenu.showPanel(principalPanel);
        mainMenu.showAdminButton(false);
        reservePanel.btnModififyAdmin.setVisible(false);
        isUserLogedIn(false);
        mainMenu.setVisible(true);
    }


    
    private void startProfile(){
        userProfile.setTitle("Perfil de " + user.getUsername());
        userProfile.setLocationRelativeTo(mainMenu);
        userProfile.lblNames.setText(user.getName());
        userProfile.lblFamilyNames.setText(user.getFamilyNames());
        userProfile.chckPetsProfile.setSelected(user.hasPets());
        userProfile.chckImpairedProfile.setSelected(user.isImpaired());
    
    }
    
    private void startRoomPanels(){
        //actual date on chooser
        Date actualDate = new Date();
        reservePanel.reservationDateStart.setDate(actualDate);
        Date tomorrowDate = new Date(actualDate.getTime() + TimeUnit.DAYS.toMillis( 1 ));
        reservePanel.reservationDateEnd.setDate(tomorrowDate);
        
        currentFloor = 1;
        reservePanel.showPanel(roomFloor);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if (actionEvent.getSource() == mainMenu.btnReserve) {
            startRoomPanels();
            mainMenu.showPanel(reservePanel);
            setupActualDate();
            isAvalible();
        }
        if (actionEvent.getSource() == mainMenu.btnLogin) {
            userLogIn.setVisible(true);
        }
        if (actionEvent.getSource() == mainMenu.btnUserProfile){
            makeProfileTable();
            userProfile.setVisible(true);
        }
        if (actionEvent.getSource() == mainMenu.btnPromo){
            mainMenu.showPanel(offersPanel);
        }
        if (actionEvent.getSource() == userLogIn.btnLogin) {
            buttonLogin();
        }
        if (actionEvent.getSource() == mainMenu.btnLogOut) {
            user.setIsAdmin(false);
            isUserLogedIn(false);
            mainMenu.showAdminButton(false);
            modifyAvalibleAdmin();
            mainMenu.repaint();
            mainMenu.showPanel(principalPanel);
            
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
            if (currentFloor>1) {
                currentFloor-=1;
            }
            changeFloor(currentFloor);
        }
       if (actionEvent.getSource() == reservePanel.btnAvailability){
           setupActualDate();
           isAvalible();
       }
       if (actionEvent.getSource() == reservePanel.btnReservation){
           if (isUsrLog == true){
               makeReservation();
           }else{
               JOptionPane.showMessageDialog(null, "Inicie Sesión por favor. 😁");
           }
       }
       if (actionEvent.getSource() == mainMenu.btnAdmin){
           makeAdminTable();
           adminMenu.setVisible(true);
           mainMenu.showPanel(principalPanel);
       }
       if (actionEvent.getSource() == adminMenu.addButtom){
           adminReservationForm.setVisible(true);
       }
       if (actionEvent.getSource() == adminMenu.killButtom){  
          String result = JOptionPane.showInputDialog("Escribe el ID de la reservacion");
          try {
            int roomID = Integer.parseInt(result);
            deleteReservation(roomID);
            makeAdminTable();
        } catch (NumberFormatException excepcion) {
            JOptionPane.showMessageDialog(null, "Escribe el numero del ID!");
        }
           
       }
       if (actionEvent.getSource() == adminMenu.editButtom){
           adminEditForm.setVisible(true);
       }
       if (actionEvent.getSource() == adminReservationForm.registerBtn){
            boolean succes = adminMakeReservation();
            if(succes){
                makeAdminTable();
                adminReservationForm.dispose();
            }
        }
       if (actionEvent.getSource() == adminEditForm.editBtn){
            boolean succes = editReservationAdmin();
            if(succes){
                makeAdminTable();
                adminEditForm.dispose();
            }   
       }
       
       if (actionEvent.getSource() == reservePanel.btnModififyAdmin){
            boolean succes = editRoomInformation();
            if(succes){
                reservePanel.repaint();
            }
                
       }
       
    }
    
   private void changeFloor(int floor){
        if (floor > 0 && floor<NUMBER_OF_FLOORS) {
        roomFloor.btnRoom1.setText(floor + "1");
        roomFloor.btnRoom2.setText(floor + "2");
        roomFloor.btnRoom3.setText(floor + "3");
        roomFloor.btnRoom4.setText(floor + "4");
        roomFloor.btnRoom5.setText(floor + "5");
        roomFloor.btnRoom6.setText(floor + "6");
        reservePanel.floorLabel.setText("Piso " + String.valueOf(floor));
        reservePanel.showPanel(roomFloor);
        setupActualDate();
        isAvalible();
       }
        if (floor == NUMBER_OF_FLOORS) {
           reservePanel.floorLabel.setText("Piso " + String.valueOf(floor));
           reservePanel.showPanel(roomFloorDeluxe);
           setupActualDate();
           isAvalible();
       }
    }
    
    
    private void cleanRegisterText (){
        userRegister.txtUserName1.setText(null);
        userRegister.txtPassword.setText(null);
        userRegister.txtNames.setText(null);
        userRegister.txtFatherName.setText(null);
        userRegister.txtMotherName.setText(null);
    }
    
    private void cleanLoginText(){
        userLogIn.txtUsernameLogin.setText(null);
        userLogIn.txtPaswordLogin.setText(null);
    }
    
    private boolean isNoTextBoxEmpty(){
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
    
    private void isUserLogedIn(boolean isUserLogedIn){
        mainMenu.showProfileButton(isUserLogedIn);
        mainMenu.showLogInButton(isUserLogedIn);
        mainMenu.showLogOutButton(isUserLogedIn);
        isUsrLog = isUserLogedIn;    
    }
    
    private void modifyAvalibleAdmin(){
        reservePanel.btnModififyAdmin.setVisible(user.IsAdmin());
        reservePanel.txtRoomPrice.setEditable(user.IsAdmin());
        reservePanel.txtRoomCommodities.setEditable(user.IsAdmin());
        reservePanel.chckRoomPets.setEnabled(user.IsAdmin());
        reservePanel.chckRoomImpaired.setEnabled(user.IsAdmin());
    }
    
    
    private void buttonLogin(){
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
                modifyAvalibleAdmin();
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
    
    private void buttonRegister(){
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

   private void buttonRoom(String roomId){
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
   
   private void isAvalible(){
       if (currentFloor > 0 && currentFloor<NUMBER_OF_FLOORS) {
            reservationData.setRoomID(roomFloor.btnRoom1.getText());
            if(reservationDataQuerys.isAvalible(reservationData)){
                roomFloor.btnRoom1.setBackground(Color.green);
            }else{
                roomFloor.btnRoom1.setBackground(Color.red);
            }
            reservationData.setRoomID(roomFloor.btnRoom2.getText());
            if(reservationDataQuerys.isAvalible(reservationData)){
                roomFloor.btnRoom2.setBackground(Color.green);
            }else{
                roomFloor.btnRoom2.setBackground(Color.red);
            }
            reservationData.setRoomID(roomFloor.btnRoom3.getText());
           if(reservationDataQuerys.isAvalible(reservationData)){
                roomFloor.btnRoom3.setBackground(Color.green);
            }else{
                roomFloor.btnRoom3.setBackground(Color.red);
            }
            reservationData.setRoomID(roomFloor.btnRoom4.getText());
            if(reservationDataQuerys.isAvalible(reservationData)){
                roomFloor.btnRoom4.setBackground(Color.green);
            }else{
                roomFloor.btnRoom4.setBackground(Color.red);
            }
            reservationData.setRoomID(roomFloor.btnRoom5.getText());
            if(reservationDataQuerys.isAvalible(reservationData)){
                roomFloor.btnRoom5.setBackground(Color.green);
            }else{
                roomFloor.btnRoom5.setBackground(Color.red);
            }
            reservationData.setRoomID(roomFloor.btnRoom6.getText());
            if(reservationDataQuerys.isAvalible(reservationData)){
                roomFloor.btnRoom6.setBackground(Color.green);
            }else{
                roomFloor.btnRoom6.setBackground(Color.red);
            }
       }if(currentFloor == NUMBER_OF_FLOORS){
            reservationData.setRoomID(roomFloorDeluxe.btnDeluxe1.getText());
            if(reservationDataQuerys.isAvalible(reservationData)){
                roomFloorDeluxe.btnDeluxe1.setBackground(Color.green);
            }else{
                roomFloorDeluxe.btnDeluxe1.setBackground(Color.red);
            }
            reservationData.setRoomID(roomFloorDeluxe.btnDeluxe2.getText());
            if(reservationDataQuerys.isAvalible(reservationData)){
                roomFloorDeluxe.btnDeluxe2.setBackground(Color.green);
            }else{
                roomFloorDeluxe.btnDeluxe2.setBackground(Color.red);
            }
       }
   }
   
   private void makeReservation(){
      if(!"".equals(reservePanel.txtRoom.getText())){
              reservationData.setRoomID(reservePanel.txtRoom.getText());
              setupActualDate();
              if(integrityReserve() && integrityRequires()){
                  reservationData.setUserName(user.getUsername());
                  reservationData.setFee(calculateFee());
                  System.out.println("entre y ademas con esto de money: " + reservationData.getFee());
                  boolean succes = reservationDataQuerys.makeReservation(reservationData);
                  if(succes)
                      JOptionPane.showMessageDialog(null, "Reservado con Exito");
                  else
                      JOptionPane.showMessageDialog(null, "Hubo un problema en la reservacion!");
              }
      }else{
          JOptionPane.showMessageDialog(null, "Seleccione una habitacion por favor");
      }
   }
   
   private void setupActualDate(){
       reservationData.setStartDate(new java.sql.Date(reservePanel.reservationDateStart.getDate().getTime()));
       reservationData.setEndDate(new java.sql.Date(reservePanel.reservationDateEnd.getDate().getTime()));
   }
   
   private float calculateFee(){
       int days = calculateDays();
       float dayPrice = parseFloat(reservePanel.txtRoomPrice.getText());
       float resultado = (float)days * dayPrice;
       if(days>=7){
           resultado = (float) (resultado * .8);
           JOptionPane.showMessageDialog(null, "20% De descuento aplicado!");
       }
       return resultado;
   }
   
   private int calculateDays(){
       int milisecondsByDay = 86400000;
       int days = ((int)reservationData.getEndDate().getTime() - 
               (int)reservationData.getStartDate().getTime())/milisecondsByDay;
       return days;
   }
   
   private boolean integrityRequires(){
       boolean isPetEqual = reservePanel.chckRoomPets.isSelected() == user.hasPets();
       if((user.hasPets()) && (!isPetEqual)){
           JOptionPane.showMessageDialog(null, "La habitación no está preparada para mascotas");
           return false;
       }
       boolean isImpairedEqual = reservePanel.chckRoomImpaired.isSelected() == user.isImpaired();
       if((user.isImpaired()) && (!isImpairedEqual)){
           JOptionPane.showMessageDialog(null, "La habitación no esta preparada para discapacitados, elija otra.");
           return false;
       }
       return true;
   }
   
   private boolean integrityReserve(){
       boolean isAvalible = reservationDataQuerys.isAvalible(reservationData);
       boolean goodDates = calculateDays() > 0;
       Date actualDate = new Date();
       Date yesterdayDate = new Date(actualDate.getTime() - TimeUnit.DAYS.toMillis( 1 ));
       boolean pastDays = reservationData.getStartDate().before(yesterdayDate)
               || reservationData.getEndDate().before(actualDate);
       if(isAvalible&&goodDates&&!pastDays){
           return true;
       }else{
           if(!isAvalible){
               JOptionPane.showMessageDialog(null, "Fecha no disponible");
           }
           if(!goodDates){
           JOptionPane.showMessageDialog(null, "Fechas incorrectas: ");    
           }
           if(pastDays){
           JOptionPane.showMessageDialog(null, "Fechas incorrectas: Los dias ya han pasado");    
           }
           return false;
       }
   }
   
   private void makeAdminTable(){
   DefaultTableModel modelo =  new DefaultTableModel();
   modelo.setColumnIdentifiers(new Object[]{"ID Reservacion","Usuario","Habitación","Fecha Entrada"
           ,"Fecha Salida","Tarifa"});
   adminMenu.contentTable.setModel(modelo);
   modelo.setRowCount(0);
   
   List<ReservationData> reservations;
   reservations = reservationDataQuerys.showReservation();
   
   for(ReservationData actual : reservations){
       modelo.addRow(new Object[]{
       actual.getReservationID(),
       actual.getUserName(),
       actual.getRoomID(),
       actual.getStartDate(),
       actual.getEndDate(),
       actual.getFee()});
   }
   }
   
   private void makeProfileTable(){
       DefaultTableModel modelo =  new DefaultTableModel();
       modelo.setColumnIdentifiers(new Object[]{"ID Reservacion","Usuario","Habitación","Fecha Entrada"
               ,"Fecha Salida","Tarifa"});
       userProfile.profileTable.setModel(modelo);
       modelo.setRowCount(0);

       List<ReservationData> reservations;
       reservations = reservationDataQuerys.showUserReservations(user.getUsername());

       for(ReservationData actual : reservations){
            modelo.addRow(new Object[]{
            actual.getReservationID(),
            actual.getUserName(),
            actual.getRoomID(),
            actual.getStartDate(),
            actual.getEndDate(),
            actual.getFee()});
        }   
   }

   private void deleteReservation(int roomID){
     boolean isDeleted = reservationDataQuerys.deleteReservation(roomID);
     if(isDeleted)
         JOptionPane.showMessageDialog(null, "ReservaEliminada");
     else
         JOptionPane.showMessageDialog(null, "Error al eliminar, intentelo otra vez");
   }

   private boolean adminMakeReservation(){
       reservationData.setUserName(adminReservationForm.txtUser.getText());
       reservationData.setRoomID((String) adminReservationForm.comboRoom.getSelectedItem());
       reservationData.setStartDate(new java.sql.Date(adminReservationForm.startDate.getDate().getTime()) );
       reservationData.setEndDate(new java.sql.Date(adminReservationForm.endDate.getDate().getTime()));
       reservationData.setFee(Float.parseFloat(adminReservationForm.txtFee.getText()));
       if(integrityReserve()){
                boolean succes = reservationDataQuerys.makeReservation(reservationData);
                if(succes){
                    JOptionPane.showMessageDialog(null, "Reservado con Exito");
                return true;
                }else
                    JOptionPane.showMessageDialog(null, "Hubo un problema en la reservacion, verifique los datos!");
              }
       return false;
   }

   private boolean editReservationAdmin(){
       reservationData.setReservationID(Integer.parseInt(adminEditForm.txtID.getText()));
       reservationData.setUserName(adminEditForm.txtUser.getText());
       reservationData.setRoomID((String) adminEditForm.comboRoom.getSelectedItem());
       reservationData.setStartDate(new java.sql.Date(adminEditForm.startDate.getDate().getTime()) );
       reservationData.setEndDate(new java.sql.Date(adminEditForm.endDate.getDate().getTime()));
       reservationData.setFee(Float.parseFloat(adminEditForm.txtFee.getText()));
          boolean succes = reservationDataQuerys.editReservation(reservationData);
            if(succes){
                return true;
            }else
                JOptionPane.showMessageDialog(null, "Hubo un problema en la modificacion, verifique los datos!");
              
        return false;
   }


   private boolean editRoomInformation(){
       if(!"".equals(reservePanel.txtRoom.getText())){
           roomData.setRoomId(reservePanel.txtRoom.getText());
           roomData.setPricePerDay(Float.parseFloat(reservePanel.txtRoomPrice.getText()));
           roomData.setIsPetAvaliable(reservePanel.chckRoomPets.isSelected());
           roomData.setIsImpairedAvailable(reservePanel.chckRoomImpaired.isSelected());
           roomData.setCommodities(reservePanel.txtRoomCommodities.getText());
           boolean succes = roomDataQuerys.editRoomData(roomData);
           JOptionPane.showMessageDialog(null, "Modificación Realizada");
           return true;
       }else{
           JOptionPane.showMessageDialog(null, "Seleccione una habitacion por favor");
       }
       return false;
   }
}
