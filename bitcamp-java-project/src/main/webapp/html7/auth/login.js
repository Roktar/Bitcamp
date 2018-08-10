$("#loginBtn").click( function() {
	
	let data = {
			id:$(fId).val(),
			password:$(fPassword).val()
	}
	
	if($(document.body).is("#fSaveId:checked")) {
		//data.saveId = "true";
		document.cookie += "userId=" + $(fId).val() + ";";
	}
	
 	$.post(serverRoot+"/json/auth/login",
	data, 
	res => {
		if(res.state == "success")
			location.href="../board/list.html"; // 서버로부터 뭔갈 받는 게 아니기때문에 상대경로 사용 OK
		else
			window.alert("로그인 실패");
	}, "json");
});
