<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header.css">
<header id="header">

	<!-- 로고 -->
	<div class="logo">
		<a href="${pageContext.request.contextPath}/index">
			<h1>YamMusic</h1>
		</a>
	</div>


	<!-- 메뉴 -->
	<nav class="menu">
		<ul>

			<li><a href="${pageContext.request.contextPath}/index"> ホーム
			</a></li>

			<li><a href="${pageContext.request.contextPath}/index#features">
					特徴 </a></li>

			<li><a href="${pageContext.request.contextPath}/index#pricing">
					料金プラン </a></li>

			<li><a href="${pageContext.request.contextPath}/Notice">
					コミュニティ </a></li>

		</ul>
	</nav>


	<!-- 오른쪽 메뉴 -->
	<div class="right-menu">

		<div class="memberLogin">

			<!-- 로그인 안 된 상태 -->
			<c:if test="${empty sessionId}">

				<div class="memberLogin">

					<button class="join" type="button"
						onclick="location.href='${pageContext.request.contextPath}/Member?t_gubun=join'">
						会員登録</button>

					<button class="login" type="button">ログイン</button>

				</div>

			</c:if>


			<!-- 로그인 후 -->
			<c:if test="${not empty sessionId}">

				<div class="login_user_menu">

					<span class="welcome_name"> ${sessionName}様 </span>

					<button class="myinfo_btn" type="button"
						onclick="location.href='${pageContext.request.contextPath}/Member?t_gubun=myinfo'">
						マイページ</button>

					<button class="logout_btn" type="button"
						onclick="location.href='${pageContext.request.contextPath}/Member?t_gubun=logout'">
						ログアウト</button>

				</div>

			</c:if>

			<!-- 다크모드 -->
			<button class="darkmood_moon" type="button">
				<i class="fa-solid fa-moon"></i>
			</button>


			<!-- 언어 변경 -->
			<button class="change_lenguage" type="button">
				<i class="fa-solid fa-globe"></i>
			</button>

		</div>
</header>