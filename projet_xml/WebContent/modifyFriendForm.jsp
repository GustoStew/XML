<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<%@ page import="classe.*"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map.Entry"%>
<jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
<jsp:useBean id="currentFriend" scope="session" class="classe.Friend"></jsp:useBean>
<title>
	Modification <% out.println(currentFriend.getLastName()+" "+currentFriend.getFirstName());%>
</title>
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
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/projet_xml/welcome.jsp">Accueil <i
					class="glyphicon glyphicon-home"></i></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active" class="btn-group"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-expanded="false">Amis <span class="badge">
								<% out.println(user.getFriendCount()); %>
						</span></a>
						<ul class="dropdown-menu" role="menu">
							<% if(user.getFriendCount()!=0)
            	out.println("<li><a href=\"/projet_xml/consultListFriend.jsp\">Consulter</a></li>");%>
							<li><a href="/projet_xml/newFriendForm.jsp">Ajouter</a></li>
						</ul></li>
					<li class="btn-group"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Groupes
							<span class="badge">
								<% out.println(user.getGroupCount());%>
						</span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<% if(user.getFriendCount()!=0)
        	  out.println("<li><a href=\"/projet_xml/consultListGroup.jsp\">Consulter</a></li>");%>
							<li><a href="/projet_xml/newGroupForm.jsp">Ajouter</a></li>
						</ul></li>
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
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="container">
		<h3>Modifier ses informations</h3>
		<form class="form-horizontal" action="/projet_xml/ModifyFriend" method="post">
			<div class="form-group">
				<label class="col-md-1 control-label">Nom</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="lastname"
						name="lastname" placeholder="<% out.println(currentFriend.getLastName());%>" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Prénom</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="firstname"
						name="firstname" placeholder="<% out.println(currentFriend.getFirstName());%>" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Email</label>
				<div class="col-md-4">
					<input type="email" class="form-control" id="mail" name="mail"
						placeholder="<% out.println(currentFriend.getMail());%>" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Téléphone</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="phone" name="phone"
						placeholder="<% out.println(currentFriend.getPhone());%>" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Adresse</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="address" name="address"
						placeholder="<% out.println(currentFriend.getAddress());%>" required>
				</div>
			</div>
			<h3>Modifier ses groupes</h3>
			<div class="form-group">
				<div class="col-md-2">
					<% for(Entry<String,Group> groupTmp : user.getGroups().entrySet()){
							out.println("<div class=\"checkbox\">");
							out.println("<label>");
							if(currentFriend.getGroups().contains(groupTmp.getKey()))
								out.println("<input type=\"checkbox\" id=\"" + groupTmp.getKey() + "\" name=\"" + groupTmp.getKey() + "\" checked> " + groupTmp.getKey() + "");
							else
								out.println("<input type=\"checkbox\" id=\"" + groupTmp.getKey() + "\" name=\"" + groupTmp.getKey() + "\"> " + groupTmp.getKey() + "");
							out.println("</label>");
							out.println("</div>");
						}
					%>
				</div>
			</div>
			<button type="submit" class="btn btn-success">Valider les modifications</button>
		</form>
	</div>
</body>
</html>
