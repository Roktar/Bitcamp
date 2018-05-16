package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 데이터 입력받기
@WebServlet("/step03/exam06")
public class Exam06 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        //get요청의 경우에는 해당 라인은 의미가 없다.
        req.setCharacterEncoding("UTF-8");
        //String name = req.getParameter("name");
        String[] names = req.getParameterValues("name");
        
        res.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        for(String name : names)
            out.printf("이름 : %s\n", name);
    }
}
