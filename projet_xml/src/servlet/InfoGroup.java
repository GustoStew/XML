package servlet;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.Group;
import classe.User;


@WebServlet("/InfoGroup")
public class InfoGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InfoGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idGroup = request.getParameter("group");
		for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
			if(groupTmp.getKey().equals(idGroup)){
				session.setAttribute("currentGroup", groupTmp.getValue());
				break;
			}
		}
		this.getServletContext().getRequestDispatcher("/consultInfoGroup.jsp").forward(request, response);
	}

}
