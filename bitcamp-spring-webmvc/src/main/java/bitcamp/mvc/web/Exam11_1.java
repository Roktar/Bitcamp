// 파일 업로드
package bitcamp.mvc.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/exam11_1") 
public class Exam11_1 {    
    
    // 서블릿컨텍스트는 메소드의 매개변수로 받아올 수 없다.
    @Autowired ServletContext sc;
    
    // void로 하는 경우, viewResolver에 등록했던 prefix, suffix는 자동으로 붙고 파일명은 현재 경로가 된다.
    // 즉, WEB-INF/jsp/exam11_1/upload01.jsp 가 된다.
    // ! Ajax 방식이 아닌 jsp를 사용한 단순 파일 업로드-다운로드 방식.
    @RequestMapping(value="upload01", method = RequestMethod.POST)
    public void upload01(String name, int age, Model model, MultipartFile... files) {
        
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("file1", "");
        model.addAttribute("file2", "");
        
        // 파일 경로 구하기
        // - 서버에 저장될 실제 경로를 찾는다.
        // - 빈 폴더인 경우 publish가 안될 경우도 있다. 따라서 readMe 파일은 하나 있는 게 좋다.
        String filesDir = sc.getRealPath("/files");
        
        int i=0;
        
        for(MultipartFile file : files) {
            // 저장 시 파일명을 랜덤하게 지정하여 저장하는 방법
            // UUID 클래스를 사용한다. 실시간으로 계속 바뀌고 왠만해서는 중복될 일이 없기 때문에 주로 사용.
            String fileName = UUID.randomUUID().toString();
            model.addAttribute("file" + i + "Origin", file.getOriginalFilename());
            model.addAttribute("file" + i++ + "New",  fileName);
            
            // 꺼낸 파일을 실제 경로로 이동시킨다.
            // - 새로운 파일 객체를 만들고 그 파일 객체에 정보를 넘겨주고 실제 파일로 만든다.
            try {
                File path = new File(filesDir+"/"+fileName);
                System.out.println(path);
                file.transferTo(path);
            } catch (IllegalStateException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }
}

