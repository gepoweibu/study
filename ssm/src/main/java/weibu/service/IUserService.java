package weibu.service;

import java.util.List;

import weibu.entity.User;

public interface IUserService {
	public void printUserMsg(String userName,String password);
	public boolean login(String userName,String password);
	public boolean register(User user);
	public List<User> getUsers();
}
