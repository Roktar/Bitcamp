package step17.ex2;

public class Category2 {
    
    // static nested class를 사용하여 
    // 여러 상수를 그룹별로 묶어서 관리한다.
    // 아래와 같이 만들면 계층적으로 작성하기때문에 이해하기가 쉬워진다.
    static class compuer {
        public static final int CPU = 1;
        public static final int VGA = 2;
        public static final int RAM= 3;
        public static final int MOUSE = 4;
        public static final int KEYBOARD = 5;
    }
    static class appliance {
        public static final int TV = 10;
        public static final int AUDIO = 11;
        public static final int DVD = 12;
        public static final int VACUUM = 13;
    }
    static class book {
        public static final int POET = 100;
        public static final int NOVEL = 101;
        public static final int EASSY = 102;
        public static final int LANG = 103;
    }
    // 이걸 묶는 클래스명을 소문자로 하는 건 구글의 방식.
}
