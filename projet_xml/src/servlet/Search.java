package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.Friend;
import classe.User;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Search() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Friend f = new Friend("machin", "truc", "gg@gmail.com", "0625648964", "nul part");
		ArrayList<Friend> tabFriend = new ArrayList<Friend>();
		tabFriend.add(f);
		session.setAttribute("tabFriend", tabFriend);
		this.getServletContext().getRequestDispatcher("/resultSearch.jsp").forward(request, response);
	}

}
