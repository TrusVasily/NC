package HostelDAO;

import HostelDB.Customer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements GenericDAO {
    public Serializable create() {
        String sql = "Insert into customer(FirstName, LastName, Address, Phone,Passport) Values(?,?,?,?,?)";
        Customer customer= new Customer();
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,customer.getFirstName());
            stm.setString(2,customer.getLastName());
            stm.setString(3,customer.getAddress());
            stm.setString(4,customer.getPhone());
            stm.setString(5,customer.getPassport());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;    }

    public Serializable read(int K) {
        Customer customer= new Customer();
        String sql = "select * from customer where CustomerID = ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setInt(1, K);

            ResultSet rs = stm.executeQuery();
            rs.next();
            customer.setCustomerID(rs.getInt("CustomerID"));
            customer.setFirstName(rs.getString("FirstName"));
            customer.setLastName(rs.getString("LastName"));
            customer.setAddress(rs.getString("Address"));
            customer.setPhone(rs.getString("Phone"));
            customer.setPassport(rs.getString("Passport"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void delete(Serializable param) {
        Customer customer= new Customer();
        String sql = "Delete From customer where CustomerID= ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)){
            stm.setInt(1, customer.getCustomerID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Serializable param) {
        Customer customer= new Customer();
        String sql = "UPDATE customer SET FirstName = ?,LastName = ? WHERE CustomerID =?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,customer.getFirstName());
            stm.setString(2,customer.getLastName());
            stm.setInt(3,customer.getCustomerID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAll() {
        String sql = "select * from customer";
        List<Customer> list = new ArrayList<Customer>();

        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt("EmployeeID"));
                customer.setFirstName(rs.getString("FirstName"));
                customer.setLastName(rs.getString("LastName"));
                customer.setAddress(rs.getString("Address"));
                customer.setPhone(rs.getString("Phone"));
                customer.setPassport(rs.getString("Passport"));
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
