<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn"
    uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>マイページ | YamMusic</title>

<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="stylesheet"
    href="${pageContext.request.contextPath}/member/member.css">


<script type="text/javascript">

function goUpdateForm() {

    mem.t_gubun.value = "memberUpdateForm";

    mem.method = "post";

    mem.action =
        "${pageContext.request.contextPath}/Member";

    mem.submit();
}


function goBack() {

    location.href =
        "${pageContext.request.contextPath}/index";
}


function goExit() {

    if(confirm("本当に退会しますか？")) {

        mem.t_gubun.value = "memberExit";

        mem.method = "post";

        mem.action =
            "${pageContext.request.contextPath}/Member";

        mem.submit();
    }
}

</script>

</head>


<body>


<%@ include file="../common_header.jsp" %>


<section id="myinfo_section">


<form name="mem">


    <input type="hidden"
        name="t_gubun">


    <div class="myinfo_container">


        <h1>
            マイページ
        </h1>


        <div class="myinfo_title_line"></div>



        <!-- 이름 -->
        <div class="myinfo_group">

            <div class="myinfo_label">

                <i class="fa-regular fa-user"></i>

                <h3>
                    お名前
                </h3>

            </div>


            <div class="myinfo_value">

                ${t_dto.name}

            </div>

        </div>



        <!-- ID -->
        <div class="myinfo_group">

            <div class="myinfo_label">

                <i class="fa-regular fa-id-card"></i>

                <h3>
                    ID
                </h3>

            </div>


            <div class="myinfo_value">

                ${t_dto.id}

            </div>

        </div>



        <!-- 비밀번호 -->
        <div class="myinfo_group">

            <div class="myinfo_label">

                <i class="fa-solid fa-lock"></i>

                <h3>
                    パスワード
                </h3>

            </div>


            <div class="myinfo_value">

                <c:forEach
                    begin="1"
                    end="${t_dto.password_length}">
                    *
                </c:forEach>

            </div>

        </div>



        <!-- 이메일 -->
        <div class="myinfo_group">

            <div class="myinfo_label">

                <i class="fa-regular fa-envelope"></i>

                <h3>
                    メール
                </h3>

            </div>


            <div class="myinfo_value">

                ${t_dto.email_1}@${t_dto.email_2}

            </div>

        </div>



        <!-- 등록일 -->
        <div class="myinfo_group">

            <div class="myinfo_label">

                <i class="fa-regular fa-calendar"></i>

                <h3>
                    登録日
                </h3>

            </div>


            <div class="myinfo_value">

                ${fn:substring(t_dto.reg_date, 0, 10)}

            </div>

        </div>



        <!-- 변경일 -->
        <div class="myinfo_group">

            <div class="myinfo_label">

                <i class="fa-regular fa-clock"></i>

                <h3>
                    更新日
                </h3>

            </div>


            <div class="myinfo_value">

                <c:choose>

                    <c:when test="${not empty t_dto.update_date}">

                        ${fn:substring(t_dto.update_date, 0, 10)}

                    </c:when>

                    <c:otherwise>
                        -
                    </c:otherwise>

                </c:choose>

            </div>

        </div>



        <!-- 버튼 3개 -->
        <div class="myinfo_button_box">


            <button
                type="button"
                class="myinfo_update_btn"
                onclick="goUpdateForm()">

                情報修正

            </button>


            <button
                type="button"
                class="myinfo_back_btn"
                onclick="goBack()">

                戻る

            </button>


            <button
                type="button"
                class="myinfo_exit_btn"
                onclick="goExit()">

                退会

            </button>


        </div>


    </div>


</form>


</section>


</body>

</html>