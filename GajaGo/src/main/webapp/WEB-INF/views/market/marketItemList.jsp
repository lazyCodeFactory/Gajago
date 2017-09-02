<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="/resources/css/marketItem/marketItem.css">
<jsp:include page="../template/includeResource.jsp" flush="true" />
<script src="/resources/js/market/marketItemList.js"></script>
</head>

<jsp:include page="../template/header.jsp" flush="true" />
 
	<div class="row">
		<div class="col-md-12 menuClass">
		</div>
			<div class="col-md-offset-1 col-md-10 col-md-offset-1 containerBody">
			 	<div class="col-md-3 leftMenuSide">
			 		<div class="leftMenu"> 
			 			<div class="trafficTicketTitle">티켓 양도</div>  
				 			<div class="trafficTicket" id="trafficMenu">티켓 양도</div>
							<div class="panelDiv" id="panel1">
								<ul>
									<li>비행기표 양도</li>
									<li>국내 기차표 양도</li>
									<li>호텔 숙박권 양도</li>
								</ul>					 
			
							</div>
							<div class="trafficTicket" id="accomMenu">물품마켓</div>
								<div class="panelDiv" id="panel2">
									<ul>
										<li>캠핑장비</li>
										<li>캐리어/배낭</li>
										<li>기타</li>
									</ul>					 
								</div>
						
				 		</div>
			 	</div>
			 	
			 	<div class="col-md-9 rightMenuSide">
			 	 <div class="col-md-12 enrollMarketWrite">
	  					<a href="javascript:void(0);" onclick="itemEnroll();" class="enrollMarketWriteHref">등록 </a>
					</div>
					<div class="col-md-12">
				 		<c:forEach items="${marketlist}" var="marketVo">
				 			<div class="col-md-4 marketItem">
				 				<div class="col-md-offset-1 col-md-10 col-md-offset-1 marketItemImgDiv">
				 					<img src="${marketVo.marketItemFile1}" class="marketItemImg"/>
				 				</div>
				 				<div class="col-md-12 marketItemContent">
			 		 				<div class="col-md-offset-1 col-md-10 col-md-offset-1">
			 		 					<span class="title"> 제목:</span>   
			 		 					${marketVo.marketTitle}
			 		 				</div>
			 		 				<div class="col-md-offset-1 col-md-10 col-md-offset-1">
			 		 					<span class="title"> 글쓴이:</span>
			 		 					 ${marketVo.marketWriter}
			 		 				</div>
		 		 				</div>
				 				
				 			</div>
			 		   </c:forEach>
			 		</div>
			 	</div>
		</div>
	</div>
 
<jsp:include page="../template/footer.jsp" flush="true" />
