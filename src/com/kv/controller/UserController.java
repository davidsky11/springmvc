package com.kv.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	
	/**
	 * 列举所有用户信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public String list(Model model) {
		log.info("get into list in UserController...");
		Pager<User> pagers = new Pager<User>();
		pagers = userService.find();
		log.info("pagers.size : " + pagers.getSize());
		model.addAttribute("pagers", pagers);
		return "user/list";
	}
	
	/**
	 * 跳转到用户添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add(Model model) {
		log.info("get in add...");
		model.addAttribute(new User());
		return "user/add";
		
	}
	
//	@RequestMapping(value = "/add", method=RequestMethod.POST)
//	public String add(@ModelAttribute("user") User user) {
//		log.info("add a new User...");
//		userService.add(user);
//		return "redirect:users";
//	}
	
	/**
	 * 新增用户信息到数据库
	 * @param model
	 * @param user
	 * @param br
	 * @return
	 */
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(Model model, @Validated User user, BindingResult br) {
		if (br.hasErrors()) {
			return "user/add";
		}
		
		log.info("add a new User...");
		userService.add(user);
		return "redirect:/user/users";
	}
	
	/**
	 * 显示用户详细信息
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public String show(Model model, @PathVariable int id) {
		model.addAttribute(userService.load(id));
		return "user/show";
	}
	
	/**
	 * 跳转到用户更新页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id]/update", method=RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		model.addAttribute(userService.load(id));
		return "user/update";
	}
	
	/**
	 * 更新用户信息到数据库
	 * @param id
	 * @param user
	 * @param br
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/update", method=RequestMethod.POST)
	public String update(@PathVariable int id, @Validated User user, BindingResult br, Model model) {
		if (br.hasErrors()) {
			model.addAttribute(userService.load(id));
			return "user/update";
		}
		
		User u = userService.load(id);
		u.setPassword(user.getPassword());
		u.setNickname(user.getNickname());
		u.setEmail(user.getEmail());
		userService.update(u);
		return "redirect:/user/users";
	}
	
	/**
	 * 从数据库中删除指定用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/user/users";
	}
	
}
