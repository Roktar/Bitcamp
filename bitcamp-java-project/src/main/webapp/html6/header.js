let header = $("#header");

// <div id="header> 에 로그인 정보 출력
$.get("/bitcamp-java-project/html6/header.html", data => {
	header.html(data);
	loadLoginUser(); // 비동기를 동시에 2개 사용하는 것은 지양해야함.
});

// 로그인 정보를 스프링으로부터 받아오고 세팅하기
function loadLoginUser() {
	
	$.getJSON("/bitcamp-java-project/json/auth/loginuser", (data) => {
		$("#username").text(data.id);
		$("#logoutBtn").click((e) => {
			e.preventDefault(); // 원래 하던 일이 있는데 그것을 못하게하기
			$.get("/bitcamp-java-project/json/auth/logout", () => {
				location.href = "/bitcamp-java-project/html6/auth/login.html";
			});
		});
	}).fail(() => {
		location.href = "/bitcamp-java-project/html6/auth/login.html";
	});
}