// 템플릿 소스 준비
let trtemplate = $("#trtemplate").html();
// 템플릿 엔진 준비
let template = Handlebars.compile(trtemplate);

$.getJSON( serverRoot + "/json/board/list", {
		pageNo : 1
	} (data) => {
	
	$(tableBody).html(template({list:data}));
	
    //for(let item of data) {
    	/*let trHTML = template(item); // 엔진에 데이터를 넣어서 템플릿 적용한 소스 생성
    	$(trHTML).appendTo(tableBody);*/
    	
    	
        /*$("<tr>").html("<td><a href='form.html?no=" + item.no + "'>" + item.no  + "</a></td>" + 
		                 "<td>" + item.title + "</td>" + 
		                 "<td>" + item.createdDate + "</td>").appendTo(tableBody); */
		                 
  //}
});