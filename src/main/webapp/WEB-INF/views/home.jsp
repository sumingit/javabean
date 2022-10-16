<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>  

<html>
<head>
	<meta charset="UTF-8">
	<title>Welecome to JAVABIN!</title>
<script type="text/javascript" src="${path}/resources/js/home.js"></script>

<style>
  #wrapper {
      width: 1100px;
      margin: 0 auto;
        }
</style>
</head>
<body>
	<div class="container">
	<%@include file="header.jsp"%>

		<div id="wrapper">
			<div class="bxslider">
		        <div><img src="${path}/resources/images/home1.jpg" ></div>
		        <div><img src="${path}/resources/images/home2.jpg" ></div>
		        <div><img src="${path}/resources/images/home3.jpg" ></div>
		    </div>
		</div>
	    
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
