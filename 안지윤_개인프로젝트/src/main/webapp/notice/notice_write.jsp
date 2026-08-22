<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>

<meta charset="UTF-8">

<title>YamMusic | Music Community</title>


<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">


<!-- 공통 CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">


<!-- 글쓰기 페이지 CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/notice/notice_write2.css">


</head>


<body>


	<!-- ================================
	     공통 Header
	================================ -->

	<%@ include file="../common_header.jsp"%>



	<!-- ================================
	     글쓰기 영역
	================================ -->

	<section id="recommend_write">


		<!-- 제목 -->

		<div class="write_title">

			<p class="sub_title">MUSIC COMMUNITY</p>

			<h1>おすすめの音楽を共有しよう</h1>

			<p class="title_desc">お気に入りの曲や、その曲をおすすめしたい理由を みんなと共有してください。</p>

		</div>



		<!-- ================================
		     FORM
		================================ -->

		<form name="notice" method="post"
			action="${pageContext.request.contextPath}/Notice">


			<input type="hidden" name="t_gubun" value="save">



			<div class="write_container">


				<!-- ================================
				     01 곡 정보
				================================ -->

				<div class="song_section">


					<div class="section_title">

						<span>01</span>

						<h3>楽曲情報</h3>

					</div>



					<div class="song_row">


						<!-- 곡명 -->

						<div class="form_group">

							<label for="song"> 曲名 </label> <select id="song"
								name="t_music_no" class="song_select" onchange="changeSong()">


								<option value="">曲を選択してください</option>

								<c:forEach items="${musicList}" var="music">

									<option value="${music.music_no}" data-artist="${music.artist}">
										${music.title}</option>

								</c:forEach>
							</select>

						</div>



						<!-- 아티스트 -->

						<div class="form_group">

							<label for="artist"> アーティスト </label> <input type="text"
								id="artist" name="t_artist" class="artist_input"
								placeholder="曲を選択すると表示されます" readonly>

						</div>


					</div>


				</div>



				<!-- ================================
				     02 추천 이유
				================================ -->

				<div class="review_section">


					<div class="section_title">

						<span>02</span>

						<h3>おすすめ理由</h3>

					</div>


					<textarea name="t_reason" class="reason_text" maxlength="300"
						placeholder="この曲をおすすめしたい理由を書いてください。"></textarea>


					<div class="text_info">最大300文字</div>


				</div>



				<!-- ================================
				     03 감상
				================================ -->

				<div class="review_section">


					<div class="section_title">

						<span>03</span>

						<h3>感想</h3>

					</div>


					<textarea name="t_content" class="content_text" maxlength="1000"
						placeholder="曲を聴いて感じたことや、好きなポイントを書いてください。"></textarea>


					<div class="text_info">最大1000文字</div>


				</div>



				<!-- ================================
				     작성자 / 버튼
				================================ -->

				<div class="writer_section">


					<div class="writer_info">

						<span class="writer_label"> 投稿者 </span> <span class="writer_name">
							${sessionName} </span>

					</div>



					<div class="button_area">


						<!-- 취소 -->

						<button type="button" class="cancel_button"
							onclick="location.href='${pageContext.request.contextPath}/Notice'">

							キャンセル</button>



						<!-- 등록 -->

						<button type="button" class="submit_button" onclick="goSave()">

							投稿する</button>


					</div>


				</div>


			</div>


		</form>


	</section>



	<!-- ================================
	     FOOTER
	================================ -->

	<footer id="footer">

		<div class="footer_bottom">

			<p>© 2026 YamMusic Inc. All Rights Reserved.</p>

		</div>

	</footer>



	<!-- ================================
	     SCRIPT
	================================ -->

	<script>
		function changeSong() {

			const songSelect = document.querySelector(".song_select");
			const artist = document.querySelector(".artist_input");

			const selectedOption = songSelect.options[songSelect.selectedIndex];

			artist.value = selectedOption.dataset.artist || "";
		}

		function goSave() {

			const form = document.notice;

			if (form.t_music_no.value === "") {

				alert("曲を選択してください。");

				form.t_music_no.focus();

				return;

			}

			if (form.t_reason.value.trim() === "") {

				alert("おすすめ理由を入力してください。");

				form.t_reason.focus();

				return;

			}

			if (form.t_content.value.trim() === "") {

				alert("感想を入力してください。");

				form.t_content.focus();

				return;

			}

			if (confirm("投稿しますか？")) {

				form.submit();

			}

		}
	</script>


</body>

</html>