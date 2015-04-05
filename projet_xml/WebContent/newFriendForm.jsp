<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<%@ page import="classe.*"%>
<%@ page import="services.*" %>
<%@ page import="java.util.Map.Entry"%>
<jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
<title>Nouvel Ami</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
	    $('#newFriendForm').submit(function() {
	        $.ajax({
	        	type : $('#newFriendForm').attr('method'),
	            url : '/projet_xml/NewFriendAjax',
	            data : {
	            	mail : $('#mail').val()
	            },
	            success : function(data) {
	            	if(data=="false"){
	            		alert('Vous avez déjà un ami qui possède ce mail !');
	            	}
	            }
	        });
	    });
  });
</script>
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
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><span class="badge-active"><%= user.getFriendCount()%></span> Amis</b></a>
          <ul class="dropdown-menu" >
            <% if(user.getFriendCount()!=0)
            	out.println("<li><a href=\"/projet_xml/consultListFriend.jsp\">Consulter</a></li>");%>
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
        <li><a href="/projet_xml/SignOut"><i class="glyphicon glyphicon-off"></i> Déconnexion</a></li>
      </ul>
    </div>
  </div>
</nav>
	<div class="container">
		<h2>Ajout d'un ami</h2>
		<h3>Rentrer ses informations</h3>
		<form id="newFriendForm" class="form-horizontal" action="/projet_xml/NewFriend" method="post">
			<div class="form-group">
				<label class="col-md-1 control-label">Nom</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="lastname"
						name="lastname" placeholder="François" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Prénom</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="firstname"
						name="firstname" placeholder="Durand" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Email</label>
				<div class="col-md-4">
					<input type="email" class="form-control" id="mail" 
						name="mail"	placeholder="XXX@exemple.com" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Téléphone</label>
				<div class="col-md-4">
					<input type="number" class="form-control" id="phone" 
						name="phone" placeholder="0610203040" maxlength="10" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Adresse</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="address" 
						name="address" placeholder="35 rue des oliviers 33000 BORDEAUX" required>
				</div>
			</div>
	<% if(user.getGroupCount()!=0){%>
			<h3>Choisissez un(des) groupe(s)</h3>
			<div class="form-group">
				<div class="col-md-2">
					<% for(Entry<String,Group> groupTmp : user.getGroups().entrySet()){%>
							<div class="checkbox">
							<label>
							<input type="checkbox" id="<%= groupTmp.getKey()%>" name="<%= groupTmp.getKey()%>" ><%= groupTmp.getKey()%>
							</label>
							</div>
						<% }%>
				</div>
			</div>
	<% }%>
			<button type="submit" class="btn btn-success">Ajouter</button>
		</form>
	</div>
</body>
</html>