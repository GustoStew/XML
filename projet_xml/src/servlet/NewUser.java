package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.ServiceUser;
import util.SerializerListID;
import classe.*;

@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewUser() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SerializerListID serialListID = new SerializerListID("/Users/germainleguen/Dev/UserID.xml");
		ListUserID listID = serialListID.getLastSave();
		User user = new User(request.getParameter("firstname"), 
							 request.getParameter("lastname"), 
							 request.getParameter("mail"), 
							 request.getParameter("phone"), 
							 request.getParameter("address"));
		ServiceUser.addGroup(user, "Amis");
		ServiceUser.addGroup(user, "Famille");
		ServiceUser.addGroup(user, "Travail");
		listID.addUser(user.getMail(), request.getParameter("pwd"));
		serialListID.save(listID);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

}
