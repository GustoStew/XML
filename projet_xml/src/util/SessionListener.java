package util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import classe.User;

/**
 * Implémente l'interface {@link HttpSessionListener}
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 */
public class SessionListener implements HttpSessionListener{

	/**
	 * Méthode non définie
	 */
	public void sessionCreated(HttpSessionEvent event) {
	}
	
	/**
	 * Sauvegarde contenant les informations de l'utilisateur
	 * @param event Evénement généré à l'invalidation de la session
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null){
			ServletContext context = session.getServletContext();
			SerializerUser serialUser = new SerializerUser(context.getInitParameter("databasePath") + user.getMail() + ".xml");
			serialUser.save(user);
		}
	}

}
