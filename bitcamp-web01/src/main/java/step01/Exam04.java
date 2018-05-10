package step01;

import javax.servlet.annotation.WebServlet;

//Servlet 생성
// - http 프로토콜을 다루는 기능이 추가된 HttpServlet 상속
@WebServlet("/step01/exam04")
public class Exam04 extends HttpServlet {
    // 클라이언트로부터 요청이 들어오면
    // HTTP 명령에 따라 do 메소드 중 하나가 호출될 것이다.
    // 재정의하지않았기때문에 원래 썼던대로 실행될 것이다.
    
}
