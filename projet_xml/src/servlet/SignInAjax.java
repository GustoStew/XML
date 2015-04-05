package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.SerializerListID;
import classe.ListUserID;

@WebServlet("/SignInAjax")
public class SignInAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignInAjax() {
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
		response.setContentType("text/plain");
		if(!listID.getData().containsKey(idUser) || !listID.getData().get(idUser).equals(pwd)){
			response.getWriter().write("false");
		}
	}

}
