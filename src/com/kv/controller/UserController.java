package com.kv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kv.exception.UserException;
import com.kv.model.User;
import com.kv.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;

	public UserController() {
		
	}
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public String list(Model model) {
		List<User> users = userService.listUser();
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
	public String add(@ModelAttribute("user") User user, Model model) {
		// 开启modelDriven
		model.addAttribute(new User());	
		logger.info("get into add(post)...");
		
		return "user/add";
	} // 法二
	
	// 在具体添加用户时，是post请求，就访问以下代码
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(@Validated User user, BindingResult br, MultipartFile attach, HttpServletRequest request) throws IOException { // 一定要紧跟Validate之后写验证结果
		if (br.hasErrors()) {
			return "user/add";			// 如果又错误，直接跳转add视图
		}
//		String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
//		File f = new File(realPath + "/" + attach.getOriginalFilename());
//		FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
		
		logger.info("get into regist(post)...");
		logger.info(user.toString());
		
		userService.addUser(user);
		return "redirect:/user/users";			// 客户端跳转
	}
	
	// 在具体添加用户时，是post请求，就访问以下代码
	/*@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(@Validated User user, BindingResult br, @RequestParam("attachs") MultipartFile[] attachs, HttpServletRequest request) throws IOException { // 一定要紧跟Validate之后写验证结果
		if (br.hasErrors()) {
			return "user/add";			// 如果又错误，直接跳转add视图
		}
		String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
		
		// 上传多个文件的情况
		for (MultipartFile attach : attachs) {	
			if (attach.isEmpty()) {
				continue;
			}
			File f = new File(realPath + "/" + attach.getOriginalFilename());
			FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
		}
		users.put(user.getUsername(), user);
		return "redirect:/user/users";			// 客户端跳转
	}*/
	
	@RequestMapping(value = "/{username}", method=RequestMethod.GET)
	public String show(@PathVariable String username, Model model) {
		User user = userService.selectUserByName(username);
		model.addAttribute(user);
		return "user/show";
	}
	
	@RequestMapping(value = "/{username}", method=RequestMethod.GET, params="json")
	@ResponseBody
	public User show(@PathVariable String username) {
		return userService.selectUserByName(username);
	}
	
	@RequestMapping(value = "/{username}/update", method=RequestMethod.GET)
	public String update(@PathVariable String username, Model model) {
		User user = userService.selectUserByName(username);
		model.addAttribute(user);
		return "user/update";
	}
	
	@RequestMapping(value = "/{username}/update", method=RequestMethod.POST)
	public String update(@PathVariable String username, @Validated User user, BindingResult br) {
		if (br.hasErrors()) {
			return "user/update";			// 如果又错误，直接跳转update视图
		}
		userService.updateUser(user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value = "{username}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable String username) {
		User user =  userService.selectUserByName(username);
		if (null == user) {
			
		} else {
			userService.deleteUser(user.getId());
		}
		return "redirect:/user/users";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		logger.info("get into login(post)...");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		logger.info("login... \nusername - " + username + "\npassword - " + password);
		logger.info(" userService - " + userService);
		List<User> userList = userService.selectUser(user);
		
		logger.info("符合条件的用户数 : " + userList.size());
		if (userList.size() > 0) {
			session.setAttribute("loginUser", userList.get(0));
			return "redirect:/user/users";
		} else {
			throw new UserException("用户名/密码不正确！");
		}
	}
	
	@RequestMapping(value = "/regist", method=RequestMethod.GET)
	public String regist(@ModelAttribute("user") User user) {
		// 开启modelDriven
		logger.info("get into regist(post)...");
		return "user/regist";
	}
	
	@RequestMapping(value = "/regist", method=RequestMethod.POST)
	public String regist(User user, BindingResult rs) {
		logger.info("get into regist(post)...");
		
		userService.addUser(user);
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
