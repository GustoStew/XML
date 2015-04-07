package servlet;

import java.io.IOException;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classe.*;

/**
 * Servlet permettant d'ajouter un nouvel ami à l'utilisateur
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Friend
 * @see Group
 */
@WebServlet("/NewFriend")
public class NewFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * Constructeur par défaut
	 */
    public NewFriend() {
        super();
       
    }

    /**
     * Crée un nouvel ami et l'ajoute à l'utilisateur
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#friendExist(String)
     * @see User#addFriend(Friend)
     * @see User#getGroups()
     * @see Group#addFriend(Friend)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//On teste si l'adresse mail fourni n'existe
		//Si c'est le cas on crée un ami avec les informations du formulaire et on l'ajoute à l'utilisateur
		if(!user.friendExist(request.getParameter("mail"))){
				Friend newFriend = new Friend(request.getParameter("firstname"), 
								request.getParameter("lastname").toUpperCase(), 
								request.getParameter("mail"), 
								request.getParameter("phone"), 
								request.getParameter("address"));
				user.addFriend(newFriend);		
				for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
					if(request.getParameter(groupTmp.getKey())!=null)
						groupTmp.getValue().addFriend(newFriend);
				}
				session.setAttribute("user", user);
				this.getServletContext().getRequestDispatcher("/consultListFriend.jsp").forward(request, response);
		}
		else
			this.getServletContext().getRequestDispatcher("/newFriendForm.jsp").forward(request, response);
	}

}
