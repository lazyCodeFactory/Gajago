<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<body>
	<div class="row">
		<div class="col-md-12">
			<div class="topHeader">
				<dl>
					<dd>
						<a href="#">메뉴3</a>
					</dd>
					<dd>
						<a href="#">메뉴2</a>
					</dd>
					<dd>
					
						<c:choose>
						  <c:when test="${mainName == null }">
							<a href="/login">로그인</a>
							</c:when>
							<c:otherwise>
								${mainName } 님 안녕하세요
							</c:otherwise>
						</c:choose>
					</dd>
				</dl>
			</div>
			<div class="secondHeader">
				<img src="/resources/sdfsdf.png" class='titleMain' />
			</div>
			<div class="headermenu"></div>
		</div>
	</div>