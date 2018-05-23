package step09.ex2;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener3 implements ServletRequestAttributeListener{
    
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.printf("%s의 저장된 값 : %s\n", srae.getName(), srae.getValue());
    }
    
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.printf("%s의 삭제된 값 : %s\n", srae.getName(), srae.getValue());
    }
    
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.printf("%s(%s)의 변경된 값 : %s\n", srae.getName(), srae.getServletRequest().getAttribute(srae.getName()), srae.getValue());
    }
}
