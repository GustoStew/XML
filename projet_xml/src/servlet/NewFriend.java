package servlet;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.*
;
@WebServlet("/NewFriend")
public class NewFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewFriend() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Friend tmp = new Friend(request.getParameter("firstname"), 
								request.getParameter("lastname"), 
								request.getParameter("mail"), 
								request.getParameter("phone"), 
								request.getParameter("address"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		user.addFriend(tmp);
		for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
			if(request.getParameter(groupTmp.getKey())!=null)
				groupTmp.getValue().addFriendToGroup(tmp);
		}
		session.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

}
