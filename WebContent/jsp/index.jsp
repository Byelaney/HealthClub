<!--这个页面是用户成功登录之后的主页面 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ page import="com.Club.Model.*"  %>    
<%@ page import="java.util.ArrayList;" %>

<%! String nextProfile=""; %>

<%	
	ArrayList<Activity> activities=(ArrayList<Activity>)session.getAttribute("activity");	
	if(activities!=null){
		session.removeAttribute("activity");
	}
	
	ArrayList<JoinedRecord> joinedRecord=(ArrayList<JoinedRecord>)session.getAttribute("record");
	if(joinedRecord!=null){
		session.removeAttribute("record");
	}
	
	ArrayList<PayRecord> payRecord=(ArrayList<PayRecord>)session.getAttribute("payrecord");
	if(payRecord!=null){
		session.removeAttribute("payrecord");
	}
	
	String path = request.getContextPath();   
	String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 



	String type=(String)session.getAttribute("type");
	
	
    Boolean isLogged=(Boolean)session.getAttribute("logged");
    
    
	if(type.equals("personal")){
	PersonalMember member=(PersonalMember)session.getAttribute("member");
	if(member==null||isLogged==false){
		response.setContentType("text/html; charset=utf-8");
		response.sendRedirect(basePath+"jsp/login.jsp");
	}
	nextProfile="jsp/personal/profile.jsp";
	
	}
	else{
		HouseMember member=(HouseMember)session.getAttribute("member");
		if(member==null||isLogged==false){
			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(basePath+"jsp/login.jsp");
		}	
	nextProfile="jsp/family/profile2.jsp";	
	}
	
	
%>    




<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="when you log in you can see this page">
    <meta name="author" content="guan jun">
    <link rel="shortcut icon" href="<%=basePath %>image/icon.jpg">

    <title>Welcome to Health Club!</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath%>dist/css/carousel.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
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
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a>Home</a></li>
                <li><a href="<%=basePath %>Logout">Logout</a></li>
                <li><a href="<%=basePath %>ShowActivity">Join Activity</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Profile <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="<%=basePath+nextProfile %>">My Profile</a></li>
                    <li><a href="<%=basePath %>JoinedRecord">Participated activities</a></li>
                    
                    <li class="divider"></li>
                    <li class="dropdown-header">Favors</li>
                    <li><a href="<%=basePath %>PayRecord">PayRecord</a></li>
                    <li><a href="#">Favorite activities</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="item active">
          <img src="<%=basePath%>image/1.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Yoga.</h1>
              <p>The yoga origins from India, is popular in the world. The yoga is the East most ancient builds up strength one of techniques. It produces in the B.C.E., is the human wisdom crystallization.</p>
              <p><a class="btn btn-lg btn-primary" href="http://en.wikipedia.org/wiki/Yoga" role="button" target="_blank">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="<%=basePath%>image/2.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Surfing.</h1>
              <p>Surfing is not restricted to saltwater, but can sometimes take place on rivers, using a standing wave. The main use of the word "surfing" is for riding waves using a board on which the surfer stands..</p>
              <p><a class="btn btn-lg btn-primary" href="http://en.wikipedia.org/wiki/Surfing" role="button" target="_blank">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="<%=basePath%>image/3.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Swimming.</h1>
              <p>Swimming is very good at pepole' health ,People who always swims will have a good vital capacity ，will have a sound muscular，and will have a good mood. .</p>
              <p><a class="btn btn-lg btn-primary" href="http://en.wikipedia.org/wiki/Human_swimming" role="button" target="_blank">Learn more</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
    </div><!-- /.carousel -->



    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="<%=basePath%>image/4.jpg" alt="Generic placeholder image">
          <h2>basketball</h2>
          <p>Basketball is a sport played by two teams of five players on a rectangular court.  Basketball is one of the world's most popular and widely viewed sports.</p>
          <p><a class="btn btn-default" href="http://en.wikipedia.org/wiki/Basketball" role="button" target="_blank">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="<%=basePath%>image/5.jpg" alt="Generic placeholder image">
          <h2>football</h2>
          <p>Association football, commonly known as football or soccer, is a sport played between two teams of eleven players with a spherical ball.</p>
          <p><a class="btn btn-default" href="http://en.wikipedia.org/wiki/Football_(soccer)" role="button" target="_blank">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="<%=basePath%>image/6.jpg" alt="Generic placeholder image">
          <h2>tennis</h2>
          <p>Tennis is a sport people usually play individually against a single opponent (singles) or between two teams of two players each (doubles). </p>
          <p><a class="btn btn-default" href="http://en.wikipedia.org/wiki/Tennis" role="button" target="_blank">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->

      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath %>js/jquery.js"></script>
    <script src="<%=basePath%>dist/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>js/holder.js"></script>
  </body>
</html>