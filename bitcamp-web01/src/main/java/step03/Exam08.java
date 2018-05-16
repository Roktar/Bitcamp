package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 데이터 입력받기
@WebServlet("/step03/exam08")
public class Exam08 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        //get요청의 경우에는 해당 라인은 의미가 없다.
        req.setCharacterEncoding("UTF-8");
        //String name = req.getParameter("name");
        Map<String, String[]> paramMap = req.getParameterMap();
        
        res.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        Set<String> names = paramMap.keySet();
        for(String name : names) {
            out.printf("%s= ", name);
            String[] values = paramMap.get(name);
            
            for(String value : values)
                out.printf("%s ", value);
            out.println();
        }
        
    }
}
