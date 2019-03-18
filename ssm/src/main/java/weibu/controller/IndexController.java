package weibu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String toIndexPage() {
		return "index";
	}
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	@RequestMapping("/registerPage")
	public String registerPage() {
		return "register";
	}
	@RequestMapping("/userManngerPage")
	public String userManngerPage() {
		return "userMannger";
	}
}
