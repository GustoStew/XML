package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.ServiceUser;
import classe.Group;
import classe.User;


@WebServlet("/DeleteGroup")
public class DeleteGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteGroup() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Group groupTmp = (Group) session.getAttribute("currentGroup");
		session.setAttribute("currentGroup", null);
		if(ServiceUser.groupExist(user, groupTmp.getName()))
			ServiceUser.deleteGroup(user, groupTmp.getName());
		this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idGroup = request.getParameter("group");
		if(ServiceUser.groupExist(user, idGroup))
			ServiceUser.deleteGroup(user, idGroup);
		this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}

}
