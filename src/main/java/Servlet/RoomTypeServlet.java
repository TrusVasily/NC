package Servlet;

import HostelDAO.RoomTypeDAO;
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
import java.util.List;

@WebServlet(urlPatterns ={"/RoomType"})
public class RoomTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomTypeDAO roomTypeDAO = new RoomTypeDAO();

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
        List<RoomType> room = roomTypeDAO.getAll();
        request.setAttribute("room", room);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ShowRoomType.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String RoomType = request.getParameter("RoomType");
        String RoomName = request.getParameter("RoomName");
        Double Price = Double.parseDouble(request.getParameter("Price"));
        RoomType roomtype = new RoomType();
        roomTypeDAO.create();
        response.sendRedirect("/RoomType");

    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String RoomType = req.getParameter("RoomType");
        RoomType roomType = new RoomType();
        roomType.setRoomType(req.getParameter("RoomType"));
        roomType.setRoomName(req.getParameter("RoomName"));
        roomType.setPrice(Double.parseDouble(req.getParameter("Price")));
        roomTypeDAO.update(roomType);
        resp.sendRedirect("/RoomType");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String RoomType = request.getParameter("RomeType");
        roomTypeDAO.delete((RoomType));
        response.sendRedirect("/RoomType");
    }
}