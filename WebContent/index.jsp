<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<head>
        <%@include file="header.html" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.html" %>
        
                   <!-- Full Page Image Background Carousel Header -->
    <header id="myCarousel" class="carousel slide" data-ride="caroussel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for Slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <!-- Set the first background image using inline CSS below. -->
                <div class="fill"><img class="img-responsive" src="resources/dist/img/img1.jpg"></div>
                <div class="carousel-caption">
                    <h2>kkkk</h2>
                </div>
            </div>
            <div class="item">
                <!-- Set the second background image using inline CSS below. -->
                <div class="fill"><img class="img-responsive" src="resources/dist/img/img3.jpg"></div>
                <div class="carousel-caption">
                    <h2>kkkk</h2>
                </div>
            </div>
            <div class="item">
                <!-- Set the third background image using inline CSS below. -->
                <div class="fill"><img class="img-responsive" src="resources/dist/img/img1.jpg" ></div>
                <div class="carousel-caption">
                    <h2>kkk</h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>

    </header>

<!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1 text-center">
                    <h4><strong></strong>
                    </h4>
                    <p>DIC 3<br>ECOLE SUPERIEURE POLYTECHNIQUE</p>
                    <ul class="list-unstyled">
                        <li><i class="fa fa-phone fa-fw"></i> (+221) 77 816 04 09 - 77 193 82 80</li>
                        <li><i class="fa fa-envelope-o fa-fw"></i>  <a href="mailto:diopman22@gmail.com">diopman22@gmail.com</a></li>
                        <li><i class="fa fa-envelope-o fa-fw"></i>  <a href="mailto:mohamedsamb@esp.sn">mohamedsamb@esp.sn</a></li>
                    </ul>
                    <br>
                    
                    <hr class="small">
                    <p class="text-muted">Copyright &copy;  2016</p>
                </div>
            </div>
        </div>
    </footer>

        </div>

    </body>
    
    <!--
    Partie reservee au code jquery
    -->
  
    <script type="text/javascript">
        $(document).ready(function(){
            $('.carousel').carousel({
                interval: 4000;
            });
             $('.modal').on('hidden.bs.modal', function (e) {
                   $(".modal-body").html("");
              });
        });
    </script>
    
    
    <!-- jQuery Version 1.11.1 -->
    <script src="resources/dist/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    
    <script type="text/javascript" src="resources/dist/js/bootstrap.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 3000 //changes the speed
    });
    </script>
    </body>
</body>
</html>