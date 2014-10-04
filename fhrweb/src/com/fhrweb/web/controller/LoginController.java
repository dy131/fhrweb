package com.fhrweb.web.controller;



import com.fhrweb.web.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * TennisIndexController 网球新首�?
 * @author ALWIN.LIANG
 *
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {
	
	//@Resource
	//protected ImglibImgDao imglibImgDao;
	


	@RequestMapping("index")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("tennis/index");
		
		//System.out.println("dasfsda");
		
		//mv.addObject("newsList", newsList);
		return null;
		
	}

}
