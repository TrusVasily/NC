package Servlet;

import HostelDAO.CustomerDAO;
import HostelDB.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ={"/Customer"})
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO = new CustomerDAO();

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
        List<Customer> list = customerDAO.getAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ShowCustomer.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String Address = request.getParameter("Address");
        String Phone = request.getParameter("Phone");
        String Passport = request.getParameter("Passport");

        Customer customer = new Customer();
        customerDAO.create();
        response.sendRedirect("/Customer");

    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int CustomerID = Integer.parseInt(req.getParameter("CustomerID"));
        Customer customer = new Customer();
        customer.setCustomerID(Integer.parseInt(req.getParameter("CustomerID")));
        customer.setFirstName(req.getParameter("FirstName"));
        customer.setLastName(req.getParameter("LastName"));
        customer.setAddress(req.getParameter("Address"));
        customer.setPhone(req.getParameter("Phone"));
        customer.setPassport(req.getParameter("Passport"));
        customerDAO.update(customer);
        resp.sendRedirect("/Customer");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
        customerDAO.delete((CustomerID));
        response.sendRedirect("/Customer");
    }
}