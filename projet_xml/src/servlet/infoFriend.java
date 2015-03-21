package servlet;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classe.*;

@WebServlet("/infoFriend")
public class infoFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public infoFriend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idFriend = request.getParameter("friend");
		Friend f = user.getFriends().get(idFriend);
		session.setAttribute("currentFriend", f);
		this.getServletContext().getRequestDispatcher("/consultInfoFriend.jsp").forward(request, response);
	}

}
