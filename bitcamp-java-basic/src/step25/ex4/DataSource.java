package step25.ex4;

import java.sql.Connection;

public interface DataSource {
    public Connection getConnection() throws Exception;
    public void returnConnection(Connection con); 
}
