$(function() {
	$(".mapsearchBtn").hide();
	$(".areasearchBtn").hide();
	searchType('1');

	var initBtn =$("#initBtn").val();
	initCheck(initBtn);
	
	
});

function initCheck(initBtnVal){
	if(initBtnVal == 'y'){
		$(".changeRegionBtn").hide();
		$(".changeRegionDiv").show();
		$(".plusRegion").show();

	}else{
	 	$(".changeRegionDiv").hide();
		$(".changeRegionBtn").show();
		$(".plusRegion").hide();
		
	}
	
}


function searchType(obj){
	var type = obj;
	if(type=='1'){
		$(".mapsearchBtn").show();
		$(".areasearchBtn").hide();
		
	}else{
		$(".mapsearchBtn").hide();
		$(".areasearchBtn").show();
	}
}

function plusRegion(obj){
	var $this = obj;
	$("#initBtn").val("y");
	var initBtn =$("#initBtn").val();
	initCheck(initBtn);

}

