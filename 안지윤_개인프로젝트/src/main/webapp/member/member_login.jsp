 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="main.css" rel="stylesheet">
<script type="text/javascript">

function goLogin() {

    var login = document.login;

    if(login.t_id.value == "") {

        alert("IDを入力してください.");

        login.t_id.focus();

        return;
    }


    if(login.t_password.value == "") {

        alert("パスワードを入力してください.");

        login.t_password.focus();

        return;
    }


    login.method = "post";

    login.action =
        "${pageContext.request.contextPath}/Member";

    login.submit();
}

</script>
</head>
<body>


	<div class="modal_login">


    <div class="login_container">


        <div class="login_exit">
            &times;
        </div>


        <h1>
           ログイン
        </h1>


<form name="login">
      <input type="hidden" name="t_gubun" value="memberLogin">
        <div class="id_pass_text">
				<div class="id_box">
			       
			          <input type="text" name="t_id" class="id_input" placeholder="ID">
				</div>
				<div class="password_box">
			            <input type="password" name="t_password" class="password_input" placeholder="パスワード">
				</div>
        </div>


        <div class="login_button">

            <button type="button"  class="login_click"  onclick="goLogin()">
                ログイン
            </button>

        </div>
</form>

        <div class="login_footer">

            <a href="member/member_join.html">
                会員登録
            </a>

            <a>|</a>

            <a href="#">
               パスワードを忘れた方
            </a>

        </div>


    </div>


</div>





</body>
</html>