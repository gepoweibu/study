package weibu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import weibu.entity.User;

public interface IUserDao {
	public User getUser(@Param("userName") String userName,@Param("password") String password);
	public List<User> getUsers();
	public boolean userLogin(String userName,String password);
	public boolean userRegister(User user);
}
