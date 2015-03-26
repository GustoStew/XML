package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		if(user.groupExist(groupTmp.getName()))
			user.deleteGroup(groupTmp.getName());
		this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idGroup = request.getParameter("group");
		if(user.groupExist(idGroup))
			user.deleteGroup(idGroup);
		this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}

}
