<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<%@ page import="classe.*" %>
	<%@ page import="java.util.HashMap" %>
	<%@ page import="java.util.Map.Entry" %>
	<jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
  <title>Accueil</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inner">
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
        <li class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Groupes <span class="badge"><% out.println(user.getGroupCount());%></span></a>
          <ul class="dropdown-menu" role="menu">
          <% if(user.getGroupCount()!=0)
        	  out.println("<li><a href=\"/projet_xml/consultListGroup.jsp\">Consulter</a></li>");%>
            <li><a href="/projet_xml/newGroupForm.jsp">Ajouter</a></li>           
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
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
	<h2>Bonjour <% out.println(user.getFirstName());%> !</h2>
	<h3>Vos informations</h3>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Prénom</span></h4>
		</div>
		<div class="col-md-3">
			<h4><% out.println(user.getFirstName());%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Nom</span></h4>
		</div>
		<div class="col-md-3">
			<h4><% out.println(user.getLastName());%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Email</span></h4>
		</div>
		<div class="col-md-3">
			<h4><% out.println(user.getMail());%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Téléphone</span></h4>
		</div>
		<div class="col-md-3">
			<h4><% out.println(user.getPhone());%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Adresse</span></h4>
		</div>
		<div class="col-md-3">
			<h4><% out.println(user.getAddress());%></h4>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-1">
			<a href="#" id="modify" class="btn btn-primary"> Modifier <i class="glyphicon glyphicon-pencil"></i></a>
		</div>
	</div>
</div>
</body>
</html>
