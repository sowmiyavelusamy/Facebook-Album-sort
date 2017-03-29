<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page import="facebook4j.examples.signin.imageofFriends"%>
<%@ page import="facebook4j.examples.signin.GetAlbumServlet"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>TAGGED IMAGES</h1>
<%


HashMap<String,List<String>> tagUrl =(HashMap<String,List<String>>)session.getAttribute("TagPhotourlMap");

for(String urlImages:tagUrl.keySet()){
	     
	%>	
		 <img src="<%=tagUrl.get(urlImages)%>"/>
		 
		 
<%
}

%>


</body>

</html>