package HostelDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Booking implements Serializable {
    private int BookingID;
    private int CustomerID;
    private int RoomID;
    private String BookingDate;
    private String DateIN;
    private String DateOUT;
    private Double Bill;

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }

    public String getDateIN() {
        return DateIN;
    }

    public void setDateIN(String dateIN) {
        DateIN = dateIN;
    }

    public String getDateOUT() {
        return DateOUT;
    }

    public void setDateOUT(String dateOUT) {
        DateOUT = dateOUT;
    }

    public Double getBill() {
        return Bill;
    }

    public void setBill(Double bill) {
        Bill = bill;
    }

}
