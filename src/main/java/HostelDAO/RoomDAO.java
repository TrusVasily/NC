package HostelDAO;

import HostelDB.Room;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements GenericDAO {
    public Serializable create() {
        String sql = "Insert into room(RoomType, RoomDescription, HotelID) Values(?,?,?)";
        Room room= new Room();
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,room.getRoomType());
            stm.setString(2,room.getRoomDescription());
            stm.setInt(3,room.getHotelID());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public Serializable read(int K) {
        Room room= new Room();
        String sql = "select * from room where RoomID = ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setInt(1, K);

            ResultSet rs = stm.executeQuery();
            rs.next();
            room.setRoomID(rs.getInt("RoomID"));
            room.setRoomType(rs.getString("RoomType"));
            room.setRoomDescription(rs.getString("RoomDescription"));
            room.setHotelID(rs.getInt("HostID"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public void delete(Serializable param) {
        Room room= new Room();
        String sql = "Delete From room where RoomID= ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)){
            stm.setInt(1, room.getRoomID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Serializable param) {
        Room room= new Room();
        String sql = "UPDATE room SET RoomDescription = ? WHERE RoomID =?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,room.getRoomDescription());
            stm.setInt(2,room.getRoomID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List getAll() {
        String sql = "select RoomID,RoomType,RoomDescription,HotelID  from room";
        List<Room> list = new ArrayList<Room>();

        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("RoomID"));
                room.setRoomType(rs.getString("RoomType"));
                room.setRoomDescription(rs.getString("RoomDescription"));
                room.setHotelID(rs.getInt("HotelID"));

                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
