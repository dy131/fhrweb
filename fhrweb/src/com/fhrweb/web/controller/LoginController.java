package com.fhrweb.web.controller;



import com.fhrweb.web.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Ê×Ò³
 * @author xingguo.lu
 * @date 2014-10-04 
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
		
		System.out.println("dasfsda");
		System.out.println("ddddddddddddd");
		System.out.println("ddddddddddddd");
		System.out.println("ddddddddddddd");
		
		//mv.addObject("newsList", newsList);
		return null;
		
	}

}
