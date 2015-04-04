package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.ServiceUser;
import classe.User;


@WebServlet("/CheckFriendAjax")
public class NewFriendAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewFriendAjax() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		response.setContentType("text/plain");
		if(ServiceUser.friendExist(user, request.getParameter("mail"))){
			response.getWriter().write("false");
		}
		else{
			response.getWriter().write("true");
		}
	}

}
