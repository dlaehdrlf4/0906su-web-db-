<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="insert" method=""> <!-- 현재 주소는 user/register로 되어있다. -->
		<label for="email">이메일</label>
		<input type = "text" name = "email" id = "email" required="required"/><br />
		<label for = "pw">비밀번호</label>
		<input type = "passward" name = "pw" id = "pw" required="required"/><br />
		<label for= "name">이름</label>
		<input type ="text" name ="name" id = "name" required="required"/><br />
		<label for ="phone">전화번호</label>
		<input type ="tel" name ="phone" id = "phone" /><br />
		<label for = "addr">주소</label>
		<input type ="text" size="100" name ="address" id = "address" required="required"/><br />
	
		<input type = "submit" value="회원가입"/>
		<input type = "button" value="메인으로"
		onclick="location.href='../'"/>
		
	</form>
</body>
</html>