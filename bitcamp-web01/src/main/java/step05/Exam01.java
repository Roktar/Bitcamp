package step05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 파일 업로드
@WebServlet("/step05/exam01")
public class Exam01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String name = req.getParameter("name");
        //int age = Integer.parseInt(req.getParameter("age"));
        String age = req.getParameter("age");
        String photo = req.getParameter("photo");
        
        res.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = res.getWriter();

        out.printf("이름:%s\n", name);
        out.printf("나이:%s\n", age);
        out.printf("사진:%s\n", photo);
    }
}
