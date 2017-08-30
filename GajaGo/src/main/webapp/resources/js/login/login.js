$(function() {

});

function login() {

	var id = $("#id").val();
	var password = $("#password").val();
	var jData = {
		"id" : id,
		"password" : password
	};

	$.ajax({
		url : "/loginChkProc",
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		type : "post",
		data : jData,
		success : function(data) {
			if (data.retSign == 'NY') {
				console.log(data.retData);
				alert(data.retData.id+"님 반갑습니다.");
				$("#mainName").val(data.retData.id);
				$("#mainProfileImg").val(data.retData.profilePic);
          	 	$("#mainData").attr("action", "/main");
           	 	$("#mainData").submit();
			} else {
				alert(data.retMsg);
			}
		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});
}