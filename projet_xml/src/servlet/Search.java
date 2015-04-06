package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classe.*;

/**
 * Servlet permettant d'effectuer une recherche parmis les informations des différents amis d'un utilisateur
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Friend
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructeur par défaut
	 */
    public Search() {
        super();
    }

    /**
     * Recherche une chaine de caractères parmis les informations des amis
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#searchMatch(String)
     * @see User#User()
     * @see User#setFriends(HashMap)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis las ession et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//On récupère une HashMap contenant les amis dont les informations concordent avec la chaine de caractères donnée
		HashMap<String, Friend> tabFriend = user.searchMatch(request.getParameter("search"));
		
		//On crée un utilisateur factice dans lequel on place la HashMap
		//Cela permet de faciliter le transfert des informations vers la jsp
		User userTmp = new User();
		userTmp.setFriends(tabFriend);
		userTmp.setFriendCount(tabFriend.size());
		session.setAttribute("userTmp", userTmp);
		this.getServletContext().getRequestDispatcher("/resultSearch.jsp").forward(request, response);
	}

}
