package HostelDB;


import java.io.Serializable;

public class Room implements Serializable {
    private int RoomID;
    private String RoomType;
    private String RoomDescription ;
    private int HotelID;

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public void setRoomDescription(String roomDescription) {
        RoomDescription = roomDescription;
    }

    public void setHotelID(int hotelID) {
        HotelID = hotelID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public String getRoomType() {
        return RoomType;
    }

    public String getRoomDescription() {
        return RoomDescription;
    }

    public int getHotelID() {
        return HotelID;
    }

}
