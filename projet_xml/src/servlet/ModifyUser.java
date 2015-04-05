package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.User;

@WebServlet("/ModifyUser")
public class ModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String newFirstName, newLastName, newPhone, newAddress;
		newFirstName = request.getParameter("firstname");
		newLastName = request.getParameter("lastname");
		newPhone = request.getParameter("phone");
		newAddress = request.getParameter("address");
		if(newFirstName!="")
			user.setFirstName(newFirstName);
		if(newLastName!="")
			user.setLastName(newLastName);
		if(newPhone!="")
			user.setPhone(newPhone);
		if(newAddress!="")
			user.setAddress(newAddress);
		session.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

}
