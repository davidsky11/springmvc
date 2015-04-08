package com.kv.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kv.model.User;
import com.kv.service.UserException;

@Controller
@RequestMapping("/user")
public class UserController {

	private Map<String, User> users = new HashMap<String, User>();
	
	public UserController() {
		users.put("kv", new User("kv", "123", "戴胜凯", "sss"));
		users.put("cl", new User("cl", "123", "陈亮", "ttt"));
		users.put("wst", new User("wst", "123", "王思婷", "uuu"));
		users.put("zcw", new User("zcw", "123", "詹成伟", "vvv"));
	}
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", users);
		return "user/list";
	}
	
	// 链接到add页面时是GET请求，会访问这段代码
//	@RequestMapping(value = "/add", method=RequestMethod.GET)
//	public String add(Model model) {
//		System.out.println("#############");
//		// 开启modelDriven
//		model.addAttribute(new User());		return "user/add";
//	}  // 法一
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add(@ModelAttribute("user") User user) {
		// 开启modelDriven
//		model.addAttribute(new User());		
		return "user/add";
	} // 法二
	
	// 在具体添加用户时，是post请求，就访问以下代码
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(@Validated User user, BindingResult br) { // 一定要紧跟Validate之后写验证结果
		if (br.hasErrors()) {
			return "user/add";			// 如果又错误，直接跳转add视图
		}
		users.put(user.getUsername(), user);
		return "redirect:/user/users";			// 客户端跳转
	}
	
	@RequestMapping(value = "/{username}", method=RequestMethod.GET)
	public String show(@PathVariable String username, Model model) {
		model.addAttribute(users.get(username));
		return "user/show";
	}
	
	@RequestMapping(value = "/{username}/update", method=RequestMethod.GET)
	public String update(@PathVariable String username, Model model) {
		model.addAttribute(users.get(username));
		return "user/update";
	}
	
	@RequestMapping(value = "/{username}/update", method=RequestMethod.POST)
	public String update(@PathVariable String username, @Validated User user, BindingResult br) {
		if (br.hasErrors()) {
			return "user/update";			// 如果又错误，直接跳转update视图
		}
		users.put(username, user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value = "{username}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable String username) {
		users.remove(username);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		if (!users.containsKey(username)) {
			throw new UserException("用户名不存在！");
		}
		User user = users.get(username);
		if (!user.getPassword().equals(password)) {
			throw new UserException("用户密码不正确！");
		}
		
		session.setAttribute("LoginUser", user);
		return "redirect:/user/users";
	}
	
	/**
	 * 局部异常处理，仅仅只能处理这个控制器中的异常
	 */
	@ExceptionHandler(value = UserException.class)
	public String handlerException(UserException e, HttpServletRequest req) {
		req.setAttribute("e", e);
		return "error";
	}
	
}
