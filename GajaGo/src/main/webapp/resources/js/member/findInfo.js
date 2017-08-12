$(function() {

});

function findId() {

	var findIdName = $("#findIdName").val();
	var findIdEmail = $("#findIdEmail").val();
     
	if (findIdName == '' || findIdName.length <= 0) {
		alert("이름을 입력해주세요");
		return false;
	} else if (findIdEmail == '' || findIdEmail.length <= 0) {
		alert("메일주소를 입력해주세요");
		return false;
	}
	var jData = {"name":findIdName,"email":findIdEmail};
	$.ajax({
		url : "/findId",
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		type : "post",
		data : jData,
		success : function(data) {
			if(data.retSign =='Y'){
				alert("찾으시는 ID는 "+data.retData.id+"입니다");
			}else{
				alert(data.retMsg);
			}
		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});

	
	
	
}
 function findPwd(){
		var findPwId = $("#findPwId").val();
		var findPwName = $("#findPwName").val();
		var findPwEmail = $("#findPwEmail").val();
		
		
		if (findPwId == '' || findPwId.length <= 0) {
			alert("아이디를 입력해주세요");
			return false;
		} else if (findPwName == '' || findPwName.length <= 0) {
			alert("이름을 입력해주세요");
			return false;
		}  else if (findPwEmail == '' || findPwEmail.length <= 0) {
			alert("메일주소를 입력해주세요");
			return false;
		}
		var jData = {"id":findPwId,"name":findPwName,"email":findPwEmail};
 
		$.ajax({
			url : "/findPwd",
			dataType : "json",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			type : "post",
			data : jData,
			success : function(data) {
				if(data.retSign =='Y'){
					alert(data.retMsg);
					location.href="/login";
				}else{
					alert(data.retMsg);
				}
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "error:" + error);
			}
		});
 
 
 
 }

 
 
 