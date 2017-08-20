<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
	<div class="row">
		<div class="col-md-12">
			<div class="topHeader">
			    <div class="col-md-3 topLogo">
					<img src="" alt="" class="logoPng">			    
			    </div>
			    <div class="col-md-offset-3 col-md-9 topMenu">
					<c:choose>
							<c:when test="${mainName == null }">
								<a href="/login">로그인</a>
							</c:when>
							<c:otherwise>
								${mainName } 님 안녕하세요
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
			<div class="headermenu"></div>
		</div>
	</div>