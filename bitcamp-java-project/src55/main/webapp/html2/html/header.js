// <div id="header> 에 로그인 정보 출력
let logxhr = new XMLHttpRequest();
logxhr.open("GET", "../../html/header.html", false);
logxhr.send();
window.header.innerHTML = logxhr.responseText;

// 로그인 정보를 스프링으로부터 받아오고 세팅하기
var xhr = new XMLHttpRequest();
xhr.onreadystatechange = () => {
    if (xhr.readyState == 4) {
        if (xhr.status == 200) {
            if(xhr.responseText == "")  {
            	location.href="/bitcamp-java-project/html/auth/login.html";
            	return;
            }
            let data = JSON.parse(xhr.responseText);
            document.querySelector("#username").textContent = data.id;
            	
        }
    }
};
xhr.open("GET", "/bitcamp-java-project/json/auth/loginuser", false);
xhr.send();