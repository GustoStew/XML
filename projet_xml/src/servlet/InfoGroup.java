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
 * Servlet permettant la récupération d'un groupe pour l'affichage de ses informations
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Group
 */
@WebServlet("/InfoGroup")
public class InfoGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * Constructeur par défaut
	 */
    public InfoGroup() {
        super();
    }
    
    /**
     *  Récupère un groupe depuis la request et le met en attribut de session
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#getGroups()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idGroup = request.getParameter("group");
		Group g = user.getGroups().get(idGroup);
		
		//On place le groupe obtenu en attribut de session
		session.setAttribute("currentGroup", g);
		
		this.getServletContext().getRequestDispatcher("/consultInfoGroup.jsp").forward(request, response);
	}

}
