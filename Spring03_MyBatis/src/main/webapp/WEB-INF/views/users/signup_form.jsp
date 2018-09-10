<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/signup_form.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body ng-app="myApp">
<div class="container">
	<h3>회원 가입 페이지 입니다.</h3>
	<form ng-submit="onSubmit($event)" ng-controller="formCtrl" action="signup.do" method="post" 
			name="f" novalidate>
		<div class="form-group has-feedback"
			ng-class="{'has-success':f.id.$valid && canUseId ,'has-error': (f.id.$invalid || !canUseId)&& f.id.$dirty }">
			<label class="control-label">아이디</label>
			<input type="text" class="form-control" name="id" 
			ng-model="id" ng-required="true"
			ng-change="onIdInput()"
			ng-minlength="4"
			ng-pattern="/^[a-zA-Z0-9]+$/"/>
			<span class="form-control-feedback glyphicon glyphicon-ok" ng-show="f.id.$valid && canUseId"></span>
			<span class="form-control-feedback glyphicon glyphicon-remove" ng-show="(f.id.$invalid || !canUseId) && f.id.$dirty"></span>
			<p class="help-block" ng-show="f.id.$error.required && f.id.$dirty">반드시 입력하세요</p>
			<p class="help-block" ng-show="!canUseId && f.id.$dirty">사용할수 없는 아이디 입니다.</p>
			<p class="help-block" ng-show="f.id.$error.minlength && f.id.$dirty">4글자 이상 입력하세요</p>
			<p class="help-block" ng-show="f.id.$error.pattern && f.id.$dirty">특수 문자는 허용하지 않습니다.</p>
		</div>
		<div class="form-group has-feedback"
			ng-class="{'has-success':f.pwd.$valid,'has-error': (f.pwd.$invalid || !isPwdEqual) && f.pwd.$dirty }">
			<label class="control-label">비밀번호</label>
			<input type="password" class="form-control" name="pwd" 
			ng-model="pwd" ng-required="true"
			ng-change="onPwdInput()"
			ng-minlength="4"
			ng-pattern="/^[a-zA-Z0-9]+$/"/>
			<span class="form-control-feedback glyphicon glyphicon-ok" ng-show="f.pwd.$valid && isPwdEqual"></span>
			<span class="form-control-feedback glyphicon glyphicon-remove" ng-show="(f.pwd.$invalid || !isPwdEqual) && f.pwd.$dirty"></span>
			<p class="help-block" ng-show="f.pwd.$error.required && f.pwd.$dirty">반드시 입력하세요</p>
			<p class="help-block" ng-show="f.pwd.$error.minlength && f.pwd.$dirty">4글자 이상 입력하세요</p>
			<p class="help-block" ng-show="f.pwd.$error.pattern && f.pwd.$dirty">특수 문자는 허용하지 않습니다.</p>
			<p class="help-block" ng-show="!isPwdEqual && f.pwd.$dirty">비밀번호 확인란과 같아야 합니다</p>
		</div>
		<div class="form-group has-feedback" 
			ng-class="{'has-success':isPwdEqual,'has-error': !isPwdEqual && f.pwd.$dirty }">
			<label class="control-label">비밀번호 확인</label>
			<input type="password" class="form-control" ng-model="pwd2" ng-change="onPwdInput()"/>
		</div>
		<div class="form-group has-feedback"
			ng-class="{'has-success':f.email.$valid,'has-error': f.email.$invalid && f.email.$dirty }">
			<label class="control-label">이메일</label>
			<input type="text" class="form-control" name="email" 
			ng-model="email" 
			ng-required="true"
			ng-pattern="/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/"/>
			<span class="form-control-feedback glyphicon glyphicon-ok" ng-show="f.email.$valid"></span>
			<span class="form-control-feedback glyphicon glyphicon-remove" ng-show="f.email.$invalid && f.email.$dirty"></span>
			<p class="help-block" ng-show="f.email.$error.required && f.email.$dirty">반드시 입력하세요</p>
			<p class="help-block" ng-show="f.email.$error.pattern && f.email.$dirty">이메일 형식을 확인하세요</p>
		</div>				
		<button ng-disabled="f.$invalid || !canUseId || !isPwdEqual" class="btn btn-success" type="submit">가입</button>
		<button class="btn btn-warning" type="reset">취소</button>		
	</form>
</div>
<script src="${pageContext.request.contextPath }/resources/js/angular.min.js"></script>	
<script>
	var app=angular.module("myApp", []);
	app.controller("formCtrl", function($scope, $http){
		$scope.canUseId=false;
		//아이디를 입력했을때 호출되는 함수 
		$scope.onIdInput=function(){
			//입력한 내용을 서버에 ajax 요청을 통해서 보낸다. 
			$http({
				url:"checkid.do",
				method:"post",
				data:"inputId="+$scope.id,
				headers:{"Content-Type":"application/x-www-form-urlencoded;charset=utf-8"}
			}).success(function(data){
				$scope.canUseId=data.canUse;
			});
			
		};
		//두개의 비밀번호를 같게 입력했는지 여부 
		$scope.isPwdEqual=false;
		//비밀번호를 입력했을때 호출되는 함수 
		$scope.onPwdInput=function(){
			if($scope.pwd==$scope.pwd2){
				$scope.isPwdEqual=true;
			}else{
				$scope.isPwdEqual=false;
			}
		};
		
		//폼 전송 이벤트가 발생했을때 호출되는 함수
		$scope.onSubmit=function(e){
			//폼이 유효하지 않으면 
			if($scope.f.$invalid || !$scope.canUseId || !$scope.isPwdEqual){
				//폼 전송 이벤트 막기
				e.preventDefault();
			}
		};
	});
</script>
</body>
</html>












