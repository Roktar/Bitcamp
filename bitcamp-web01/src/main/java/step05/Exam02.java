package step05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

// 파일 업로드
@WebServlet("/step05/exam02")
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        
        // 1) 멀티파트형식인 지 확인
        if(!isMultipart) {
            out.println("멀티파트 형식이 아닙니다.");
            return;
        }
        
        // 2) 저장할 공장 준비
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        // 3) 분석기에 공장 장착
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        //Map<String, String> pMap = new HashMap<>();
        
        // 4) 멀티파트로 전송된 요청 데이터 분석하기
        try {
            List<FileItem> items = upload.parseRequest(req);
            
            // 5) 데이터를 둘러보기
            for(FileItem item : items) {
                if(item.isFormField()) { // 일반적인 텍스트 항목인가?          
                    //pMap.put(item.getFieldName(), item.get)
                    out.printf("%s=%s\n", item.getFieldName(), item.getString("UTF-8"));
                } else {
                    //out.printf("%s=%s\n", item.getFieldName(), item.getName());
                    // 여기서는 특정 폴더를 지정하여 저장한다.
                    // 저장되는 곳은 루트폴더다.
                    ServletContext appEnvInfo = req.getServletContext();
                    String savePath = appEnvInfo.getRealPath("/");
                    
                    out.printf(savePath);
                    
                    item.write(new File(savePath + "/" + item.getName()));
                }
            }
            
        } catch(Exception e) {
            
        }
    }
}
