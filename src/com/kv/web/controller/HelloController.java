package com.kv.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
//	@RequestMapping({"/hello","/"})
//	public String hello(@RequestParam("username") String username) {		// 如果传值必不可少，则要加@RequestParam
//		System.out.println("hello");
//		System.out.println(username);
//		return "hello";			// 逻辑视图的名称
//	}

	// RequestMapping表示用那个url来对应
//	@RequestMapping({"/hello","/"})
//	public String hello(String username, Map<String, Object> context) {		// 如果传值必不可少，则要加@RequestParam
//		System.out.println("hello");
//		context.put("username", username);
//		System.out.println(username);
//		return "hello";			// 逻辑视图的名称
//	}
	
	@RequestMapping({"/hello","/"})
	public String hello(String username, Model model) {		// 如果传值必不可少，则要加@RequestParam
		System.out.println("hello");
		model.addAttribute("username", username);
		
		// 此时用那个作为key? 它默认是使用对象的类型作为key --> model.addAttribute("string", username) --> 对应Object的名称
		// model.addAttribute(new User()); --> model.addAttribute("user", new User());
		model.addAttribute(username);
		System.out.println(username);
		return "hello";			// 逻辑视图的名称
	}

	@RequestMapping({"/welcome"})
	public String welcome() {
		return "welcome";
	}
}
