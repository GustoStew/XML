package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classe.User;

/**
 * Servlet permettant d'ajouter un groupe à l'utilisateur
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 */
@WebServlet("/NewGroup")
public class NewGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructeur par défaut
	 */
    public NewGroup() {
        super();
    }
	
    /**
     * Crée un groupe et l'ajoute à l'utilisateur
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#groupExist(String)
     * @see User#addGroup(String)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécesaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//Si le groupe n'existe pas déjà, alors on l'ajoute
		if(!user.groupExist(request.getParameter("name"))){
			user.addGroup(request.getParameter("name"));
			session.setAttribute("user", user);
		}
		this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}
}
