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
<nav class="navbar navbar-inner">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/projet_xml/welcome.jsp">Accueil <i class="glyphicon glyphicon-home"></i></a>
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
        <li><a href="/projet_xml/LogOut"><i class="glyphicon glyphicon-off"></i> Déconnexion</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	<h2><% out.println(currentFriend.getLastName()+" "+currentFriend.getFirstName());%></h2>
	<a href="/projet_xml/modifyFriendForm.jsp" id="modify" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i></a>
	<a href="/projet_xml/DeleteFriend" id="delete" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
	<h3>Ses informations</h3>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Prénom</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= currentFriend.getFirstName()%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Nom</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= currentFriend.getLastName()%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Email</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= currentFriend.getMail()%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Téléphone</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= currentFriend.getPhone()%></h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<h4><span class="label label-info">Adresse</span></h4>
		</div>
		<div class="col-md-3">
			<h4><%= currentFriend.getAddress()%></h4>
		</div>
	</div>
	<% if(currentFriend.getGroups().size()!=0){%>
			<h3>Ses groupes</h3>
			<% for(String idGroup : currentFriend.getGroups()){%>
				<h4><span class="label label-info"><%=idGroup %></span></h4>
			<% }%>
		<% }%>
</div>
</body>
</html>
