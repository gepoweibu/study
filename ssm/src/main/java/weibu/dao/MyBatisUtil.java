package weibu.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	/*
	 * 自动提交事务
	 */
	public static SqlSession getSqlSession() throws IOException {
		String resource = "MybatisConfig.xml";
		InputStream ins = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(ins);
		SqlSession sqlSession = ssf.openSession(true);
		return sqlSession;
	}

}
