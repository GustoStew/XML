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

@WebServlet("/infoFriend")
public class infoFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public infoFriend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("idfriend"+request.getParameter("friend"));
		String idFriend = request.getParameter("friend");
		Friend f = new Friend();
		for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
			if(groupTmp.getValue().getMembers().containsKey(idFriend)){
				f = groupTmp.getValue().getMembers().get(idFriend);
				break;}
		}
		System.out.println(f.getLastName());
		session.setAttribute("currentFriend",f);
		this.getServletContext().getRequestDispatcher("/consultInfoFriend.jsp").forward(request, response);
	}

}
