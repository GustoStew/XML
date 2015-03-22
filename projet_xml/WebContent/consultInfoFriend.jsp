<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<%@ page import="classe.*" %>
	<%@ page import="java.util.HashMap" %>
	<%@ page import="java.util.Map.Entry" %>
	<jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
	<jsp:useBean id="currentFriend" scope="session" class="classe.Friend"></jsp:useBean>
  <title><% out.println(currentFriend.getLastName()+" "+currentFriend.getFirstName());%></title>
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
        <li class="active" class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Amis <span class="badge"><% out.println(user.getFriendCount()); %></span></a>
          <ul class="dropdown-menu" role="menu">
            <% if(user.getFriendCount()!=0)
            	out.println("<li><a href=\"/projet_xml/consultListFriend.jsp\">Consulter</a></li>");%>
            <li><a href="/projet_xml/newFriendForm.jsp">Ajouter</a></li>
          </ul>
        </li>
        <li class="btn-group">
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
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
	<h2><% out.println(currentFriend.getLastName()+" "+currentFriend.getFirstName());%></h2>
	<h3>Ses informations</h3>
	<h4><span class="label label-default">Prénom</span> <% out.println(currentFriend.getFirstName());%></h4>
	<h4><span class="label label-default">Nom</span> <% out.println(currentFriend.getLastName());%></h4>
	<h4><span class="label label-default">Mail</span> <% out.println(currentFriend.getMail());%></h4>
	<h4><span class="label label-default">Téléphone</span> <% out.println(currentFriend.getPhone());%></h4>
	<h4><span class="label label-default">Adresse</span> <% out.println(currentFriend.getAddress());%></h4>
	<% if(currentFriend.getGroups().size()!=0){
			out.println("<h3>Ses groupes</h3>");
			for(String idGroup : currentFriend.getGroups()){
				out.println("<h4><span class=\"label label-info\">" + idGroup + "</span></h4>");
			}
		}
	%>
<br>
<a href="/projet_xml/modifyFriend.jsp" id="modify" class="btn btn-primary"> Modifier <i class="glyphicon glyphicon-pencil"></i></a>
<a href="/projet_xml/DeleteFriend" id="delete" class="btn btn-danger"> Supprimer <i class="glyphicon glyphicon-trash"></i></a>
</div>
</body>
</html>
