package com.kv.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kv.domain.Role;
import com.kv.domain.User;
import com.kv.exception.UserException;
import com.kv.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private IUserService userService;
	
	public UserController() {
		
	}
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public String list(Model model) {
		logger.info("get into list...");
		List<User> users = userService.listAll();
		
		logger.info("list.size - " + users.size());
		model.addAttribute("users", users);
		return "user/list";
	}
	
	// 链接到add页面时是GET请求，会访问这段代码
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add(Model model) {
		// 开启modelDriven
		model.addAttribute(new User());
		
		List<Role> roles = userService.listRole();
		model.addAllAttributes(roles);
		
		return "user/add";
	}  // 法一
	
	/*@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add(@ModelAttribute("user") User user) {
		
		return "user/add";
	}*/
	
	// 在具体添加用户时，是post请求，就访问以下代码
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(@Validated User user, BindingResult br, MultipartFile attach, HttpServletRequest request) throws IOException { // 一定要紧跟Validate之后写验证结果
		if (br.hasErrors()) {
			return "user/add";			// 如果又错误，直接跳转add视图
		}
		
		if (!attach.isEmpty()) {
			String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
			File f = new File(realPath + "/" + attach.getOriginalFilename());
			FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
		}

		userService.register(user);
		
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
		User user = userService.getUserByName(username);
		model.addAttribute(user);
		return "user/show";
	}
	
	@RequestMapping(value = "/{username}", method=RequestMethod.GET, params="json")
	@ResponseBody
	public User show(@PathVariable String username) {
		User user = userService.getUserByName(username);
		return user;
	}
	
	@RequestMapping(value = "/{username}/update", method=RequestMethod.GET)
	public String update(@PathVariable String username, Model model) {
		User user = userService.getUserByName(username);
		model.addAttribute(user);
		return "user/update";
	}
	
	@RequestMapping(value = "/{username}/update", method=RequestMethod.POST)
	public String update(@PathVariable String username, @Validated User user, BindingResult br) {
		if (br.hasErrors()) {
			logger.error("传入的用户数据不对，重新编辑...");
			return "user/update";			// 如果又错误，直接跳转update视图
		}
		
		userService.updateUser(user);
		
		return "redirect:/user/users";
	}
	
	@RequestMapping(value = "{username}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable String username) {
		User user = userService.getUserByName(username);
		if (null != user)	userService.deleteUser(user);
		
		return "redirect:/user/users";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		logger.info("login ... \nusername - " + username + "\npassword - " + password);
		
		User user = userService.login(username, password);
		if (null != user) {
			session.setAttribute("loginUser", user);
		} else {
			throw new UserException("用户名/密码不正确!");
		}
		
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
