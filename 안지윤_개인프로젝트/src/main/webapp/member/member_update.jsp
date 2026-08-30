<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>会員情報修正 | YamMusic</title>

<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="stylesheet"
    href="${pageContext.request.contextPath}/member/member.css">

<script type="text/javascript">

function goUpdate() {

    if(mem.t_name.value == "") {

        alert("お名前を入力してください。");

        mem.t_name.focus();

        return;
    }


    if(mem.t_password.value == "") {

        alert("新しいパスワードを入力してください。");

        mem.t_password.focus();

        return;
    }


    if(mem.t_password_confirm.value == "") {

        alert("パスワード確認を入力してください。");

        mem.t_password_confirm.focus();

        return;
    }


    if(mem.t_password.value !=
            mem.t_password_confirm.value) {

        alert("パスワードが一致しません。");

        mem.t_password_confirm.focus();

        return;
    }


    if(mem.t_email_1.value == "") {

        alert("メールアドレスを入力してください。");

        mem.t_email_1.focus();

        return;
    }


    mem.t_gubun.value = "memberUpdate";

    mem.method = "post";

    mem.action =
        "${pageContext.request.contextPath}/Member";

    mem.submit();
}


function goBack() {

    location.href =
        "${pageContext.request.contextPath}/Member?t_gubun=myinfo";
}

</script>

</head>


<body>


<%@ include file="../common_header.jsp" %>


<section id="myinfo_section">


<form name="mem">


    <input type="hidden"
        name="t_gubun">


    <input type="hidden"
        name="t_id"
        value="${t_dto.id}">


    <div class="myinfo_container">


        <h1>
            会員情報修正
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

                <input type="text"
                    name="t_name"
                    value="${t_dto.name}"
                    maxlength="20">

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

                <input type="text"
                    value="${t_dto.id}"
                    readonly>

            </div>


        </div>



        <!-- 현재 비밀번호 -->
        <div class="myinfo_group">


            <div class="myinfo_label">

                <i class="fa-solid fa-lock"></i>

                <h3>
                    現在のパスワード
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



        <!-- 새 비밀번호 -->
        <div class="myinfo_group">


            <div class="myinfo_label">

                <i class="fa-solid fa-key"></i>

                <h3>
                    新しいパスワード
                </h3>

            </div>


            <div class="myinfo_value">

                <input type="password"
                    name="t_password"
                    maxlength="20"
                    placeholder="新しいパスワード">

            </div>


        </div>



        <!-- 비밀번호 확인 -->
        <div class="myinfo_group">


            <div class="myinfo_label">

                <i class="fa-solid fa-check"></i>

                <h3>
                    パスワード確認
                </h3>

            </div>


            <div class="myinfo_value">

                <input type="password"
                    name="t_password_confirm"
                    maxlength="20"
                    placeholder="もう一度入力してください">

            </div>


        </div>



        <!-- 이메일 -->
        <div class="myinfo_email_group">


            <div class="myinfo_label">

                <i class="fa-regular fa-envelope"></i>

                <h3>
                    メール
                </h3>

            </div>


            <div class="myinfo_email_value">


                <input type="text"
                    name="t_email_1"
                    class="mail_input"
                    value="${t_dto.email_1}"
                    maxlength="50">


                <span class="address_sign">
                    @
                </span>


                <select
                    name="t_email_2"
                    class="mail_addre">


                    <option value="naver.com"
                        <c:if test="${t_dto.email_2 eq 'naver.com'}">
                            selected
                        </c:if>>
                        naver.com
                    </option>


                    <option value="daum.net"
                        <c:if test="${t_dto.email_2 eq 'daum.net'}">
                            selected
                        </c:if>>
                        daum.net
                    </option>


                    <option value="google.com"
                        <c:if test="${t_dto.email_2 eq 'google.com'}">
                            selected
                        </c:if>>
                        google.com
                    </option>


                </select>


            </div>


        </div>



        <div class="myinfo_button_box">


            <button
                type="button"
                class="myinfo_update_btn"
                onclick="goUpdate()">

                情報修正

            </button>


            <button
                type="button"
                class="myinfo_back_btn"
                onclick="goBack()">

                戻る

            </button>


        </div>


    </div>


</form>


</section>


</body>

</html>