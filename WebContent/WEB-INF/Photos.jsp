<%@page import="facebook4j.examples.signin.AlbumPhotoWrapper"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="facebook4j.examples.signin.DisplyNames"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<form name="sortedDates" action="/sort" method="GET">
<body>

 
<select name="sorted" onchange="javascript:document.sortedDates.submit();">
<option value="DATE">Date</option>
<option value="NAME">Name</option>

<%
ArrayList<AlbumPhotoWrapper> picList = (ArrayList<AlbumPhotoWrapper>) request.getAttribute("ImageList2");  
 for ( AlbumPhotoWrapper Storedimg :picList ) 
	{
	%>
	<option value="<%=Storedimg.getDate()%>"><%=Storedimg.getDate()%></option>
	<%
	}
	%>
    
 </select>
 
 
</body>
</form>
</html>