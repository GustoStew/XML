<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<%@ page import="classe.*" %>
	<%@ page import="services.*" %>
	<%@ page import="java.util.HashMap" %>
	<%@ page import="java.util.Map.Entry" %>
	<jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
	<jsp:useBean id="userTmp" scope="session" class="classe.User"></jsp:useBean>
  <title>Recherche</title>
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
        <li><a href="/projet_xml/SignOut"><i class="glyphicon glyphicon-off"></i> Déconnexion</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container"> 
      <div class="col-md-8">
      <h2>Résultat de votre recherche</h2>  
      <% if(userTmp.getFriendCount()==0){%>
      	<div class="alert alert-info col-md-3"><b>Pas de résultats</b></div>
      	<% }
      	else {%>                                                                          
      <div class="table-responsive">          
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
        	 <% for(Entry<String, Friend> friendTmp : userTmp.getFriends().entrySet()){ %>
  							<% Friend f = friendTmp.getValue(); %>
  							<tr>
 							<td><%= f.getLastName()%></td>
 							<td><%= f.getFirstName()%></td>
 							<td><%= f.getMail()%></td>
 							<td>
 								<form action="/projet_xml/infoFriend" method="post">
 									<button type="submit" class="btn btn-info btn-md" name="friend" value="<%= f.getMail()%>"><i class="glyphicon glyphicon-info-sign"></i></button>
 								</form>
 							</td>
 							<td>
 								<form action="/projet_xml/DeleteFriend" method="post">
 									<button type="submit" class="btn btn-danger btn-md" name="friend" value="<%= f.getMail()%>"><i class="glyphicon glyphicon-trash"></i></button>
 								</form>
 							</td>
 							<tr>
 					<%} %>
        </tbody>
      </table>
      </div>
      <% }%>
    </div>
    </div>
</body>
</html>