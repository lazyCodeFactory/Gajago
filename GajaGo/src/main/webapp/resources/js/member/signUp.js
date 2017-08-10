$(function() {
	$(".seeA").click(function(){
		var idName = $(this).parent().attr("id");
			var	dhtml ="<textarea rows='5' cols='80'>";
		 		dhtml += idName;
		 		dhtml += "</textarea>";
				
				var chkClickVal = $(this).before().val();
				  if(chkClickVal == 'Y'){
					  $(this).next().html('');
					  $(this).before().val("N");
				  }else{
					  $(this).next().html(dhtml);
					  $(this).before().val("Y");
						    
				  }
	})
	
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
