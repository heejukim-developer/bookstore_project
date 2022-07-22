<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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

    <title>회원가입</title>
    <link
      rel="short icon"
      href="./assets/img/favicon.png"
      type="image/x-icon"
    />
    
    <script>
    //////////////////////////////////////
    $(document).ready(function(){
	    //회원가입 버튼을 누르면 
	    $('input[type=submit]').click(function(){
    	
		//아이디 입력 저장 = id값 
		let userId = $('#id').val()
		//비밀번호 입력 저장 
		let userPassWord = $('#password').val()

		//이메일 저장 
		let email =$('#email').val();
		//이름 저장 
		let name =$('#name').val();

		//자기소개 저장
		let intro = $('#intro').val();

    
		//콘솔창에 나타내기 
		console.log(`id:${userId},
					password:${userPassWord},
					email:${email},
					name:${name},
					자기소개:${intro}`)

		//<아이디의 조건>
		// /^[a-zA-Z0-9]$/ 은 a-z소문자 A-Z대문자 아무거나,0-9숫자 아무거나 사용할수 있다는 뜻
		let idPattern = /^[a-zA-Z0-9]{4,12}$/

		//<비밀번호의 조건 >
		let passPattern =/^[a-zA-Z0-9]{4,12}$/

		//<이메일의 조건>
		let emailPattern =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		//<이름의 조건>
		let namePattern = /^[가-힣]{2,4}$/

		//<자기소개의 조건>
		let introPattern = /\s|/gi //공백제거 
		

		//아이디 조건문 
		if(!idPattern.test(userId) || id.length <3){
			alert('아이디는 4~12자리의 영문 대소문자와 숫자로만 입력하세요');
			/* $('#pwd').focus() */
			return false;
		}
		
		//비밀번호 조건문 
		if(!passPattern.test(userPassWord) || password.length <3){
			alert('비밀번호는 4~12자리의 영문 대소문자와 숫자로만 입력하세요');
			return false;
			}

		//이메일 조건문 	 
		 if (!emailPattern.test(email)){
			 alert ('이메일형식이 잘못되었습니다');
			 return false;
			}
		 //이름 조건문
		 if (!namePattern.test(name)){
			 alert ('이름은 5자까지 입력가능합니다');
			 return false;
			 }
		 
		 //자기소개 조건문
		    if (intro == ''){
				alert('자기소개를 한글자 이상 입력해주세요');
				return false;
			}	

		return true
	
	 });
 });
    //////////////////////////////////
    </script>
  </head>
  
  <body>
  
   <!-- Nabar start -->

    <%@ include file = "./common/header.jsp"%>
    <!-- Header end -->

  <!-- breadclumb end -->
  <!-- head end -->

  <!-- detail start -->
  <section>
    <h1>회원가입 페이지</h1>
  </section>
  
<section>
    <form name="login" action="success.htm" method="post">
    
      이름<br>
      <input type="text" name="name" id="name" placeholder="이름을 입력하세요 ">
      <br><br>
      
      
      아이디<br>
      <input type="text" name="id" id="id" placeholder="아이디 입력" >
      <br><br>

      
      비밀번호<br> 
      <input type="password" name="password" id="password">
      <br><br>
      
      이메일<br>
      <input type="email" name="email" id="email" placeholder="email@gmail.com">
      <br><br>
      
      자기소개<br>  
      <input type="text" name="intro" id ="intro" placeholder="1글자 이상 입력하세요">
      <br>
      
      <br>
      <input type="submit" name="" value="회원가입">
      
    </form>
  </section>
  
  <!-- detail end -->

  <!-- Footer Start -->
 <%@ include file = "./common/footer.jsp"%>
  <!-- Footer end -->
</html>
