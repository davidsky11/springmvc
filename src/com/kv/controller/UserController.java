package com.kv.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kv.model.Pager;
import com.kv.model.User;
import com.kv.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Log log = LogFactory.getLog(UserController.class);
	
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public UserController() {

	}
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public String list(Model model) {
		log.info("get into list in UserController...");
		Pager<User> pagers = new Pager<User>();
		/*
		List<User> datas = new ArrayList<User>();
		User u1 = new User(0, "test", "123", "TST", "test@126.com");
		datas.add(u1);
		User u2 = new User(1, "kevin", "123", "kv", "kv@126.com");
		datas.add(u2);
		pagers.setDatas(datas);

		pagers.setOffset(0);
		pagers.setSize(2);
		pagers.setTotal(2);
		
		log.info("new a pager...");*/
		pagers = userService.find();
		log.info("pagers.size : " + pagers.getSize());
		model.addAttribute("pagers", pagers);
		return "user/list";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add(Model model) {
		log.info("get in add...");
		model.addAttribute(new User());
		return "user/add";
		
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("user") User user) {
		log.info("add a new User...");
		userService.add(user);
		return "redirect:users";
	}
	
}
