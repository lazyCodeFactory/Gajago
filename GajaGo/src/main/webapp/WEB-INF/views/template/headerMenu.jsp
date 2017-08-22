<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
	<div class="row">
		<nav class="navbar navbar-default" role="navigation">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<a class="navbar-brand" href="/innerTravelList"><span class="menuSpan">국내여행</span></a> 
				<a class="navbar-brand" href="#"><span class="menuSpan">해외여행</span></a>
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">여행수기/정보 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">여행수기</a></li>
							<li class="divider"></li>
							<li><a href="#">나라별/주의사항</a></li>
 						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">중고장터 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">삽니다</a></li>
							<li class="divider"></li>
							<li><a href="#">팝니다</a></li>
							<li class="divider"></li>
							<li><a href="#">교환하다</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->

		</nav>

	</div>