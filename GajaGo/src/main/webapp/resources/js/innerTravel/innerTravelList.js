$(function() {
	var initBtn = $("#initBtn").val();
	initCheck(initBtn);
	

	$(".listSortTab > ul > li").click(function() {
		$(".listSortTab > ul > li").each(function() {
			var isExistClass = $(this).hasClass("active");
			if (isExistClass) {
				$(this).removeClass("active");
			}
		});

		$(this).addClass("active");
	});

	
	 


});
//init 되고 난뒤에 뿌려야 되니까 

 

function detailView(contentId) {
	$("#contentId").val(contentId);
	$("#detail").attr("action", "/innerTravelDetail");
	$("#detail").submit();
}

function initCheck(initBtnVal) {
	if (initBtnVal == 'y') {
		$(".changeRegionBtn").hide();
		$(".changeRegionDiv").show();
		$(".plusRegion").show();

	} else {
		$(".changeRegionDiv").hide();
		$(".changeRegionBtn").show();
		$(".plusRegion").hide();

	}

}
 

function plusRegion(obj) {
	var $this = obj;
	$("#initBtn").val("y");
	var initBtn = $("#initBtn").val();
	initCheck(initBtn);
}
 
function makelist(num) {
	var areaResult = num.indexOf('a');
	var cateResult = num.indexOf('c');
	var jData = "";
	// 지역코드가 있을때
	if (areaResult >= 0) {
		$("#areaCode").val(num);

		var cateCode = $("#cateCode").val();
		var areaCode = num.replace("a", "");
		// 카테고리코드가 없을때

		if (cateCode == '' || cateCode.length <= 0) {
			jData = {
				"areaCode" : areaCode
			};
			// 카테고리코드가 있을때
		} else {
			cateCode = cateCode.replace("c", "");
			$("#cateCode").val(cateCode);
			jData = {
				"areaCode" : areaCode,
				"cateCode" : cateCode
			}
		}

	}

	if (cateResult >= 0) {
		$("#cateCode").val(num);
		var areaCode = $("#areaCode").val();
		var cateCode = num.replace("c", "");
		$("#cateCode").val(cateCode);
		if (areaCode == '' || areaCode.length <= 0) {
			jData = {
				"cateCode" : cateCode
			};
			// 지역코드가 있을때
		} else {
			areaCode = areaCode.replace("a", "");
			jData = {
				"areaCode" : areaCode,
				"cateCode" : cateCode
			};
		}
	}

	$.ajax({
		url : "/innerListProc",
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		type : "post",
		data : jData,
		success : function(data) {
			if (data.retSign == 'Y') {
				var dhtml = "";
				for (var i = 0; i < data.retData.length; i++) {
					var firstimage1 = 1;
					dhtml += "<div class='col-md-3 listItem'>";
					dhtml += "<div class='col-md-12 imgDiv'>";
					dhtml += "<a href='javascript:void(0);' onclick='detailView("+ data.retData[i].contentid + ");'>";
					dhtml += "<img src='" + data.retData[i].firstimage + "' class='listItemImg'>";
					dhtml += "</a>";
					dhtml += "</div>";
					dhtml += "<div class='col-md-12 expDiv'>";
					title = data.retData[i].title.replace("(", "<br/>(");
					dhtml += "<span class='listItemTitle'>" + title + "</span>";
					dhtml += "</div>";
					dhtml += "</div>";
					dhtml += "</div>";

				}

				$(".listSort").html(dhtml);
			} else {
				alert(data.retMsg);
			}
		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "error:"+ error);
		}
	});
 }
