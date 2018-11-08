package HostelDAO;

import HostelDB.Hostel;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HostelDAO implements GenericDAO {
    public Serializable create() {
        String sql = "Insert into Hostel(Name, Addres, Phone,City,EmployeeID) Values(?,?,?,?,?)";
        Hostel hostel= new Hostel();
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,hostel.getName());
            stm.setString(2,hostel.getAddress());
            stm.setString(3,hostel.getPhone());
            stm.setString(4,hostel.getCity());
            stm.setInt(5,hostel.getEmpoyeeID());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostel;
    }

    public Serializable read(int K) {
        Hostel hostel= new Hostel();
        String sql = "select * from hostel where HostID = ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setInt(1, K);

            ResultSet rs = stm.executeQuery();
            rs.next();
            hostel.setHostID(rs.getInt("HostID"));
            hostel.setName(rs.getString("Name"));
            hostel.setAddress(rs.getString("Address"));
            hostel.setPhone(rs.getString("Phone"));
            hostel.setCity(rs.getString("City"));
            hostel.setEmpoyeeID(rs.getInt("EmployeeID"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return hostel;
    }

    public void delete(Serializable param) {
        Hostel hostel= new Hostel();
        String sql = "Delete From hostel where HostID= ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)){
            stm.setInt(1, hostel.getHostID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Serializable param) {
        Hostel hostel= new Hostel();
        String sql = "UPDATE hostel SET Name = ?,Phone = ? WHERE HostID =?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,hostel.getName());
            stm.setString(2,hostel.getPhone());
            stm.setInt(3,hostel.getHostID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAll() {

        String sql = "select * from hostel";
        List<Hostel> list = new ArrayList<Hostel>();

        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Hostel hostel = new Hostel();
                hostel.setHostID(rs.getInt("HostID"));
                hostel.setName(rs.getString("Name"));
                hostel.setAddress(rs.getString("Address"));
                hostel.setPhone(rs.getString("Phone"));
                hostel.setCity(rs.getString("City"));
                hostel.setEmpoyeeID(rs.getInt("EmployeeID"));
                list.add(hostel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
