<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/innerTrevel/innerTrevel.css">
<jsp:include page="../template/includeResource.jsp" flush="true" />
<script src="/resources/js/innerTravel/raphael_min.js"></script>
<script src="/resources/js/innerTravel/raphael_path_s.korea.js"></script>
<script src="/resources/js/innerTravel/innerTrevel.js"></script>

</head>
<jsp:include page="../template/header.jsp" flush="true" />

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


		<div class="col-md-12 areasearchBtn">
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			</div>
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			</div>
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			</div>
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			
			</div>
			
			
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			
			</div>
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			
			</div>
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			
			</div>
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			</div>
			
			
			
			
			<div class="col-md-3 innerAreaTab">
				<img src="sssssssssssss" class='imgBtn'>
			</div>
			
			
			  
		</div>


 
		
	</div>
</div>


<jsp:include page="../template/footer.jsp" flush="true" />
