package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classe.*;

/**
 * Servlet permettant d'ajouter un ami à un groupe
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Group
 * @see Friend
 */
@WebServlet("/AddFriendToGroup")
public class AddFriendToGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * Constructeur par défaut
	 */
    public AddFriendToGroup() {
        super();
    }
    
    /**
     * Ajoute un ami à un groupe
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see Group#addFriend(Friend)
     * @see User#getFriends()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idFriend = request.getParameter("friend");
		Group currentGroup = (Group) session.getAttribute("currentGroup");
		
		//On ajoute l'ami au groupe
		Friend f = user.getFriends().get(idFriend);
		currentGroup.addFriend(f);
		
		session.setAttribute("currentGroup", currentGroup);
		this.getServletContext().getRequestDispatcher("/consultInfoGroup.jsp").forward(request, response);
	}
}
