<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>YamMusic | Music View</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/notice/notice_view.css">
</head>
<body>

	<%@ include file="../common_header.jsp"%>

	<section id="recommend_view">

		<!-- 배경 효과 -->
		<div class="view_bg"></div>

		<div class="view_inner">

			<!-- 상단 타이틀 -->
			<div class="view_title">
				<p class="sub_title">MUSIC COMMUNITY</p>
				<h1>おすすめの音楽をチェックしよう</h1>
				<p class="title_desc">みんなが共有したおすすめの音楽と、その理由を見てみましょう。</p>
			</div>

			<!-- 메인 글래스 카드 -->
			<div class="view_container">

				<!-- 01 음악 정보 -->
				<div class="section_block">
					<div class="section_heading">
						<span>01</span>
						<h3>楽曲情報</h3>
					</div>

					<div class="music_info_wrap">

						<div class="album_box">
							<c:choose>
								<c:when test="${not empty dto.album_image}">
									<img
										src="${pageContext.request.contextPath}/${dto.album_image}"
										alt="${dto.title}">
								</c:when>
								<c:otherwise>
									<div class="no_image">
										<i class="fa-solid fa-music"></i>
									</div>
								</c:otherwise>
							</c:choose>
						</div>

						<div class="music_info_text">

							<div class="info_row">
								<label>曲名</label>
								<div class="info_value">${dto.title}</div>
							</div>

							<div class="info_row">
								<label>アーティスト</label>
								<div class="info_value">${dto.artist}</div>
							</div>

							<div class="meta_row">
								<div class="meta_item">
									<i class="fa-regular fa-user"></i> <span>${dto.id}</span>
								</div>

								<div class="meta_item">
									<i class="fa-regular fa-calendar"></i> <span>${dto.reg_date}</span>
								</div>

								<div class="meta_item">
									<i class="fa-regular fa-eye"></i> <span>${dto.hit}</span>
								</div>

								<c:if test="${not empty sessionId && sessionId ne dto.id}">
									<div class="meta_item">
										<button type="button" class="like_btn"
											onclick="location.href='${pageContext.request.contextPath}/Notice?t_gubun=like&t_board_no=${dto.board_no}'">

											<i class="fa-solid fa-heart"></i> <span>${likeCount}</span>

										</button>
									</div>
								</c:if>
							</div>

						</div>

					</div>
				</div>

				<!-- 02 추천 이유 -->
				<div class="section_block">
					<div class="section_heading">
						<span>02</span>
						<h3>おすすめ理由</h3>
					</div>

					<div class="content_box">${dto.recommend_reason}</div>
				</div>

				<!-- 03 감상 -->
				<div class="section_block">
					<div class="section_heading">
						<span>03</span>
						<h3>感想</h3>
					</div>

					<div class="content_box">${dto.board_content}</div>
				</div>

				<!-- 버튼 -->
				<div class="button_area">
					<button type="button" class="list_button"
						onclick="location.href='${pageContext.request.contextPath}/Notice'">
						一覧へ</button>

					<c:if test="${sessionId eq dto.id}">
						<button type="button" class="edit_button"
							onclick="location.href='${pageContext.request.contextPath}/Notice?t_gubun=updateForm&t_board_no=${dto.board_no}'">
							編集</button>

						<button type="button" class="delete_button"
							onclick="location.href='${pageContext.request.contextPath}/Notice?t_gubun=delete&t_board_no=${dto.board_no}'">削除</button>
					</c:if>
				</div>

			</div>
		</div>
	</section>

	<footer id="footer">
		<div class="footer_bottom">
			<p>© 2026 YamMusic Inc. All Rights Reserved.</p>
		</div>
	</footer>

	<c:if test="${not empty msg}">
		<script>
			alert("${msg}");
		</script>
	</c:if>

</body>
</html>