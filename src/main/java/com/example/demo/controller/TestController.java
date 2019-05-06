package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.DataObject;

@Controller
public class TestController {
	@RequestMapping("/")
	public String test1() {
		return "test1";
	}
	
	@RequestMapping("/link")
	public String link() {
		return "link";
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(ModelAndView mav) {
		mav.setViewName("test2");
		mav.addObject("msg", "current data.");
		DataObject obj = new DataObject(123, "dopamine", "dopa@!");
		mav.addObject("object", obj);
		
		mav.addObject("msg2", "message 1<hr/>message 2<br/>message 3");
		
		return mav;
	}
	
	@RequestMapping("/test3/{id}")
	public ModelAndView test3(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("test3");
		mav.addObject("id", id);
		mav.addObject("check", id % 2 == 0);
		mav.addObject("trueVal", "Even number!");
		mav.addObject("falseVal", "Odd number...");
		
		return mav;
	}
	
	@RequestMapping("/test4/{month}")
	public ModelAndView test4(@PathVariable int month, ModelAndView mav) {
		mav.setViewName("test4");
		int m = Math.abs(month) % 12;
		m = m == 0 ? 12 : m;
		mav.addObject("month", m);
		mav.addObject("check", Math.floor(m/3));
		return mav;
	}
	
	@RequestMapping("/test5")
	public ModelAndView test5(ModelAndView mav) {
		mav.setViewName("test5");
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] {"a", "1234", "1234"});
		list.add(new String[] {"b", "33333", "222"});
		list.add(new String[] {"c", "22222", "3333"});
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/test6/{num}")
	public ModelAndView test6(@PathVariable int num, ModelAndView mav) {
		mav.setViewName("test6");
		mav.addObject("num", num);
		if(num >= 0)
			mav.addObject("check", "num >= list.size() ? 0 : num");
		else
			mav.addObject("check", "num <= list.size() * -1 ? 0 : num * -1");
		
		List<DataObject> list = new ArrayList<DataObject>();
		list.add(new DataObject(0, "aa", "aa"));
		list.add(new DataObject(1, "bb", "bb"));
		list.add(new DataObject(2, "cc", "cc"));
		mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("/test7")
	public ModelAndView test7(ModelAndView mav) {
		mav.setViewName("test7");
		
		List<DataObject> list = new ArrayList<DataObject>();
		list.add(new DataObject(0, "ee", "22"));
		list.add(new DataObject(1, "rr", "33"));
		list.add(new DataObject(2, "wwww", "77"));
		
		mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("/test8/{tax}")
	public ModelAndView test8(@PathVariable int tax, ModelAndView mav) {
		mav.setViewName("test8");
		mav.addObject("tax", tax);
		return mav;
	}
	
	@RequestMapping("/test9")
	public ModelAndView test9(ModelAndView mav) {
		mav.setViewName("test9");
		return mav;
	}
	
	
}
