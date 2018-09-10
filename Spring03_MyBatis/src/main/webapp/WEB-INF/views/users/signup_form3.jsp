<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/signup_form.jsp</title>
</head>
<body ng-app="myApp">
<h3>회원 가입 페이지 입니다.</h3>
<form ng-submit="onSubmit($event)" ng-controller="formCtrl" action="signup.do" method="post" 
		name="signupForm" novalidate>
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" 
		ng-model="id" ng-change="onIdInput()"/>
	<span ng-style="{'color':checkIdColor}">{{checkMsg}}</span>
	<br/>
	<label for="pwd">비밀번호</label>
	<input type="text" name="pwd" id="pwd"/><br/>
	<label for="email">이메일</label>
	<input type="text" name="email" id="email"/><br/>
	<button type="submit">가입</button>
</form>
<script src="${pageContext.request.contextPath }/resources/js/angular.min.js"></script>	
<script>
	var app=angular.module("myApp", []);
	app.controller("formCtrl", function($scope, $http){
		//아이디를 입력했을때 호출되는 함수 
		$scope.onIdInput=function(){
			//입력한 내용을 서버에 ajax 요청을 통해서 보낸다. 
			$http({
				url:"checkid.do",
				method:"get",
				params:{inputId:$scope.id}
			}).success(function(data){
				console.log(data);
				if(data.canUse){
					$scope.checkMsg="사용가능";
					$scope.checkIdColor="#00ff00";
					$scope.formValid=true;
				}else{
					$scope.checkMsg="사용불가";
					$scope.checkIdColor="#ff0000";
					$scope.formValid=false;
				}
			});
		};
		
		//폼의 유효성 여부
		$scope.formValid=false;
		
		//폼 전송 이벤트가 발생했을때 호출되는 함수
		$scope.onSubmit=function(e){
			//폼이 유효하지 않으면 
			if(!$scope.formValid){
				//폼 전송 이벤트 막기
				e.preventDefault();
			}
		};
	});
</script>
</body>
</html>












