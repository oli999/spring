<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/pw_changeform.jsp</title>
</head>
<body>
<h3>비밀번호 변경</h3>
<p>현재 비밀번호를 입력한후 새로 사용할 비밀번호를 입력하세요.</p>
<form action="pw_update.do" method="post" id="myForm">
	<label for="currentPwd">현재 비밀번호</label>
	<input type="password" name="currentPwd" id="currentPwd" />
	<span id="currentCheck"></span>
	<br/>
	<label for="pwd">새 비밀번호</label>
	<input type="password" name="pwd" id="pwd"/>
	<span id="pwdCheck"></span>
	<br/>
	<label for="pwd2">새 비밀번호 확인</label>
	<input type="password" name="pwd2" id="pwd2"/>
	<br/>
	<button type="submit">확인</button>
	<button type="reset">취소</button>
</form>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>	
<script>
	//현재 비밀번호와 새로운 비밀번호의 유효성 여부 
	var isCurrentPwdValid=false;
	var isNewPwdValid=false;

	//현재 비밀번호 입력란에 포커스를 잃었을때 호출되는 함수 등록
	$("#currentPwd").on("blur", function(){
		//현재까지 입력한 비밀번호 읽어오기
		var inputPwd=$(this).val();
		//ajax 요청을 통해서 현재 비밀번호가 맞는지 확인한다.
		$.ajax({
			url:"pw_check.do",
			method:"post",
			data:{inputPwd:inputPwd},
			success:function(responseData){
				if(responseData.isValid){
					$("#currentCheck").css("color","green")
					.text("현재 비밀번호 입력됨");
					//현재 비밀번호 유효성 여부 true
					isCurrentPwdValid=true;
				}else{
					$("#currentCheck").css("color","red")
					.text("현재 비밀번호가 틀렸습니다.");
					//현재 비밀번호 유효성 여부 false 
					isCurrentPwdValid=false;
				}
			}
		});
	});
	
	$("#pwd, #pwd2").on("input", function(){
		//입력한 두 비밀번호를 읽어와서 
		var pwd=$("#pwd").val();
		var pwd2=$("#pwd2").val();
		if(pwd == pwd2){//두 비밀번호가 같으면
			$("#pwdCheck").text("");
			isNewPwdValid=true;
		}else{//같지 않으면
			$("#pwdCheck").css("color","red")
			.text("비밀번호를 확인 하세요.");
			isNewPwdValid=false;
		}
	});
	//폼 전송 이벤트가 발생했을때 실행할 함수 등록 
	$("#myForm").on("submit", function(){
		//현재 비밀번호가 유효하지 않거나 새 비밀번호를 같게 입력하지 
		//않았으면 
		if(!isCurrentPwdValid || !isNewPwdValid){
			return false; //폼 전송 막기 
		}
	});
</script>
</body>
</html>














