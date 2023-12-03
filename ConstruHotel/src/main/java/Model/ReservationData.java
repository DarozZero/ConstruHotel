/*
 * ReservationData
 *
 * Ver 1.0 - Versión funcional final
 *
 * 04/12/2004
 *
 * Copyright - MuñozÁviles2024
 */
package Model;

/**
 *
 * @author Daroz
 */
public class ReservationData {
    private int reservationID;
    private String userName;
    private String roomID;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    private float fee;

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public java.sql.Date getEndDate() {
        return endDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public ReservationData() {
    }

    public ReservationData(int reservationID, String userName, String roomID, java.sql.Date startDate, java.sql.Date endDate, float fee) {
        this.reservationID = reservationID;
        this.userName = userName;
        this.roomID = roomID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fee = fee;
    }
    
    
}

