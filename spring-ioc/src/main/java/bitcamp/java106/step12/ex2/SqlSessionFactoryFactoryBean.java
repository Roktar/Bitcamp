package bitcamp.java106.step12.ex2;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class SqlSessionFactoryFactoryBean extends AbstractFactoryBean<SqlSessionFactory>{

    String configLocation = null;
    
    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }
    
    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        try {
            InputStream in = Resources.getResourceAsStream(configLocation);
            return new SqlSessionFactoryBuilder().build(in);
        } catch(Exception e) { }
        return null;
    }

    @Override
    protected SqlSessionFactory createInstance() throws Exception {
        // TODO Auto-generated method stub
        return super.getObject();
    }

}
