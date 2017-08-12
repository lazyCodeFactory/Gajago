<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  공통 리소스 부분 -->
	<jsp:include page="../template/includeResource.jsp" flush="true" />
	<link rel="stylesheet" href="/resources/css/member/findInfo.css">
	<script src="/resources/js/member/findInfo.js"></script>
	
	</head>
<!-- 	Heaer부분 -->
	<jsp:include page="../template/header.jsp" flush="true" />

	<div class="row">
				
		<div class="col-md-offset-1 col-md-10 col-md-offset-1 containerBody">
		<div class="col-md-12 tabClass">
			<ul class="nav nav-tabs">
	  			<li>
	  				<a href="">아이디 찾기</a>
	  			</li>
		  		<li>
		  			<a href="">비밀번호 찾기</a>
		  		</li>
			</ul>
		</div>
			
			<div class="col-md-6 findId">
 			  		<H2>아이디 찾기</H2>
					<table>
						<tbody>
							<tr>
							 	<th>이름</th>
							 	<td><input type="text" name="findIdName" id="findIdName" class="form-control"/></td>
							</tr>
							<tr>
							 	<th>메일</th>
							 	<td><input type="text" name="findIdEmail" id="findIdEmail" class="form-control"/></td>
							</tr>
							<tr>
							 	<td class="btnArea"><button type="button" class="findBtn" onclick="findId();">아이디 찾기</button></td>
							</tr>
						
						</tbody>
					</table>
 			</div>
			<div class="col-md-6 findPass">
 					<H2>비밀번호 찾기</H2>
					
					<table>
						<tbody>
							<tr>
							 	<th>아이디</th>
							 	<td><input type="text" id="findPwId" name="findPwId" class="form-control"/></td>
							</tr>
							<tr>
							 	<th>이름</th>
							 	<td><input type="text" id="findPwName" name="findPwName"  class="form-control"/></td>
							</tr>
							<tr>
							 	<th>메일</th>
							 	<td><input type="text" id="findPwEmail" name="findPwEmail"  class="form-control"/></td>
							</tr>
							<tr>
							 	<td class="btnArea">
							 		<button type="button" onclick="findPwd()" class="findBtn">비밀번호 찾기</button></td>
							</tr>
						
						</tbody>
					</table>
 			</div>
		</div>
	</div>
	
	
<!-- 	Footer부분 -->
	<jsp:include page="../template/footer.jsp" flush="true" />
