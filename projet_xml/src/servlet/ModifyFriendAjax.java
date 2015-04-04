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


@WebServlet("/ModifyFriendAjax")
public class ModifyFriendAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyFriendAjax() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Friend currentFriend = (Friend) session.getAttribute("currentFriend");
		String newMail = request.getParameter("mail");
		response.setContentType("text/plain");
		if(ServiceUser.friendExist(user, newMail) && !currentFriend.getMail().equals(newMail)){
			response.getWriter().write("false");
		}
		else{
			response.getWriter().write("true");
		}
	}

}
