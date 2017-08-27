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
<input type="text"   id="contentTypeId" value="${travelMap.contenttypeid}">  

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
    		<c:if test="${travelMap.contenttypeid =='32'}">
				<li><a href="javascript:void(0);" onclick="viewTab('4');">Room 정보</a></li>
    		</c:if>
    		<c:if test="${travelMap.contenttypeid =='39'}">
				<li><a href="javascript:void(0);" onclick="viewTab('5');">음식메뉴</a></li>
    		</c:if>
  		</ul>      
		</div>
		   <div class="col-md-12 topArea">	
				<div class="col-md-12 containerImg">
		    		<c:if test="${travelMap.contenttypeid =='32' or travelMap.contenttypeid =='39'}">
		 		    	<div class="col-md-12 innerTravelfirstimageInfo">
							<img src="${travelMap.firstimage}"/>
						</div>
					</c:if>


		    		<c:if test="${travelMap.contenttypeid =='25'}">
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
	    			
<!-- 	    	관광지 12번 ,레포츠 28번 ,음식점39번 -->
		    		<c:if test="${travelMap.contenttypeid =='12' or travelMap.contenttypeid =='28' or  traveMap.contenttypeid =='39'}">
		    			<div class="col-md-12">
	 						  <ul class="bxslider">
								<c:forEach var="originimgurl" items="${travelMap.originimgurlList}" varStatus="i">
 									<li id="${status.index}"><img src="${originimgurl}" class="bximage"/></li>
 								 </c:forEach>
 							  </ul>
 						</div>
		    		</c:if>	   
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
						
						<c:if test="${not empty fn:trim(travelMap.addr1)}">
								<span class="title">주소<br/></span>
								<span class="content">
									${travelMap.addr1} ${travelMap.addr2 }<br/>
								</span>
							</c:if>
 							
							<c:if test="${not empty fn:trim(travelMap.zipcode)}">
								<span class="title">우편번호<br/></span>
								<span class="content">${travelMap.zipcode}<br/>
								</span>
							</c:if>
		 										
							<c:choose>
								<c:when test="${travelMap.cateCode =='25'}">
									<span class="title">코스 총거리<br/></span>	
									<span class="content">${travelMap.distance }<br/></span>
									<span class="title">코스 이동시간<br/></span>
									<span class="content">${travelMap.taketime }<br/></span>
								</c:when>
					
					
								<c:when test="${travelMap.cateCode =='39'}">
					
									<c:if test="${not empty fn:trim(travelMap.firstmenu)}">
										<span class="title">대표메뉴<br/></span>
										<span class="content">${travelMap.firstmenu}<br/>
										</span>
									</c:if>
		
									<c:if test="${not empty fn:trim(travelMap.treatmenu)}">
										<span class="title">메뉴종류<br/></span>
										<span class="content">${travelMap.treatmenu}<br/>
										</span>
									</c:if>

									<c:if test="${not empty fn:trim(travelMap.seat)}">
										<span class="title">좌석수<br/></span>
										<span class="content">${travelMap.seat}<br/>
										</span>
									</c:if>

									<c:if test="${not empty fn:trim(travelMap.restdatefood)}">
										<span class="title">휴무일<br/></span>
										<span class="content">${travelMap.restdatefood}<br/>
										</span>
									</c:if>
					
					
									<c:if test="${not empty fn:trim(travelMap.packing)}">
										<span class="title">포장유무<br/></span>
										<span class="content">${travelMap.packing}<br/>
										</span>
									</c:if>
										

									<c:if test="${not empty fn:trim(travelMap.reservationfood)}">
										<span class="title">예약안내<br/></span>
										<span class="content">${travelMap.reservationfood}<br/>
										</span>
									</c:if>
					


									<c:if test="${not empty fn:trim(travelMap.smoking)}">
										<span class="title">금연/흡연 여부<br/></span>
										<span class="content">${travelMap.smoking}<br/>
										</span>
									</c:if>

					
								</c:when>
					
								<c:when test="${travelMap.cateCode =='12'}">
								   <c:if test="${not empty fn:trim(travelMap.infocenter)}">
										<span class="title">문의 및 안내 <br/></span>	
										<span class="content">${travelMap.infocenter}<br/></span>
									</c:if>
								
									<c:if test="${not empty fn:trim(travelMap.restdate)}">
										<span class="title">쉬는날 <br/></span>	
										<span class="content">${travelMap.restdate}<br/></span>
									</c:if>
						 			<c:if test="${not empty fn:trim(travelMap.chkbabycarriage)}">
										<span class="title">유모차 대여 여부<br/></span>	
										<span class="content">${travelMap.chkbabycarriage}<br/></span>
									</c:if>
									
									<c:if test="${not empty fn:trim(travelMap.chkpet)}">
										<span class="title">애완동물 동반 가능 여부<br/></span>
										<span class="content">${travelMap.chkpet}<br/></span>
									</c:if>
									
									<c:if test="${not empty fn:trim(travelMap.chkcreditcard)}">
										<span class="title">신용카드 가능 여부<br/></span>
										<span class="content">${travelMap.chkcreditcard}<br/></span>
									</c:if>	
								</c:when>
								
								<c:when test="${travelMap.cateCode =='32'}">
									<c:if test="${not empty fn:trim(travelMap.checkintime)}">
										<span class="title">체크인<br/></span>
										<span class="content">${travelMap.checkintime}<br/></span>
									</c:if>	
									
									
									<c:if test="${not empty fn:trim(travelMap.checkouttime)}">
										<span class="title">체크아웃<br/></span>
										<span class="content">${travelMap.checkouttime}<br/></span>
									</c:if>	
									
									
									<c:if test="${not empty fn:trim(travelMap.parkinglodging)}">
										<span class="title">주차가능<br/></span>
										<span class="content">${travelMap.parkinglodging}<br/></span>
									</c:if>	
	
									<c:if test="${not empty fn:trim(travelMap.karaoke)}">
										<span class="title">노래방<br/></span>
										<span class="content">${travelMap.karaoke}<br/></span>
									</c:if>	
									<c:if test="${not empty fn:trim(travelMap.pickup)}">
										<span class="title">픽업서비스<br/></span>
										<span class="content">${travelMap.pickup}<br/></span>
									</c:if>	
									<c:if test="${not empty fn:trim(travelMap.reservationlodging)}">
										<span class="title">예약안내<br/></span>
										<span class="content">${travelMap.reservationlodging}<br/></span>
									</c:if>	
									<c:if test="${not empty fn:trim(travelMap.reservationurl)}">
										<span class="title">예약 웹사이트<br/></span>
										<span class="content">${travelMap.reservationurl}<br/></span>
									</c:if>	
									<c:if test="${not empty fn:trim(travelMap.roomcount)}">
										<span class="title">객실수<br/></span>
										<span class="content">${travelMap.roomcount}<br/></span>
									</c:if>	
									<c:if test="${not empty fn:trim(travelMap.roomtype)}">
										<span class="title">객실 유형<br/></span>
										<span class="content">${travelMap.roomtype}<br/></span>
									</c:if>	
	
									<c:if test="${not empty fn:trim(travelMap.foodplace)}">
										<span class="title">식음료장 <br/></span>
										<span class="content">${travelMap.roomtype}<br/></span>
									</c:if>	
	
									<c:if test="${not empty fn:trim(travelMap.barbecue)}">
										<span class="title">바베큐장<br/></span>
										<span class="content">
											<c:choose>
												 <c:when test="${travelMap.barbecue == '1'}">
											 		있음
											 	 </c:when>
											 	 <c:otherwise>
											 	 	없음
											 	 </c:otherwise>
											</c:choose>
										<br/>
										</span>
									</c:if>	
	
	
									<c:if test="${not empty fn:trim(travelMap.sauna)}">
										<span class="title">사우나<br/></span>
										<span class="content">
											<c:choose>
												 <c:when test="${travelMap.sauna == '1'}">
											 		있음
											 	 </c:when>
											 	 <c:otherwise>
											 	 	없음
											 	 </c:otherwise>
											</c:choose>
										<br/>
										</span>
									</c:if>
									
									<c:if test="${not empty fn:trim(travelMap.publicbath)}">
										<span class="title">공중목욕시설<br/></span>
										<span class="content">
											<c:choose>
												 <c:when test="${travelMap.publicbath == '1'}">
											 		있음
											 	 </c:when>
											 	 <c:otherwise>
											 	 	없음
											 	 </c:otherwise>
											</c:choose>
										<br/>
										</span>
									</c:if>
									
									
									<c:if test="${not empty fn:trim(travelMap.seminar)}">
										<span class="title">공중목욕시설<br/></span>
										<span class="content">
											<c:choose>
												 <c:when test="${travelMap.seminar == '1'}">
											 		있음
											 	 </c:when>
											 	 <c:otherwise>
											 	 	없음
											 	 </c:otherwise>
											</c:choose>
										<br/>
										</span>
									</c:if>
									
									<c:if test="${not empty fn:trim(travelMap.campfire)}">
										<span class="title">캠프파이어<br/></span>
										<span class="content">
											<c:choose>
												 <c:when test="${travelMap.campfire == '1'}">
											 		있음
											 	 </c:when>
											 	 <c:otherwise>
											 	 	없음
											 	 </c:otherwise>
											</c:choose>
										<br/>
										</span>
									</c:if>
		
		
									
									
									<c:if test="${not empty fn:trim(travelMap.sports)}">
										<span class="title">운동시설<br/></span>
										<span class="content">
											<c:choose>
												 <c:when test="${publicbath == '1'}">
											 		있음
											 	 </c:when>
											 	 <c:otherwise>
											 	 	없음
											 	 </c:otherwise>
											</c:choose>
										<br/>
										</span>
									</c:if>
	
 							<c:if test="${not empty fn:trim(travelMap.chkcooking)}">
 								<span class="title">조리여부<br/></span>
								<span class="content">${travelMap.chkcooking}<br/></span>
							</c:if>
										
								</c:when>
							</c:choose>
							
 							<c:if test="${not empty fn:trim(travelMap.homepage)}">
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
				<div class="col-md-12 roomInfo">
				<!-- 룸정보 -->


		    		<c:if test="${travelMap.contenttypeid =='32'}">
		 		    	<div class="col-md-12 innerTravelRoomInfo">
		 		    	<div class="col-md-7 innerTravelroomImageInfo">
		 		    		<input type="text" id="roomimg1Size" value="${fn:length(travelMap.roomimg1List)}"/>
							<ul class="bxslider">
								<c:forEach var="roomimg1" items="${travelMap.roomimg1List }"  varStatus="status">
 									<li id="${status.index}">
										<img src="${roomimg1}" class="bximage"/>
									</li>
 								</c:forEach>
							</ul>
						</div>
						<div class="col-md-5 innerTravelcourseWrite">
							<c:forEach var="title" items="${travelMap.titleList }" varStatus="i">
								
								
								<div class="col-md-12 courseWriteEach" id="course${i.index}">
									<div class="col-md-12 subname">${title}<br/></div>
									<ul>
									<c:forEach var="roomaircondition" items="${travelMap.roomairconditionList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 <li><span class="title">에어컨:</span><span class="content">${roomaircondition}</span></li>	
										 </c:if>
									</c:forEach>
									
									
									<c:forEach var="roombasecount" items="${travelMap.roombasecountList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title"></span><span class="content">${roombasecount }</span></li>
										 </c:if>
									</c:forEach>
									
									<c:forEach var="roombath" items="${travelMap.roombathList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title">욕조:</span><span class="content">${roombath}</span></li> 
										 </c:if>
									</c:forEach>
									
									<c:forEach var="roomcook" items="${travelMap.roomcookList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title"></span><span class="content">${roomcook}</span></li>
										 </c:if>
									</c:forEach>
									
									<c:forEach var="roomhairdryer" items="${travelMap.roomhairdryerList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title">헤어드라이어:</span><span class="content">${roomhairdryer}</span></li>
										 </c:if>
									</c:forEach>
									
									
									<c:forEach var="roomoffseasonminfee1" items="${travelMap.roomoffseasonminfee1List }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title"></span><span class="content">${roomoffseasonminfee1}</span></li>
										 </c:if>
									</c:forEach>
									
									
									<c:forEach var="roomoffseasonminfee2" items="${travelMap.roomoffseasonminfee2List }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title"></span><span class="content">${roomoffseasonminfee2}</span></li>
										 </c:if>
									</c:forEach>
									
									
									<c:forEach var="roompeakseasonminfee1" items="${travelMap.roompeakseasonminfee1List }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title"></span><span class="content">${roompeakseasonminfee1}</span></li>
										 </c:if>
									</c:forEach>
									
									<c:forEach var="roompeakseasonminfee2" items="${travelMap.roompeakseasonminfee2List }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title"></span><span class="content">${roompeakseasonminfee2}</span></li>
										 </c:if>
									</c:forEach>
									
									
									<c:forEach var="roomrefrigerator" items="${travelMap.roomrefrigeratorList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title">냉장고</span><span class="content">${roomrefrigerator}</span></li>
										 </c:if>
									</c:forEach>
									
									
									<c:forEach var="roomsize1" items="${travelMap.roomsize1List }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title"></span><span class="content">${roomsize1}</span></li>
										 </c:if>
									</c:forEach>
									
									
									
									<c:forEach var="roomsize2" items="${travelMap.roomsize2List }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title"></span><span class="content">${roomsize2}</span></li>
										 </c:if>
									</c:forEach>
									
									
									<c:forEach var="roomtitle" items="${travelMap.roomtitleList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title">객실명:</span><span class="content">${roomtitle}</span></li>
										 </c:if>
									</c:forEach>
									
									
									<c:forEach var="roomtv" items="${travelMap.roomtvList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title">TV:</span><span class="content">${roomtv}</span></li>
										 </c:if>
									</c:forEach>
									
									<c:forEach var="roomcount" items="${travelMap.roomcountList }" varStatus="j">
										 <c:if test="${ i.index eq j.index}">
										 	<li><span class="title">객실수:</span><span class="content">${roomcount}</span></li>
										 </c:if>
									</c:forEach>
									</ul>
							
								</div>	
							</c:forEach>
						</div>
						</div>
			    	</c:if>
				
				</div>
				
				
				<div class="col-md-12 foodMenuInfo">
					<c:if test="${travelMap.contenttypeid =='39'}">
						<div class="col-md-offset-1 col-md-10 col-md-offset-1 foodMenuInfo">
							<div class="col-md-9 menuOriginImg">
								<c:forEach var ="menuoriginimgurl" items="${travelMap.menuoriginimgurlList }" begin="0" end="3" varStatus="status">
									<img src="${menuoriginimgurl}" class="foodMenuMain" id="original${status.index}" >
								
								</c:forEach>
							</div>
							<div class="col-md-3 menuSmallImg">
								<c:forEach var ="menusmallimageurl" items="${travelMap.menusmallimageurlList}" begin="0" end="3" varStatus="status">
								  <a href="javascript:void(0);" onclick="subImgClick(${status.index});">
 									 <img src="${menusmallimageurl }" class="foodMenuMainSub" id="small${status.index}">
 								  </a>
								</c:forEach>
							</div>
							
						
						</div>
					</c:if>
				</div>
			</div>
			

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
						<div class="col-md-9 qnaCommunityTextArea">
							<textarea rows="2" cols="90" id="qnaTextArea">로그인후 작성가능 합니다</textarea>
						</div>
						<div class="col-md-2 qnaCommunityTextButton">
							<button type="button" onclick="onWrite(${travelMap.contentId });">
								<span class="glyphicon glyphicon-saved">등록</span>
							</button>
						</div>
					</div>	
					<div class="col-md-12 qnaCommunityBoard"></div>
				</div>
 <!--   근처 여행지  -->										
				<div class="col-md-12 aroundReCommunity"></div>
		 	</div> 
		</div> 
<!-- 		좌측 부분 끝  -->
		
		
<!-- 		오른쪽 부분 시작 -->
		<div class="col-md-3 rightDiv"></div>
<!-- 		오른쪽 부분 끝  -->
		
 	 </div>
<!--  	 전체 컨텐츠 바디부분 끝   -->
</div>
<!-- row 부분 끝  -->
<jsp:include page="../template/footer.jsp" flush="true" />
