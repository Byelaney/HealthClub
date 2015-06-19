<!--这个页面用来显示家庭用户参与过的活动给waitress查看  -->

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.Club.Model.*"  %>   
<%@ page import="java.util.ArrayList;" %>

<%	
String path=request.getContextPath();   
String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 

	
    
	ArrayList<JoinedRecord> record=(ArrayList<JoinedRecord>)session.getAttribute("activity");
	
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
          <a class="navbar-brand" href="<%=basePath %>jsp/waitress/waitress.jsp">Health Club</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="<%=basePath %>jsp/waitress/waitress.jsp">Home</a></li>
           	<li><a href="<%=basePath %>jsp/waitress/editFamily.jsp">Edit</a></li>
            <li><a href="<%=basePath %>jsp/waitress/payRecord.jsp">PayRecord</a></li>
            <li><a href="<%=basePath %>Logout">Logout</a></li>
            <li><a href="<%=basePath %>jsp/waitress/waitress.jsp">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    

      <div class="starter-template">			
		<h1></h1>

    </div><!-- /.container -->




<div class="container-fluid">
		<div class="row-fluid">
		</div>
		
		
		<div class="row-fluid">
			<table class="table table-striped table-bordered table-hover datatable">
				<thead>
					<tr>
						<th>Ground</th>
						<th>Coach</th>
						<th>Date</th>
						<th>Time</th>
						<th>RequestTime</th>
					</tr>
				</thead>
				<tbody>
						<% 
							for(int i=0;i<record.size();i++){
						%>
					<tr class="odd gradeX">
						
						<td class="center"><%=record.get(i).getGround() %></td>
						<td class="center"><%=record.get(i).getCoach() %></td>
						<td class="center"><%=record.get(i).getActivityDate() %></td>
						<td class="center"><%=record.get(i).getTime() %></td>	
						<td class="center"><%=record.get(i).getRequestTime() %></td>
						
					</tr>
					
					<% } %>
					
				</tbody>
					
			</table>
			
		</div>
		 
	</div>
	
		

	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="<%=basePath %>dist/js/bootstrap.min.js"></script>
  </body>
</html>