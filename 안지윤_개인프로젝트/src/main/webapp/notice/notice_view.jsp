<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">

<head>
<script
	src="${pageContext.request.contextPath}/member/login_function.js"
	defer>
</script>

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


<%@ include file="../common_header.jsp" %>


<section id="recommend_view">


    <!-- 배경 효과 -->
    <div class="view_bg"></div>


    <div class="view_inner">


        <!-- 상단 타이틀 -->
        <div class="view_title">

            <p class="sub_title">
                MUSIC COMMUNITY
            </p>

            <h1>
                おすすめの音楽をチェックしよう
            </h1>

            <p class="title_desc">
                みんなが共有したおすすめの音楽と、その理由を見てみましょう。
            </p>

        </div>



        <!-- 메인 글래스 카드 -->
        <div class="view_container">

            <div class="section_block">


                <div class="section_heading">

                    <span>
                        01
                    </span>

                    <h3>
                        楽曲情報
                    </h3>

                </div>



                <div class="music_info_wrap">


                    <!-- 앨범 이미지 -->
                    <div class="album_box">


                        <c:choose>


                            <c:when test="${not empty t_dto.album_image}">

                                <img
                                    src="${pageContext.request.contextPath}/${t_dto.album_image}"
                                    alt="${t_dto.title}">

                            </c:when>


                            <c:otherwise>

                                <div class="no_image">

                                    <i class="fa-solid fa-music"></i>

                                </div>

                            </c:otherwise>


                        </c:choose>


                    </div>



                    <!-- 음악 정보 -->
                    <div class="music_info_text">


                        <!-- 곡명 -->
                        <div class="info_row">

                            <label>
                                曲名
                            </label>

                            <div class="info_value">

                                ${t_dto.title}

                            </div>

                        </div>



                        <!-- 아티스트 -->
                        <div class="info_row">

                            <label>
                                アーティスト
                            </label>

                            <div class="info_value">

                                ${t_dto.artist}

                            </div>

                        </div>



                        <!-- 메타정보 -->
                        <div class="meta_row">


                            <!-- 작성자 -->
                            <div class="meta_item">

                                <i class="fa-regular fa-user"></i>

                                <span>
                                    ${t_dto.id}
                                </span>

                            </div>



                            <!-- 등록일 -->
                            <div class="meta_item">

                                <i class="fa-regular fa-calendar"></i>

                                <span>
                                    ${t_dto.reg_date}
                                </span>

                            </div>



                            <!-- 조회수 -->
                            <div class="meta_item">

                                <i class="fa-regular fa-eye"></i>

                                <span>
                                    ${t_dto.hit}
                                </span>

                            </div>



                            <!-- 좋아요 -->
                            <c:if test="${not empty sessionId && sessionId ne t_dto.id}">

                                <div class="meta_item">

                                    <button
                                        type="button"
                                        class="like_btn"
                                        onclick="location.href='${pageContext.request.contextPath}/Notice?t_gubun=like&t_board_no=${t_dto.board_no}'">

                                        <i class="fa-solid fa-heart"></i>

                                        <span>
                                            ${likeCount}
                                        </span>

                                    </button>

                                </div>

                            </c:if>


                            <!-- 작성자 본인일 때도 좋아요 수는 표시 -->
                            <c:if test="${empty sessionId || sessionId eq t_dto.id}">

                                <div class="meta_item">

                                    <i class="fa-solid fa-heart"></i>

                                    <span>
                                        ${likeCount}
                                    </span>

                                </div>

                            </c:if>


                        </div>


                    </div>


                </div>


            </div>

            <div class="section_block">


                <div class="section_heading">

                    <span>
                        02
                    </span>

                    <h3>
                        おすすめ理由
                    </h3>

                </div>


                <div class="content_box">

                    ${t_dto.recommend_reason}

                </div>


            </div>



            <div class="section_block">


                <div class="section_heading">

                    <span>
                        03
                    </span>

                    <h3>
                        感想
                    </h3>

                </div>


                <div class="content_box">

                    ${t_dto.board_content}

                </div>


            </div>



            <div class="button_area">


                <!-- 목록 -->
                <button
                    type="button"
                    class="list_button"
                    onclick="location.href='${pageContext.request.contextPath}/Notice'">

                    一覧へ

                </button>



                <!-- 작성자 본인만 수정/삭제 -->
                <c:if test="${sessionId eq t_dto.id}">


                    <!-- 수정 -->
                    <button
                        type="button"
                        class="edit_button"
                        onclick="location.href='${pageContext.request.contextPath}/Notice?t_gubun=updateForm&t_board_no=${t_dto.board_no}'">

                        編集

                    </button>



                    <!-- 삭제 -->
                    <button
                        type="button"
                        class="delete_button"
                        onclick="
                            if(confirm('本当に削除しますか？')) {
                                location.href='${pageContext.request.contextPath}/Notice?t_gubun=delete&t_board_no=${t_dto.board_no}';
                            }
                        ">

                        削除

                    </button>


                </c:if>


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

<%@ include file="../member/member_login_modal.jsp" %>
</body>

</html>