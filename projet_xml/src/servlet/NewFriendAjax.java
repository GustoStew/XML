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
 * Servlet permettant la vérification du formulaire d'ajout d'un ami grâce à une requête AJAX
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 */
@WebServlet("/NewFriendAjax")
public class NewFriendAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructeur par défaut
	 */
    public NewFriendAjax() {
        super();
    }

    /**
     * Teste si l'adresse mail envoyé en AJAX est valide
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#friendExist(String)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		response.setContentType("text/plain");
		
		//Si l'adresse mail fourni existe déjà
		//Alors on renvoie "false" grâce à la réponse AJAX
		if(user.friendExist(request.getParameter("mail"))){
			response.getWriter().write("false");
		}
	}

}
