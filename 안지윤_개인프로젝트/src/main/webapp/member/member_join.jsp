<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<title>Track27 안지윤</title>
<title>Insert title here</title>
<link href="member/member.css" rel="stylesheet">
</head>
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">


function goSave(){
	 if(checkEmpty(mem.t_name,"お名前を入力してください。")) return;
    if(checkEmpty(mem.t_id,"IDを入力してください。")) return;

    if(mem.t_id_check.value==""){
        alert("IDの重複確認を行ってください。");
        return;
    }

    if(mem.t_id_check.value=="使用不可"){
        alert("このIDは使用できません。");
        mem.t_id.focus();
        return;
    }

   

    if(checkEmpty(mem.t_password,"パスワードを入力してください。")) return;

    if(checkEmpty(mem.t_password_confirm,"確認用パスワードを入力してください。")) return;

    if(mem.t_password.value != mem.t_password_confirm.value){
        alert("パスワードが一致していません。");
        mem.t_password_confirm.focus();
        return;
    }

    if(checkEmpty(mem.t_email_1,"メールアドレスを入力してください。")) return;

    if(checkEmpty(mem.t_email_2,"メールアドレスを選択してください。")) return;

    if(!mem.t_agree.checked){
        alert("利用規約とプライバシーポリシーに同意してください。");
        mem.t_agree.focus();
        return;
    }

    mem.t_gubun.value="memberSave";
    mem.method="post";
    mem.action="Member";
    mem.submit();
}
 //중복검사
function checkId(){

    if(checkEmpty(mem.t_id,"IDを入力してから重複確認を行ってください。")) return;

    var id = mem.t_id.value;

    $.ajax({
        type : "POST",
        url : "Member",

        data : {
            t_gubun : "checkId",
            t_id : id
        },

        dataType : "text",

        error : function(){
            alert("通信に失敗しました。");
        },

        success : function(data){

            var result = $.trim(data);

            mem.t_id_check.value = result;

            if(result == "使用可能"){
                alert("使用可能なIDです。");

            }else if(result == "使用不可"){
                alert("このIDはすでに使用されています。");

            }else{
                alert("サーバーからの応答に問題があります。");
            }
        }
    });
}
 function setEmpty(){
     mem.t_id_check.value="";
  }
 </script>
<body>

<%@ include file="../common_header.jsp" %>

<section id="join_section">
<form name="mem">
<input type="hidden" name=t_gubun>
<div class="join_container">

<h1>新規会員登録</h1>

<div class="join_question">

<div class="join_group">

<h3 class="namebox">お名前（氏名）</h3>
<input type ="text" name="t_name" class="name_input">
</div>

<div class="join_group">
<h3 class="idbox">ID</h3>
<input type ="text" name="t_id" class="id_input">
<input type="button" onclick="checkId()" class="id_check_btn" value="ID重複確認">
<input type="hidden"   name = "t_id_check" >
</div>

<div class="join_group">
<h3 >利用するパスワード</h3>
<input type ="password" name="t_password" class="password_input">
</div>

<div class="join_group">
<h3>パスワード（確認）</h3>
<input type ="password" name="t_password_confirm" class="password_input">
</div>


<!-- <div class="join_group">
<h3 class="tellbox">電話番号</h3>
<input type="text" class="tell_input">

</div> -->


<div class="join_group">
<h3>メールアドレス</h3>
<input type="text" name="t_email_1" class="mail_input">
<span class="address_sign">@</span>
<select class="mail_addre" name="t_email_2">
<option>naver.com</option>
<option>daum.net</option>
<option>google.com</option>

</select>
</div>
<!-- <h3>PLAN選択</h3>
<input type="radio" class="plan_input">Basic PLAN
<input type="radio" class="plan_input">Standard PLAN
<input type="radio" class="plan_input">Premium PLAN -->
</div>


<input type="checkbox" name="t_agree" class="check_info">
<span class="info_text" >利用規約とプライバシーポリシーに同意しますか？</span>

<div class="join_button">
<button type="button" onclick="goSave()">
会員登録する（無料）
</button>
</div>



</div>
</form>
   </section>

</body>

</html>