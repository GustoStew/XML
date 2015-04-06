package util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import classe.User;

public class SessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent event) {
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null){
			ServletContext context = session.getServletContext();
			System.out.println(user.getMail());
			SerializerUser serialUser = new SerializerUser(context.getInitParameter("databasePath") + user.getMail() + ".xml");
			serialUser.save(user);
		}
	}

}
