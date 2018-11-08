package Servlet;

import HostelDAO.EmployeeDAO;

import HostelDB.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ={"/Employee"})
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO = new EmployeeDAO();

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
        List<Employee> list = employeeDAO.getAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ShowEmployee.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String Address = request.getParameter("Address");
        String Phone = request.getParameter("Phone");

        employeeDAO.create();
        response.sendRedirect("/Employee");

    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int EmployeeID = Integer.parseInt(req.getParameter("EmployeeID"));
        Employee employee = new Employee();
        employee.setEmployeeID(Integer.parseInt(req.getParameter("EmployeeID")));
        employee.setFirstName(req.getParameter("FirstName"));
        employee.setLastName(req.getParameter("LastName"));
        employee.setAddress(req.getParameter("Address"));
        employee.setPhone(req.getParameter("Phone"));
        employeeDAO.update(employee);
        resp.sendRedirect("/Employee");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
        employeeDAO.delete((EmployeeID));
        response.sendRedirect("/Employee");
    }
}