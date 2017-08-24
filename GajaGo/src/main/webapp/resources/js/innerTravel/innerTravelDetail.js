$(function() {
 	$(".innerTravelExplTab > ul > li").click(function() {
		$(".innerTravelExplTab > ul > li").each(function() {
			var isExistClass = $(this).hasClass("active");
			if (isExistClass) {
				$(this).removeClass("active");
			}
		});

		$(this).addClass("active");
	})

	$('.bxslider').bxSlider({
		mode : 'horizontal',
		auto : false
	});
	$(".courseWriteEach").each(function(){
		if($(this).attr("id") == 'course0'){
			$(this).show();
		}else{
			$(this).hide();
		}
	});
	viewTab("1");


});
 
var map;
function initMap() {
	var mapX = $("#mapx").val();
	var mapY = $("#mapy").val();
	mapX = Number(mapX);
	mapY = Number(mapY);

	map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : mapY,
			lng : mapX
		},
		zoom : 10
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

	} else if (type == '2') {
		$(".containerImg").hide();
		$(".containerMap").show();
		initMap();
	} 
}

 function onWrite(innerTravelQnaContentId){
	 var innerTravelQnaWriter = "tigggi";
	 var innerTravelQnaContent = "xxxxxxxxxxxxxxxx";
  	 var jData = {"innerTravelQnaWriter":innerTravelQnaWriter,"innerTravelQnaContent":innerTravelQnaContent,"innerTravelQnaContentId":innerTravelQnaContentId};
	 
		$.ajax({
			url : "/innerCommInsertProc",
			dataType : "json",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			type : "post",
			data : jData,
			success : function(data) {
				if (data.retSign == 'Y') {
					innerTravelQnaList(innerTravelQnaContentId);

 				} else {
					alert(data.retMsg);
				}
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "error:"+ error);
			}
		});
	 
	 function innerTravelQnaList(innerTravelQnaContentId){
		 var jData ={"innerTravelQnaContentId":innerTravelQnaContentId};
		 
		 $.ajax({
				url : "/innerCommSelectProc",
				dataType : "json",
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				type : "post",
				data : jData,
				success : function(data) {
					if (data.retSign == 'Y') {
 						for(var i=0;i<data.retData.length;i++){
 							console.log(data.retData[i]);
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
 }
