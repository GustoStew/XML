package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.ListUserID;
import classe.User;
import util.SerializerListID;
import util.SerializerUser;


@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignIn() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		SerializerListID serialListID = new SerializerListID(context.getInitParameter("databasePath") + "UserID.xml");
		ListUserID listID = serialListID.getLastSave();
		String idUser = request.getParameter("mail");
		String pwd = request.getParameter("pwd");
		if(listID.getData().containsKey(idUser) && listID.getData().get(idUser).equals(pwd)){
			SerializerUser serialUser = new SerializerUser(context.getInitParameter("databasePath") + idUser + ".xml");
			User user = serialUser.getLastSave();
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		}
		else{
			this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
		}
	}
}
