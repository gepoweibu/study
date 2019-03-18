package weibu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibu.dao.IUserDao;
import weibu.entity.User;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
    private IUserDao userDao;
	@Override
	public void printUserMsg(String userName,String password) {
		System.out.println(userDao.getUser(userName, password));
	}
	@Override
	public boolean login(String userName, String password) {
		return userDao.userLogin(userName, password);
	}
	@Override
	public boolean register(User user) {
		return userDao.userRegister(user);
	}
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
}
