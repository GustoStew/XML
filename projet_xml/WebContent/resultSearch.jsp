<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="classe.*"%>
<jsp:useBean id="tabFriend" scope="session" class="java.util.ArrayList<Friend>"></jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for(Friend f : tabFriend){
		out.println("<p>" + f.getMail() + "</p>");
	}
	%>
</body>
</html>