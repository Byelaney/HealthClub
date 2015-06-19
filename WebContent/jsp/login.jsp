<!--这个页面用来提交用户登录的表单-->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%  String path = request.getContextPath();   
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 

%>   


<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="this page let user log in">
    <meta name="author" content="guan jun">
    <link rel="shortcut icon" href="<%=basePath %>image/icon.jpg">

    <title>Welcome back to Health Club</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath %>dist/css/signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form class="form-signin" role="form" action="<%=basePath %>LogIn" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="account" placeholder="Account" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="Password" required>
        <label class="form-control">
          <input type="radio" name="membertype" value="personal" /> Personal
          <input type="radio" name="membertype" value="family" /> Family
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>