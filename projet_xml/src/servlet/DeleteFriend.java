package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.ServiceUser;
import classe.Friend;
import classe.User;


@WebServlet("/DeleteFriend")
public class DeleteFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFriend() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Friend friendTmp = (Friend) session.getAttribute("currentFriend");
		session.setAttribute("currentFriend", null);
		if(ServiceUser.friendExist(user, friendTmp.getMail()))
			ServiceUser.deleteFriend(user, friendTmp.getMail());
		this.getServletContext().getRequestDispatcher("/consultListFriend.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idFriend = request.getParameter("friend");
		if(ServiceUser.friendExist(user, idFriend))
			ServiceUser.deleteFriend(user, idFriend);
		this.getServletContext().getRequestDispatcher("/consultListFriend.jsp").forward(request, response);
	}

}
