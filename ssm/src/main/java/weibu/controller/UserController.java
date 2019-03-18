package weibu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weibu.entity.User;
import weibu.service.IUserService;
@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/login")
	public @ResponseBody User login(String userName,String password) {
		System.out.println("用户名:"+userName+" 密码："+password);
		userService.login(userName, password);
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		return user;
	}
	@RequestMapping("/register")
	@ResponseBody
	public User rigster(@RequestBody User user) {
		userService.register(user);
		return user;
	}
	@RequestMapping("/getUsers")
	@ResponseBody
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
}
