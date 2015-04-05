package servlet;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.*;
import services.*;

@WebServlet("/NewFriend")
public class NewFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewFriend() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(!ServiceUser.friendExist(user, request.getParameter("mail"))){
				Friend newFriend = new Friend(request.getParameter("firstname"), 
								request.getParameter("lastname"), 
								request.getParameter("mail"), 
								request.getParameter("phone"), 
								request.getParameter("address"));
				ServiceUser.addFriend(user, newFriend);		
				for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
					if(request.getParameter(groupTmp.getKey())!=null)
						ServiceGroup.addFriend(groupTmp.getValue(),newFriend);
				}
				session.setAttribute("user", user);
				this.getServletContext().getRequestDispatcher("/consultListFriend.jsp").forward(request, response);
		}
		else
			this.getServletContext().getRequestDispatcher("/newFriendForm.jsp").forward(request, response);
	}

}
