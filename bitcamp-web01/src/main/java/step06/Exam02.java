package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HTML 출력
@WebServlet("/step06/exam02")
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>/step06/exam02</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>성적 입력</h1>");
        out.println("<form action='exam02' method='post'>");
        out.println("이름 <input type=text name='name'><br>");
        out.println("국어 <input type=text name='kor'><br>");
        out.println("영어 <input type=text name='eng'><br>");
        out.println("수학 <input type=text name='math'><br>");
        out.println("<button> 계산 </button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int kor = Integer.parseInt(req.getParameter("kor"));
        int eng = Integer.parseInt(req.getParameter("eng"));
        int math = Integer.parseInt(req.getParameter("math"));
        int sum = kor+eng+math;
        float avg = sum/3f;
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>/step06/exam02</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>성적 입력</h1>");
        out.println("이름 : " + name + "<br>");
        out.printf("국어 : %d <br>", kor);
        out.printf("영어 : %d <br>", eng);
        out.printf("수학 : %d <br>", math);
        out.printf("합계 : %d <br>", sum);
        out.printf("평균 : %.1f <br>", avg);
        out.println("</body>");
        out.println("</html>");
        
        
    }
}
