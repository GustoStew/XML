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
	<jsp:useBean id="currentGroup" scope="session" class="classe.Group"></jsp:useBean>
  <title><%= currentGroup.getName()%></title>
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
        <li><a href="/projet_xml/consultListGroup.jsp"><b><span class="badge-active"><%= user.getGroupCount()%></span> Groupes</b></a></li>
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
      <h2><%= currentGroup.getName()%></h2>  
      <% if(currentGroup.getMembers().size() == user.getFriends().size() && currentGroup.getMembers().size() == 0){%>
      	<div class="alert alert-info">Vous devriez rajouter des contacts. C'est par <a href="/projet_xml/newFriendForm.jsp" class="alert-link">ici</a>.</div> 
      	<% }%>
      <% if(currentGroup.getMembers().size() == 0){%>
      	 <div class="alert alert-info">Vous n'avez pas encore d'ami dans ce groupe.</div> 
      <% }
      	else{%>                                                                         
      <div class="table-responsive">   
      <h3>Liste des membres</h3>       
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
        	 <% for(String idFriend : currentGroup.getMembers()){
  							Friend f = user.getFriends().get(idFriend);%>
  							<tr>
 								<td><%=f.getLastName() %></td>
  								<td><%=f.getFirstName() %></td>
  								<td><%=f.getMail() %></td>
  								<td>
  									<form action="/projet_xml/infoFriend" method="post">
  										<button type="submit" class="btn btn-info btn-md" name="friend" value="<%=f.getMail() %>"><i class="glyphicon glyphicon-info-sign"></i></button>
  									</form>
  								</td>
  								<td>
  									<form action="/projet_xml/DeleteFriendFromGroup" method="post">
  										<button type="submit" class="btn btn-danger btn-md" name="friend" value="<%=f.getMail() %>"><i class="glyphicon glyphicon-trash"></i></button>
  									</form>
  								</td>
  							</tr>
  					<% }%>
        </tbody>
      </table>
      </div>
      <% }%>
      </div>
      </div>
      <div class="container">
      <% if(currentGroup.getMembers().size() != user.getFriends().size()){%>
      <div class="col-md-8">
      <h3>Ajouter un ami</h3>
      <form action="/projet_xml/AddFriendToGroup" method="post">
      	<div class="form-group">
      		<div class="input-group">
      			<select class="form-control" id="friend" name="friend">
      				<% for(Entry<String, Friend> friendTmp : user.getFriends().entrySet()){
      						if(!currentGroup.getMembers().contains(friendTmp.getKey())){%>
      							<option value="<%= friendTmp.getKey()%>"><%= friendTmp.getValue().getLastName()%> <%= friendTmp.getValue().getFirstName()%></option>
      						<% }
      					}%>
      			</select>
      		</div>
      	</div>
      	<button type="submit" class="btn btn-default">Ajouter</button>
      </form>
      <br>
    </div>
    <% }%>
     <a href="/projet_xml/DeleteGroup" id="delete" class="btn btn-danger"> Supprimer le groupe <i class="glyphicon glyphicon-trash"></i></a>
    </div>
</body>
</html>