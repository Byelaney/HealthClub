<!--这个页面用来提交admin修改个人用户信息的表单  -->

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.Club.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%
String path = request.getContextPath();   
String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 


int index=Integer.valueOf(String.valueOf(session.getAttribute("index"))).intValue();
ArrayList<PersonalMember> personal=(ArrayList<PersonalMember>)session.getAttribute("personal");
PersonalMember member=personal.get(index);
session.setAttribute("selectedPersonal",member);

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

      <form class="form-signin" role="form" action="<%=basePath %>EditPersonalByAdmin" method="POST">
        <h2 class="form-signin-heading">Easy to edit</h2>
        
        
        <input type="password" class="form-control" name="password" placeholder="Password" required autofocus>
        
        <input type="text" class="form-control" name="address" placeholder="Address:<%=member.getAddress() %>" required>
        
         
        <input type="text" class="form-control" name="age" placeholder="ages:<%=member.getAge() %>" maxlength=2 onkeypress="return IsNum(event)" required/>
      
        <label class="form-control">
          <input type="radio" name="gender" value="male" /> Male
          <input type="radio" name="gender" value="female" /> Female
        </label>
       
       
        <script language="javascript" type="text/javascript">
         function IsNum(e) {
            var k = window.event ? e.keyCode : e.which;
            if (((k >= 48) && (k <= 57)) || k == 8 || k == 0) {
            } else {
                if (window.event) {
                    window.event.returnValue = false;
                }
                else {
                    e.preventDefault(); 
                 }
             }
         } 
    </script>
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
      </form>

    </div> <!-- /container -->
	
	
	
	
	
</body>
</html>