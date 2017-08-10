    Kakao.init('b4015b4d1ed4104a61bf5ece903fcd0f');
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        Kakao.API.request({
          url: '/v1/user/me',
          success: function(res) {
        	  var id = res.id;
            var kaccount_email = res.kaccount_email;
            var thumbnail_image = res.thumbnail_image;
            console.log(thumbnail_image)
            var snsType= "K";
            $("#fbData").attr("action", "/signUp");
            $("#snsId").val(id);
            $("#email").val(kaccount_email);
            $("#profilePic").val(thumbnail_image);
            $("#snsType").val(snsType);
            $("#fbData").submit();

          
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
