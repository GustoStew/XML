package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.User;
import util.SerializerUser;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogOut() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		SerializerUser serialUser = new SerializerUser("/Users/germainleguen/Dev/" + user.getMail() + ".xml");
		session.removeAttribute("user");
		serialUser.save(user);
		this.getServletContext().getRequestDispatcher("/connection.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
