package servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classe.*;
import util.*;

/**
 * Servlet permettant à un utilisateur de s'authentifier
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see SerializerListID
 * @see SerializerUser
 * @see User
 * @see ListUserID
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructeur par défaut
	 */
    public SignIn() {
        super();
    }

    /**
     * Permet d'authentifier un utilisateur
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see SerializerListID#SerializerListID(String)
     * @see SerializerListID#getLastSave()
     * @see SerializerUser#SerializerUser(String)
     * @see SerializerUser#getLastSave()
     * @see ListUserID#getData()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère la liste des ID des utilisateurs depuis le fichier xml
		ServletContext context = getServletContext();
		SerializerListID serialListID = new SerializerListID(context.getInitParameter("databasePath") + "UserID.xml");
		ListUserID listID = serialListID.getLastSave();
		
		//Si l'adresse mail fourni est contenu dans la liste des ID des utilisateurs 
		//et que le mot de passe fourni correspond à celui de la liste des ID
		//alors on authentifie l'utilisateur
		String idUser = request.getParameter("mail");
		String pwd = request.getParameter("pwd");
		if(listID.getData().containsKey(idUser) && listID.getData().get(idUser).equals(pwd)){
			SerializerUser serialUser = new SerializerUser(context.getInitParameter("databasePath") + idUser + ".xml");
			User user = serialUser.getLastSave();
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		}
		else{
			this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
		}
	}
}
