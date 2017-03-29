<%@page import="java.util.HashMap"%>
<%@ page import="facebook4j.examples.signin.GetAlbumServlet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
     background-color:#839192;
     /* background-image: url("http://www.entheosweb.com/images/backgrounds/blue/lines.jpg");
     background-position: center; */
}
ul li a{
background:#000000; 
text-align:center;
color:white;
display:block;
/* padding:5px 15px 5px 15px; */
 width:150px;
            border-style: none;
            padding-left: 5px;
            padding-right: 5px;
            height: auto;
 
}
h1 {
    color: 	#8B4789;	
    text-align: left;
    text-decoration: underline;
}
h2 {
    color: 	#8B4789;
    text-align: right;
    text-decoration: underline;
}
ul li a:hover {
    color: #CDCD00 ;
}
ul{
   list-style-type:none;
   margin:10px;
   padding:10px;
   text-align: left;
}
a.one{
   margin:20px;
   position: absolute; 
   top: 0; 
   right: 0; 
   width: 100px; 
   text-align:right;
   color: 	#8B4789;
  font-size: 100%;
  color: 	#8B4789;
   }
a.one:hover{
color:#8B4789; 
}
</style>

</head>
<body >
<h1>ALBUMS</h1>

<%
ArrayList<String> itemsArray = (ArrayList<String>) request.getAttribute("AlbumList");
HashMap< String, String> albumNameIdMap = (HashMap< String, String>) session.getAttribute("albumIdMap"); 

for (String albumName : albumNameIdMap.keySet()) 
{
	/* String value = albumPath; */
%>
<ul>

<li><a href="disnam?param=<%=albumNameIdMap.get(albumName)%>"> <%=albumName%></a></li><br></br>
</ul>
	
<%
}
%>	
	
<a class="one" href="disnam?param=ALLPHOTOS"> CLICK TO VIEW ALL PHOTOS</a><br>

</body>
</html>