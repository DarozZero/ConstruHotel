/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ErPat
 */
public class RoomData {
    private String roomId;
    private float pricePerDay;
    private boolean isPetAvaliable;
    private boolean isImpairedAvailable;
    private String commodities;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isPetAvaliable() {
        return isPetAvaliable;
    }

    public void setIsPetAvaliable(boolean isPetAvaliable) {
        this.isPetAvaliable = isPetAvaliable;
    }

    public boolean isImpairedAvailable() {
        return isImpairedAvailable;
    }

    public void setIsImpairedAvailable(boolean isImpairedAvailable) {
        this.isImpairedAvailable = isImpairedAvailable;
    }

    public String getCommodities() {
        return commodities;
    }

    public void setCommodities(String commodities) {
        this.commodities = commodities;
    }
    
    
    
}
