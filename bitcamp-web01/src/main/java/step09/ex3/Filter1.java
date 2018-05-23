package step09.ex3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/step09/ex3/*")
public class Filter1 implements Filter{
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        
        ServletContext ctx = request.getServletContext();
        
        System.out.printf("step09.ex3.Filter1 => %s, %s", ctx.getInitParameter("p1"), ctx.getInitParameter("p2"));
        
        chain.doFilter(request, response);
        
    }
    
}
