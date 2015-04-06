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
 * Servlet permettant la suppression d'un groupe
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Group
 */
@WebServlet("/DeleteGroup")
public class DeleteGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * Constructeur par défaut
	 */
    public DeleteGroup() {
        super();
    }
    
    /**
     *  Supprime un groupe
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#deleteGroup(String)
     * @see User#groupExist(String)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session 
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Group groupTmp = (Group) session.getAttribute("currentGroup");
		session.setAttribute("currentGroup", null);
		
		//On supprime le groupe
		if(user.groupExist(groupTmp.getName()))
			user.deleteGroup(groupTmp.getName());
		
		this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}
	
	/**
     *  Supprime un groupe
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#deleteGroup(String)
     * @see User#groupExist(String)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idGroup = request.getParameter("group");
		
		//On supprime le groupe
		if(user.groupExist(idGroup))
			user.deleteGroup(idGroup);
		
		this.getServletContext().getRequestDispatcher("/consultListGroup.jsp").forward(request, response);
	}

}
