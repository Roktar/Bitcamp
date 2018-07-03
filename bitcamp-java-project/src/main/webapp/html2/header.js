let header = $("#header");

// <div id="header> 에 로그인 정보 출력
$.get("/bitcamp-java-project/html2/header.html", data => {
	header.html(data);
	loadLoginUser(); // 비동기를 동시에 2개 사용하는 것은 지양해야함.
});

// 로그인 정보를 스프링으로부터 받아오고 세팅하기
function loadLoginUser() {
	$.getJSON("/bitcamp-java-project/json/auth/loginuser", data => {
		if(data == "") {
			location.href="/bitcamp-java-project/json/auth/loginuser";
		} else { 
			$("#username").text(data.id);
			$("#logoutBtn").click( event => {
				event.preventDefault(); // 원래 하던 것이 있었는데 하던 것을 그만하라고 하는 것(?)
				
				$.get("/bitcamp-java-project/json/auth/logout", {}, () => {
					location.href="/bitcamp-java-project/html2/auth/login.html";
				})
				
			});
		}
	});
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
	    if (xhr.readyState == 4) {
	        if (xhr.status == 200) {
	            if(xhr.responseText == "")  {
	            	location.href="/bitcamp-java-project/html2/auth/login.html";
	            	return;
	            }
	            let data = JSON.parse(xhr.responseText);
	            document.querySelector("#username").textContent = data.id;
	            	
	        }
	    }
	};
	xhr.open("GET", "/bitcamp-java-project/json/auth/loginuser", false);
	xhr.send();
}