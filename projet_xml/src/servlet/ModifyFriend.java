package servlet;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.ServiceGroup;
import services.ServiceUser;
import classe.Friend;
import classe.Group;
import classe.User;


@WebServlet("/ModifyFriend")
public class ModifyFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyFriend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Friend currentFriend = (Friend) session.getAttribute("currentFriend");
		String modifiedMail = request.getParameter("mail");
		if(!ServiceUser.friendExist(user, modifiedMail) || currentFriend.getMail().equals(modifiedMail)){
			ServiceUser.deleteFriend(user, currentFriend.getMail());
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
			session.setAttribute("currentFriend", newFriend);
			this.getServletContext().getRequestDispatcher("/consultInfoFriend.jsp").forward(request, response);
		}
		this.getServletContext().getRequestDispatcher("/modifyFriendForm.jsp").forward(request, response);
	}
}
