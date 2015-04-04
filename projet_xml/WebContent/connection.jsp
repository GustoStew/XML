<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <jsp:useBean id="user" scope="session" class="classe.User"></jsp:useBean>
  <title>Inscription</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h1>Carnet d'adresses</h1>
  <h3>Connexion</h3>
  <form class="form-inline" action="/projet_xml/LogIn" method="post">
    <div class="form-group">
      <label for="email">Email :</label>
      <input type="email" class="form-control" id="mail" name="mail" placeholder="XXX@exemple.com" required>
    </div>
    <div class="form-group">
      <label for="pwd">Mot de passe :</label>
      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Mot de passe" required>
    </div>
    <button type="submit" class="btn btn-primary">OK</button>
  </form>
</div>
<br>
<div class="container">
  <h3>Inscription d'un nouvel utilisateur</h3>
  <h4>Rentrer vos informations</h4>
  <form class="form-horizontal" action="/projet_xml/NewUser" method="post">
			<div class="form-group">
				<label class="col-md-1 control-label">Email</label>
				<div class="col-md-4">
					<input type="email" class="form-control" id="mail" 
						name="mail"	placeholder="XXX@exemple.com" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">MDP</label>
				<div class="col-md-4">
					<input type="password" class="form-control" id="pwd" 
						name="pwd"	placeholder="Mot de passe" required>
				</div>
			</div>
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
				<label class="col-md-1 control-label">Téléphone</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="phone" 
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
    <button type="submit" class="btn btn-success" name="button" >Inscription</button>
  </form>
</div>
</body>
</html>