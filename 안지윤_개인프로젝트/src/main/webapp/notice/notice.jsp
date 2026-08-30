<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Track27 안지윤</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/notice/notice2.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">

<script
	src="${pageContext.request.contextPath}/member/login_function.js" defer>
	
</script>


<script type="text/javascript">
	function goListPage(page) {

		noti.t_nowPage.value = page;

		noti.method = "post";

		noti.action = "${pageContext.request.contextPath}/Notice";

		noti.submit();
	}

	function goSearch() {

		noti.t_nowPage.value = 1;

		noti.method = "post";

		noti.action = "${pageContext.request.contextPath}/Notice";

		noti.submit();
	}
</script>


</head>


<body>


	<%@ include file="../common_header.jsp"%>


	<section id="recommend">


		<form name="noti">


			<div class="recommend_title_box">

				<h3>Music Recommendation</h3>

				<p>おすすめの音楽を共有して、新しい音楽を見つけてみましょう。</p>

			</div>



			<div class="recommend_container">


				<div class="content_container">



					<div class="search_container">


						<input type="hidden" name="t_gubun" value="list"> <input
							type="hidden" name="t_nowPage" value="">


						<div class="search_box_1">


							<div class="select_box">


								<select class="select" name="t_select">


									<option value="m.title"
										<c:if test="${select eq 'm.title'}">
									selected
								</c:if>>

										タイトル</option>


									<option value="b.board_content"
										<c:if test="${select eq 'b.board_content'}">
									selected
								</c:if>>

										内容</option>


								</select>


							</div>



							<div class="text">


								<input type="text" class="text_box" name="t_search"
									value="${search}">


							</div>



							<div class="search_btcontainer">


								<input type="button" class="search_button" value="検索"
									onclick="goSearch()">


							</div>



							<div class="btn_box">


								<button type="button" class="write_button"
									onclick="location.href='${pageContext.request.contextPath}/Notice?t_gubun=write'">

									投稿する</button>


							</div>


						</div>


					</div>



					<div class="content_boxing">


						<c:forEach items="${boardList}" var="board">


							<div class="content"
								onclick="location.href='${pageContext.request.contextPath}/Notice?t_gubun=view&t_board_no=${board.board_no}'">


								<div class="content_picture_1"
									style="
								background-image:
								url('${pageContext.request.contextPath}/${board.album_image}');
							">
								</div>



								<div class="content_info">


									<div class="content_text_info">


										<span class="content_title"> 曲名：${board.title} </span> <span
											class="content_author"> 投稿者：${board.id} </span>


									</div>



									<div class="content_bottom">


										<button type="button" class="like_btn">

											<i class="fa-solid fa-heart"></i> <span class="like_count">

												${board.like_count} </span>

										</button>


									</div>


								</div>


							</div>


						</c:forEach>


					</div>



					<div class="paging">${pageDisplay}</div>


				</div>


			</div>


		</form>


	</section>



	<footer id="footer">


		<div class="footer_bottom">


			<p>© 2026 YamMusic Inc. All Rights Reserved.</p>


		</div>


	</footer>



	<%@ include file="../member/member_login.jsp"%>


</body>

</html>