package bitcamp.java106.pms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 필터 적용대상 : 모든 서블릿
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    FilterConfig config;
    String encoding = "UTF-8";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        
        if(config.getInitParameter("encoding") != null)
            this.encoding = config.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //service()호출 전 실행되는 공간
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
        //---
        // service() 호출 후 실행되는 공간
        
        //---
    }
}
