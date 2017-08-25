<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="/resources/css/innerTravel/innerTravel.css">
<jsp:include page="../template/includeResource.jsp" flush="true" />
<script src="/resources/js/innerTravel/innerTravelDetail.js"></script>
</head>
<jsp:include page="../template/header.jsp" flush="true" />
<input type="hidden" id="mapx" value="${travelMap.mapx}"/>
<input type="hidden" id="mapy" value="${travelMap.mapy}"/>
<input type="hidden" id="title" value="${travelMap.title}"/>

<input type="hidden" id="subdetailimgLength" value="${fn:length(travelMap.subdetailimgList)}"/>
<!-- 페이징 할떄 필요한 놈들 -->
<input type="text"   id=writeBtnInit value="N">
<input type="text"   id=addBtnInit value="N">
<input type="text"   id="innerTravelQnaContentId" value="${travelMap.innerTravelQnaContentId}">
<input type="text"   id="innerTravelQnaPageIdx" value=0 >




<div class="row">
<div class="col-md-offset-1 col-md-10 col-md-offset-1 containerBody">
	<div class="col-md-12">
		<h3>${travelMap.title}</h3>
	</div>
 	<div class="col-md-9 leftDiv">
 		<div class="col-md-12 TabArea">
		 	<ul class="nav nav-tabs">
				<li class="active"><a href="javascript:void(0);" onclick="viewTab('1');">사진</a></li>
				<li><a href="javascript:void(0);" onclick="viewTab('2');">위치</a></li>
				<li><a href="javascript:void(0);" onclick="viewTab('3');">정보</a></li>
			</ul>      
		</div>
		   <div class="col-md-12 topArea">	
				<div class="col-md-12 containerImg">
	    			<div class="col-md-12">
		    			 <img src="${travelMap.firstimage}" class="titleImage">
	    			</div>
	    		</div>
				<div class="col-md-12 containerMap" style="display: none">
				 	<div id="map" style="width:100%;height:400px;"></div>
				</div>
				<div class="col-md-12 travOverview">
					<div class="col-md-12 travOverviewSection">
							<span class="title">개요<br/></span>	
							<span class="content">${travelMap.overview}<br/></span>
					</div>
					<div class="col-md-12 traveliInfoSection">
						
						<c:if test="${travelMap.addr1 !=null and travelMap.addr2 !=null}">
								<span class="title">주소<br/></span>
								<span class="content">
									${travelMap.addr1} ${travelMap.addr2 }<br/>
								</span>
							</c:if>
							
							<c:if test="${travelMap.zipcode !=null}">
								<span class="title">우편번호<br/></span>
								<span class="content">	${travelMap.zipcode}<br/>
								</span>
							</c:if>
		 										
							<c:choose>
								<c:when test="${travelMap.cateCode =='25'}">
									<span class="title">코스 총거리<br/></span>	
									<span class="content">${travelMap.distance }<br/></span>
									<span class="title">코스 이동시간<br/></span>
									<span class="content">${travelMap.taketime }<br/></span>
								</c:when>
					
								<c:when test="${travelMap.cateCode =='12'}">
								
									<span class="title">문의 및 안내 <br/></span>	
									<span class="content">${travelMap.infocenter}<br/></span>
									
								
									<span class="title">쉬는날 <br/></span>	
									<span class="content">${travelMap.restdate}<br/></span>
									
									<span class="title">유모차 대여 여부<br/></span>	
									<span class="content">${travelMap.chkbabycarriage}<br/></span>
									
									<span class="title">애완동물 동반 가능 여부<br/></span>
									<span class="content">${travelMap.chkpet}<br/></span>
					
									<span class="title">신용카드 가능 여부<br/></span>
									<span class="content">${travelMap.chkcreditcard}<br/></span>
								</c:when>
							</c:choose>
							
							<c:if test="${travelMap.homepage != null}">
								<span class="title">홈페이지<br/></span>
								<span class="content">${travelMap.homepage}<br/></span>
							</c:if>
							
							
							<c:forEach var="infoname" items="${travelMap.infonameList}" varStatus="i">
							<span class="title">${infoname}<br/></span>
								<c:forEach var="infotext" items="${travelMap.infotextList}" varStatus="j">
									 <c:if test="${i.index  eq j.index}">
										<span class="content" >${infotext}<br/></span>
								 	</c:if>
								</c:forEach>
							</c:forEach>
					</div>
 				</div>
				
			</div>
			
			<c:if test="${travelMap.cateCode =='25' }">
				<div class="col-md-12 courseInfoTitle">
					<span>추천 코스 정보</span>
				</div>
				<div class="col-md-7 innerTravelcourseInfo">
					<ul class="bxslider">
						<c:forEach var="subdetailimg" items="${travelMap.subdetailimgList }"  varStatus="status">
							<li id="${status.index}"><img src="${subdetailimg}" class="bximage"/></li>
						</c:forEach>
					</ul>
				</div>
				<div class="col-md-5 innerTravelcourseWrite">
					<c:forEach var="subname" items="${travelMap.subnameList }" varStatus="i">
						<div class="col-md-12 courseWriteEach" id="course${i.index}">
							<div class="col-md-12 subname">${subname}<br/></div>
							<c:forEach var="subdetailoverview" items="${travelMap.subdetailoverviewList }" varStatus="j">
								 <c:if test="${i.index  eq j.index}">
										<div class="col-md-12 subdetailoverview" >	${subdetailoverview }</div>
								 </c:if>
							</c:forEach>
						</div>	
					</c:forEach>
				</div>
	 		</c:if>
						
			<div class="col-md-12 innerTravelSNS">
			<h3><span>여행지</span> 이야기</h3>
					<div class="col-md-12 communityTab">
						<ul class="nav nav-tabs">
							<li class="active"><a href="javascript:void(0);" onclick="communityTab('1');">여행기</a></li>
							<li><a href="javascript:void(0);" onclick="communityTab('2');">여행지 질문하기</a></li>
							<li><a href="javascript:void(0);" onclick="communityTab('3');">이야기</a></li>
							<li><a href="javascript:void(0);" onclick="communityTab('4');">근처 추천지</a></li>
	
						</ul>
					</div>
<!-- 					여행기 부분 -->
				<div class="col-md-12 travels"></div>					
<!-- 					질문하기 -->
				<div class="col-md-12 qnaCommunity">
				    <div class="col-md-12 qnaCommunityInsert">
						<div class="col-md-1 qnaCommunityIcon"></div>
						<div class="col-md-8 qnaCommunityTextArea">
							<textarea rows="2" cols="68" id="qnaTextArea">로그인후 작성가능 합니다</textarea>
						</div>
						<div class="col-md-2 qnaCommunityTextButton">
							<button type="button" onclick="onWrite(${travelMap.contentId });">
								<span class="glyphicon glyphicon-saved">등록</span>
							</button>
						</div>
					</div>	
					<div class="col-md-12 qnaCommunityBoard"></div>
				</div>
 <!--  					근처 여행지  -->										
				<div class="col-md-12 aroundReCommunity"></div>
		 	</div> 
		</div> 
<!-- 		좌측 부분 끝  -->
		
		
<!-- 		오른쪽 부분 시작 -->
		<div class="col-md-3 rightDiv">
<!-- 			<div class="col-md-12 containerInfo"> -->
<!-- 	 	 		<div class="col-md-12 travInfo" > -->
<%-- 					<c:if test="${travelMap.addr1 !=null and travelMap.addr2 !=null}"> --%>
<!-- 						<span class="title">주소<br/></span> -->
<!-- 						<span class="content"> -->
<%-- 							${travelMap.addr1} ${travelMap.addr2 }<br/> --%>
<!-- 						</span> -->
<%-- 					</c:if> --%>
					
<%-- 					<c:if test="${travelMap.zipcode !=null}"> --%>
<!-- 						<span class="title">우편번호<br/></span> -->
<%-- 						<span class="content">	${travelMap.zipcode}<br/> --%>
<!-- 						</span> -->
<%-- 					</c:if> --%>
 										
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${travelMap.cateCode =='25'}"> --%>
<!-- 							<span class="title">코스 총거리<br/></span>	 -->
<%-- 							<span class="content">${travelMap.distance }<br/></span> --%>
<!-- 							<span class="title">코스 이동시간<br/></span> -->
<%-- 							<span class="content">${travelMap.taketime }<br/></span> --%>
<%-- 						</c:when> --%>
			
<%-- 						<c:when test="${travelMap.cateCode =='12'}"> --%>
						
<!-- 							<span class="title">문의 및 안내 <br/></span>	 -->
<%-- 							<span class="content">${travelMap.infocenter}<br/></span> --%>
							
						
<!-- 							<span class="title">쉬는날 <br/></span>	 -->
<%-- 							<span class="content">${travelMap.restdate}<br/></span> --%>
							
<!-- 							<span class="title">유모차 대여 여부<br/></span>	 -->
<%-- 							<span class="content">${travelMap.chkbabycarriage}<br/></span> --%>
							
<!-- 							<span class="title">애완동물 동반 가능 여부<br/></span> -->
<%-- 							<span class="content">${travelMap.chkpet}<br/></span> --%>
			
<!-- 							<span class="title">신용카드 가능 여부<br/></span> -->
<%-- 							<span class="content">${travelMap.chkcreditcard}<br/></span> --%>
<%-- 						</c:when> --%>
<%-- 					</c:choose> --%>
					
<%-- 					<c:if test="${travelMap.homepage ne null}"> --%>
<!-- 						<span class="title">홈페이지<br/></span> -->
<%-- 						<span class="content">${travelMap.homepage }</span> --%>
<%-- 					</c:if> --%>
<!-- 				</div> -->
<!-- 			</div>	 -->
		</div>
<!-- 		오른쪽 부분 끝  -->
		
 	 </div>
<!--  	 전체 컨텐츠 바디부분 끝   -->
</div>
<!-- row 부분 끝  -->
<jsp:include page="../template/footer.jsp" flush="true" />
