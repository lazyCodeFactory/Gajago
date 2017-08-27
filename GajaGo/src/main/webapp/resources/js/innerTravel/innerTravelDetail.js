$(function() {
// 상단탭
 	$(".innerTravelExplTab > ul > li").click(function() {
		$(".innerTravelExplTab > ul > li").each(function() {
			var isExistClass = $(this).hasClass("active");
			if (isExistClass) {
				$(this).removeClass("active");
			}
		});

		$(this).addClass("active");
	})
//	 아래 커뮤니티 부분 탭
 	$(".communityTab > ul > li").click(function() {
		$(".communityTab > ul > li").each(function() {
			var isExistClass = $(this).hasClass("active");
			if (isExistClass) {
				$(this).removeClass("active");
			}
		});
		$(this).addClass("active");
	})
 

$(".courseWriteEach").each(function(){
		if($(this).attr("id") == 'course0'){
			$(this).show();
		}else{
			$(this).hide();
		}
	});	
	
//코스 이미지 부분	
	$('.bxslider').bxSlider({
		mode : 'horizontal',
		auto : false
	});
 
	 
	
	
	viewTab("1");
	communityTab("1");
});
 



function initMap() {
	var mapX = $("#mapx").val();
	var mapY = $("#mapy").val();
	var title = $("#title").val();
	mapX = Number(mapX);
	mapY = Number(mapY);
	
	var myLatLng = {lat: mapY, lng: mapX};

	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: 15,
		center: myLatLng
	});
	var marker = new google.maps.Marker({
	    position: myLatLng,
	    map: map,
	    title: title
	});
 
 }

function searchType(obj) {
	var type = obj;
	if (type == '1') {
		$(".mapsearchBtn").show();
		$(".areasearchBtn").hide();

	} else {
		$(".mapsearchBtn").hide();
		$(".areasearchBtn").show();
	}
}





 
 function viewTab(num) {
	var type = num;
	if (type == '1') {
		$(".containerImg").show();
		$(".containerMap").hide();
		$(".travOverview").hide();
		$(".innerTravelroomInfo").hide();
		$(".foodMenuInfo").hide();
		
	} else if (type == '2') {
		$(".containerImg").hide();
		$(".travOverview").hide();
		$(".innerTravelroomInfo").hide();
		$(".foodMenuInfo").hide();
		$(".containerMap").show();
		initMap();
	}else if(type == '3'){
		$(".containerImg").hide();
		$(".containerMap").hide();
		$(".travOverview").show();
		$(".innerTravelroomInfo").hide();
		$(".foodMenuInfo").hide();
			
	}else if(type == '4'){
		$(".containerImg").hide();
		$(".containerMap").hide();
		$(".travOverview").hide();
		$(".innerTravelroomInfo").show();
		var size = $("#roomimg1Size").val();
		$("#subdetailimgLength").val(size);
		
	}else if(type=='5'){
		$(".containerImg").hide();
		$(".containerMap").hide();
		$(".travOverview").hide();
		$(".innerTravelroomInfo").hide();
		$(".foodMenuInfo").show();
		subImgClick('0');
	}
}

 function onWrite(innerTravelContentId){
	 var innerTravelQnaWriter = "tigggi";
	 var innerTravelQnaContent = $("#qnaTextArea").val();
  	 var jData = {"innerTravelQnaWriter":innerTravelQnaWriter,"innerTravelQnaContent":innerTravelQnaContent,"innerTravelQnaContentId":innerTravelContentId};
		$.ajax({
			url : "/innerCommInsertProc",
			dataType : "json",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			type : "post",
			data : jData,
			success : function(data) {
				if (data.retSign == 'Y') {
					$("#writeBtnInit").val("Y");
					$("#addBtnInit").val("N");
					innerTravelQnaList(innerTravelQnaContentId);

 				} else {
					alert(data.retMsg);
				}
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "error:"+ error);
			}
		});
	 
	
 }
		
	 function innerTravelQnaList(innerTravelQnaContentId){
 		 var writeBtnInit = $("#writeBtnInit").val();
		 var innerTravelQnaStartIdx = $("#innerTravelQnaPageIdx").val();
		 var addBtnInit = $("#addBtnInit").val();
			if(writeBtnInit =='Y' && addBtnInit!='Y'){
				addBtnInit='N';
				innerTravelQnaStartIdx=0;
			}else if(writeBtnInit =='Y'&& addBtnInit=='Y'){
				innerTravelQnaStartIdx = innerTravelQnaStartIdx;
				addBtnInit = addBtnInit;
			}
		 var jData ={"innerTravelQnaContentId":innerTravelContentId, "innerTravelQnaStartIdx" : innerTravelQnaStartIdx};
 
 		 $.ajax({
				url : "/innerCommSelectProc",
				dataType : "json",
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				type : "post",
				data : jData,
				success : function(data) {
					if (data.retSign == 'Y') {
						var dhtml="";
						if(addBtnInit == 'N'){
 							dhtml+="<table class='table table-filter'><tbody>";
 						}
						for(var i=0;i<data.retData.length;i++){
							if(i < data.retData.length-1){
	 							dhtml+="<tr>";
	 							dhtml+="<td>";
	 							dhtml+="<div class='media'>";
	 							dhtml+="<input type='text' name='idx' id='idx' value="+data.retData[i].innerTravelQnaIdx+">";
	 							dhtml+="<a href='#' class='pull-left'>";
	 							dhtml+="<img src='https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg' class='media-photo'>";
	 							dhtml+="</a>";
	 							dhtml+="<div class='media-body'>";
	 							dhtml+="<span class='media-meta pull-right'>"+data.retData[i].innerTravelQnaWriteTime+"</span>";
	 							dhtml+="<h4 class='title'>";
	 							dhtml+="제목";
	 							dhtml+="<span class='pull-right pagado'>"+data.retData[i].innerTravelQnaWriter+"</span>";
	 							dhtml+="</h4>";
	 							dhtml+="<p class='summary'>"+data.retData[i].innerTravelQnaContent+"</p>";
	 							dhtml+="</div>";
	 							dhtml+="</div>";
	 							dhtml+="</td>";
	 							dhtml+="</tr>";
							}else if(i == data.retData.length-1){
								innerTravelQnaStartIdx = Number(innerTravelQnaStartIdx)+9;
								$("#innerTravelQnaPageIdx").val(innerTravelQnaStartIdx);
								$("#innerTravelContentId").val(innerTravelContentId);
								dhtml+="<tr class='moreSeeArea'><td><button type='button' class='moreSeeBtn' id='moreSee' onclick ='innerTravelQnaList("+innerTravelQnaContentId+");'>더보기</button></td></tr>";

							}
  						}
						
						if(addBtnInit == 'N'){
 							dhtml+="</tbody></table>";
 						}
						
						if(addBtnInit == 'N'){
							$(".qnaCommunityBoard").html(dhtml);
							$("#addBtnInit").val("Y");
							
						}else{
							$(".moreSeeArea").hide();
							$(".table-filter > tbody").append(dhtml);
							$("#addBtnInit").val("Y");
							
						}
	 				} else {
						alert(data.retMsg);
					}
				},
				error : function(request, status, error) {
					console.log("code:" + request.status + "\n" + "error:"+ error);
				}
			});
	 }
	 function communityTab(obj){
			var type = obj;
		   if(type=='1'){
			   $(".qnaCommunity").hide();
			   
		   }else if(type=='2'){
			   $(".qnaCommunity").hide();
			   
		   }else if(type=='3'){
			   $(".qnaCommunity").show();
			   
		   }else if(type=='4'){
			   $(".qnaCommunity").hide();
			   
		   }
		}	 
	 
function subImgClick(param){
  	$(".foodMenuMain").each(function(){
  		var originalId = $(this).attr("id");
   		var paramId = "original"+param;
   		console.log(originalId);
   		console.log(paramId);
   		
 		if(originalId == paramId){
 			$("#"+originalId).show();
 		}else{
 			$("#"+originalId).hide();
 	 			
 		}
 	});
 		
 		
	}
 