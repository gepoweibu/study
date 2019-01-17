package com.weibu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.weibu.dao.IUser;
import com.weibu.pojo.User;

public class UserService {
	private static SqlSession session;
	private static IUser iuser;
	static {
		try {
			String resource = "MybatisConfig.xml";
			InputStream ins = Resources.getResourceAsStream(resource);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(ins);
			session = ssf.openSession(true);
			iuser = session.getMapper(IUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		try {
			//insertUser("selina", "selina1995", "selina@gamil.com","888666999");
			//deleteUser(4);
			updateUser(2,"小红","665588sss","5536648@qq.com","15753648695");
			printUsers();
		} finally {
			session.close();
		}

	}
	public static void printUsers() {
		List<User> users = iuser.getUserList();
		for (User user : users) {
			System.out.println(user);
		}
	} 
	public static void insertUser(String userName,String password,String email,String phone) {
		User user=new User();
		user.setName(userName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		iuser.insertUser(user);
	}
	public static void updateUser(int id,String userName,String password,String email,String phone) {
		User user=new User();
		user.setId(id);
		user.setName(userName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		iuser.updateUser(user);
	}
	public static void deleteUser(int userId) {
		iuser.deleteUser(userId);
	}
}
