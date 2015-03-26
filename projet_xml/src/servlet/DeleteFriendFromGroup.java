package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.Group;
import classe.User;


@WebServlet("/DeleteFriendFromGroup")
public class DeleteFriendFromGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFriendFromGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Group currentGroup = (Group) session.getAttribute("currentGroup");
		User user = (User) session.getAttribute("user");
		String idFriend = request.getParameter("friend");
		if(user.groupExist(currentGroup.getName()) && user.friendExist(idFriend))
			user.deleteFriendFromGroup(idFriend, currentGroup.getName());
		this.getServletContext().getRequestDispatcher("/consultInfoGroup.jsp").forward(request, response);
	}

}
