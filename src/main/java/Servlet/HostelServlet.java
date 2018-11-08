package Servlet;

import HostelDAO.EmployeeDAO;

import HostelDAO.HostelDAO;
import HostelDB.Employee;
import HostelDB.Hostel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ={"/Hostel"})
public class HostelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HostelDAO hostelDAO = new HostelDAO();

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
        List<Hostel> list = hostelDAO.getAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ShowHostel.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Name = request.getParameter("FirstName");
        String Address = request.getParameter("Address");
        String Phone = request.getParameter("Phone");
        String City = request.getParameter("City");
        int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));

        hostelDAO.create();
        response.sendRedirect("/Hostel");

    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int HostID = Integer.parseInt(req.getParameter("HostID"));
        Hostel hostel = new Hostel();
        hostel.setHostID(Integer.parseInt(req.getParameter("HostID")));
        hostel.setName(req.getParameter("Name"));
        hostel.setAddress(req.getParameter("Address"));
        hostel.setPhone(req.getParameter("Phone"));
        hostel.setCity(req.getParameter("City"));
        hostelDAO.update(hostel);
        resp.sendRedirect("/Hostel");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int HostID = Integer.parseInt(request.getParameter("HostID"));
        hostelDAO.delete((HostID));
        response.sendRedirect("/Hostel");
    }
}