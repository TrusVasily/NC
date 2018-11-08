package Servlet;

import HostelDAO.BookingDAO;
import HostelDAO.RoomTypeDAO;
import HostelDB.Booking;
import HostelDB.Room;
import HostelDB.RoomType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns ={"/Booking"})
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookingDAO bookingDAO = new BookingDAO();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Booking> list = bookingDAO.getAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ShowBooking.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String CustomerID = request.getParameter("RoomType");
        String RoomID = request.getParameter("RoomName");
        String BookingDate = request.getParameter("BookingDate");
        String DateIN = request.getParameter("DateIN");
        String DateOUT = request.getParameter("DateOUT");
        Double Bill = Double.parseDouble(request.getParameter("Bill"));

        Booking booking = new Booking();
        bookingDAO.create();
        response.sendRedirect("/Booking");

    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String BookingID = req.getParameter("BookingID");
        Booking booking = new Booking();
        booking.setBookingID(Integer.parseInt(req.getParameter("BookingID")));
        booking.setCustomerID(Integer.parseInt(req.getParameter("CustomerID")));
        booking.setRoomID(Integer.parseInt(req.getParameter("RoomID")));
        booking.setBookingDate(req.getParameter("BookingDate"));
        booking.setDateIN(req.getParameter("DateIN"));
        booking.setDateOUT(req.getParameter("DateOUT"));
        booking.setBill(Double.parseDouble(req.getParameter("Bill")));
        bookingDAO.update(booking);
        resp.sendRedirect("/Booking");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String BookingID = request.getParameter("BookingID");
        bookingDAO.delete((BookingID));
        response.sendRedirect("/Booking");
    }
}
