package com.weibu.dao;

import java.util.List;
import com.weibu.pojo.User;

public interface IUser {
	public User getUser(int userId);
	public List<User> getUserList();
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userId);
}
