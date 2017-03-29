 <%@page import="java.net.URL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page import="facebook4j.examples.signin.imageofFriends"%>
<%@ page import="facebook4j.examples.signin.GetAlbumServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="facebook4j.examples.signin.AlbumPhotoWrapper"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
 background-color:#aeb6bf;
}
</style>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
$(function() {
    var secondsortValue = "${optionVal}";
   
	$("#sort").val(secondsortValue);
    
});
</script>



<body onload = "">

<form name="sortedTagDates" action="${pageContext.request.contextPath}/date" method="GET">

<select class="right" name="sort" id="sort" onchange="javascript:document.sortedTagDates.submit();">
<option value="default">default</option>
<option value="Sortbydate">sort by date</option>


</select><br><br>

<h1 align="center">TAGGED IMAGES</h1>
<%
HashMap<String,List<AlbumPhotoWrapper>> tagUrl =(HashMap<String,List<AlbumPhotoWrapper>>)session.getAttribute("TagPhotourlMap");
List<AlbumPhotoWrapper> urlImagesWrapperList = null;
if(request.getAttribute("isSorted")!=null && request.getAttribute("isSorted")== "true"){
	urlImagesWrapperList = (List<AlbumPhotoWrapper>) request.getAttribute("sortedList");
} else {
	urlImagesWrapperList = tagUrl.get(session.getAttribute("selectedName"));
}


for(AlbumPhotoWrapper urlImagesWrapper : urlImagesWrapperList){
	     
	%>	
		 <img src="<%=urlImagesWrapper.getUrl()%>" width="100px" height="100px" onclick="window.open(this.src,this.target) ;"/>
		  <% out.println(urlImagesWrapper.getDate());%>
		 
<%
}

%> 
<%-- <%
HashMap<String,List<URL>> tagUrl =(HashMap<String,List<URL>>)session.getAttribute("TagPhotourlMap");

for(URL urlImages:tagUrl.get(request.getAttribute("selectedName"))){
	     
	%>	
		 <img src="<%=urlImages%>" width="100px" height="100px" onclick="window.open(this.src,this.target) ;"/>
		 
		 
<%
}

%> --%>

</form>
</body>

</html>