var fNo = document.querySelector("#fNo"),
    fTitle = document.querySelector("#fTitle"),
    fContent = document.querySelector("#fContent"),
    fCreatedDate = document.querySelector("#fCreatedDate");
    
    
if (location.href.split("?").length > 1) {
	
    /*var tags = document.querySelectorAll(".input-view"); */
    var tags = $(".input-view");
    /*for (var tag of tags)
        tag.style.display = "none"; */
    tags.css("display", "none");
    
    
    var no = location.href.split("?")[1].split("=")[1];
    
    $.getJSON(serverRoot+"/json/board/"+no, data => {
/* 		fNo.value = data.no;
		fTitle.value = data.title;
		fContent.value = data.content;
		fCreatedDate.value = data.createdDate; */
        $(fNo).val(data.no);
        $(fTitle).val(data.title);
        $(fContent).val(data.content);
        $(fCreatedDate).val(data.createdDate);
    });
    
    $("#updBtn").click( () => {
    	$.post(serverRoot6"/json/board/update", {
    		no:$(fNo).val(),
    		title:$(fTitle).val(),
    		content:$(fContent).val(),
    	}, () => {
    		location.href = "list.html";
    	});
    }); 
    
/*     document.querySelector("#updBtn").onclick = () => {
    	 var xhr = new XMLHttpRequest();
         xhr.onreadystatechange = () => {
             if (xhr.readyState == 4) {
                 if (xhr.status == 200) {
                     location.href = "list.html";
                 } else {
                     window.alert("변경 실패!")
                 }
             }
         };
         
         xhr.open("POST", "../../json/board/update", true);
         xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
         //주의!
         //=> 자바스크립트의 AJAX를 사용하여 직접 서버에 한글을 포함하는 데이터를 보낼 때는
         //   개발자가 URL 인코딩 해서 보내야 한다.
         xhr.send("title=" + encodeURIComponent(fTitle.value) + 
                 "&content=" + encodeURIComponent(fContent.value) + 
                 "&no=" + fNo.value);
    }; */
    
    
    $("#delBtn").click( () => {
        if(confirm("정말 삭제?") == false)
            return;
        
        $.get(serverRoot"/json/board/delete", {
        	"no":no
        }, () => {
        	location.href="list.html";
        });
    });
    
/*     document.querySelector("#delBtn").onclick = () => {
    	if(confirm("정말 삭제?") == false)
    		return;
    	
        var xhr = new XMLHttpRequest();
        var no = location.href.split("?")[1].split("=")[1];
        
        console.log(no);
        
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200)
                    location.href = "list.html";
                else
                    window.alert("삭제 실패!")
            }
        };
        
        xhr.open("GET", "../../json/board/delete?no=" + no, true);
        //주의!
        //=> 자바스크립트의 AJAX를 사용하여 직접 서버에 한글을 포함하는 데이터를 보낼 때는
        //   개발자가 URL 인코딩 해서 보내야 한다.
        xhr.send();
    }; */

    
} else { // 새 글 등록
	let tags = $(".detail-view");
    tags.css("display", "none");
    
    $("#addBtn").click(function() {
    	console.log("input called");
	    $.post(serverRoot+"/json/board/add", {
		    	title:$(fTitle).val(),
		    	content:$(fContent).val()
		    }, function() {
		    	location.href="list.html";
	    });
    });
}