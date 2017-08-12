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

	var id = $("#id").val();
	var password = $("#password").val();
	var password2 = $("#password2").val();
	var name = $("#name").val();
	var nickname = $("#nickname").val();
	var phone = $("#phone").val();
    var gender = $(":input:radio[name=gender]:checked").val();
	
	if(!phone.length <=0 ){
		phone = phone.replace("-","");
	}
	phone = phone.replace("-","");
	var email = $("#email").val();

	if(id == '' || id.length <=0){
		alert("아이디를 입력해주세요");
		return false;
		
	}else if(password == '' || password.length <=0){
		alert("비밀번호를 입력해주세요");
		return false;
		
	}else if(password2 == '' || password2.length <=0){
		alert("비밀번호 확인란을 입력해주세요");
		return false;
	}else if(name == '' || name.length <=0){
		alert("이름을 입력해주세요");
		return false;
		
	}else if(nickname == '' || nickname.length <=0){
		alert("닉네임을 입력해주세요");
		return false;
		
	}else if(phone =='' || phone.length <=0){
		alert("전화 번호를 입력해주세요");
		return false;
		
	}else if(email =='' || email.length<=0){
		alert("이메일을 입력해주세요");
		return false;
		
	}else if(password != password2 ){
		alert("비밀번호와 비밀번호 확인란이 일치하지 않습니다");
		return false;
	}
	
	
	
	
	
	 var regCheck = regChkfunction(id,password,phone,email);
	 if(regCheck == true){
		 var chkid = $("#chkid").val();
		 if(chkid =='Y'){
			 $("#signUp").attr("action", "/insertProc");
			 $("#signUp").submit();
		 }else{
			 alert("회원가입 중복체크를 반드시 해주세요");
			 return false;
		 }
		return false; 
	 }
}


//정규식 체크
function regChkfunction(id,password,phone,email){
	var result = true;
	var idRegExp = /^[a-z]+[a-z0-9]{5,19}$/g;
	var passwordRegExp =/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/ ;
	var emailRegExp=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;;
	var phoneRegExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	if( !idRegExp.test( id ) ) {
        alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
        result = false;
    }
	
	//password
	if(!passwordRegExp.test(password)){
		alert("비밀번호는 영문자,소문자,특수문자 혼합으로 8~15자리 수 안에 해주세요");
		result = false;
    }
	
	//email
	if(!emailRegExp.test(email)){
		alert("이메일 형식에 맞춰서 입력해주세요");
		result = false;
    }   
	//phone
	if(!phoneRegExp.test(phone)){
 			alert("핸드폰 양식에 맞춰서 입력해주세요");
			result = false;
	}
    return result;

}



	`	`
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
				$("#chkid").val("Y");

			}else{
				alert(data.retMsg);
				$("#id").val("");
				$("#chkid").val("Y");

			}
		},
		error : function(request, status, error) {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});
}
