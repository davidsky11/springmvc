package com.kv.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
		model.addAttribute("pagers", userService.find());
		return "user/list";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "user/add";
		
	}
}
