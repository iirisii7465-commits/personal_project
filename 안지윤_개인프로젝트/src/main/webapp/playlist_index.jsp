<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="ja">

<head>

<meta charset="UTF-8">

<title>YamMusic | Playlist</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/playlist.css">

</head>


<body>


<%@ include file="../common_header.jsp" %>



<section id="playlist">


	<div class="playlist_inner">


		<!-- =========================
			 검색
		========================= -->

		<div class="playlist_search">


			<i class="fa-solid fa-magnifying-glass"></i>


			<input
				type="text"
				placeholder="曲名、アルバム、アーティストを検索">


		</div>



		<!-- =========================
			 카테고리
		========================= -->

		<div class="playlist_category">


			<button type="button">
				J-POP
			</button>

			<button type="button">
				K-POP
			</button>

			<button type="button">
				気分転換
			</button>

			<button type="button">
				集中
			</button>

			<button type="button">
				休憩
			</button>

			<button type="button">
				ドライブ
			</button>

			<button type="button">
				夏
			</button>

			<button type="button">
				夜
			</button>

			<button type="button">
				パーティー
			</button>

			<button type="button">
				睡眠
			</button>


		</div>



		<!-- =========================
			 추천 플레이리스트
		========================= -->

		<div class="playlist_section">


			<div class="section_header">


				<div>

					<p class="section_small">
						FOR YOU
					</p>

					<h2>
						おすすめプレイリスト
					</h2>

				</div>


				<div class="section_buttons">

					<button type="button">

						<i class="fa-solid fa-chevron-left"></i>

					</button>


					<button type="button">

						<i class="fa-solid fa-chevron-right"></i>

					</button>

				</div>


			</div>



			<div class="playlist_cards">


				<!-- SUMMER -->

				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/summer.jpg"
							alt="summer playlist">

						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						夏に聴きたい曲
					</h3>


					<p>
						夏の気分を楽しめる爽やかなプレイリスト
					</p>


				</div>



				<!-- JAZZ -->

				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/jazz.jpg"
							alt="jazz playlist">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						Cafe & Jazz
					</h3>


					<p>
						落ち着いた時間に聴きたいジャズ
					</p>


				</div>



				<!-- NIGHT -->

				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/night.jpg"
							alt="night playlist">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						Night Playlist
					</h3>


					<p>
						静かな夜に似合う音楽
					</p>


				</div>



				<!-- DRIVE -->

				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/drive.jpg"
							alt="drive playlist">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						Drive Music
					</h3>


					<p>
						ドライブを楽しくする音楽
					</p>


				</div>



				<!-- STUDY -->

				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/study.jpg"
							alt="study playlist">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						集中したいとき
					</h3>


					<p>
						勉強や作業のためのプレイリスト
					</p>


				</div>


			</div>


		</div>



		<!-- =========================
			 인기 플레이리스트
		========================= -->

		<div class="playlist_section">


			<div class="section_header">


				<div>

					<p class="section_small">
						TRENDING
					</p>

					<h2>
						人気のプレイリスト
					</h2>

				</div>


				<div class="section_buttons">


					<button type="button">

						<i class="fa-solid fa-chevron-left"></i>

					</button>


					<button type="button">

						<i class="fa-solid fa-chevron-right"></i>

					</button>


				</div>


			</div>



			<div class="playlist_cards">


				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/citypop.jpg"
							alt="city pop">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						City Pop
					</h3>


					<p>
						都会の夜を感じる音楽
					</p>


				</div>



				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/kpop.jpg"
							alt="kpop">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						K-POP Hits
					</h3>


					<p>
						今人気のK-POPをチェック
					</p>


				</div>



				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/chill.jpg"
							alt="chill">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						Chill Time
					</h3>


					<p>
						ゆっくり休みたいときに
					</p>


				</div>



				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/piano.jpg"
							alt="piano">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						Piano Music
					</h3>


					<p>
						静かなピアノ曲を集めました
					</p>


				</div>



				<div class="playlist_card">


					<div class="card_image">

						<img
							src="${pageContext.request.contextPath}/images/lofi.jpg"
							alt="lofi">


						<div class="card_play">

							<i class="fa-solid fa-play"></i>

						</div>

					</div>


					<h3>
						Lo-Fi
					</h3>


					<p>
						作業におすすめのLo-Fi
					</p>


				</div>


			</div>


		</div>



		<!-- =========================
			 실시간 랭킹
		========================= -->

		<div class="playlist_section ranking_section">


			<div class="section_header">


				<div>

					<p class="section_small">
						REALTIME CHART
					</p>

					<h2>
						リアルタイムランキング
					</h2>

				</div>


				<span class="update_time">

					<i class="fa-regular fa-clock"></i>

					リアルタイム更新

				</span>


			</div>



			<div class="ranking_list">


				<!-- 1 -->

				<div class="ranking_item">


					<div class="ranking_number top">
						01
					</div>


					<div class="ranking_album">

						<img
							src="${pageContext.request.contextPath}/images/music1.jpg">

					</div>


					<div class="ranking_info">

						<h3>
							Song Title
						</h3>

						<p>
							Artist Name
						</p>

					</div>


					<div class="ranking_change up">

						<i class="fa-solid fa-caret-up"></i>

						2

					</div>


					<button
						type="button"
						class="ranking_play">

						<i class="fa-solid fa-play"></i>

					</button>


				</div>



				<!-- 2 -->

				<div class="ranking_item">


					<div class="ranking_number top">
						02
					</div>


					<div class="ranking_album">

						<img
							src="${pageContext.request.contextPath}/images/music2.jpg">

					</div>


					<div class="ranking_info">

						<h3>
							Song Title
						</h3>

						<p>
							Artist Name
						</p>

					</div>


					<div class="ranking_change down">

						<i class="fa-solid fa-caret-down"></i>

						1

					</div>


					<button
						type="button"
						class="ranking_play">

						<i class="fa-solid fa-play"></i>

					</button>


				</div>



				<!-- 3 -->

				<div class="ranking_item">


					<div class="ranking_number top">
						03
					</div>


					<div class="ranking_album">

						<img
							src="${pageContext.request.contextPath}/images/music3.jpg">

					</div>


					<div class="ranking_info">

						<h3>
							Song Title
						</h3>

						<p>
							Artist Name
						</p>

					</div>


					<div class="ranking_change same">
						—
					</div>


					<button
						type="button"
						class="ranking_play">

						<i class="fa-solid fa-play"></i>

					</button>


				</div>



				<!-- 4 -->

				<div class="ranking_item">


					<div class="ranking_number">
						04
					</div>


					<div class="ranking_album">

						<img
							src="${pageContext.request.contextPath}/images/music4.jpg">

					</div>


					<div class="ranking_info">

						<h3>
							Song Title
						</h3>

						<p>
							Artist Name
						</p>

					</div>


					<div class="ranking_change up">

						<i class="fa-solid fa-caret-up"></i>

						3

					</div>


					<button
						type="button"
						class="ranking_play">

						<i class="fa-solid fa-play"></i>

					</button>


				</div>



				<!-- 5 -->

				<div class="ranking_item">


					<div class="ranking_number">
						05
					</div>


					<div class="ranking_album">

						<img
							src="${pageContext.request.contextPath}/images/music5.jpg">

					</div>


					<div class="ranking_info">

						<h3>
							Song Title
						</h3>

						<p>
							Artist Name
						</p>

					</div>


					<div class="ranking_change same">
						—
					</div>


					<button
						type="button"
						class="ranking_play">

						<i class="fa-solid fa-play"></i>

					</button>


				</div>


			</div>


		</div>


	</div>


</section>



<footer id="footer">


	<div class="footer_bottom">


		<p>
			© 2026 YamMusic Inc. All Rights Reserved.
		</p>


	</div>


</footer>


</body>

</html>