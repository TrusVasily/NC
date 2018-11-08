package HostelDAO;

import HostelDAO.GenericDAO;
import HostelDB.Employee;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements GenericDAO {


    public Serializable create() {

        String sql = "Insert into Employee(EmployeeID,FirstName, LastName, Address, Phone) Values(?,?,?,?,?)";
        Employee employee= new Employee();
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setInt(1,employee.getEmployeeID());
            stm.setString(2,employee.getFirstName());
            stm.setString(3,employee.getLastName());
            stm.setString(4,employee.getAddress());
            stm.setString(5,employee.getPhone());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return employee;
    }

    public Employee read(int key) {

        Employee employee= new Employee();
        String sql = "select * from employee where EmployeeID = ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setInt(1, key);

            ResultSet rs = stm.executeQuery();
            rs.next();
            employee.setEmployeeID(rs.getInt("EmployeeID"));
            employee.setFirstName(rs.getString("FitstName"));
            employee.setLastName(rs.getString("LastName"));
            employee.setAddress(rs.getString("Address"));
            employee.setPhone(rs.getString("Phone"));

        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void delete(Serializable param) {
        Employee employee= new Employee();
        String sql = "Delete From Employee where EmployeeID= ?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)){
            stm.setInt(1, employee.getEmployeeID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Serializable param) {
        Employee employee= new Employee();
        String sql = "UPDATE Employee SET FirstName = ?,LastName = ? WHERE EmployeeID =?";
        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql))
        {
            stm.setString(1,employee.getFirstName());
            stm.setString(2,employee.getLastName());
            stm.setInt(3,employee.getEmployeeID());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAll() {
        String sql = "select * from employee";
        List<Employee> list = new ArrayList<Employee>();

        try (PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql)){
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt("EmployeeID"));
                employee.setFirstName(rs.getString("FirstName"));
                employee.setLastName(rs.getString("LastName"));
                employee.setAddress(rs.getString("Address"));
                employee.setPhone(rs.getString("Phone"));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
