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
        <li class="active" class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="badge-active"><% out.println(user.getFriendCount()); %></span> Amis </a>
          <ul class="dropdown-menu" role="menu">
            <% if(user.getFriendCount()!=0)
            	out.println("<li><a href=\"/projet_xml/consultListFriend.jsp\">Consulter</a></li>");%>
            <li><a href="/projet_xml/newFriendForm.jsp">Ajouter</a></li>
          </ul>
        </li>
        <li class="btn-group">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="badge-active"><% out.println(user.getGroupCount());%></span> Groupes </a>
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
		<div class="row">
		<div class="col-md-6">
		<h2>Ajout d'un ami</h2>
		<h3>Rentrer ses informations</h3>
		<form role="form" action="/projet_xml/NewFriend" method="post">
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Prénom</span> <input type="text"
						class="form-control" id="firstname" name="firstname"
						placeholder="François" required>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Nom</span> <input type="text"
						class="form-control" id="lastname" name="lastname"
						placeholder="Durand" required>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"> Adresse @</span> <input
						type="email" class="form-control" id="mail" name="mail"
						placeholder="XXX@exemple.com" required>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Téléphone</span> <input type="text"
						class="form-control" id="phone" name="phone"
						placeholder="0610203040" required>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Adresse</span> <input type="text"
						class="form-control" id="address" name="address"
						placeholder="15 rue des peupliers 33000 BORDEAUX" required>
				</div>
			</div>
			<h3>Choisissez un(des) groupe(s)</h3>
			<div class="form-group">
				 <% for(Entry<String,Group> groupTmp : user.getGroups().entrySet()){
					out.println("<div class=\"checkbox\">");
					out.println("<label>");
					out.println("<input type=\"checkbox\" id=\"" + groupTmp.getKey() + "\" name=\"" + groupTmp.getKey() + "\" > " + groupTmp.getKey() + "");
					out.println("</label>");
					out.println("</div>");
				}
				%>
			</div>
			<button type="submit" class="btn btn-default">Ajouter</button>
		</form>
		</div>
		
		</div>
	</div>
</body>
</html>