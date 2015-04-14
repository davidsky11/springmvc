package com.kv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kv.model.User;
import com.kv.service.IUserService;

@Controller
@SessionAttributes("loginUser")
public class IndexController {

	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 跳转到login页面
	 * @return
	 */
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * 处理用户登录操作，跳转到list页面
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String login(String username, String password, Model model) {
		User u = userService.login(username, password);
		model.addAttribute("loginUser", u);
		return "redirect:/user/users";
	}
	
	/**
	 * 用户登出，跳转到登录界面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(Model model, HttpSession session) {
		model.asMap().remove("loginUser");		// 从session中移除登录用户信息
		session.invalidate();					// 使用户失效
		return "redirect:/login";
	}
	
}
