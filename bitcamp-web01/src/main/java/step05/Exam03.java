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
@WebServlet("/step05/exam03")
public class Exam03 extends HttpServlet {
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
        
        // 4) 멀티파트로 전송된 요청 데이터 분석하기
        try {
            Map<String, List<FileItem>> pMap = upload.parseParameterMap(req);
            FileItem photo = pMap.get("photo").get(0);
            out.printf("name=%s\n", pMap.get("name").get(0).getString("UTF-8"));
            out.printf("age=%s\n", pMap.get("age").get(0).getString());
 
            ServletContext appEnvInfo = req.getServletContext();
            String savePath = appEnvInfo.getRealPath("/");
            
            out.printf(savePath);
            photo.write(new File(savePath + "/" + photo.getName()));
            
                    
        } catch(Exception e) {
            
        }
    }
}
