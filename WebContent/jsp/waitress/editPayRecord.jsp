<!--这个页面用来提交admin修改payrecord的表单  -->

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.Club.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%
String path = request.getContextPath();   
String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 

PayRecord payRecord=(PayRecord)session.getAttribute("editPayRecord");
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

      <form class="form-signin" role="form" action="<%=basePath %>EditRecordByAdmin" method="POST">
        <h2 class="form-signin-heading">Easy to edit</h2>
        
        
        <input type="text" class="form-control" name="payrecordid" placeholder="PayRecordID:<%=payRecord.getPayRecordId() %>" required autofocus>
        
        <input type="text" class="form-control" name="account" placeholder="Account:<%=payRecord.getAccount() %>" required>
                
        <input type="text" class="form-control" name="payment" placeholder="Payment:<%=payRecord.getPayment() %>" required/>
      
        <input type="date" class="form-control" name="date" required/>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
      </form>

    </div> <!-- /container -->
	
	
	
	
	
</body>
</html>