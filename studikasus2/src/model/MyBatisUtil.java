package model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing MyBatis: " + e.getMessage(), e);
        }
    }

    /**
     * Returns an open MyBatis SqlSession.
     * 
     * @return SqlSession instance
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * Closes the given SqlSession.
     * 
     * @param session the SqlSession to close
     */
    public static void closeSqlSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
}
