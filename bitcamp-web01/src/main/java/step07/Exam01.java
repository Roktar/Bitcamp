package step07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 생성과 load-on-startup 옵션
@WebServlet("/step07/exam01")
public class Exam01 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Exam01() {
        System.out.println("------ step07.Exam01() ");
    }
    
    @Override
    public void init() throws ServletException {
        
        System.out.println("------ step07.Exam01.init()");
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------ step07.Exam01.service()[doGet()]");
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
    }
}
