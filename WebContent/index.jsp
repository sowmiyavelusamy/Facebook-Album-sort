<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Sign in with Facebook example</title>
<style type="text/css">
body{
 background-color:#5DADE2;
}
.footer {
  position: absolute;
  right: 0;
  bottom: 0;
  left: 0;
  text-align: center;
  padding: 1rem;
  background-color: #C0C0C0;
  text-align: center;
  font-size: 150%;
}

img {
    display: block;
    margin: 0 auto;
}
img.top {
    display: block;
    margin: 0 auto;
    
}
.topcorner{
   position:absolute;
   top:0;
   right:0;
    margin:20px;
   font-size: 20px;
  }
 .logout:hover {
    color:#f44336;
     
} 
.Midbutton{
  text-align: center;
  right:50%;
  position:absolute;
}
.hidden{
 display: none;
}
</style>
</head>
<body>

 <%
       request.getAttribute("GetAlbumServlet");
 %>
<tag:notloggedin>
<p><img src="http://badcredit-v2.digitalbrandsinc.netdna-cdn.com/wp-content/uploads/630x335FacebookFriends.jpg" alt="" width="900" height="250" align="middle"/></p>
<p>&nbsp;</p>
  <blockquote>
        <blockquote><blockquote><blockquote><blockquote>
        <blockquote>
       <!--  <p>Login in to FaceBook:</p> -->
  <a href="signin"><img class="top" src="./assets/login-with-facebook.png" alt="Sign in with Facebook"></a>

         <p>&nbsp;</p>
                      <p>&nbsp;</p>
                      <p>&nbsp;</p>
                      <p>&nbsp;</p>
                      
                      <p>&nbsp;</p>
                      <p>&nbsp;</p>
                      <p>&nbsp;</p>
           
        
                </blockquote></blockquote>
                </blockquote>
                </blockquote></blockquote></blockquote>
  
</tag:notloggedin>
<tag:loggedin>
  <%-- <h1>Welcome ${facebook.name} (${facebook.id})</h1> --%>
  <h1 align="center" style="color:6600CC;">Welcome ${facebook.name}</h1>
 <a href="tokenInfo" class="hidden" target="_blank">Get Album</a><br><br>
	
  <form action="./getAlbum" method="get">
  
  <p><img src="http://slidervilla.com/pointelle/files/2015/02/facebook-albums.png" height="300" width="300"/></p>
                   <%-- <p><img src="${pageContext.request.contextPath}/assets/facebook-albums.png"/></p> --%>
                      <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <blockquote>
                              <blockquote>
                                <blockquote>
                                  <blockquote>
                                    <blockquote>
 
   <!--  <textarea cols="0" rows="1" name="message"></textarea>  -->

   <input type="submit" class="Midbutton" name="getAlbum" value="Get Albums" />
  </blockquote>
                                  </blockquote>
                                </blockquote>
                              </blockquote>
                            </blockquote>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
 
  </form>
<div class="topcorner">
 <a href="./logout" class="logout">Logout</a></div>

</tag:loggedin>
<li>
  <footer class="footer" id="footer">Project by Sowmiya Velusamy</footer>
</li>

</body>
</html>