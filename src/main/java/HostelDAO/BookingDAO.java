package HostelDAO;

import HostelDB.Booking;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements GenericDAO {
    public Serializable create() {
        String sql = "Insert into booking(CustomerID,RoomID, BookingDate, DateIN, DateOUT,Bill) Values(?,?,?,?,?,?)";
        Booking booking= new Booking();
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setInt(1,booking.getCustomerID());
            stm.setInt(2,booking.getRoomID());
            stm.setString(3,booking.getBookingDate());
            stm.setString(4,booking.getDateIN());
            stm.setString(5,booking.getDateOUT());
            stm.setDouble(6,booking.getBill());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    public Serializable read(int K) {
        Booking booking= new Booking();
        String sql = "select * from booking where BookingID = ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setInt(1, K);

            ResultSet rs = stm.executeQuery();
            rs.next();
            booking.setBookingID(rs.getInt("EmployeeID"));
            booking.setCustomerID(rs.getInt("CustomerID"));
            booking.setRoomID(rs.getInt("RoomID"));
            booking.setBookingDate(rs.getString("BookingDate"));
            booking.setDateIN(rs.getString("DateIN"));
            booking.setDateOUT(rs.getString("DateOUT"));
            booking.setBill(rs.getDouble("Bill"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    public void delete(Serializable param) {
        Booking booking= new Booking();
        String sql = "Delete From Booking where BookingID= ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)){
            stm.setInt(1, booking.getBookingID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Serializable param) {
        Booking booking= new Booking();
        String sql = "UPDATE booking SET DateIN = ?,DateOUT = ? WHERE BookingID =?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,booking.getDateIN());
            stm.setString(2,booking.getDateOUT());
            stm.setInt(3,booking.getBookingID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAll() {
        String sql = "select * from booking";
        List<Booking> list = new ArrayList<Booking>();

        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)){
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Booking booking = new Booking();
                booking.setBookingID(rs.getInt("BookingID"));
                booking.setCustomerID(rs.getInt("CustomerID"));
                booking.setRoomID(rs.getInt("RoomID"));
                booking.setBookingDate(rs.getString("BookingDate"));
                booking.setDateIN(rs.getString("DateIN"));
                booking.setDateOUT(rs.getString("DateOUT"));
                booking.setBill(rs.getDouble("Bill"));

                list.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

