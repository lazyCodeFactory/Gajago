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
		dhtml += "<div class='menuWrite'>";
		dhtml += "<div class='menuWriteTitle'>";
		dhtml += "<div class='col-md-2 menutitleType'>";
		dhtml += "<select class='menuWriteType'>";
		dhtml += "<option value=''>잡담</option>";
		dhtml += "</select>";
		dhtml += "</div>";
		dhtml += "<div class='col-md-9 menutitle'>";
		dhtml += "<input type='text' class='form-control' id='usr'>";
		dhtml += "</div>";
		dhtml += "<div class='col-md-1 menuCancleBtn'>";
		dhtml += "<button type='button' class='closeBtn' onclick='cancleDiv();'><span>X</span></button>";
		dhtml += "</div>";
		dhtml += "</div>";
		dhtml += "<div class='menuWriteContent'>";
		dhtml += "<textarea rows='18' cols='119'></textarea>";
		dhtml += "<div class='menuWriteFile'>";
		dhtml += "<div class='filebox'>";
		dhtml += "<label><i class='fa fa-camera'><input type='file' class='file' style='display:none;'></i></label>";
		dhtml += "<label><i class='fa fa-car'></i></label>";
		dhtml += "<label><i class='fa fa-calculator'></i></label>";
		dhtml += "</div>";
	 	dhtml += "</div>";
		dhtml += "</div>";
		dhtml += "</div>";

 	
	var windowW = 867; // 창의 가로 길이
	var windowH = 600; // 창의 세로 길이
	var left = Math.ceil((window.screen.width - windowW) / 2);
	var top = Math.ceil((window.screen.height - windowH) / 2);

	$.blockUI({
		message : dhtml,
		css : {
			top : top,  
			left : left,
			width : '867px'
		}
	});
}
function cancleDiv(){
	$.unblockUI();
}