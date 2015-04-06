package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet permettant la destruction de la session 
 * @author Germain LE GUEN et Roxanne COUSIN
 *
 */
@WebServlet("/SignOut")
public class SignOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut
	 */
    public SignOut() {
        super();
    }

    /**
     * Détruit la session et redirige vers la page d'accueil
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/projet_xml/connection.jsp");
		return;
	}

}
