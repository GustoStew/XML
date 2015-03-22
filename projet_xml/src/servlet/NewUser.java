package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.XmlSerializer;
import classe.*
;
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewUser() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("machin"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(request.getParameter("firstname"), 
							 request.getParameter("lastname"), 
							 request.getParameter("mail"), 
							 request.getParameter("phone"), 
							 request.getParameter("address"));
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

}
