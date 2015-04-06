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
 * Servlet permettant la vérification du formulaire d'ajout d'un groupe grâce à une requête AJAX
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 */
@WebServlet("/NewGroupAjax")
public class NewGroupAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructeur par défaut
	 */
    public NewGroupAjax() {
        super();
    }

    /**
     * Teste si le nom du groupe est valide
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#groupExist(String)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		response.setContentType("text/plain");
		
		//Si le nom du groupe fourni existe déjà alors on renvoie "false" grâce à la réponse AJAX
		if (user.groupExist(request.getParameter("nameGroup"))){
	        response.getWriter().write("false");
		}
	}

}
