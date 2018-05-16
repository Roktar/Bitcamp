package step07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 생성과 load-on 생성
@WebServlet(value="/step07/exam02", // servlet URL 
            loadOnStartup=1)
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Exam02() {
        System.out.println("------ step07.Exam02() ");
    }
    
    @Override
    public void init() throws ServletException {
        System.out.println("------ step07.Exam02.init()");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------ step07.Exam02.service()[doGet()]");
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
    }
}
