<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.Club.Model.*"  %>   
<%@ page import="java.util.ArrayList;" %>

<%	
String path = request.getContextPath();   
String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 

MonthPO monthPO=(MonthPO)session.getAttribute("MonthPO");
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

<script>
window.onload=myFunction;

function myFunction(){
	var ctx = document.getElementById("myChart").getContext("2d");

	var data = {
	labels : ["Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"],
	datasets : [
		
		{
			fillColor : "rgba(220,220,220,0.5)",
			strokeColor : "rgba(220,220,220,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			data : [<%=monthPO.getJan() %>,
			        <%=monthPO.getFeb() %>,
			        <%=monthPO.getMar() %>,
			        <%=monthPO.getApril() %>,
			        <%=monthPO.getMay() %>,
			        <%=monthPO.getJune() %>,
			        <%=monthPO.getJuly() %>,
			        <%=monthPO.getAug() %>,
			        <%=monthPO.getSep() %>,
			        <%=monthPO.getOct() %>,
			        <%=monthPO.getNov() %>,
			        <%=monthPO.getDec() %>]
		}
	]};

	var options = {
            scaleLineWidth : 1, 
            scaleShowLabels : true, 
            scaleOverlay : true, 
            barStrokeWidth : 2,
            animationSteps : 30
        };


	new Chart(ctx).Line(data,options);
	
}

</script>


    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=basePath %>jsp/manager/manager.jsp">Health Club</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
         	<li class="active"><a>Month Member</a></li>
            <li ><a href="<%=basePath %>jsp/manager/manager.jsp">Home</a></li>
            <li><a href="<%=basePath %>GetCoachPOByManager">Coach use</a>
            <li><a href="<%=basePath %>Logout">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">

      <div class="starter-template">			
		<h1></h1>
	  </div>	
    </div><!-- /.container -->

<div class="container-fluid">
		<div class="row-fluid">
			<h1></h1>
			
		</div>
		<div class="row-fluid">
			
		</div>
		
	</div>

	<canvas id="myChart" width="1200" height="600"></canvas>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath %>js/Chart.js-master/Chart.js"></script>
    <script src="<%=basePath %>dist/js/bootstrap.min.js"></script>
  </body>
</html>




