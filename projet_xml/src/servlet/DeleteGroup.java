package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.Friend;
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
		user.deleteGroup(groupTmp.getName());
		if(user.hasNoGroups())
			this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		else
			this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idGroup = request.getParameter("group");
		user.deleteGroup(idGroup);
		if(user.hasNoGroups())
			this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		else
			this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}

}
