<%@page import="facebook4j.examples.signin.AlbumPhotoWrapper"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="facebook4j.examples.signin.PhotoSort"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
   img {
   display: inline-block;
margin: 0 0  20px 20px;
  float: bottom;
    text-align: center;
    width: 120px;
    vertical-align: bottom;

}  

.right {
    float: right;
    width: 250px;
    border: 2px solid #728FCE;
   
 
  
   font-size: 20px;
     margin-top: 0px;
}
ul{
  position:absolute;
   top:0;
   left:5;
   font-size: 20px;
}
ul li a:hover {
    color:#000000;
   border-bottom: 2px dashed #DD0000;
}
body{
     background-color:#839192;
     
}
 #myImg {

 width: 135px;

font-size: 250px; 
}  
h2 {
    text-decoration: underline;
}
#imagewithcaption{

display: inline-block;
text-align: center;
font-size: smaller;
/* margin: 0 0  20px 20px;
  float: bottom;
    text-align: center;
    width: 120px;
    vertical-align: bottom; */
    

}   












#myImg {
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
}

#myImg:hover {opacity: 0.7;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
}

/* Caption of Modal Image */
#caption {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
    text-align: center;
    color: #ccc;
    padding: 10px 0;
    height: 150px;
}

/* Add Animation */
.modal-content, #caption {
    -webkit-animation-name: zoom;
    -webkit-animation-duration: 0.6s;
    animation-name: zoom;
    animation-duration: 0.6s;
}

@-webkit-keyframes zoom {
    from {-webkit-transform:scale(0)}
    to {-webkit-transform:scale(1)}
}

@keyframes zoom {
    from {transform:scale(0)}
    to {transform:scale(1)}
}

/* The Close Button */
.close {
    position: absolute;
    top: 15px;
    right: 35px;
    color: #f1f1f1;
    font-size: 40px;
    font-weight: bold;
    transition: 0.3s;
}

.close:hover,
.close:focus {
    color: #bbb;
    text-decoration: none;
    cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px){
    .modal-content {
        width: 100%;
    }
}





</style>

</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
$(function() {
    var sortValue = "${optionVal}";
   
	$("#sortBy").val(sortValue);
    
});
</script>



<body onload = "">
<p><font size="6"><h2 align="center" >Photo Book</h2></font></p><br><br>
<form name="sortedDates" action="${pageContext.request.contextPath}/sort" method="GET">

<select class="right" name="sortBy" id="sortBy" onchange="javascript:document.sortedDates.submit();">
<option value="SELE">Select</option>
<option value="SELECT">Sort by DESC</option>
<option value="DATE">Sort by ASC</option>
 
<!-- <option value="LOCATION">Location</option> -->
</select><br><br>
<ul>
<li><a href="back">Go to AlbumPage</a></li>
</ul>





<%
ArrayList< AlbumPhotoWrapper> imageArray = (ArrayList< AlbumPhotoWrapper>) request.getAttribute("ImageList"); 
	for ( AlbumPhotoWrapper picPath : imageArray) 
	{
		
%>
 
<div id="imagewithcaption">
 <img  src="<%=picPath.getUrl()%>"  width="100px" height="100px" hspace="60" onclick="window.open(this.src,this.target) ;"/> 
 
  <!--   onclick="window.open(this.src,this.target) ;"/>      onclick="location.href=this.src  --> 

<%-- <img id="myImg" src="<%=picPath.getUrl()%>"  width="100px" height="100px" onclick="changeImage(<%=picPath.getUrl()%>)" /> --%>



   
    <figcaption> <% out.println( picPath.getDate());%></figcaption>
 </div>    
 <%--      <% out.println( picPath.getLocation());%> --%>
  
   
<%
	}
%>
<!-- The Modal -->
<!-- <div id="myModal" class="modal">
  <span class="close">×</span>
  <img class="modal-content" id="img01">
  <div id="caption"></div>
</div> -->



</form>





<!-- <script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById('myImg');
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
img.onclick = function(){
    modal.style.display = "block";
    modalImg.src = this.src;
    modalImg.alt = this.alt;
    captionText.innerHTML = this.alt;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}


function changeImage(path){
	alert("path--"+path);
	var modal = document.getElementById('myModal');

	// Get the image and insert it inside the modal - use its "alt" text as a caption
	var img = document.getElementById('myImg');
	var modalImg = document.getElementById("img01");
	var captionText = document.getElementById("caption");
	
	
	modal.style.display = "block";
    modalImg.src = path;
    modalImg.alt = this.alt;
    captionText.innerHTML = this.alt;
    
	alert("hello its working");
}
</script>
 -->


</body>
</html>