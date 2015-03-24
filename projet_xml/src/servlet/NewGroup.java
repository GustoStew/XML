package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.XmlSerializer;
import classe.*;

@WebServlet("/NewGroup")
public class NewGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewGroup() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		user.addGroup(request.getParameter("name"));
		session.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

}
