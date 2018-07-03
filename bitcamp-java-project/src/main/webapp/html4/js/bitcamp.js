// 자바스크립트 함수를 모아둔 라이브러리 파일

// 태그 생성, JQuery 도큐먼트에서 .~로 시작하는 함수들
var jQuery = function(param) {
	let tags;
	
	if(param instanceof HTMLElement) {
		// 파라미터값이 일반 태그일 때, 배열에 담고 도우미 함수를 붙여서 반환
		// param이 fno일 때, tags = [ fno ]가 되고 fno 안에는 여러 함수가 있을 것.
		tags = [param];
	} else if(param.startsWith("<")) {
		let tagName = param.substr(1, param.length -2 );
		tags = [document.createElement(tagName)];
	} else if(param.startsWith(".")) {
		tags = document.querySelectorAll(param);
	} else if(param.startsWith("#") ) {
		tags = [document.querySelector(param)];
	}
	
	tags.html = value => {
		for(let tag of tags)
			tag.innerHTML = value;
		return tags;
	}
	
	tags.appendTo = parent => {
		for(let tag of tags)
			parent.appendChild(tag);
		return tags;
	}
	
	tags.css = (styleName, value) => {
		console.log(tags);
		for(let tag of tags) {
			console.log(tag);
    		tag.style[styleName] = value;
		}
		return tags;
	} 
	
    tags.val = function(value) {
    	if (arguments.length == 0)
    		return tags[0].value;
    	for (var tag of tags)
    		tag.value = value;
    	return tags;
    };
	
	tags.click = listener => {
		for(let tag of tags)
			tag.addEventListener("click", listener);
		return tags;
	}
	
	tags.text = value => {
		for(let tag of tags)
			tag.textContent = value;
		return tags;
	}
	
	tags.is = s => {
		console.log(tags);
		if(tags[0].querySelectorAll(s).length > 0 )
			return true;
		
		return false;
	}
	
	return tags;
};

// settings는 호출하는 쪽에서 객체로 보낸다.
// ex) ajax("123", {
//					 method : "POST",
//					 data : {
//								name:kil, age=15 .. },
//	   });


// 이하 Document에서 JQuery가 앞에 붙는 메소드들.
jQuery.ajax = function(url, settings) { // settings가 비어잇는 경우, 빈 객체로 만든다.
	if(settings == undefined || settings == null)
		settings = {};
	
	if(settings.method == undefined)
		settings.method = "GET"; // 요청방식이 지정되지않은 경우 GET방식으로 한다.
	
	if(settings.dataType == undefined) // 서버에 반환되는 데이터의 타입을 의미한다.
		settings.dataType = "text";
	
	 var xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = () => {
	        if (xhr.readyState == 4) {
	            if (xhr.status == 200 || xhr.status == 201) {
	              if(settings.success == undefined) // success에 함수가 지정된 게 없으면 반환하지않음.
	            	  return

            	  if(settings.dataType == "text") // 데이터타입 검증
            		  settings.success(xhr.responseText); // text형식으로 값을 넘겨준다.
            	  else if(settings.dataType == "json") // 데이터타입 검증
            		  settings.success(JSON.parse(xhr.responseText));
	            } else {
	            	if(settings.error) // error에 대한 함수가 등록되어있는 경우 그걸 호출.
	            		settings.error();
	            }
	        }
	    };
	    
	    
	    if(settings.method === "POST" || settings.method === "post") {
	    	xhr.open(settings.method, url, true);
	    	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    	
	    	// 파라미터형식으로 들어온다는 것으로 가정한다.
	    	// name=kil&age=15&phone=010-123-1234 ...
	    	
	    	xhr.send(jQuery.toQueryString(settings.data));
	    } else {
	    	if(url.indexOf("?") != -1)
	    		url += "&" + jQuery.toQueryString(settings.data);
	    	else 
	    		url += "?" + jQuery.toQueryString(settings.data);
	    	
	    	xhr.open(settings.method, url, true);
	    	xhr.send();
	    }
}

jQuery.toQueryString = obj => {
	let qs = "";
	
	if(obj) {
		for(let key in obj) {
			if(qs.length > 0)
				qs += "&";
			qs += key + "=" + encodeURIComponent(obj[key]);
		}
	}
	
	return qs;
}

jQuery.getJSON = function(url, data, success) {
	// 호출 예시 1 : getJSON("board/list");
	// - data : undefined, success : undefined
	// 호출 예시 2 : getJSON("board/list", {pageNo:1, pageSize:5});
	// - data : data, success : undefined
	// 호출 예시 3 : getJSON("board/list", {pageNo:1, pageSIze:5}, function(data) {...});
	// - data : data, success : success
	// 호출 예시 4 : getJSON("board/list", function(data) {...});
	if(data == undefined || typeof data != "function") {
		jQuery.ajax(url, {
			"data":data,
			"dataType":"json",
			"success":success
		});
		// 호출 예시 1, 2, 3
	} else if(typeof data == "function") {
		jQuery.ajax(url, {
			"dataType":"json",
			"success":data
		});
		// 호출 예시 4
	}
};

jQuery.post = function(url, data, success, dataType) {
	let settings = {
			method:"POST"
	} // 요청 객체 원형
	
	if(arguments.length == 2) {
		if(typeof data == "function") {
			settings.success = data;
		} else if(typeof data == "string") {
			settings.dataType=data;
		} else
			settings.data = data;
	} else if(arguments.length == 3) {
		if(typeof success == "function") {
			settings.data = data;
			settings.success = success;
		} else if(typeof success == "string") {
			settings.dataType = success;
			
			if(typeof data == "function")
				settings.success = data;
			else
				settings.data = data;
			
		}
	} else if(arguments.length == 4) {
		settings.data = data;
		settings.success = success;
		settings.dataType = dataType;
	}
	
	jQuery.ajax(url, settings);
};


jQuery.get = function(url, data, success, dataType) {
	let settings = {
			method:"GET"
	} // 요청 객체 원형
	
	if(arguments.length == 2) {
		if(typeof data == "function") {
			settings.success = data;
		} else if(typeof data == "string") {
			settings.dataType=data;
		} else
			settings.data = data;
	} else if(arguments.length == 3) {
		if(typeof success == "function") {
			settings.data = data;
			settings.success = success;
		} else if(typeof success == "string") {
			settings.dataType = success;
			
			if(typeof data == "function")
				settings.success = data;
			else
				settings.data = data;
			
		}
	} else if(arguments.length == 4) {
		settings.data = data;
		settings.success = success;
		settings.dataType = dataType;
	}
	
	jQuery.ajax(url, settings);
};



jQuery.printThis = () => {
	console.log(this);
}

// 2번째 인자로 데이터대신 바로 success를 줄 수도 있다. ==> 그걸 위한 처리가 else에 있는 거.

var $ = jQuery;

// 위에서 만든 건 다음과 같다.
/*bitcamp.js
bitcamp = { ajax : function(){...} }*/