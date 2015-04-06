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
 * Servlet permettant de modifier les informations d'un ami
 * @author Germain LE GUEN et Roxanne COUSIN
 * @see User
 * @see Friend
 * @see Group
 */
@WebServlet("/ModifyFriend")
public class ModifyFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructeur par défaut
	 */
    public ModifyFriend() {
        super();
    }

    /**
     * Modifie les informations d'un ami
     * @param request Paramètre par défaut 
     * @param response Paramètre par défaut
     * @throws ServletException Exception par défaut
     * @throws IOException Exception par défaut
     * @see User#friendExist(String)
     * @see User#deleteFriend(String)
     * @see User#addFriend(Friend)
     * @see User#getGroups()
     * @see Friend#Friend(String, String, String, String, String)
     * @see Group#addFriend(Friend)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On récupère les données nécessaires depuis la session et la request
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Friend currentFriend = (Friend) session.getAttribute("currentFriend");
		String newMail = request.getParameter("mail");
		
		//On teste si le nouveau mail n'existe pas déjà ou si il est identique à celui existant déjà (c.a.d pas de modifications du mail)
		if(!user.friendExist(newMail) || currentFriend.getMail().equals(newMail)){
			//Pour chaque information de l'ami (prénom, nom, ...) :
			//Si elle a été modifiée par le formulaire alors on récupère la nouvelle valeur
			//Sinon on utilise la valeur existante
			String newFirstName, newLastName, newPhone, newAddress;
			newFirstName = request.getParameter("firstname");
			newLastName = request.getParameter("lastname");
			newPhone = request.getParameter("phone");
			newAddress = request.getParameter("address");
			if(newFirstName=="")
				newFirstName = currentFriend.getFirstName();
			if(newLastName=="")
				newLastName = currentFriend.getLastName();
			if(newMail=="")
				newMail = currentFriend.getMail();
			if(newPhone=="")
				newPhone = currentFriend.getPhone();
			if(newAddress=="")
				newAddress = currentFriend.getAddress();
			
			//On supprime l'ami concerné
			user.deleteFriend(currentFriend.getMail());
			
			//On le recrée avec les nouvelles valeurs, on l'ajoute à l'utilisateur, puis on le lie aux groupes sélectionnés dans le formulaire
			Friend newFriend = new Friend(newFirstName, 
				  						  newLastName, 
				  						  newMail, 
				  						  newPhone, 
				  						  newAddress);
			user.addFriend(newFriend);
			for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
				if(request.getParameter(groupTmp.getKey())!=null)
					groupTmp.getValue().addFriend(newFriend);
			}
			
			session.setAttribute("user", user);
			session.setAttribute("currentFriend", newFriend);
			this.getServletContext().getRequestDispatcher("/consultInfoFriend.jsp").forward(request, response);
		}
		else
			this.getServletContext().getRequestDispatcher("/modifyFriendForm.jsp").forward(request, response);
	}
}
