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
  <title>Groupes</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function() {
	    $('#newGroupForm').submit(function() {
	        $.ajax({
	        	type : $('#newGroupForm').attr('method'),
	            url : '/projet_xml/NewGroupAjax',
	            data : {
	            nameGroup : $('#nameGroup').val()
	            },
	            success : function(data) {
	            	if(data=="false"){
	            		alert('Vous possédez déjà un groupe nommé ainsi !');
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
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="badge-active"><%= user.getFriendCount()%></span> Amis</a>
          <ul class="dropdown-menu" >
            <% if(!ServiceUser.hasNoFriends(user))
            	out.println("<li><a href=\"/projet_xml/consultListFriend.jsp\">Consulter</a></li>");%>
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
        <li><a href="/projet_xml/signOut"><i class="glyphicon glyphicon-off"></i> Déconnexion</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	<div class="col-md-6">
      <h2>Vos groupes</h2>
      <% if(ServiceUser.hasNoGroups(user)){%>
      	<div class="alert alert-info">Vous n'avez pas encore de groupe.</div>
      	<% }
      	else {%>
      	 	                                                                          
      <div class="table-responsive">          
      <table class="table">
        <thead>
          <tr>
            <th>Nom</th>
            <th>Nombre d'amis</th>
            <th>Infos</th>
            <th>Supprimer</th>
          </tr>
        </thead>
        <tbody>
        	 <% for(Entry<String, Group> groupTmp : user.getGroups().entrySet()){
  							Group g = groupTmp.getValue();%>
 							<tr>
 								<td><%= g.getName()%></td>
 								<td><%= g.getMembers().size()%></td>
  								<td>
  									<form action="/projet_xml/InfoGroup" method="post">
										<button type="submit" class="btn btn-info btn-md" name="group" value="<%= g.getName()%>"><i class="glyphicon glyphicon-info-sign"></i></button>
  									</form>
								</td>
  								<td>
  									<form action="/projet_xml/DeleteGroup" method="post">
  										<button type="submit" class="btn btn-danger btn-md" name="group" value="<%= g.getName()%>"><i class="glyphicon glyphicon-trash"></i></button>
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
		<div class="col-md-6">
			<h3>Ajouter un groupe</h3>
			<form class="form-horizontal" action="/projet_xml/NewGroup" method="post" id="newGroupForm">
				<div class="form-group">
					<label class="col-md-1 control-label">Nom</label>
					<div class="col-md-4">
						<input type="text" class="form-control" id="nameGroup"
							name="name" placeholder="Amis" required>
						<div class="alert alert-danger" id="alert" hidden>Existe déjà !</div>
				</div>
			</div>
			<button type="submit" class="btn btn-success">Ajouter</button>
		</form>
		</div>
	</div>
</body>
</html>