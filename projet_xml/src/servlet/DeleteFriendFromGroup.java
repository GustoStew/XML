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
 * Servlet permettant la suppression d'un ami dans un groupe
 * @author Germain LE GUEN et Roxannne COUSIN
 * @see User
 * @see Group
 */
@WebServlet("/DeleteFriendFromGroup")
public class DeleteFriendFromGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * Constructeur par défaut
	 */
    public DeleteFriendFromGroup() {
        super();
    }
    
    /**
     * Supprime un ami d'un groupe
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#deleteFriendFromGroup(String, String)
     * @see Group#getName()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		Group currentGroup = (Group) session.getAttribute("currentGroup");
		User user = (User) session.getAttribute("user");
		String idFriend = request.getParameter("friend");
		
		//On supprime l'ami du groupe
		user.deleteFriendFromGroup(idFriend, currentGroup.getName());
		
		this.getServletContext().getRequestDispatcher("/consultInfoGroup.jsp").forward(request, response);
	}

}
