 function statusChangeCallback(response) {
     if (response.status === 'connected') {
     } else { }
  }
 
 
window.fbAsyncInit = function() {
	FB.init({
		appId : '1916090195272061',
		cookie : true, // enable cookies to allow the server to access 
		xfbml : true, // parse social plugins on this page
		version : 'v2.8', // use graph api version 2.8
 
	});
	
	FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  });
};

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id))
		return;
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function operator() {

   FB.login(function(response){
          if (response.status === 'connected') {
        	  facebookLoginGetInfo();
         } else {
             
         }
     })
}



function facebookLoginGetInfo() {
    FB.api('/me',{locale : 'en_US'},
           function(response) {
    			console.log(response);
	    		var userId = response.id;
	    		var email = response.email;
	    		var nickname = response.first_name+response.last_name
	    		var gender =response.gender;
	    		var age_range = response.age_range;
	    		var profile = response.picture.data.url;
	    		var jData = { "snsUserId" : userId ,"snsType" : "F" ,"profilePic":profile ,"nickname":nickname};
	    		
	    		 $.ajax({
	    				url : "/loginChkProc",
	    				dataType : "json",
	    				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
	    				type : "post",
	    				data : jData,
	    				success : function(data) {
                         if (data.retSign == 'N') {
                        	 alert(data.retMsg);
                        	 return false;
                         }else if(data.retSign == 'NY' || data.retSign == 'SY'){
                        	 $("#mainName").val(nickname);
                        	 $("#mainProfileImg").val(profile);
                			 $("#mainData").attr("action", "/main");
                        	 $("#mainData").submit();
                          }
                     },
                     error : function(e) {
                         console.log(e);
                     }
             });
    	},
     {
         locale : 'en_US',
         fields : 'id, email , first_name ,last_name, age_range, picture ,gender, verified'
     });
}
