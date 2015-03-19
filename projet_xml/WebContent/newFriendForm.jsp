<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<%@ page import="classe.*"%>
<%@ page import="java.util.Map.Entry"%>
<jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
<title>Nouvel Ami</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
      <a class="navbar-brand" href="/XML/welcome.jsp">Accueil <i class="glyphicon glyphicon-home"></i></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active" class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Amis <span class="badge"><% out.println(user.getFriendCount()); %></span></a>
          <ul class="dropdown-menu" role="menu">
            <% if(user.getFriendCount()!=0)
            	out.println("<li><a href=\"/XML/consultListFriend.jsp\">Consulter</a></li>");%>
            <li><a href="/XML/newFriendForm.jsp">Ajouter</a></li>
          </ul>
        </li>
        <li class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Groupes <span class="badge"><% out.println(user.getGroupCount());%></span></a>
          <ul class="dropdown-menu" role="menu">
          <% if(user.getFriendCount()!=0)
        	  out.println("<li><a href=\"#\">Consulter</a></li>");%>
            <li><a href="#">Ajouter</a></li>           
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
		<div class="row">
		<div class="col-md-6">
		<h2>Ajout d'un ami</h2>
		<h3>Rentrer ses informations</h3>
		<form role="form" action="/XML/NewFriend" method="post">
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Prénom</span> <input type="text"
						class="form-control" id="firstname" name="firstname"
						placeholder="Françcois">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Nom</span> <input type="text"
						class="form-control" id="lastname" name="lastname"
						placeholder="Durand">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"> Adresse @</span> <input
						type="email" class="form-control" id="mail" name="mail"
						placeholder="XXX@exemple.com">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Téléphone</span> <input type="text"
						class="form-control" id="phone" name="phone"
						placeholder="0610203040">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Adresse</span> <input type="text"
						class="form-control" id="address" name="address"
						placeholder="15 rue des peupliers 33000 BORDEAUX">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Groupe</span>
					<select class="form-control" id="group" name="group">
						<% for(Entry<String, Group> tmp : user.getGroups().entrySet()){
        				out.println("<option value=\""+ tmp.getKey() + "\">" + tmp.getKey()+ "</option>");  
          				}%>
					</select>
				</div>
			</div>
			<button type="submit" class="btn btn-default">Valider</button>
		</form>
		</div>
		
		</div>
	</div>
</body>
</html>