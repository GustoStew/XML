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
    <div class="navbar-header">
      <a class="navbar-brand" href="/projet_xml/welcome.jsp"><b>Accueil <i class="glyphicon glyphicon-home"></i></b></a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="badge-active"><%= user.getFriendCount()%></span> Amis</a>
          <ul class="dropdown-menu" >
            <% if(user.getFriendCount()!=0){%>
            	<li><a href="/projet_xml/consultListFriend.jsp">Consulter</a></li><% }%>
            <li><a href="/projet_xml/newFriendForm.jsp">Ajouter</a></li>
          </ul>
        </li>
        <li><a href="/projet_xml/consultListGroup.jsp"><span class="badge-active"><%= user.getGroupCount()%></span> Groupes</a></li>
      </ul>
      <form class="navbar-form navbar-left" action="/projet_xml/Search" method="post">
        <div class="form-group">
          <input type="text" class="form-control" id="search" name="search" placeholder="Recherche">
        </div>
        <button type="submit" class="btn btn-primary">Ok</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="javascript:window.print()"><i class="glyphicon glyphicon-print"></i> Imprimer</a></li>
        <li><a href="/projet_xml/signOut"><i class="glyphicon glyphicon-off"></i> Déconnexion</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	<h2>Bonjour <%= user.getFirstName()%> !</h2>
	<h3>Vos informations <a href="/projet_xml/ModifyUser" id="modify" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a></h3>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Prénom</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= user.getFirstName()%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Nom</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= user.getLastName()%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Email</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= user.getMail()%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Téléphone</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= user.getPhone()%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Adresse</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= user.getAddress()%></h4>
		</div>
	</div>
	
</div>
</body>
</html>
