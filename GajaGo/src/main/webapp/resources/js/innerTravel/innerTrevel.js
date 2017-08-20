$(function() {
	$(".mapsearchBtn").hide();
	$(".areasearchBtn").hide();
	searchType(1);
});

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