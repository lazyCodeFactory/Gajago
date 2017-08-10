$(function() {

});
function signUp() {
	// 체크

	$("#signUp").attr("action", "/insertProc");
	$("#signUp").submit();
}

function checkSameID() {
	var id = $("#id").val();
	var jsonData = {
		"id" : id
	};

	$.ajax({
		url : "/checkSameId",
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		type : "post",
		data : jsonData,
		success : function(data) {
			if(data.retSign =='Y'){
				alert(data.retMsg);
			}else{
				alert(data.retMsg);
				$("#id").val("");
			}
		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});
}
