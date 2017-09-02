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
 

 	

 
//function initMap() {
//	var mapX = $("#mapx").val();
//	var mapY = $("#mapy").val();
//	var title = $("#title").val();
//	mapX = Number(mapX);
//	mapY = Number(mapY);
//	
//	var myLatLng = {lat: mapY, lng: mapX};
//
//	var map = new google.maps.Map(document.getElementById('map'), {
//		zoom: 15,
//		center: myLatLng
//	});
//	var marker = new google.maps.Marker({
//	    position: myLatLng,
//	    map: map,
//	    title: title
//	});
// 
// }

function getLocation() {
	  if (navigator.geolocation) { // GPS를 지원하면
		  navigator.geolocation.getCurrentPosition(function(position) {
 	      var mylat = position.coords.latitude;
	      var mylong = position.coords.longitude;
	      findLoad(mylat,mylong);
	    }, function(error) {
	      console.error(error);
	    }, {
	      enableHighAccuracy: false,
	      maximumAge: 0,
	      timeout: Infinity
	    });
	  } else {
	    alert('GPS를 지원하지 않습니다');
	  }
	}


function findLoad(mylat,mylong){
	var mapX = $("#mapx").val();
	var mapY = $("#mapy").val();
	var html = "http://map.naver.com/index.nhn";
	html += "?slng="+mylong;
	html += "&slat="+mylat;
	html += "	&stext=접속지점";
	html += "	&elng="+mapX;
	html += "	&elat="+mapY;
	html += "	&etext=도착지이름";
	html += "	&menu=route";
	html += "	&pathType=1";
	window.open(html,"_blank");
}



function initMap() {
	var map = null;
	var mapX = $("#mapx").val();
	var mapY = $("#mapy").val();
    map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(mapY, mapX),
        zoom: 10
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
	 var innerTravelQnaWriter = $("#id").val();
	 var innerTravelQnaContent = $("#qnaTextArea").val();
 	 var innerTravelQnaprofilePic = $("#profilePic").val();

	 
	 
  	 var jData = {"innerTravelQnaWriter":innerTravelQnaWriter,"innerTravelQnaContent":innerTravelQnaContent,"innerTravelQnaContentId":innerTravelContentId,"innerTravelQnaprofilePic":innerTravelQnaprofilePic};
		$.ajax({
			url : "/innerCommInsertProc",
			dataType : "json",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			type : "post",
			data : jData,
			success : function(data) {
				if (data.retSign == 'Y') {
  					innerTravelQnaList(innerTravelContentId);
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
 	 
		 var jData ={"innerTravelQnaContentId":innerTravelQnaContentId};
		 var id = $("#id").val();
 		 $.ajax({
				url : "/innerCommSelectProc",
				dataType : "json",
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				type : "post",
				data : jData,
				success : function(data) {
					if (data.retSign == 'Y') {
 						var dhtml="";
  							dhtml+="<table class='table table-filter'><tbody>";
 						for(var i=0;i<data.retData.length;i++){
 	 							dhtml+="<tr>";
	 							dhtml+="<td>";
	 							dhtml+="<div class='media'>";
	 							dhtml+="<input type='hidden' name='idx' id='idx' value="+data.retData[i].innerTravelQnaIdx+">";
	 							dhtml+="<a href='#' class='pull-left'>";
	 							dhtml+="<img src="+data.retData[i].innerTravelQnaprofilePic+" class='media-photo'>";
	 							dhtml+="</a>";
	 							dhtml+="<div class='media-body'>";
	 							dhtml+="<span class='media-meta pull-right'>"+data.retData[i].innerTravelQnaWriteTime+"</span>";
	 							dhtml+="<h4 class='title'>";
	 							dhtml+="제목";
	 							dhtml+="<span class='pull-right pagado'>"+data.retData[i].innerTravelQnaWriter+"</span>";
	 							dhtml+="</h4>";
	 							dhtml+="<p class='summary'>"+data.retData[i].innerTravelQnaContent+"</p>";
	 							console.log(i+"번쨰글쓴이"+data.retData[i].innerTravelQnaWriter+"글쓴내용"+data.retData[i].innerTravelQnaContent);
	 							console.log("현재로그인아이디 "+id);
	 							
	 							if(id == data.retData[i].innerTravelQnaWriter){
	 								dhtml+="<button type='button'  id='deleteBtn' class='closebtn' onclick='deleteTwitConfirm("+data.retData[i].innerTravelQnaIdx+","+innerTravelQnaContentId+");'>버튼</button>";
	 							}
	 							
	 							
	 							dhtml+="</div>";
	 							dhtml+="</div>";
	 							dhtml+="</td>";
	 							dhtml+="</tr>";
  						}
  							dhtml+="</tbody></table>";
 							$(".qnaCommunityBoard").html(dhtml);
 
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
		var contentId= $("#innerTravelQnaContentId").val();
		   if(type=='1'){
			   $(".qnaCommunity").hide();
		   }else if(type=='2'){
			   $(".qnaCommunity").hide();
		   }else if(type=='3'){
			   $(".qnaCommunity").hide();
		   }else if(type=='4'){
			   $(".qnaCommunity").show();
			   innerTravelQnaList(contentId);
		   } 
		}	 
	 
	 
		function deleteTwitConfirm(idx,innerTravelContentId){
 			$.blockUI({ 
 				message:"<div class='layoutForm'><div class='deleteTitle'> 삭제하시겠습니까?</div><div class='deleteBtnArea'><button type='button' onclick='deleteTwit("+idx+","+innerTravelContentId+");'>삭제</button><button type='reset' onclick='removeModal();'>취소</button></div></div>"
			});
		}
	 
	    function deleteTwit(idx,innerTravelContentId){

	    	 var jData ={"innerTravelQnaIdx":idx,"innerTravelQnaContentId":innerTravelContentId };
 
	 		 $.ajax({	
					url : "/innerCommDeleteProc",
					dataType : "json",
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					type : "post",
					data : jData,
					success : function(data) {
						if (data.retSign == 'Y') {
							alert(data.retMsg);
				 	    	$.unblockUI();
							innerTravelQnaList(innerTravelContentId); 
		 				} else {
							alert(data.retMsg);
						}
					},
					error : function(request, status, error) {
						console.log("code:" + request.status + "\n" + "error:"+ error);
					}
				});
	    	
	    	
	    	
	    	
	    	
	    }
	    function removeModal(){
 	    	$.unblockUI();
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
		
		
	
		
		
 