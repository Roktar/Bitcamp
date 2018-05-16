package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 데이터 입력받기
@WebServlet("/step03/exam07")
public class Exam07 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        //get요청의 경우에는 해당 라인은 의미가 없다.
        req.setCharacterEncoding("UTF-8");
        //String name = req.getParameter("name");
        Enumeration<String> names = req.getParameterNames();
        
        res.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        // 클라이언트가 어떤 값을 보내는 지 애매할 때 사용하라.
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            out.printf("%s : %s \n", name, req.getParameter(name));
        }
    }
}
