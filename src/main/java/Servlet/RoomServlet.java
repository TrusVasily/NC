package Servlet;

import HostelDAO.RoomDAO;
import HostelDB.Room;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ={"/Room"})
public class RoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomDAO roomDAO = new RoomDAO();

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
        List<Room> room = roomDAO.getAll();
        request.setAttribute("room", room);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ShowRoom.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String RoomType = request.getParameter("RoomType");
        String RoomDescription = request.getParameter("RoomDescription");
        int HotelID = Integer.parseInt(request.getParameter("HotelID"));
        Room room = new Room();
        roomDAO.create();
        response.sendRedirect("/Room");

    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int RoomID = Integer.parseInt(req.getParameter("RoomID"));
        Room room = new Room();
        room.setRoomID(Integer.parseInt(req.getParameter("RoomID")));
        room.setRoomType(req.getParameter("RoomType"));
        room.setRoomDescription(req.getParameter("RoomDescription"));
        room.setHotelID(Integer.parseInt(req.getParameter("HotelID")));
        roomDAO.update(room);
        resp.sendRedirect("/Room");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int RoomID = Integer.parseInt(request.getParameter("RoomID"));
        roomDAO.delete((RoomID));
        response.sendRedirect("/Room");
    }
}
