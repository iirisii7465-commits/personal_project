// 모달 가져오기
const modal = document.querySelector(".modal_login");

// 헤더 로그인 버튼
const loginBtn = document.querySelector(".login");
if(loginBtn && modal){
    loginBtn.onclick = function(){
        modal.style.display = "flex";
    };
}

// 히어로 로그인 버튼
const button2 = document.querySelector(".button_2");
if(button2 && modal){
    button2.onclick = function(){
        modal.style.display = "flex";
    };
}

// X 버튼
const loginExit = document.querySelector(".login_exit");
if(loginExit && modal){
    loginExit.onclick = function(){
        modal.style.display = "none";
    };
}

// 모달 바깥 클릭 시 닫기
window.onclick = function(e){
    if(modal && e.target == modal){
        modal.style.display = "none";
    }
};