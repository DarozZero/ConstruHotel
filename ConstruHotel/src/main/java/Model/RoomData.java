/*
 * RoomData
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
