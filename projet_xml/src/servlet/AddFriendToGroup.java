package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.ServiceGroup;
import services.ServiceUser;
import classe.*;

@WebServlet("/AddFriendToGroup")
public class AddFriendToGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddFriendToGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post de addfriend to group");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idFriend = request.getParameter("friend");
		Group currentGroup = (Group) session.getAttribute("currentGroup");
		Friend f = user.getFriends().get(idFriend);
		ServiceGroup.addFriend(currentGroup, f);
		session.setAttribute("currentGroup", currentGroup);
		this.getServletContext().getRequestDispatcher("/consultInfoGroup.jsp").forward(request, response);
	}
}
