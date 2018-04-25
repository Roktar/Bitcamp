package step25.ex4;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

public class DefaultDataSource implements DataSource {
    String driver;
    String jdbcUrl;
    String user;
    String password;
    
    ArrayList<Connection> conPool = new ArrayList<>();
    
    // DB관련정보를 받지못한 경우, JVM 프로퍼티에서 찾는다.
    // jdbc.properties 파일을 작성해야둬야할 듯. => 그래서 만들었습니다.
    public DefaultDataSource() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jdbc.properties"));
        this.driver = props.getProperty("jdbc.driver");
        this.jdbcUrl = props.getProperty("jdbc.url");
        this.user = props.getProperty("jdbc.username");
        this.password = props.getProperty("jdbc.password");
        
        //JDBC 드라이버 로딩 및 DriverManager에 등록
        Class.forName(driver);
    }
    
    // 프로그램 상에서 DB정보를 받은 경우, 받은 정보를 토대로 연결한다.
    public DefaultDataSource(String driver, String jdbcUrl, String user, String password) throws Exception {
        this.driver = driver;
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
        
        //JDBC 드라이버 로딩 및 DriverManager에 등록
        Class.forName(driver);
    }
    
    public Connection getConnection() throws Exception {
        if(conPool.size() == 0)
            return new ConnectionProxy(this, DriverManager.getConnection(jdbcUrl, user, password));
        // Connection Pool에 아무런 Connection이 없다면, 새로 생성해서 내보낸다.
        // 업무를 분배해줄 connectionproxy 클래스에 담아서 내보낸다.

        Connection con = conPool.remove(0);
        // Pool에서 하나의 연결을 꺼낸다.
        
        if(con.isClosed() && !con.isValid(1))
            return DriverManager.getConnection(jdbcUrl, user, password);;
        // Pool에서 꺼낸 객체가 닫혀있거나 유효하지않은 상태인 경우, 새로운 Connection 객체를 만들어서 반환한다.
        // 열려있다는 것은 객체가 사용될 수 있는 상태를 의미한다.
        // 유효하다는 것은 DBMS와 연결이 정상적으로 되어있다는 의미가 된다.
        // isValid함수의 인자는 최대로 기다리는 시간이다.(즉 여기서는 1초까지 기다리고 그 이내에 응답이 와야함)
        
        return con;
        // Pool에서 꺼낸 객체가 열려있고 객체가 유효한 상태인 경우, 그 객체를 반환
    }
    
    public void returnConnection(Connection con) {
        conPool.add(con);
        System.out.println("Connection ClassName = " + con.getClass().getName() + ", pool size = " + conPool.size());
    } // 사용한 객체를 반환하는 함수
}
