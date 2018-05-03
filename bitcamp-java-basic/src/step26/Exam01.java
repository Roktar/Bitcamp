package step26;

import java.io.FileReader;
import java.util.Properties;

public class Exam01 {
    static String fileName  = "message";
    static String userLanguage = "en";
    static String userCountry = "enUS";
    static Properties label;

    static void init() throws Exception {
        // user는 자동적으로 생성되어 사용하는 객체인가봄.
        System.out.println(System.getProperty("user.country"));
        System.out.println(System.getProperty("user.language"));
        if(System.getProperty("user.country") != null)
            userCountry = System.getProperty("user.country");
        if(System.getProperty("user.language") != null)
            userLanguage = System.getProperty("user.language");
        
        label = new Properties();
        label.load(new FileReader(String.format("%s-%s%s.properties", fileName, userLanguage, userCountry)));
    }
    
    public static void main(String[] args) throws Exception {
        init();
        
        //다음은 화면에 텍스트를 출력할 때, 직접 입력한 값을 출력하는 것이 아닌
        //프로퍼티 파일에서 읽은 값을 출력
        
        //이유 : 다양한 언어로 출력하기위함
        //즉, 다국어를 제공할 수 있도록 개발된 프로그램을 "국제화(i18n)"라고 한다.
        System.out.println(label.get("welcome"));
        
        //지역화(l10n)
        //국제화를 지원하는 프로그램의 경우, 메뉴명.라벨명.버튼명 등
        //화면에서 출력하는 텍스트를 별도의 프로퍼티 파일에 저장

    }
}
