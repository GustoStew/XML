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
 * Servlet permettant la récupération d'un ami pour l'affichage de ses informations
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Friend
 */
@WebServlet("/infoFriend")
public class infoFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * Constructeur par défaut
	 */
    public infoFriend() {
        super();
    }
	
    /**
     * Récupère un ami grâce à la request puis le met en attribut de session
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#getFriends()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idFriend = request.getParameter("friend");
		Friend f = user.getFriends().get(idFriend);
		
		//On place l'ami obtenu en attribut de session
		session.setAttribute("currentFriend", f);
		
		this.getServletContext().getRequestDispatcher("/consultInfoFriend.jsp").forward(request, response);
	}

}
