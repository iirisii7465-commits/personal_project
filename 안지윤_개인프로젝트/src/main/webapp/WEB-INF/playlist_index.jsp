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
	href="${pageContext.request.contextPath}/playlist/playlist.css">

</head>


<body>


<%@ include file="../common_header.jsp" %>


<section id="playlist">


	<!-- =========================
		 HERO
	========================= -->

	<div class="playlist_hero">


		<div class="hero_effect effect_1"></div>
		<div class="hero_effect effect_2"></div>


		<div class="hero_text">

			<p class="hero_sub">
				YAMMUSIC PLAYLIST
			</p>

			<h1>
				今日の気分に合う
				<span>音楽を見つけよう。</span>
			</h1>

			<p class="hero_desc">
				人気の音楽や、シーンに合わせたプレイリストから
				お気に入りの一曲を探してみましょう。
			</p>


			<button
				type="button"
				class="hero_button"
				onclick="document.getElementById('ranking').scrollIntoView({behavior:'smooth'})">

				ランキングを見る

				<i class="fa-solid fa-arrow-down"></i>

			</button>

		</div>


		<!-- 오른쪽 장식 카드 -->

		<div class="hero_visual">


			<div class="hero_music_card card_back_1"></div>

			<div class="hero_music_card card_back_2"></div>


			<div class="hero_music_card main_card">


				<div class="album_cover">

					<i class="fa-solid fa-music"></i>

				</div>


				<div class="hero_song_info">

					<p class="now_playing">
						NOW PLAYING
					</p>

					<h3>
						Discover Your Music
					</h3>

					<p>
						YamMusic Selection
					</p>

				</div>


				<div class="music_progress">

					<div class="progress_bar">

						<div class="progress_value"></div>

					</div>

				</div>


				<div class="player_buttons">

					<i class="fa-solid fa-backward-step"></i>

					<div class="play_button">
						<i class="fa-solid fa-play"></i>
					</div>

					<i class="fa-solid fa-forward-step"></i>

				</div>


			</div>


		</div>


	</div>



	<!-- =========================
		 실시간 / 인기 랭킹
	========================= -->

	<div
		class="playlist_section"
		id="ranking">


		<div class="section_title">


			<div>

				<p class="section_sub">
					TRENDING NOW
				</p>

				<h2>
					人気ランキング
				</h2>

			</div>


			<p class="section_desc">
				今、人気の音楽をチェック
			</p>


		</div>



		<div class="ranking_container">


			<!-- 나중에 API 붙이면
			     c:forEach로 변경하면 됨 -->


			<div class="ranking_item">

				<div class="rank_number top_rank">
					01
				</div>

				<div class="rank_album">

					<i class="fa-solid fa-music"></i>

				</div>

				<div class="rank_info">

					<h3>
						Song Title
					</h3>

					<p>
						Artist Name
					</p>

				</div>

				<div class="rank_status up">

					<i class="fa-solid fa-caret-up"></i>

					2

				</div>

				<button
					type="button"
					class="rank_play">

					<i class="fa-solid fa-play"></i>

				</button>

			</div>



			<div class="ranking_item">

				<div class="rank_number top_rank">
					02
				</div>

				<div class="rank_album">

					<i class="fa-solid fa-headphones"></i>

				</div>

				<div class="rank_info">

					<h3>
						Song Title
					</h3>

					<p>
						Artist Name
					</p>

				</div>

				<div class="rank_status down">

					<i class="fa-solid fa-caret-down"></i>

					1

				</div>

				<button
					type="button"
					class="rank_play">

					<i class="fa-solid fa-play"></i>

				</button>

			</div>



			<div class="ranking_item">

				<div class="rank_number top_rank">
					03
				</div>

				<div class="rank_album">

					<i class="fa-solid fa-record-vinyl"></i>

				</div>

				<div class="rank_info">

					<h3>
						Song Title
					</h3>

					<p>
						Artist Name
					</p>

				</div>

				<div class="rank_status same">

					—

				</div>

				<button
					type="button"
					class="rank_play">

					<i class="fa-solid fa-play"></i>

				</button>

			</div>



			<div class="ranking_item">

				<div class="rank_number">
					04
				</div>

				<div class="rank_album">

					<i class="fa-solid fa-music"></i>

				</div>

				<div class="rank_info">

					<h3>
						Song Title
					</h3>

					<p>
						Artist Name
					</p>

				</div>

				<div class="rank_status up">

					<i class="fa-solid fa-caret-up"></i>

					3

				</div>

				<button
					type="button"
					class="rank_play">

					<i class="fa-solid fa-play"></i>

				</button>

			</div>



			<div class="ranking_item">

				<div class="rank_number">
					05
				</div>

				<div class="rank_album">

					<i class="fa-solid fa-music"></i>

				</div>

				<div class="rank_info">

					<h3>
						Song Title
					</h3>

					<p>
						Artist Name
					</p>

				</div>

				<div class="rank_status same">
					—
				</div>

				<button
					type="button"
					class="rank_play">

					<i class="fa-solid fa-play"></i>

				</button>

			</div>


		</div>


	</div>



	<!-- =========================
		 분위기별 플레이리스트
	========================= -->

	<div class="playlist_section">


		<div class="section_title">

			<div>

				<p class="section_sub">
					FOR YOUR MOOD
				</p>

				<h2>
					気分別プレイリスト
				</h2>

			</div>

		</div>



		<div class="mood_grid">


			<!-- SUMMER -->

			<div class="mood_card summer">


				<div class="mood_overlay"></div>


				<div class="mood_icon">

					<i class="fa-solid fa-sun"></i>

				</div>


				<div class="mood_text">

					<p>
						SUMMER
					</p>

					<h3>
						夏に聴きたい曲
					</h3>

					<span>
						爽やかな夏のプレイリスト
					</span>

				</div>


				<div class="mood_arrow">

					<i class="fa-solid fa-arrow-right"></i>

				</div>


			</div>



			<!-- STUDY -->

			<div class="mood_card study">


				<div class="mood_overlay"></div>


				<div class="mood_icon">

					<i class="fa-solid fa-book-open"></i>

				</div>


				<div class="mood_text">

					<p>
						STUDY
					</p>

					<h3>
						集中したいとき
					</h3>

					<span>
						勉強や作業におすすめ
					</span>

				</div>


				<div class="mood_arrow">

					<i class="fa-solid fa-arrow-right"></i>

				</div>


			</div>



			<!-- NIGHT -->

			<div class="mood_card night">


				<div class="mood_overlay"></div>


				<div class="mood_icon">

					<i class="fa-solid fa-moon"></i>

				</div>


				<div class="mood_text">

					<p>
						NIGHT
					</p>

					<h3>
						夜に聴きたい曲
					</h3>

					<span>
						静かな夜のための音楽
					</span>

				</div>


				<div class="mood_arrow">

					<i class="fa-solid fa-arrow-right"></i>

				</div>


			</div>



			<!-- DRIVE -->

			<div class="mood_card drive">


				<div class="mood_overlay"></div>


				<div class="mood_icon">

					<i class="fa-solid fa-car-side"></i>

				</div>


				<div class="mood_text">

					<p>
						DRIVE
					</p>

					<h3>
						ドライブソング
					</h3>

					<span>
						気分が上がるドライブ音楽
					</span>

				</div>


				<div class="mood_arrow">

					<i class="fa-solid fa-arrow-right"></i>

				</div>


			</div>


		</div>


	</div>



	<!-- =========================
		 WEEKLY PICK
	========================= -->

	<div class="playlist_section weekly_section">


		<div class="weekly_box">


			<div class="weekly_icon">

				<i class="fa-solid fa-headphones-simple"></i>

			</div>


			<div class="weekly_text">

				<p>
					YAMMUSIC WEEKLY PICK
				</p>

				<h2>
					今週のおすすめプレイリスト
				</h2>

				<span>
					YamMusicで今週おすすめの音楽を集めました。
				</span>

			</div>


			<button
				type="button"
				class="weekly_button">

				聴いてみる

				<i class="fa-solid fa-arrow-right"></i>

			</button>


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