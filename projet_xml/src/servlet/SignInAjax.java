package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.SerializerListID;
import classe.ListUserID;

/**
 * Servlet permettant la vérification du formulaire d'authentification grâce à une requête AJAX
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see SerializerListID
 * @see ListUserID
 */
@WebServlet("/SignInAjax")
public class SignInAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut
	 */
    public SignInAjax() {
        super();
    }

    /**
     * Teste si l'adresse mail et le mot de passe envoyés en AJAX sont valides
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see SerializerListID#SerializerListID(String)
     * @see SerializerListID#getLastSave()
     * @see ListUserID#getData()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère la liste des ID des utilisateurs depuis le fichier xml
		ServletContext context = getServletContext();
		SerializerListID serialListID = new SerializerListID(context.getInitParameter("databasePath") + "UserID.xml");
		ListUserID listID = serialListID.getLastSave();
		
		//Si l'adresse mail fourni n'est pas dans la liste des ID des utilisateurs
		//ou que le mot de passe fourni est différent de celui demandé
		//alors on renvoie "false" grâce à la réponse AJAX
		String idUser = request.getParameter("mail");
		String pwd = request.getParameter("pwd");
		response.setContentType("text/plain");
		if(!listID.getData().containsKey(idUser) || !listID.getData().get(idUser).equals(pwd)){
			response.getWriter().write("false");
		}
	}

}
