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
 * Servlet permettant de modifier les informations de l'utilisateur
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 */
@WebServlet("/ModifyUser")
public class ModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par défaut
	 */
    public ModifyUser() {
        super();
    }
    
    /**
     * Modifie les informations de l'utilisateur 
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#setFirstName(String)
     * @see User#setLastName(String)
     * @see User#setPhone(String)
     * @see User#setAddress(String)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires de la session et de la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//Pour chaque information de l'utilisateur (prénom, nom, ...) :
		//Si elle a été modifiée par le formulaire alors on modifie la valeur (set)
		String newFirstName, newLastName, newPhone, newAddress;
		newFirstName = request.getParameter("firstname");
		newLastName = request.getParameter("lastname");
		newPhone = request.getParameter("phone");
		newAddress = request.getParameter("address");
		if(newFirstName!="")
			user.setFirstName(newFirstName);
		if(newLastName!="")
			user.setLastName(newLastName);
		if(newPhone!="")
			user.setPhone(newPhone);
		if(newAddress!="")
			user.setAddress(newAddress);
		
		session.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

}
