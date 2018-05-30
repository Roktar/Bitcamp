// 로그아웃 처리 서블릿 - 세션을 무효화시킨다.
package bitcamp.java106.pms.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/auth/logout")
public class LogoutController {

    @RequestMapping
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        
        String refererUrl = request.getHeader("Referer");
        
        if(refererUrl == null)
            refererUrl = request.getContextPath();
        System.out.println("logout-ref:" + refererUrl);
        return "redirect:"+refererUrl;
    }
}

//ver 41 - 클래스 추가