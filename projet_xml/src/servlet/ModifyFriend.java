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
		String newMail = request.getParameter("mail");
		if(!ServiceUser.friendExist(user, newMail) || currentFriend.getMail().equals(newMail)){
			String newFirstName, newLastName, newPhone, newAddress;
			newFirstName = request.getParameter("firstname");
			newLastName = request.getParameter("lastname");
			newPhone = request.getParameter("phone");
			newAddress = request.getParameter("address");
			System.out.println("prenom" + newFirstName);
			System.out.println("nom" + newLastName);
			System.out.println("mail" + newMail);
			System.out.println("phone" + newPhone);
			System.out.println("ad" + newAddress);
			if(newFirstName=="")
				newFirstName = currentFriend.getFirstName();
			if(newLastName=="")
				newLastName = currentFriend.getLastName();
			if(newMail=="")
				newMail = currentFriend.getMail();
			if(newPhone=="")
				newPhone = currentFriend.getPhone();
			if(newAddress=="")
				newAddress = currentFriend.getAddress();
			System.out.println("prenom" + newFirstName);
			System.out.println("nom" + newLastName);
			System.out.println("mail" + newMail);
			System.out.println("phone" + newPhone);
			System.out.println("ad" + newAddress);
			ServiceUser.deleteFriend(user, currentFriend.getMail());
			Friend newFriend = new Friend(newFirstName, 
				  						  newLastName, 
				  						  newMail, 
				  						  newPhone, 
				  						  newAddress);
			ServiceUser.addFriend(user, newFriend);
			for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
				if(request.getParameter(groupTmp.getKey())!=null)
					ServiceGroup.addFriend(groupTmp.getValue(),newFriend);
			}
			session.setAttribute("user", user);
			session.setAttribute("currentFriend", newFriend);
			this.getServletContext().getRequestDispatcher("/consultInfoFriend.jsp").forward(request, response);
		}
		else
			this.getServletContext().getRequestDispatcher("/modifyFriendForm.jsp").forward(request, response);
	}
}
