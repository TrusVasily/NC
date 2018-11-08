package HostelDAO;

import HostelDB.RoomType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAO implements GenericDAO {
    public Serializable create() {
        String sql = "Insert into roomtype(RoomType, RoomName, Price) Values(?,?,?)";
        RoomType roomType= new RoomType();
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,roomType.getRoomType());
            stm.setString(2,roomType.getRoomName());
            stm.setDouble(3,roomType.getPrice());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomType;
    }

    public Serializable read(int K) {
        RoomType roomType= new RoomType();
        String sql = "select * from roomtype where RoomType = ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setInt(1, K);

            ResultSet rs = stm.executeQuery();
            rs.next();
            roomType.setRoomType(rs.getString("RoomType"));
            roomType.setRoomName(rs.getString("RoomName"));
            roomType.setPrice(rs.getDouble("Price"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return roomType;    }

    public void delete(Serializable param) {
        RoomType roomType= new RoomType();
        String sql = "Delete From roomtype where RoomType= ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)){
            stm.setString(1, roomType.getRoomType());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Serializable param) {
        RoomType roomType= new RoomType();
        String sql = "UPDATE roomtype SET RoomName = ?,Price = ? WHERE RoomType =?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,roomType.getRoomType());
            stm.setString(2,roomType.getRoomName());
            stm.setDouble(3,roomType.getPrice());
            stm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List getAll() {
        String sql = "select * from roomtype";
        List<RoomType> list = new ArrayList<RoomType>();

        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setRoomType(rs.getString("RoomType"));
                roomType.setRoomName(rs.getString("RoomName"));
                roomType.setPrice(rs.getDouble("Price"));
                list.add(roomType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
