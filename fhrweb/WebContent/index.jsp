<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>人力首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
    <script src="js/move.js" type="text/javascript"></script>
	<link href="css/head.css" type="text/css" rel="stylesheet">
	<link href="css/lead.css" type="text/css" rel="stylesheet">
  </head>
  
  <body>
        <div>
     	   <jsp:include page="header.jsp"></jsp:include>
     	</div>
     	<div>
     	   <jsp:include page="lead.jsp"></jsp:include>
     	</div>
     	<!-- 班级简介 -->
     	<div class="content_top">
   	       <b style="font-size: 20px;">班级简介：</b><br>
   	       <hr size="4" color="grey">
     	</div>
     	<div class="content">
     	    <div class="content_left">
     	       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>人力2班是一个优秀的班集体，人力2班是一个优秀的班集体，人力2班是一个优秀的班集体，人力2班是一个优秀的班集体，人力2班是一个优秀的班集体，
     	                       人力2班是一个优秀的班集体，人力2班是一个优秀的班集体，人力2班是一个优秀的班集体，人力2班是一个优秀的班集体，人力2班是一个优秀的班集体，</b>
     	    </div>
     	    <!-- 图片轮换 -->
     	    <div class="content_right">
     	       <div id="playments">
			    <ul class="bigimgsul" >
			        <a class="btnleft"></a>
			        <a class="btnright"></a>
			        <div class="markleft"></div>
			        <div class="markright"></div>
			        <li style="z-index:1">
			        <img src="images/1.jpg"  /></li>
			        <li><img src="images/2.jpg" /></li>
			        <li><img src="images/3.jpg" /></li>
			        <li><img src="images/4.jpg" /></li>
			        <li><img src="images/5.jpg" /></li>
			        <li><img src="images/6.jpg" /></li>
			        <li><img src="images/7.jpg" /></li>
			        <li><img src="images/8.jpg" /></li>
			        <li><img src="images/2.jpg" /></li>
			        <li><img src="images/3.jpg" /></li>
			        <li><img src="images/4.jpg" /></li>
			        <li><img src="images/5.jpg" /></li>
			        <li><img src="images/6.jpg" /></li>
			        <li><img src="images/7.jpg" /></li>
			        <li><img src="images/8.jpg" /></li>
			    </ul>
			    <div class="smallimgs" >
			        <ul class="smallimgsul" >
			            <li style="filter: 100; opacity: 1; "><img src="images/1.jpg" /></li>
			            <li><img src="images/2.jpg" /></li>
			            <li><img src="images/3.jpg" /></li>
			            <li><img src="images/4.jpg" /></li>
			            <li><img src="images/5.jpg" /></li>
			            <li><img src="images/6.jpg" /></li>
			            <li><img src="images/7.jpg" /></li>
			            <li><img src="images/8.jpg" /></li>
			            <li><img src="images/2.jpg" /></li>
			            <li><img src="images/3.jpg" /></li>
			            <li><img src="images/4.jpg" /></li>
			            <li><img src="images/5.jpg" /></li>
			            <li><img src="images/6.jpg" /></li>
			            <li><img src="images/7.jpg" /></li>
			            <li><img src="images/8.jpg" /></li>
			        </ul>
			    </div>
     	 </div>
     </div>
     </div>
     <!-- 评论 -->
     <div class="content_talk">
	     <div >
	         <div>
	         <form action="">
	             <fieldset style="width: 924px;">
	                 <legend>留言：</legend>
	                from:<input type="text" name="uname"><br>
	                 <span style="color: white">from:</span><textarea rows="5" cols="100"></textarea><br>
	                 <input type="submit" value="提交" style=""/>
	             </fieldset>
	          </form>
	         </div>
	     </div>
     </div>
     <!-- 底部 -->
       <div>
     	   <jsp:include page="bottom.jsp"></jsp:include>
     	</div>
  </body>
</html>
