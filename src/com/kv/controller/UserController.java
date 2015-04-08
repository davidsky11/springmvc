package com.kv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kv.model.User;

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
}
