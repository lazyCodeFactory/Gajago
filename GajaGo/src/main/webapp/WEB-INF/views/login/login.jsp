<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/login/login.css">
<jsp:include page="../template/includeResource.jsp" flush="true" />
<script src="http://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="/resources/js/login/facebook.js"></script>
<script src="/resources/js/login/login.js"></script>
</head>
<jsp:include page="../template/header.jsp" flush="true" />

<div class="row">
	<div class="col-md-offset-1 col-md-10 col-md-offset-1 containerBody">
		<div class="loginDiv">
			<section class="login-form">

				<form id="mainData" method="post">
					<input type="hidden" id="mainName" name="mainName" value="" /> 
					<input type="text" id="mainProfileImg" name="mainProfileImg" value="" /> 
				</form>


				<form method="post" action="#" role="login">
					<img src="/resources/image/login/loginTitle.jpg" class="img-responsive" alt="" /> 
					<input type="email" name="id" id="id"  class="form-control input-lg" value="" /> 
					<input type="password" name="password" id="password" class="form-control input-lg"  placeholder="Password" required="" />
					<div class="pwstrength_viewport_progress"></div>
					<button type="button" name="go" class="btn btn-lg btn-primary btn-block" onclick="login();">로그인</button>
				
					<div class="col-md-12 snsLogin">
<!-- 						<div id="fb-root"></div> -->
						<div class="col-md-6 faceBookDiv">
							<a  class="facebook" href="javascript:void(0);" onclick="operator();" scope="public_profile,email">
								<img src="/resources/image/login/facebooklogin.png">
							</a>
						</div>
						<div class="col-md-6 kakaoDiv"></div>
						<a id="kakao-login-btn" class="kakaoBtn"></a>
						<script src="/resources/js/login/kakao.js"></script>
					</div>
				
					<div class="findInfo">
						<a href="/findInfo">계정정보 찾기</a>
						<a href="/signUp">회원가입</a> 
					</div>
				</form>
			</section>
		</div>
	</div>
</div>


<jsp:include page="../template/footer.jsp" flush="true" />
