package HostelDB;

import java.io.Serializable;
import java.math.BigDecimal;

public class RoomType implements Serializable {
    private String RoomType;
    private String RoomName;
    private double Price;

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

}
