<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/member/member.css">

<script src="${pageContext.request.contextPath}/js/jquery-1.8.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>

<title>マイページ | YamMusic</title>

<script type="text/javascript">

function goUpdate(){

    mem.t_gubun.value = "memberUpdate";

    mem.method = "post";
    mem.action = "Member";
    mem.submit();
}


function goBack(){
    history.back();
}

</script>

</head>


<body>

<%@ include file="../common_header.jsp" %>


<section id="myinfo_section">

<form name="mem">

    <input type="hidden" name="t_gubun">
    <input type="hidden" name="t_id" value="${t_dto.id}">


    <div class="myinfo_container">

    <h1>会員情報</h1>

    <div class="myinfo_title_line"></div>


    <div class="myinfo_question">


        <!-- 이름 -->
        <div class="myinfo_group">

            <div class="myinfo_label">
                <i class="fa-regular fa-user"></i>
                <h3>お名前</h3>
            </div>

            <div class="myinfo_value">
                ${t_dto.name}
            </div>

        </div>


        <!-- ID -->
        <div class="myinfo_group">

            <div class="myinfo_label">
                <i class="fa-regular fa-id-card"></i>
                <h3>ID</h3>
            </div>

            <div class="myinfo_value">
                ${t_dto.id}
            </div>

        </div>


      

      <div class="myinfo_group">

    <div class="myinfo_label">
        <i class="fa-solid fa-lock"></i>
        <h3>パスワード</h3>
    </div>

    <div class="myinfo_value">
        <c:forEach begin="1" end="${t_dto.password_length}">
            *
        </c:forEach>
    </div>

</div>

        <!-- 이메일 -->
        <div class="myinfo_group">

            <div class="myinfo_label">
                <i class="fa-regular fa-envelope"></i>
                <h3>メールアドレス</h3>
            </div>

            <div class="myinfo_value">
                ${t_dto.email_1}@${t_dto.email_2}
            </div>

        </div>


    </div>


    <div class="myinfo_button_box">

        <button type="button"
                class="myinfo_update_btn"
                onclick="goUpdate()">
            情報修正
        </button>


        <button type="button"
                class="myinfo_back_btn"
                onclick="history.back()">
            戻る
        </button>

    </div>

</div>
</form>

</section>


</body>
</html>