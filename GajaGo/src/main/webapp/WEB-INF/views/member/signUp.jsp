<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!--  공통 리소스 부분 -->
	<jsp:include page="../template/includeResource.jsp" flush="true" />
	<link rel="stylesheet" href="/resources/css/member/signUp.css">
	<script src="/resources/js/member/signUp.js"></script>
	
	</head>
<!-- 	Heaer부분 -->
	<jsp:include page="../template/header.jsp" flush="true" />

	<div class="row">
		<div class="col-md-offset-1 col-md-10 col-md-offset-1 containerBody">
				<form id="signUp" method="post">
				<div class="col-md-2 explainTitle"  >
					<span class="explain">1.정보입력</span>
				</div>
				<div class="col-md-10  memberJoin">
					<h2>회원가입</h2>
						<ul>
							<li>
								<div class="col-md-12 signUpEle">
									<label for="id"> 아이디</label>
									<input type="text" name="id" id="id" placeholder="아이디를 입력해주세요" class="form-control"/>
									<button type="button" onclick="checkSameID()">아이디 중복 체크</button>
								</div>
							</li>
							<li>
								<div class="col-md-12 signUpEle">
									<label for="passwd"> 비밀번호</label>
									<input type="password" name="password" placeholder="영문/숫자/특수문자조합 6~15자" class="form-control"/>
								</div>
							</li>
							<li>
								<div class="col-md-12 signUpEle">
									<label for=""> 비밀번호 확인</label>
									<input type="password" name="password2" placeholder="영문/숫자/특수문자조합 6~15자" class="form-control"/>
								</div>
							</li>
							<li>
								<div class="col-md-12 signUpEle">
									<label for="name"> 이름 </label>
									<input type="text" name="name" placeholder="이름을 입력해주세요" class="form-control" value="${member.name }"/>
								</div>
							</li>
							
							<li>
								<div class="col-md-12 signUpEle">
									<label for="nickname"> 닉네임 </label>
									<input type="text" name="nickname" placeholder="닉네임을 입력해주세요" class="form-control" value="${member.nickname}"/>
								</div>
							</li>
							
							
							<li>
								<div class="col-md-12 signUpEle">
									<label for="phone"> 휴대폰 번호 </label>
									<input type="text" name="phone" placeholder="휴대폰 번호를 입력해주세요" class="form-control"/>
								</div>
							</li>
							
							
							<li>
								<div class="col-md-12 signUpEle">
									<label for="email"> 이메일</label>
									<input type="text" name="email" placeholder="email을 입력해주세요" class="form-control" value="${member.email }"/>
								</div>
							</li>
						
						
							<li>
								<div class="col-md-12 signUpEle">
									<label for="gender">성별</label>
									    <c:choose>
									    <c:when test="${member.gender eq 1}">
											<input type="radio" name="gender"  value="1" checked="checked"/>남
											<input type="radio" name="gender"  value="2"/>여
										</c:when>
										
										<c:when test="${member.gender eq 2}">
											<input type="radio" name="gender"  value="M" />남
											<input type="radio" name="gender"  value="F" checked="checked"/>여
										</c:when>
										<c:otherwise>
											<input type="radio" name="gender"  value="M" />남
											<input type="radio" name="gender"  value="F" />여
										
										</c:otherwise>
										
										</c:choose>
										
								</div>
							</li>
						
						</ul>
				</div>
				
				
				<div class="col-md-2 explainTitle2"  >
					<span class="explain">2.회원동의</span>
				</div>
				
				
				<div class="col-md-10  memberAgree">
					<ul>
					
							<li>
								<div class="col-md-12 signUpEle">
									<label for="email">약관동의</label>
									   <div class="terms">
									   		<ul>
									   			<li>
									   				<input type="checkbox" name="terms"  value="1"/><span class="important">필수</span>이용약관
												</li>
									   			<li>
									   				<input type="checkbox" name="terms"  value="1"/><span class="important">필수</span>이용약관
												</li>
									   			<li>
									   				<input type="checkbox" name="terms"  value="1"/><span class="important">필수</span>이용약관
												</li>
									   			<li>
									   				<input type="checkbox" name="terms"  value="1"/><span class="important">필수</span>이용약관
												</li>
									   			<li>
									   				<input type="checkbox" name="terms"  value="1"/><span class="important">필수</span>이용약관
												</li>
									   			<li>
									   				<input type="checkbox" name="terms"  value="1"/><span class="important">필수</span>이용약관
												</li>
									   		
									   		</ul>
										</div>
								</div>
							</li>
						
						</ul>
					
				</div>
				
				<input type="hidden" name="snsId" id="snsId" value="${member.snsId}"/>
				<input type="hidden" name="snsType" id="snsType" value="${member.snsType}"/>
				<input type="hidden" name="profilePic" id="profilePic" value="${member.profilePic}"/>
				
				<div class="col-md-offset-2 col-md-10 btnArea">
					<button type="button" class="btnBlue" onclick="signUp()">회원가입</button>
					<button type="reset" class="btnReset">취소</button>
					
				</div>
				</form>
		</div>
	</div>
<!-- 	Footer부분 -->
	<jsp:include page="../template/footer.jsp" flush="true" />