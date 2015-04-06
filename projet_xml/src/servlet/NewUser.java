package servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.SerializerListID;
import util.SerializerUser;
import classe.*;

/**
 * Servlet permettant d'ajouter un nouvel utilisateur
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see ListUserID
 * @see User
 * @see SerializerListID
 * @see SerializerUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructeur par défaut
	 */
    public NewUser() {
        super();   
    }

    /**
     * Ajoute un nouvel utilisateur
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see SerializerUser#SerializerUser(String)
     * @see SerializerUser#getLastSave()
     * @see SerializerUser#save(Object)
     * @see SerializerListID#SerializerListID(String)
     * @see SerializerListID#getLastSave()
     * @see SerializerListID#save(Object)
     * @see ListUserID#getData()
     * @see User#User(String, String, String, String, String)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère la liste des ID des différents utilisateurs depuis le fichier xml
		ServletContext context = getServletContext();
		SerializerListID serialListID = new SerializerListID(context.getInitParameter("databasePath") + "UserID.xml");
		ListUserID listID = serialListID.getLastSave();
		
		//Si l'adresse mail fourni par le formulaire n'est pas déjà utilisé
		//Alors on crée l'utilisateur, on sauvegarde ses informations
		//Et on l'ajoute à la liste des ID
		if(!listID.getData().containsKey(request.getParameter("mail"))){
			User user = new User(request.getParameter("firstname"), 
					             request.getParameter("lastname"), 
					             request.getParameter("mail"), 
					             request.getParameter("phone"), 
					             request.getParameter("address"));
			user.addGroup("Amis");
			user.addGroup("Famille");
			user.addGroup("Travail");
			listID.getData().put(user.getMail(), request.getParameter("pwd"));
			serialListID.save(listID);
			SerializerUser serialUser = new SerializerUser(context.getInitParameter("databasePath") + user.getMail() + ".xml");
			serialUser.save(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		}
		else
			this.getServletContext().getRequestDispatcher("/connection.jsp").forward(request, response);
	}

}
