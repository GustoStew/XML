package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.SerializerListID;
import util.SerializerUser;
import classe.ListUserID;

/**
 * Servlet permettant la vérification du formulaire d'ajout d'un utilisateur grâce à une requête AJAX
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see ListUserID
 * @see SerializerListID
 * @see SerializerUser
 */
@WebServlet("/NewUserAjax")
public class NewUserAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut
	 */
    public NewUserAjax() {
        super();
    }
    
    /**
     * Teste si l'adresse mail envoyé en AJAX est valide
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see SerializerListID#SerializerListID(String)
     * @see SerializerListID#getLastSave()
     * @see ListUserID#getData()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère la liste des ID des différents utilisateurs depuis le fichier xml
		ServletContext context = getServletContext();
		SerializerListID serialListID = new SerializerListID(context.getInitParameter("databasePath") + "UserID.xml");
		ListUserID listID = serialListID.getLastSave();
		response.setContentType("text/plain");
		
		//Si l'adresse mail existe déjà alors on renvoie "false" grâce à la réponse AJAX
		if(listID.getData().containsKey(request.getParameter("mail"))){
			response.getWriter().write("false");
		}
	}

}
