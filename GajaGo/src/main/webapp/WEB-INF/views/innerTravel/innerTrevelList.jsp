<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/innerTrevel/innerTrevel.css">
<jsp:include page="../template/includeResource.jsp" flush="true" />
<script src="/resources/js/innerTravel/raphael_min.js"></script>
<script src="/resources/js/innerTravel/raphael_path_s.korea.js"></script>
<script src="/resources/js/innerTravel/innerTrevel.js"></script>

</head>
<jsp:include page="../template/header.jsp" flush="true" />
<input type="hidden" id="initBtn" value="x"/>
<div class="row">
	<div class="col-md-offset-1 col-md-10 col-md-offset-1 tabMenu">
	<ul class="nav nav-tabs">
	  			<li>
	  				<a href="javascript:void(0);" onclick=searchType(1);>지도로 찾기</a>
	  			</li>
		  		<li>
		  			<a href="javascript:void(0);" onclick=searchType(2);>버튼으로 찾기</a>
		  		</li>
			</ul>
	</div>
	<div class="col-md-offset-1 col-md-10 col-md-offset-1 containerBody">
 		<div class="col-md-12 mapsearchBtn">
	 		<div id="canvas" class="col-md-4 canvas">
				<div id="south" class="southMap"></div>
				<div id="seoul"></div>
				<div id="gygg"></div>
				<div id="incheon"></div>
				<div id="gangwon"></div>
				<div id="chungbuk"></div>
				<div id="chungnam"></div>
				<div id="daejeon"></div>
				<div id="sejong"></div>
				<div id="gwangju"></div>
				<div id="jeonbuk"></div>
				<div id="jeonnam"></div>
				<div id="gyeongbuk"></div>
				<div id="gyeongnam"></div>
				<div id="daegu"></div>
				<div id="busan"></div>
				<div id="ulsan"></div>
				<div id="jeju"></div>
			</div>
			<div class="col-md-3 cityExplain"></div>
		</div>


		<div class="areasearchBtn">
			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getSeoulImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getSeoulImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getSeoulImage.jpg'" class='imgBtn'>
				</a>
			</div>
			
			<div class="col-md-3 innerAreaTab">
			
				<a href="#">
					<img src="/resources/image/innerTravel/getGyunggiImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getGyunggiImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getGyunggiImage.jpg'" class='imgBtn'>
				</a>
			</div>
			
			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getGangwonImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getGangwonImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getGangwonImage.jpg'" class='imgBtn'>
				</a>
			</div>
			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getIncheonImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getIncheonImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getIncheonImage.jpg'" class='imgBtn'>
				</a>
			</div>
			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getChungnameImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getChungnameImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getChungnameImage.jpg'" class='imgBtn'>
				</a>
			</div>
			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getDaejunImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getDaejunImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getDaejunImage.jpg'" class='imgBtn'>
				</a>
			</div>
			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getChungbukImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getChungbukImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getChungbukImage.jpg'" class='imgBtn'>
				</a>
			</div>
 
			<div class="col-md-3 innerAreaTab plusDiv">
				<a href="javascript:void(0);" onclick="plusRegion(this);">
				   <div class="changeRegionBtn">
						<img src="/resources/image/innerTravel/plusDiv.jpg"  class='imgBtn'>
				   </div>
				   
				   <div class="changeRegionDiv">
					<img src="/resources/image/innerTravel/getChungbukImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getChungbukImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getChungbukImage.jpg'" class='imgBtn'>
				   </div>
				  
				   
				</a>
			</div>
			



	 <div class="row">
		<div class="col-md-12 plusRegion">
			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getChungbukImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getChungbukImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getChungbukImage.jpg'" class='imgBtn'>
				</a>
			</div>
 
 
 			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getChungbukImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getChungbukImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getChungbukImage.jpg'" class='imgBtn'>
				</a>
			</div>
 
 
 			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getChungbukImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getChungbukImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getChungbukImage.jpg'" class='imgBtn'>
				</a>
			</div>
 
 
 			<div class="col-md-3 innerAreaTab">
				<a href="#">
					<img src="/resources/image/innerTravel/getChungbukImage.jpg" onmouseover="this.src='/resources/image/innerTravel/getChungbukImageClick.jpg'" onmouseout="this.src='/resources/image/innerTravel/getChungbukImage.jpg'" class='imgBtn'>
				</a>
			</div>
 		</div>
	</div>




			
			
		</div>
		
	 
			
	</div>
</div>

<jsp:include page="../template/footer.jsp" flush="true" />
