<!--这个页面用来显示个人用户的用户信息-->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.Club.Model.*"  %>   
<%! String idCard;//第一次注册时的卡号
    String account;
    String gender;
    int age=0;
 	String address;
 	String bankCardAccount;
 	String Memberstate;
 	
 	%>
<%	
String path = request.getContextPath();   
String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 

	String type=(String)session.getAttribute("type");
    Boolean isLogged=(Boolean)session.getAttribute("logged");
    
	PersonalMember member=(PersonalMember)session.getAttribute("member");
	if(member==null||isLogged==false){
		response.setContentType("text/html; charset=utf-8");
		response.sendRedirect(basePath+"jsp/login.jsp");
	}
	
	idCard=member.getIdCard();
	account=member.getAccount();
	gender=member.getGender();
	age=member.getAge();
	address=member.getAddress();
	bankCardAccount=member.getBankCardAccount();
	Memberstate=member.getMemberstate();
	
	
	
%>    

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=basePath %>image/icon.jpg">

    <title>Welcome to Health Club</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath %>dist/css/profile.css" rel="stylesheet">

	<link href="<%=basePath %>dist/css/personal.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=basePath %>jsp/index.jsp">Health Club</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a>Profile</a></li>
            <li><a href="<%=basePath %>Logout">Logout</a></li>
            <li><a href="<%=basePath %>jsp/index.jsp">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

      <div class="starter-template">			
	  </div>
    </div><!-- /.container -->

<div class="container-fluid">
		<div class="row-fluid">
			<h1></h1>
			
		</div>
		<div class="row-fluid">
		</div>
		
	</div>
	
	<p id="ceaseButton">
	<a href="<%=basePath %>CeaseUser"><button type="button" class="btn btn-lg btn-danger">Cease Account</button></a>
	</p>
	
		<div id="personalFile">
			<div id="detail">	
				<img alt="portrait" src="<%=basePath %>image/portrait.gif">
				<br>
				<label>Account: <%=account %></label>
				<br><br>
				<label>Password: *******</label>
				<br><br>
				<label>Gender: <%=gender %></label>
				<br><br>
				<label>Age: <%=age %></label>
				<br><br>
				<label>Address: <%=address %></label>
				<br><br>
				<label>State: <%=Memberstate %></label>
			</div>
		</div>
	<p id="submitButton">
		<button type="button" class="btn btn-success"  onclick="document.location=('<%=basePath %>jsp/personal/edit.jsp')">Edit All</button>
	</p>
	
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="<%=basePath %>dist/js/bootstrap.min.js"></script>
    
    
    
  </body>
</html>
