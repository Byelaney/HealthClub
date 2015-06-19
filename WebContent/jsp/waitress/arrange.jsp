<!--这个页面用来提交服务员安排活动的表单  -->

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.Club.Model.*" %>

<%
String path = request.getContextPath();   
String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome - Health Club</title>
<script src="<%=basePath %>dist/js/bootstrap.js" type=text/javascript></script>
<link rel="stylesheet" href="<%=basePath %>dist/css/bootstrap.css">
 <link rel="shortcut icon" href="<%=basePath %>image/icon.jpg">
 <!-- Custom styles for this template -->
    <link href="<%=basePath %>dist/css/signin.css" rel="stylesheet">


</head>
<body>
	
	
	 <div class="container">

      <form class="form-signin" role="form" action="<%=basePath %>Arrangement" method="POST">
        <h2 class="form-signin-heading"></h2>
        
        
        <input type="text" class="form-control" name="ground" placeholder="Ground" required autofocus/>
        
        <input type="text" class="form-control" name="coach" placeholder="Coach" required/>
        
         
        <input type="text" class="form-control" name="time" placeholder="Time" required/>
      	<input type="date" class="form-control" name="date" placeholder="Date" required>
  
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Arrange</button>
      </form>

    </div> <!-- /container -->
	
	
	
	
	
</body>
</html>