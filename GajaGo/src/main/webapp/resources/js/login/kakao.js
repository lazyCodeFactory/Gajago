    Kakao.init('b4015b4d1ed4104a61bf5ece903fcd0f');
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        Kakao.API.request({
          url: '/v1/user/me',
          success: function(res) {
        	var userId = res.id;
            var kaccount_email = res.kaccount_email;
            var thumbnail_image = res.thumbnail_image;
            var snsType= "K";
    		var jData = {"snsUserId" : userId ,"snsType" : "K" ,"profilePic":thumbnail_image };

   		 $.ajax({
             type : "post",
             url : "/loginChkProc",
             data : jData,
             dataType : "json",
     		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
             success : function(data) {
            	    if (data.retSign == 'N') {
                   	 	alert(data.retMsg);
                   	 	return false;
                    }else if(data.retSign == 'NY' || data.retSign == 'SY'){
                   	 	$("#mainName").val(name);
                   	 	$("#mainData").attr("action", "/main");
                   	 	$("#mainData").submit();
                     }
            	 
             },error: function(e){
            	 console.log(e);
             }
             });
    		
         },
          fail: function(error) {
        	  console.log(JSON.stringify(error));
          }
        });
      },
      fail: function(err) {
        alert(JSON.stringify(err));
      }
    });
