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
<input type="hidden" id="subdetailimgLength" value="${fn:length(travelMap.subdetailimgList)}"/>
<div class="row">
<div class="col-md-offset-1 col-md-10 col-md-offset-1 containerBody">
 	<div class="col-md-9 leftDiv">
		 	<ul class="nav nav-tabs">
				<li class="active"><a href="javascript:void(0);" onclick="viewTab('1');">사진</a></li>
				<li><a href="javascript:void(0);" onclick="viewTab('2');">위치</a></li>
		   </ul>      

		   <div class="col-md-12 topArea">	
				<div class="col-md-12 containerImg">
	    			<div class="col-md-12">
		    			 <img src="${travelMap.firstimage}" class="titleImage">
	    			</div>
	    		</div>
				<div class="col-md-12 containerMap" style="display: none">
				 	<div id="map" style="width:100%;height:400px;"></div>
				</div>
			</div>
			
			<c:if test="${travelMap.cateCode =='25' }">
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
				<h3> 
					<span>${travelMap.title}</span> 이야기</h3>
					<div class="col-md-12 communityTab">
						<ul class="nav nav-tabs">
							<li class="active"><a href="javascript:void(0);" onclick="communityTab('1');">여행기</a></li>
							<li><a href="javascript:void(0);" onclick="communityTab('2');">질문하기</a></li>
							<li><a href="javascript:void(0);" onclick="communityTab('3');">근처 추천지</a></li>
						
						</ul>
					</div>
<!-- 					여행기 부분 -->
					<div class="col-md-12 travels">
					
					</div>					
<!-- 					질문하기 -->
					<div class="col-md-12 qnaCommunity">
					<div class="col-md-12 qnaCommunityTextArea">
						<textarea rows="4" cols="100">로그인후 작성가능 합니다</textarea>
					</div>
					<div class="col-md-12 qnaCommunityTextButton">
						<button type="button" onclick="onWrite(${travelMap.contentId });">
							<span class="glyphicon glyphicon-saved">등록</span>
						</button>
						
					</div>
					</div>
<!--  					근처 여행지  -->										
					<div class="col-md-12 aroundReCommunity">
					</div>
					
					
				</div> 		 
			</div>
			<div class="col-md-3 rightDiv">
				<div class="col-md-12 containerInfo">
		 	 		<div class="col-md-12 travOverview">${travelMap.overview}<br/></div>
			 	 	<div class="col-md-12 travInfo" >
						<c:if test="${travelMap.addr1 !=null and travelMap.addr2 !=null} ">
							<span class="title">주소:</span>${travelMap.addr1} ${travelMap.addr2 }<br/>
						</c:if>
						<c:if test="${travelMap.cateCode =='25' }">
							<span class="title">코스 총거리:</span>	${travelMap.distance }<br/>
							<span class="title">코스 이동시간:</span>	${travelMap.taketime }<br/>
						</c:if>
						<c:if test="${travelMap.homepage !=null} ">
							<span class="title">홈페이지:</span>${travelMap.homepage }
						</c:if>
					</div>
				</div>	
			</div>
		</div>
		</div>
 	
	
	
	
	
<%-- 	${travelMap.title }<br/> --%>
<%-- 		${travelMap.overview }<br/> --%>
<%-- 		${travelMap.addr1 }<br/> --%>
<%-- 		${travelMap.addr2 }<br/> --%>
<%-- 		${travelMap.distance }<br/> --%>
		
	
<%-- 		<c:forEach var="subname" items="${travelMap.subnameList }"> --%>
<%-- 			${subname }<br/> --%>
<%-- 		</c:forEach> --%>
	
<%-- 		<c:forEach var="subdetailoverview" items="${travelMap.subdetailoverviewList }"> --%>
<%-- 			${subdetailoverview }<br/> --%>
<%-- 		</c:forEach> --%>
		
	
<%-- 		<c:forEach var="subdetailimg" items="${travelMap.subdetailimgList }"> --%>
<%-- 			${subdetailimg }<br/> --%>
<%-- 		</c:forEach> --%>

<%-- 		${travelMap.taketime }<br/> --%>
<%-- 		${travelMap.homepage }<br/> --%>
	 
 	


<jsp:include page="../template/footer.jsp" flush="true" />
