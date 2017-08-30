<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
	<div class="row">
		<div class="col-md-12">
			<div class="col-md-12 topHeader">
			    <div class="col-md-3 topLogo">
					<img src="/resources/image/common/logo.jpg" alt="" class="logoPng">			    
			    </div>
			    <div class="col-md-offset-3 col-md-9 topMenu">
					<c:choose>
							<c:when test="${sessionInfo.snsId == null && sessionInfo.id == null}">
 								<button class="loginBtn">
									<i class="fa fa-sign-in" aria-hidden="true"></i>로그인
 								</button>
							</c:when>
							<c:otherwise>
						 
								<img src="${sessionInfo.profilePic }" class="profileImageArea"/>
								<span>${sessionInfo.nickname} 님 안녕하세요</span>
							</c:otherwise>
						</c:choose>
			    </div>
			</div>
			<div class="secondHeader">
			<div class="searchZone">
			   <div class="search">
			      <input type="text" class="searchTerm" placeholder="여행정보를 검색해 주세요">
			      <button type="submit" class="searchButton">
			        <i class="fa fa-search"></i>
			     </button>
			   </div>
			</div>
			</div>
 				<jsp:include page="../template/headerMenu.jsp" flush="true" />
		</div>
	</div>