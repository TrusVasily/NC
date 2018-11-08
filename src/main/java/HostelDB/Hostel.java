package HostelDB;


import java.io.Serializable;

public class Hostel implements Serializable {
    private int HostID;
    private String Name;
    private String Address;
    private String City;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    private String Phone;
    private int EmpoyeeID;

    public int getHostID() {
        return HostID;
    }

    public void setHostID(int hostID) {
        HostID = hostID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getEmpoyeeID() {
        return EmpoyeeID;
    }

    public void setEmpoyeeID(int empoyeeID) {
        EmpoyeeID = empoyeeID;
    }


}
