package step21.ex5;

public class BoardException extends RuntimeException {

     // 이 클래스의 생성자를 호출하면,
     // 그와 대응하는 수퍼클래스의 생성자를 호출하는 일 외에는 다른 작업을 수행치않음.
    
    // 여기서는 추가 클래스를 만든 이유는 추가 기능을 위함이 아니라
    // 의미있는 이름을 가진 클래스를 만들기 위함이다.
    // 예외 발생 시 클래스이름으로 어떤 예외인 지 쉽게 추측할 수 있다.
    public BoardException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BoardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public BoardException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public BoardException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BoardException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
