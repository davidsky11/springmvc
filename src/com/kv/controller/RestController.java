package com.kv.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kv.model.Person;

@Controller
public class RestController {

	private static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/rest", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String hello() {
		return "你好！ Hello";
	}
	
	@RequestMapping(value = "/say/{msg}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}
	
	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
	public @ResponseBody Person getPerson(@PathVariable("id") int id) {
		logger.info("获取人员信息 id = " + id);
		Person person = new Person();
		person.setName("kevin");
		person.setSex("男");
		person.setAge(25);
		person.setId(11);
		return person;
	}
	
	
	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
	public @ResponseBody Object deletePerson(@PathVariable("id") int id) {
		logger.info("删除人员信息 id = " + id);
		JSONObject object = new JSONObject();
		object.put("msg", "删除人员信息成功");
		return object;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public @ResponseBody Object addPerson(Person person) {
		logger.info("注册人员信息 id = " + person.getId());
		JSONObject object = new JSONObject();
		object.put("msg", "注册人员信息成功");
		return object;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public @ResponseBody Object updatePerson(Person person) {
		logger.info("更新人员信息 id = " + person.getId());
		JSONObject object = new JSONObject();
		object.put("msg", "更新人员信息成功");
		return object;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.PATCH)  
	public @ResponseBody  
	List<Person> listPerson(@RequestParam(value = "name", required = false, defaultValue = "") String name) {  
        logger.info("查询人员name like " + name);  
        List<Person> lstPersons = new ArrayList<Person>();  
	  
        Person person = new Person();  
        person.setName("张三");  
        person.setSex("男");  
        person.setAge(25);  
        person.setId(101);  
        lstPersons.add(person);  
  
        Person person2 = new Person();  
        person2.setName("李四");  
        person2.setSex("女");  
        person2.setAge(23);  
        person2.setId(102);  
        lstPersons.add(person2);  
  
        Person person3 = new Person();  
        person3.setName("王五");  
        person3.setSex("男");  
        person3.setAge(27);  
        person3.setId(103);  
        lstPersons.add(person3);  
  
        return lstPersons;  
	}  
	
}
