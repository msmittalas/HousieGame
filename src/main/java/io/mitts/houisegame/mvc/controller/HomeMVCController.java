package io.mitts.houisegame.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/")
public class HomeMVCController {

	@GetMapping
	public ModelAndView home()
	{
		 return  new ModelAndView("index");
	}
}
