<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/resources/css/innerTravel/innerTravel.css">
<jsp:include page="../template/includeResource.jsp" flush="true" />
<script src="/resources/js/innerTravel/innerTravelList.js"></script>
</head>
<jsp:include page="../template/header.jsp" flush="true" />
 <form id="detail" method="post">
	<input type="hidden" id="initBtn" value="x" />
	<input type="hidden" id="areaCode" value="1" />
	<input type="text" name="cateCode" id="cateCode" value="25" />
 	<input type="text" name="contentId" id="contentId" value="" />
  
  	<input type="text" name="profilePic" id="profilePic" value="${profilePic}" />
  	<input type="text" name="nickname" id="nickname" value="${nickname}" />
  
 </form>

<div class="row">

	<div class="col-md-offset-1 col-md-10 col-md-offset-1 containerBody">
	 
		<div class="areasearchBtn">
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a1');">
				<img src="/resources/image/innerTravel/getSeoulImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getSeoulImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getSeoulImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>서울</span>
				</div>
			</div>
			
			
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a2');">
				<img src="/resources/image/innerTravel/getIncheonImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getIncheonImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getIncheonImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>인천</span>
				</div>	
			</div>
			
			
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a3');">
				<img src="/resources/image/innerTravel/getDaejunImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getDaejunImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getDaejunImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>대전</span>
				</div>	
			</div>
			
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a4');"> 
				<img src="/resources/image/innerTravel/getDaeguImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getDaeguImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getDaeguImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>대구</span>
				</div>
				
			</div>
			
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a5');"> 
				<img src="/resources/image/innerTravel/getGwangjuImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getGwangjuImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getGwangjuImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>광주</span>
				</div>
				
			</div>
			
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a6');"> 
				<img src="/resources/image/innerTravel/getBusanImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getBusanImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getBusanImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>부산</span>
				</div>
				
			</div>
			
			
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a7');"> 
				<img src="/resources/image/innerTravel/getUlsanImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getUlsanImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getUlsanImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>울산</span>
				</div>
				
			</div>
			
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a31');">
				<img src="/resources/image/innerTravel/getGyunggiImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getGyunggiImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getGyunggiImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>경기도</span>
				</div>
				
			</div>

			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a32');"> 
				<img src="/resources/image/innerTravel/getGangwonImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getGangwonImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getGangwonImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>강원도</span>
				</div>
				
			</div>

			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a33');">
				<img src="/resources/image/innerTravel/getChungbukImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getChungbukImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getChungbukImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>충청북도</span>
				</div>
				
			</div>



			
			<div class="col-md-2 innerAreaTab">
				<a href="javascript:void(0);" onclick="makelist('a34');">
				<img src="/resources/image/innerTravel/getChungnameImage.jpg"
					onmouseover="this.src='/resources/image/innerTravel/getChungnameImageClick.jpg'"
					onmouseout="this.src='/resources/image/innerTravel/getChungnameImage.jpg'" class='imgBtn'>
				</a>
				<div class="col-md-12 areaTitle">
					<span>충청남도</span>
				</div>
				
			</div>
			
			<div class="col-md-2 innerAreaTab plusDiv">
				<a href="javascript:void(0);" onclick="plusRegion(this);">
					<div class="changeRegionBtn">
						<img src="/resources/image/innerTravel/plusDiv.jpg" class='imgBtn'>
					</div>

					<div class="changeRegionDiv">
					<a href="javascript:void(0);" onclick="makelist('a8');">
						<img src="/resources/image/innerTravel/getSejongImage.jpg"
							onmouseover="this.src='/resources/image/innerTravel/getSejongImageClick.jpg'"
							onmouseout="this.src='/resources/image/innerTravel/getSejongImage.jpg'" class='imgBtn'>
					</a>
					<div class="col-md-12 areaTitle">
						<span>세종</span>
					</div>
				
					</div>
				</a>
			</div>
			
 

  					<div class="col-md-2 innerAreaTab" style="display: none" id="hideRegion1">
						<a href="javascript:void(0);" onclick="makelist('a37');"> 
						<img src="/resources/image/innerTravel/getJeonbukImage.jpg"
							onmouseover="this.src='/resources/image/innerTravel/getJeonbukImageClick.jpg'"
							onmouseout="this.src='/resources/image/innerTravel/getJeonbukImage.jpg'" class='imgBtn'>
						</a>
						<div class="col-md-12 areaTitle">
							<span>전라북도</span>
						</div>
				
					</div>
		
		
					<div class="col-md-2 innerAreaTab" style="display: none" id="hideRegion2">
						<a href="javascript:void(0);" onclick="makelist('a38');"> 
						<img src="/resources/image/innerTravel/getJeonbukImage.jpg"
							onmouseover="this.src='/resources/image/innerTravel/getJeonnamImageClick.jpg'"
							onmouseout="this.src='/resources/image/innerTravel/getJeonnamImage.jpg'" class='imgBtn'>
						</a>
						<div class="col-md-12 areaTitle">
							<span>전라남도</span>
						</div>
				
					</div>   
		
					<div class="col-md-2 innerAreaTab" style="display: none" id="hideRegion3">
						<a href="javascript:void(0);" onclick="makelist('a39');"> 
						<img src="/resources/image/innerTravel/getJejuImage.jpg"
							onmouseover="this.src='/resources/image/innerTravel/getJejuImageClick.jpg'"
							onmouseout="this.src='/resources/image/innerTravel/getJejuImage.jpg'" class='imgBtn'>
						</a>
						<div class="col-md-12 areaTitle">
							<span>제주</span>
						</div>
				   
					</div>
 		</div>

		<div class="col-md-12 listSortTab">
			<ul class="nav nav-tabs">
				<li class="active"><a href="javascript:void(0);" onclick="makelist('c25');">코스추천</a></li>
				<li><a href="javascript:void(0);" onclick="makelist('c12');">관광지</a></li>
				<li><a href="javascript:void(0);" onclick="makelist('c28');">레포츠</a></li>
				<li><a href="javascript:void(0);" onclick="makelist('c32');">숙박</a></li>
				<li><a href="javascript:void(0);" onclick="makelist('c39');">음식점</a></li>
			</ul>

		</div>
 		<div class="col-md-12 listSort">
			<c:forEach var="innerVo" items="${innerTravelList}">
					<div class="col-md-3 listItem">
						<div class="col-md-12 imgDiv">
						<a href="javascript:void(0);" onclick="detailView('${innerVo.contentid}');" >
							<img src="${innerVo.firstimage}" class="listItemImg">
						</a>
						</div>
						<div class="col-md-12 expDiv">
							${innerVo.title}
		 				</div>
					</div>
 				
			</c:forEach>
		</div>
	</div>
</div>

<jsp:include page="../template/footer.jsp" flush="true" />
