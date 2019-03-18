package weibu.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import weibu.entity.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Override
	public User getUser(String userName, String password) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			IUserDao iuserDao = sqlSession.getMapper(IUserDao.class);
			User user = iuserDao.getUser(userName, password);
			System.out.println("数据库用户查询信息："+user);
			return user;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			IUserDao iuserDao = sqlSession.getMapper(IUserDao.class);
		    List<User> users = iuserDao.getUsers();
			return users;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public boolean userLogin(String userName, String password) {
		User user = getUser(userName, password);
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean userRegister(User user) {
		System.out.println("注册用户信息："+user);
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			IUserDao iuserDao = sqlSession.getMapper(IUserDao.class);
			return iuserDao.userRegister(user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return false;
	}

}
