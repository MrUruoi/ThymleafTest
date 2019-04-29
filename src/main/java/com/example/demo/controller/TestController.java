package com.example.demo.controller;

import org.springframework.stereotype.Controller;
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
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("test2");
		mav.addObject("msg", "current data.");
		DataObject obj = new DataObject(123, "dopamine", "dopa@!");
		mav.addObject("object", obj);
		
		mav.addObject("msg2", "message 1<hr/>message 2<br/>message 3");
		
		return mav;
	}
}
