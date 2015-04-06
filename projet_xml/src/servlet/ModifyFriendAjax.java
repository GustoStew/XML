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
 * Servlet permettant la vérification du formulaire de modification d'un ami grâce à une requête AJAX
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Friend
 */
@WebServlet("/ModifyFriendAjax")
public class ModifyFriendAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * Constructeur par défaut
	 */
    public ModifyFriendAjax() {
        super();
    }
    
    /**
     * Teste si l'adresse mail envoyé en AJAX est valide
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#friendExist(String)
     * @see Friend#getMail()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Friend currentFriend = (Friend) session.getAttribute("currentFriend");
		String newMail = request.getParameter("mail");
		response.setContentType("text/plain");
		
		//Si l'adresse mail fourni dans le formulaire existe déjà 
		//et qu'elle est différente de celle déjà existante (c.a.d modification invalide de l'adresse mail)
		//Alors on renvoie "false" grâce à la réponse AJAX
		if(user.friendExist(newMail) && !currentFriend.getMail().equals(newMail)){
			response.getWriter().write("false");
		}
	}
}
