<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<%@ page import="classe.*" %>
	<%@ page import="java.util.HashMap" %>
	<%@ page import="java.util.Map.Entry" %>
	<jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
	<jsp:useBean id="currentGroup" scope="session" class="classe.Group"></jsp:useBean>
  <title><% out.println(currentGroup.getName());%></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/projet_xml/welcome.jsp">Accueil <i class="glyphicon glyphicon-home"></i></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Amis <span class="badge"><% out.println(user.getFriendCount()); %></span></a>
          <ul class="dropdown-menu" role="menu">
            <% if(user.getFriendCount()!=0)
            	out.println("<li><a href=\"/projet_xml/consultListFriend.jsp\">Consulter</a></li>");%>
            <li><a href="/projet_xml/newFriendForm.jsp">Ajouter</a></li>
          </ul>
        </li>
        <li class="active" class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Groupes <span class="badge"><% out.println(user.getGroupCount());%></span></a>
          <ul class="dropdown-menu" role="menu">
          <% if(user.getFriendCount()!=0)
        	  out.println("<li><a href=\"/projet_xml/consultListGroup.jsp\">Consulter</a></li>");%>
            <li><a href="/projet_xml/newGroupForm.jsp">Ajouter</a></li>           
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Recherche">
        </div>
        <button type="submit" class="btn btn-default">Ok</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/projet_xml/LogOut"><i class="glyphicon glyphicon-off"></i> Déconnexion</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
         
      <div class="col-md-8"> 
      <h2><% out.println(currentGroup.getName());%></h2>                                                                               
      <div class="table-responsive">   
      <h3>Liste des membres</h3>       
      <table class="table">
        <thead>
          <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Mail</th>
            <th>Infos</th>
            <th>Supprimer</th>
          </tr>
        </thead>
        <tbody>
        	 <% for(String idFriend : currentGroup.getMembers()){
  							Friend f = user.getFriends().get(idFriend);
  							out.println("<tr>");
 							out.println("<td>"+f.getLastName()+"</td>");
  							out.println("<td>"+f.getFirstName()+"</td>");
  							out.println("<td>"+f.getMail()+"</td>");
  							out.println("<td>");
  							out.println("<form role=\"form\" action=\"/projet_xml/infoFriend\" method=\"post\">");
  							out.println("<button type=\"submit\" class=\"btn btn-info btn-md\" name=\"friend\" value=\""+f.getMail()+"\"><i class=\"glyphicon glyphicon-info-sign\"></i></button>");
  							out.println("</form>");
  							out.println("</td>");
  							out.println("<td>");
  							out.println("<form role=\"form\" action=\"/projet_xml/DeleteFriendFromGroup\" method=\"post\">");
  							out.println("<button type=\"submit\" class=\"btn btn-danger btn-md\" name=\"friend\" value=\""+f.getMail()+"\"><i class=\"glyphicon glyphicon-trash\"></i></button>");
  							out.println("</form>");
  							out.println("</td>");
  							out.println("</tr>");
  					}%>
        </tbody>
      </table>
      </div>
      </div>
      </div>
      <div class="container">
      <div class="col-md-8">
      <h3>Ajouter un ami</h3>
      <form role="form" action="/projet_xml/AddFriendToGroup" method="post">
      	<div class="form-group">
      		<div class="input-group">
      			<select class="form-control" id="friend" name="friend">
      				<% for(Entry<String, Friend> friendTmp : user.getFriends().entrySet()){
      						if(!currentGroup.getMembers().contains(friendTmp.getKey()))
      							out.println("<option value=\""+ friendTmp.getKey() + "\">" + friendTmp.getValue().getLastName() + " " + friendTmp.getValue().getFirstName() + "</option>");
      					}
      				%>
      			</select>
      		</div>
      	</div>
      	<button type="submit" class="btn btn-default">Ajouter</button>
      </form>
      <br>
      <a href="/projet_xml/DeleteGroup" id="delete" class="btn btn-danger"> Supprimer le groupe <i class="glyphicon glyphicon-trash"></i></a>
    </div>
    </div>
    <br>
    <div class="container">
    
    </div>
</body>
</html>