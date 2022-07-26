<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>

    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <script
      defer
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
      
    ></script>

    <link href="./assets/css/style.css" rel="stylesheet" />

    <title>마이페이지</title>
    <link
      rel="short icon"
      href="./assets/img/favicon.png"
      type="image/x-icon"
    />
  </head>
  <body>
  
   <!-- Nabar start -->

    <%@ include file = "./common/header.jsp"%>
    <!-- Header end -->

  <!-- breadclumb end -->
  <!-- head end -->

  <!-- detail start -->
  
<!-- 공백일 경우 경고창띄우기 -->
    <c:choose>
	<c:when test="${empty param.member_id || empty param.member_pass}">
	  <script>
	    window.onload=function(){
	      alert("아이디나 비밀번호를 입력하세요 ");}
	
	    
	  </script>
	</c:when>
</c:choose>  

<!-- param값  -->
 	${param.member_id} 님 반갑습니다 ! 
 
    <h3>테스트 아이디 : ${param.member_id }</h3>
	<h3>테스트 비밀번호 : ${param.member_pass}</h3>
	
<!-- dto에 있는 아이디 비번 비교 수정중!  -->

<c:if test ="${not empty param.member_id}">
<jsp:useBean id="dto" class="ezenproject.dto.MemberDTO"/>
<jsp:setProperty property="*" name="dto"/>
<pre>
dto체크 아이디 :${dto.member_id}
</pre>
</c:if>
	

  <!-- detail end -->

  <!-- Footer Start -->
 <%@ include file = "./common/footer.jsp"%>
  <!-- Footer end -->
</html>
