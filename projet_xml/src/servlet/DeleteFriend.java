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
 * Servlet permettant la suppression d'un ami
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Friend
 */
@WebServlet("/DeleteFriend")
public class DeleteFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructeur par défaut
	 */
    public DeleteFriend() {
        super();
    }

    /**
     * Supprime un ami 
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#deleteFriend(String)
     * @see User#friendExist(String)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Friend friendTmp = (Friend) session.getAttribute("currentFriend");
		session.setAttribute("currentFriend", null);
		
		//On supprime l'ami
		if(user.friendExist(friendTmp.getMail()))
			user.deleteFriend(friendTmp.getMail());
		
		this.getServletContext().getRequestDispatcher("/consultListFriend.jsp").forward(request, response);
	}

	/**
     * Supprime un ami
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#deleteFriend(String)
     * @see User#friendExist(String)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idFriend = request.getParameter("friend");
		
		//On supprime l'ami
		if(user.friendExist(idFriend))
			user.deleteFriend(idFriend);
		
		this.getServletContext().getRequestDispatcher("/consultListFriend.jsp").forward(request, response);
	}

}
