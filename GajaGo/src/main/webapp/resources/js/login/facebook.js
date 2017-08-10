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
    FB.api('/me',{locale : 'ko_KR'},
           function(response) {
    			console.log(response);
	    		var userId = response.id;
	    		var email = response.email;
	    		var name = response.last_name  + response.first_name;
	    		var gender =response.gender;
	    		var age_range = response.age_range;
	    		var profile = response.picture.data.url;
	    		var jData = {"userId" : userId};
    
	    		 $.ajax({
                     type : "post",
                     url : "/loginChkProc",
                     data : jData,
                     dataType : "json",
                     contentType: "application/json",
                     success : function(data) {
                         if (data.retSign == 'N') {
                             if (email == 'undefined') {
                                 email = "";
                             }
                             if(gender =='남성'){
                            	 gender="1";
                            	 
                             }else{
                            	 gender="2";
                                 	 
                             }
                             $("#fbData").attr("action", "/signUp");
                             $("#snsType").val("F");
                             $("#snsId").val(userId);
                             $("#name").val(name);
                             $("#email").val(email);
                             $("#gender").val(gender);
                             $("#profilePic").val(profile);
                             $("#fbData").submit();
                         } else {
                        	 console.log("가입되어있습니다");
                         }
                     },
                     error : function(e) {
                         console.log(e);
                     }
             });
    	},
     {
         locale : 'ko_KR',
         fields : 'id, email , first_name ,last_name, age_range, picture ,gender, verified'
     });
}
