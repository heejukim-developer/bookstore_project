<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<script>
$(document).ready(function(){
	  var currentPosition = parseInt($(".quickmenu").css("top"));
	  $(window).scroll(function() {
	    var position = $(window).scrollTop(); 
	    $(".quickmenu").stop().animate({"top":position+currentPosition+"px"},1000);
	  });
	});
</script>
</head>
<body>

<!-- 분야별 -->

<div class="col-lg-8">
	<div class="row g-5">
	
	<div class="col-lg-4 border-start custom-border">
	<strong>소설</strong>
	<c:forEach items="${alist}" var="book" varStatus="status">
	<c:if test="${book.book_category==1 && book.book_status==1}">
			<div class="post-entry-1">	
				<a href="/book/novelCategorylist.do?book_category=1">
				<img src="../assets/img/${book.book_img}" alt="" class="img-fluid">
				<span class="date">${book.book_author}</span>
				<h5>${book.book_title}</h5></a>
			</div>
	</c:if> 
	</c:forEach>
	</div><!-- 소설 끝  -->


	<div class="col-lg-4 border-start custom-border">
    <strong>인문/사회</strong>
    <c:forEach items="${alist}" var="book" varStatus="status">
	<c:if test="${book.book_category==2 && book.book_status==1}">
		<div class="post-entry-1">
		<a href="/book/humansocietyCategorylist.do?book_category=2">
		<img src="../assets/img/${book.book_img }" alt="" class="img-fluid">
		<span class="date">${book.book_author}</span>
		<h5>${book.book_title}</h5></a>
	</div>
	</c:if>
	</c:forEach>
	</div><!-- 인문/사회 끝-->

	<!-- 베스트 셀러 -->
	
	<div class="col-lg-3" >
		<p class="title">
			종합 주간 베스트셀러 <span style="color: red"> Top 5 </span></p>

		 <c:forEach items="${alist}" var="book" varStatus="status" begin="0" end="4">
		 <div class="card" >
		<a href="/book/allBooklist.do">
		<img src="../assets/img/${book.book_img}" alt="" class="img-fluid">
		 <strong class="rank">${status.count}</strong>
				<div class="card-body" style="text-align: center">
					<c:if test="${book.book_category==1 && book.book_status==1}">
						<small class="text-muted">[소설]</small>
					</c:if>

					<c:if test="${book.book_category==2 && book.book_status==1}">
						<small class="text-muted">[인문/사회]</small>
					</c:if> 

					<p class="card-title">${book.book_title}</p>
				</div>
			</a>
		</div> <!-- end card -->
		</c:forEach>

<div class="col-lg-1">
	<div class="quickmenu">
  
  <ul>
    <c:choose>
          <c:when test="${isLogOn == true  && member!= null}">
    <li><a href="/mypage/mypageForm.do">마이페이지</a></li>
    <li><a href="#">장바구니 </a></li>
  </c:when>
  <c:otherwise>
	       <li><a href="/member/loginForm.do">마이페이지</a></li>
	       <li><a href="#">장바구니 </a></li>
	       </c:otherwise>
	       </c:choose>
  </ul>
	</div>
	
</div><!-- "col-lg-1" 퀵메뉴 끝 -->  
</div> <!--	베스트셀러 "col-lg-3"의 끝 -->
</div><!--row-g-5의 끝 -->
</div><!--col-lg-8의 끝  -->	

</body>

</html>