$(function() {
	
	var menuFidx = 0;
	var menuSidx = 0;
	$(".trafficTicket").click(function() {
		menuFidx = Number(menuFidx);
		var thisId = $(this).attr("id");
		if (thisId == "trafficMenu") {
			if (menuFidx % 2 == 0) {
				$(this).next().slideDown("slow");
				menuFidx++;
			} else {
				$(this).next().slideUp("slow");
				menuFidx++;
			}
		} else if (thisId == "accomMenu") {
			if (menuSidx % 2 == 0) {
				$(this).next().slideDown("slow");
				menuSidx++;
			} else {
				$(this).next().slideUp("slow");
				menuSidx++;
			}
		}

	});
	

 });

function itemEnroll() { 
	var dhtml = "";
		dhtml += "<form name='itemMarketForm' id='itemMarketForm' method='post' enctype='multipart/form-data'>";
		dhtml += "<div class='menuWrite'>";
		dhtml += "<div class='menuWriteTitle'>";
		dhtml += "<div class='col-md-2 menutitleType'>";
		dhtml += "<select class='menuWriteType' name='marketMethodType' id='menuWriteType' onchange='menuWriteTypeChange();'><option value=''>전체</option><option value='1'>티켓양도</option><option value='2'>물품마켓</option></select>";
		dhtml += "</div>";
		dhtml += "<div class='col-md-9 menutitle'>";
		dhtml += "<input type='text' class='form-control' name='marketItemTitle' id='itemTitle'>";
		dhtml += "</div>";
		dhtml += "<div class='col-md-1 menuCancleBtn'>";
		dhtml += "<button type='button' class='closeBtn' onclick='cancleDiv();'>";
		dhtml += "<span>X</span>";
		dhtml += "</button>";
		dhtml += "</div>";
		dhtml += "</div>";
		dhtml += "<div class='menuWriteContent'>";
		dhtml += "<div class='col-md-12 detaildiv'>";
		dhtml += "<div class='AddfileshowArea'>";
//		dhtml += "<span class='col-md-2 fileshowTitle'>첨부파일 </span>";
// 		dhtml += "<input type='hidden' class='fileshowName' name='imgFileName'/>";
		dhtml += "</div>";
		dhtml += "<div class='AddfTrafficShowArea' style='display:none;'>";
		dhtml += "<div class='col-md-2'><select class='ticketType' id='ticketType' name='marketItemTicketType' onchange='onchangeType();'><option value='1'>편도</option><option value='2'>왕복</option></select></div>";
		dhtml += "<div class='col-md-10 oTrips'><span class='oTripstartTime'>출발시간:</span><input type='text' name='oTripStartDay' id='oTripstartDay'/></div>";
		dhtml += "<div class='col-md-10 rTrip' style='display:none;'><span class='rTripStartTime'>출발시간:</span><input type='text' name='rTripStartDay' id='rTripStartDay'/><span class='rTripEndTime'>도착시간:</span><input type='text' id='rTripEndDay' name='rTripEndDay'/></div></div>";
		dhtml += "</div>";
		dhtml += "<div class=''>";
//		dhtml += "<textarea rows='18' cols='119' id='itemContent' name='marketitemmContent'></textarea>";
		dhtml += "<div id='textAreaDiv' contentEditable='true'  class='textAreaDiv'></div>";
		dhtml += "</div>";
		dhtml += "<div class='menuWriteFile'>";
		dhtml += "<div class='filebox'>";
		dhtml += "<label>";
		dhtml += "<i class='fa fa-camera'>";
		dhtml += "<input type='file' class='imgFile' name='marketItemFileValue1' style='display: none;' onchange='addFileChange();'></i></label>";
		dhtml += "<label><i class='fa fa-car' onclick='carClick();'></i></label>";
		dhtml += "</div>";
		dhtml += "</div>";  
	 	dhtml += "</div>";
		dhtml += "<div class='btnBox'>";
		dhtml += "<button type='button' class='btn btn-success' onclick='submitForm();'>등록</button>";
	 	dhtml += "</div>";
	 	dhtml += "</div>";
//	 	dhtml += "<div id='addFilName' style='display: none;'>";
	 	dhtml += "<div id='addFilName'>";
	 	dhtml += "</div>";
	 	dhtml += "</form>";
	 	
	 	
	 	
 	var windowW = 1100; // 창의 가로 길이
	var windowH = 600; // 창의 세로 길이
	var left = Math.ceil((window.screen.width - windowW) / 2);
	var top = Math.ceil((window.screen.height - windowH) / 2)-80;

	$.blockUI({
		message : dhtml,
		css : {
			top : top,
			left : left,
			width : 'auto',
			height: 'auto', 
			cursor: 'auto',
			border : 'none',
			position: 'absolute'
 		}
	
	});
}

function onchangeType() {
	var type = $("#ticketType option:selected").val();
	if (type == '1') {
		$(".oTrips").show();
		$(".rTrip").hide();
		$("#oTripstartDay").datepicker();

	} else if (type == '2') {
		$(".oTrips").hide();
		$(".rTrip").show();
		$("#rTripStartDay").datepicker();
		$("#rTripEndDay").datepicker();

	} else {
		$(".oTrips").show();
		$(".rTrip").hide();
		$("#oTripstartDay").datepicker();

	}

}


function menuWriteTypeChange(){
	var type = $("#menuWriteType option:selected").val();
	if(type =='1'){
		$(".AddfTrafficShowArea").show();  
		$(".oTrips").show();
		$(".rTrip").hide();
		$("#oTripstartDay").datepicker();
		$(".fa-car").show();
	}else if(type=='2'){
		$(".fa-car").hide();
		$(".AddfTrafficShowArea").hide();  
	}else{
		$(".fa-car").hide();
		$(".AddfTrafficShowArea").hide();  
			
	}
}


function cancleDiv() {
	$.unblockUI();
}
function carClick() {
	$(".AddfTrafficShowArea").show();
	$("#oTripstartDay").datepicker();
}
function addFileChange(){
  	var form = $('form')[0]; // You need to use standard javascript object here
	var formData = new FormData(form);
	 $.ajax({
		url : "/fileUpload",
		   processData: false,
           contentType: false,
           data: formData,
           type: 'POST',
           success : function(data) {
         	   if(data.retSign =="Y"){
         		   var imgHtml = "<div class='imgEditSection'><a href='#' class='deleteEditImg'>취소하기</a><img src='/resources/upload/"+data.retImgFile+"'/ class='editImg'><br/></div>";
          		   $("#textAreaDiv").append(imgHtml);
 
          		   var inputHtml = "<input type='text'  value='"+data.retImgFileIdx+"'/>";
          		   $("#addFilName").append(inputHtml);
          		   
         		   $("input[name='marketItemFileValue1']").val('');
        	   }else{
	        	   alert("이미지 처리중 오류가 발생했습니다.관리자에게 문의해주세요");
        	   }
		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});
}

function submitForm(){
	var menuWriteType  = $("#menuWriteType option:selected").val();
	var itemTitle      = $("#itemTitle").val();
 	var ticketType     = $("#ticketType option:selected").val();
	var oTripstartDay  = $("#oTripstartDay").val();
	var rTripStartDay  = $("#rTripStartDay").val();
	var rTripEndDay    = $("#rTripEndDay").val();
	var itemContent    = $("#textAreaDiv").html();
 	if(itemTitle ==''){
		alert("제목은 입력해주세요");
		return false;
	}
 	
	if(menuWriteType == '1'){
		if(ticketType == '1'){
		   if(oTripstartDay ==''){
			   alert("날짜를 입력해주세요");
			   return false;
		   }else{
			   $("#rTripStartDay").val('');
			   $("#rTripEndDay").val('');
		   }
		}else{
			if(rTripStartDay =='' || rTripEndDay ==''){
				   alert("날짜를 입력해주세요");
				   return false;
			}else{
				   $("#oTripstartDay").val('');
			}
		}
	    var contentInputHtml = "<input type='text' name='marketItemContent' value='"+itemContent+"'/>";
		
	    $("#itemMarketForm").append(contentInputHtml);
		
		
		var inputImgIdxList = "";
		$("#addFilName").children().each(function(i,e){
			$(this).attr("name", "imgfile["+i+"]"); 
  		});
		
		
	}else if(menuWriteType == ''){
		alert("타입을 선택해주세요");
		return false;
	}
	$("#itemMarketForm").attr('action','/itemWriteAction');
	$("#itemMarketForm").attr("enctype","multipart/form-data");
 	$("#itemMarketForm").submit();
}

