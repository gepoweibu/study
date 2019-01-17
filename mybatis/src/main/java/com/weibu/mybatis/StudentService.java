package com.weibu.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.weibu.pojo.Student;

public class StudentService {

	public static void main(String[] args) throws IOException {
		String resource = "MybatisConfig.xml";
		InputStream ins = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(ins);
		SqlSession ss = ssf.openSession(true);
		try {
			Student student = (Student) ss.selectOne("com.weibu.pojo.StudentMapper.GetStudentByID", 1);
			System.out.println(student);
		} finally {
			ss.close();
		}
	}

}
