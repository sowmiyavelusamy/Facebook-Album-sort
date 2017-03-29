<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page import="facebook4j.examples.signin.taggedFriends"%>
<%@ page import="facebook4j.examples.signin.GetAlbumServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
  background-color:#d7cfd1;
}
a.movecenter{
 text-align: center;
 color:#8e44ad;
}
h1 {
    color: 	#ff3377;	
    text-decoration: underline;
    
}
a.movecenter:hover{
color:#28b463; 
}
</style>
</head>
<body>

<h1 align="center">TAGNAME LIST</h1>
<%
String selectedTagName = null;
Set<String>  tagItems =  (HashSet<String>)session.getAttribute("tagnameList");

for(String tagFrnds : tagItems){
	
	
	%>	
	<div style="text-align: center;">
	<a class="movecenter" href ="tagpic?tagName=<%=tagFrnds%>" ><%=tagFrnds%></a><br>
	</div>
<%
}

%>

	
	


</body>

</html>