<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<%@ page import="classe.*" %>
	<%@ page import="java.util.HashMap" %>
	<%@ page import="java.util.Map.Entry" %>
	<jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
  <title>Groupes</title>
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
          <% if(user.getGroupCount()!=0)
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
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
      <h2>Liste de vos groupes</h2>                                                                                   
      <div class="table-responsive">          
      <table class="table">
        <thead>
          <tr>
            <th>Nom</th>
            <th>Nombre d'amis</th>
            <th>Infos</th>
          </tr>
        </thead>
        <tbody>
        	 <% for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
  							Group g = groupTmp.getValue();
  							out.println("<tr>");
 							out.println("<td>"+g.getName()+"</td>");
  							out.println("<td>"+g.getMembers().size()+"</td>");
  							out.println("<td>");
  							out.println("<form role=\"form\" action=\"/projet_xml/InfoGroup\" method=\"post\">");
  							if(g.getMembers().size()!=0)
  								out.println("<button type=\"submit\" class=\"btn btn-default btn-md\" name=\"group\" value=\""+g.getName()+"\"><i class=\"glyphicon glyphicon-info-sign\"></i></button>");
  							else
  								out.println("<button type=\"submit\" class=\"btn btn-default btn-md\" disabled=\"disabled\" name=\"group\" value=\""+g.getName()+"\"><i class=\"glyphicon glyphicon-info-sign\"></i></button>");
  							out.println("</form>");
  							out.println("</td>");
  							out.println("</tr>");
  						
  					}%>
        </tbody>
      </table>
      </div>
    </div>
</body>
</html>