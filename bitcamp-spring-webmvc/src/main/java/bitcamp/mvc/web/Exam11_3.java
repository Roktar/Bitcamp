// 파일 업로드 - JSON
package bitcamp.mvc.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController 
@RequestMapping("/exam11_3") 
public class Exam11_3 {    
    
    // 서블릿컨텍스트는 메소드의 매개변수로 받아올 수 없다.
    @Autowired ServletContext sc;
    
    // RestController를 사용하여 일반 텍스트 형식으로 내보낸다.
    @RequestMapping(value="upload01", method = RequestMethod.POST)
    public Object upload01(MultipartFile files) { 
        // blueimp-file-upload를 사용하면 하나의 파일단위로 이 메소드를 여러번 호출하기때문에 매개변수를 배열로 받아오지않는다.
        // 단 옵션을 지정하면 한 번에 여러개의 파일을 보낼 수 있도록 설정할 수 있다.
        Map<String, Object> data = new HashMap<>();
                
        // 파일 경로 구하기
        // - 서버에 저장될 실제 경로를 찾는다.
        // - 빈 폴더인 경우 publish가 안될 경우도 있다. 따라서 readMe 파일은 하나 있는 게 좋다.
        String filesDir = sc.getRealPath("/files");
        // 저장 시 파일명을 랜덤하게 지정하여 저장하는 방법
        // UUID 클래스를 사용한다. 실시간으로 계속 바뀌고 왠만해서는 중복될 일이 없기 때문에 주로 사용.
        String fileName = UUID.randomUUID().toString();
        
        data.put("filesize", files.getSize());
        data.put("originFileName", files.getOriginalFilename());
        data.put("fileName", fileName);
        
        // 꺼낸 파일을 실제 경로로 이동시킨다.
        // - 새로운 파일 객체를 만들고 그 파일 객체에 정보를 넘겨주고 실제 파일로 만든다.
        try {
            File path = new File(filesDir+"/"+fileName);
            System.out.println(path);
            files.transferTo(path);
        } catch (IllegalStateException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
    }
}

