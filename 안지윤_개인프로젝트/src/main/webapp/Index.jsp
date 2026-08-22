<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<title>Track27 안지윤</title>
<link href="main.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet">
<script src="member/login_function.js" defer></script> <!-- 기능가져와서쓸때 링크걸어줘야됨 -->
<script type="text/javascript">
function goJoin(gubun){
	work.t_gubun.value =gubun;
	work.method="post";
	work.action="Member";
	work.submit();
}


</script>

</head>
<body>
<form name="work">
<input type="hidden" name="t_gubun">


</form>
<%@ include file="common_header.jsp" %>
	<section id="hero">
		<div class="title">
			<h1 class="title_1">まずは Free PLANでお試しください！</h1>
			<p>(最初 Standard ご購入時、１ヵ月追加プレゼント)</p>
		</div>

	<div class="title_button_text">
		<button class="button_1" onclick="goJoin()">Free PLANで始める</button> <br>
		<button class="button_2">ログイン</button>
		</div>

	</section>








	<section id="features">
		<!-- 기능 -->


		<div class="box_0">
			<h2>あなたのミュージックライフを変える特別な機能をご紹介します。</h2>
		</div>
		<div class="box_container">

			<div class="box_1">

				<div class="features_icon">
					<i class="fa-solid fa-heart-circle-plus"></i>
				</div>
				<h3>プレイリスト保存</h3>
				<p>ワンクリックでお気に入りに簡単 save</p>
			</div>

			<div class="box_1">

				<div class="features_icon">
					<i class="fa-solid fa-folder-plus"></i>
				</div>
				<h3>高速ダウンロード</h3>
				<p>お気に入りの音源をスピーディーに保存</p>
			</div>

			<div class="box_1">

				<div class="features_icon">
					<i class="fa-solid fa-headphones"></i>
				</div>
				<h3>クリアな音質</h3>
				<p>ノイズのない高音質サウンドを体験</p>
			</div>

			<div class="box_1">

				<div class="features_icon">
					<i class="fa-solid fa-play"></i>
				</div>
				<h3>途切れのない再生</h3>
				<p>広告なしでお気に入りの楽曲を連続再生</p>
			</div>

		</div>
	</section>





	<section id="pricing">
		<h1>Music PLAN</h1>
		<div class="pricing_container">

			<div class="pricing_box_1">


				<h3>Basic PLAN</h3>
				<div class="pricing_title">
					<p>音楽ストリーミング</p>
					<p>広告あり</p>
					<p>標準音質</p>
					<p>多彩な楽曲を</p>
					<p>手軽にお楽しみいただけます。</p>
				</div>

				<div class="price">
					<a href="#">１ヶ月 290円</a>
				</div>
			</div>

			<div class="pricing_box_1">


				<h3>Standard PLAN</h3>
				<div class="pricing_title2">
					<p>広告なし再生</p>
					<p>高音質ストリーミング</p>
					<p>プレイリスト無制限保存</p>
					<p>快適な音楽鑑賞</p>
					<p>多様な曲を</p>
					<p>高音質で鑑賞いただけます。</p>

				</div>
				<div class="price">
					<a href="#">１ヶ月 990円</a>
				</div>
			</div>

			<div class="pricing_box_1">


				<h3>Premium PLAN</h3>
				<div class="pricing_title3">
					<p>最高音質 Hi-Fi サウンド</p>
					<p>楽曲の無制限ダウンロード</p>
					<p>オフライン再生対応</p>
					<p>プレミアム機能を</p>
					<p>制限なしでお楽しみいただけます。</p>
				</div>

				<div class="price">
					<a href="#">１ヶ月 1300円</a>
				</div>

			</div>

		</div>

	</section>


	<section id="popular">


		<h1>今月の人気音楽チャート</h1>
		<div class="popular_container">

			<div>
				<div class="popular_box_1"></div>
				<p>
					心揺さぶるパフォーマンスと圧倒的なシ<br>ナジーで、世界をする。
				</p>
			</div>

			<div>
				<div class="popular_box_2"></div>
				<p>
					眩しい輝きとエナジーに満ちた、今始まる<br>私達だけの特別なステージ。
				</p>
			</div>
		</div>





		<div class="popular_container_2">
			<div>
				<div class="popular_box_3"></div>
				<p>
					アコギの温かな音色と透き通る<br>歌声が、あなたの心に。。。
				</p>
			</div>
			<div>
				<div class="popular_box_4"></div>
				<p>
					現実とバーチャルの境界を超えて<br>出会う!
				</p>
			</div>
			<div>
				<div class="popular_box_5"></div>
				<p>
					指先が紡ぎ出す美しい旋律とと<br>もに、柔らかいピアノ曲。
				</p>
			</div>
		</div>


	</section>



	<section id="Qna">
		<h1>QnA</h1>
		<div class="qna_container">

			<div class="question_1">
				<p class="question_font">Q1. 料金プランの変更や解約はいつでもできますか？</p>

				<div class="answer_1">
					<p>A. はい、マイページからいつでも違約金なしでプラン変更・解約が可能です。
						解約後も現在の請求期間終了までサービスをご利用いただけます。</p>

				</div>
			</div>

			<div class="question_1">
				<p class="question_font">Q. どのような支払い方法や決済手段に対応していますか？</p>

				<div class="answer_1">
					<p>A. 各種クレジットカードをはじめ、キャリア決済や携帯払いに対応しており、すぐにご利用いただけます。</p>

				</div>
			</div>
			<div class="question_1">
				<p class="question_font">Q3. StandardとPremiumの音質の違いは何ですか？</p>

				<div class="answer_1">
					<p>A. Standardはクリアな高音質ストリーミングを提供し、
						Premiumではスタジオ品質に近い最高音質のHi-Fiサウンドをお楽しみいただけます。</p>

				</div>
			</div>


		</div>



	</section>


	<footer id="footer">
		<div class="footer_info">
			<p>(주) AJYMusic &nbsp;|&nbsp; 대표: 안지윤 &nbsp;|&nbsp; 사업자등록번호:
				010-2460-6688</p>
			<p>주소: 대전광역시 중구 중앙로 121 &nbsp;|&nbsp; 문의: iirisii6688@naver.com</p>
			<p class="notice">본 서비스의 모든 음원 및 콘텐츠 저작권은 해당 저작권자에게 있으며, 무단 복제 및
				배포를 금합니다.</p>
		</div>
		<div class="footer_social">
			<a href="#" aria-label="Instagram"><i
				class="fa-brands fa-instagram"></i></a> <a href="#" aria-label="YouTube"><i
				class="fa-brands fa-youtube"></i></a> <a href="#" aria-label="X-Twitter"><i
				class="fa-brands fa-x-twitter"></i></a> <a href="#" aria-label="Github"><i
				class="fa-brands fa-github"></i></a>
		</div>

		<!-- 하단: 저작권 문구 -->
		<div class="footer_bottom">
			<p>© 2026 AJYMusic Inc. All Rights Reserved.</p>
		</div>



	</footer>

	 <%@ include file="../member/member_login.jsp"%>
</body>
</html>